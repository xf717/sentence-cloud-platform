package com.github.xf717.systemservice.manager.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.xf717.common.framework.constant.CommonConstants;
import com.github.xf717.common.framework.constant.RedisKeyConstant;
import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.exception.auth.UserInvalidException;
import com.github.xf717.common.framework.util.TreeUtil;
import com.github.xf717.common.framework.util.password.Sha256PasswordEncoder;
import com.github.xf717.common.framework.vo.authority.CheckPermissionInfo;
import com.github.xf717.common.framework.vo.authority.PermissionInfo;
import com.github.xf717.common.framework.vo.user.UserInfo;
import com.github.xf717.security.auth.client.jwt.UserAuthUtil;
import com.github.xf717.systemservice.constant.AdminCommonConstant;
import com.github.xf717.systemservice.convert.auth.PermissionConvert;
import com.github.xf717.systemservice.rpc.auth.dto.AccessInterfaceRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.AccessMenuTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.AccessRouteTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserV2RespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.MenuTreeRespDTO;
import com.github.xf717.systemservice.service.auth.BaseElementService;
import com.github.xf717.systemservice.service.auth.BaseMenuService;
import com.github.xf717.systemservice.service.auth.BaseUserService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

/**
 * PermissionManager
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/30 15:48
 */
@Service
@Validated
public class PermissionManager {

  @Autowired
  private BaseUserService baseUserService;

  @Autowired
  private BaseMenuService baseMenuService;

  @Autowired
  private BaseElementService baseElementService;

  /**
   * 加密工具
   */
  private Sha256PasswordEncoder encoder = new Sha256PasswordEncoder();

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private UserAuthUtil userAuthUtil;

  /**
   * 根据用户名称获取用户信息
   *
   * @param username
   * @return
   */
  public UserInfo getUserByUsername(String username) {
    UserInfo info = new UserInfo();
    BaseUserRespDTO baseUserDO = baseUserService.selectByUserName(username);
    info = PermissionConvert.INSTANCE.convert(baseUserDO);
    info.setId(baseUserDO.getId().toString());
    return info;
  }

  /**
   * 验证帐号密码
   *
   * @param username
   * @param password
   * @return
   */
  public UserInfo validate(String username, String password) {
    UserInfo info = new UserInfo();
    BaseUserRespDTO user = baseUserService.selectByUserName(username);
    if (encoder.matches(password, user.getPassword())) {
      info = PermissionConvert.INSTANCE.convert(user);
      info.setId(user.getId().toString());
    }
    return info;
  }

  /**
   * 获取全部权限
   *
   * @return
   */
  public List<PermissionInfo> getAllPermission() {
    String key = RedisKeyConstant.REDIS_KEY_ALL_PERMISISON;
    String s = stringRedisTemplate.opsForValue().get(key);
    if (s == null || StringUtils.isBlank(s)) {
      List<BaseMenuRespDTO> menus = baseMenuService.listAllMenus();
      List<PermissionInfo> result = new ArrayList<PermissionInfo>();
      menu2permission(menus, result);
      List<BaseElementRespDTO> elements = baseElementService.getAllElementPermissions();
      element2permission(result, elements);
      s = JSON.toJSONString(result);
      stringRedisTemplate.opsForValue().set(key, s, 12, TimeUnit.HOURS);
    }
    List<PermissionInfo> permissionInfos = JSON.parseArray(s, PermissionInfo.class);
    return permissionInfos;
  }

  /**
   * 根据用户名获取权限
   *
   * @param username
   * @return
   */
  public List<PermissionInfo> getPermissionByUsername(String username) {
    String key = String.format(RedisKeyConstant.REDIS_KEY_USER_PERMISISON, username);
    String s = stringRedisTemplate.opsForValue().get(key);
    if (s == null || StringUtils.isBlank(s)) {
      BaseUserRespDTO user = baseUserService.selectByUserName(username);
      List<BaseMenuRespDTO> menus = baseMenuService.getUserAuthorityMenuByUserId(user.getId());
      List<PermissionInfo> result = new ArrayList<PermissionInfo>();
      menu2permission(menus, result);
      List<BaseElementRespDTO> elements = baseElementService
          .getAuthorityElementByUserId(user.getId());
      element2permission(result, elements);
      stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(result), 12, TimeUnit.HOURS);
      return result;
    }
    List<PermissionInfo> permissionInfos = JSON.parseArray(s, PermissionInfo.class);
    return permissionInfos;
  }

  private void menu2permission(List<BaseMenuRespDTO> menus, List<PermissionInfo> result) {
    PermissionInfo info;
    for (BaseMenuRespDTO menu : menus) {
      if (StringUtils.isBlank(menu.getHref())) {
        menu.setHref("/" + menu.getCode());
      }
      info = new PermissionInfo();
      info.setCode(menu.getCode());
      info.setType(AdminCommonConstant.RESOURCE_TYPE_MENU);
      info.setName(AdminCommonConstant.RESOURCE_ACTION_VISIT);
      String uri = menu.getHref();
      if (!uri.startsWith("/")) {
        uri = "/" + uri;
      }
      info.setUri(uri);
      info.setMethod(AdminCommonConstant.RESOURCE_REQUEST_METHOD_GET);
      result.add(info
      );
      info.setMenu(menu.getTitle());
    }
  }

  private void element2permission(List<PermissionInfo> result, List<BaseElementRespDTO> elements) {
    PermissionInfo info;
    for (BaseElementRespDTO element : elements) {
      info = new PermissionInfo();
      info.setCode(element.getCode());
      info.setType(element.getType());
      info.setUri(element.getUri());
      info.setMethod(element.getMethod());
      info.setName(element.getName());
      info.setMenu(element.getMenuId().toString());
      result.add(info);
    }
  }

  /**
   * 获取菜单树
   *
   * @param menus
   * @param root
   * @return
   */
  private List<MenuTreeRespDTO> getMenuTree(List<BaseMenuRespDTO> menus, int root) {
    // 直接使用转换
    List<MenuTreeRespDTO> trees = PermissionConvert.INSTANCE.convert(menus);
//    MenuTree node = null;
//    for (BaseMenuRespDTO menu : menus) {
//      node = new MenuTree();
//      BeanUtils.copyProperties(menu, node);
//      trees.add(node);
//    }
    return TreeUtil.bulid(trees, root);
  }

  public FrontUserV2RespDTO getUserInfoV2() {
    String username = BaseContextHandler.getUsername();
    if (username == null) {
      return null;
    }
    BaseUserRespDTO user = baseUserService.selectByUserName(username);
    FrontUserV2RespDTO frontUser = new FrontUserV2RespDTO();
    List<BaseMenuRespDTO> menus = baseMenuService.getUserAuthorityMenuByUserId(user.getId());
    List<AccessMenuTreeRespDTO> menuTrees = new ArrayList<AccessMenuTreeRespDTO>();
    List<AccessRouteTreeRespDTO> routeTrees = new ArrayList<>();
    AccessMenuTreeRespDTO node = null;
    AccessRouteTreeRespDTO routeNode = null;
    List<Integer> menuIds = new ArrayList<>();
    List<AccessMenuTreeRespDTO> header = new ArrayList<>();
    // 设置菜单树
    for (BaseMenuRespDTO menu : menus) {
      node = new AccessMenuTreeRespDTO();
      node.setIcon(menu.getIcon());
      node.setPath(menu.getHref());
      node.setTitle(menu.getTitle());
      node.setId(menu.getId());
      node.setParentId(menu.getParentId());
      menuTrees.add(node);
      // 设置系统头部菜单
      if (menu.getParentId().equals(AdminCommonConstant.ROOT)) {
        menuIds.add(menu.getId().intValue());
        node = new AccessMenuTreeRespDTO();
        node.setIcon(menu.getIcon());
        node.setPath(menu.getHref());
        node.setTitle(menu.getTitle());
        node.setId(menu.getId());
        node.setParentId(menu.getParentId());
        header.add(node);
        continue;
      }
      routeNode = new AccessRouteTreeRespDTO();
      routeNode.setIcon(menu.getIcon());
      routeNode.setId(menu.getId());
      routeNode.setPath(menu.getHref());
      routeNode.setParentId(menu.getParentId());
      routeNode.setName(menu.getCode());
      routeNode.setComponent(menu.getComponent());
      routeNode.setComponentPath(menu.getComponentPath());
      JSONObject jsonObject = JSONObject.parseObject(menu.getJson());
      jsonObject.put("title", menu.getTitle());
      routeNode.setMeta(jsonObject);
      routeTrees.add(routeNode);
    }
    // 配置页面资源权限
    List<BaseElementRespDTO> elements = baseElementService
        .getAuthorityElementByUserId(user.getId());
    List<String> permissions = new ArrayList<>();
    List<AccessInterfaceRespDTO> interfaces = new ArrayList<>();
    AccessInterfaceRespDTO accessInterface = null;
    for (BaseElementRespDTO element : elements) {
      accessInterface = new AccessInterfaceRespDTO();
      permissions.add(element.getCode());
      accessInterface.setMethod(element.getMethod());
      accessInterface.setPath(element.getUri());
      interfaces.add(accessInterface);
    }
    // 配置路由权限
    List<AccessRouteTreeRespDTO> accessRoutes = new ArrayList<>();
    for (Integer menuId : menuIds) {
      accessRoutes.addAll(TreeUtil.bulid(routeTrees, menuId));
    }
    frontUser.setAccessMenus(TreeUtil.bulid(menuTrees, AdminCommonConstant.ROOT));
    frontUser.setAccessHeader(header);
    frontUser.setAccessRoutes(accessRoutes);
    frontUser.setUserPermissions(permissions);
    frontUser.setUserName(user.getName());
    frontUser.setAccessInterfaces(interfaces);
    //TODO 待接入头像附件上传服务
    frontUser.setAvatarUrl("https://api.adorable.io/avatars/85/abott@adorable.png");
    return frontUser;
  }

  public FrontUserRespDTO getUserInfo(String token) {
    String username = null;
    try {
      username = userAuthUtil.getInfoFromToken(token).getUniqueName();
    } catch (Exception e) {
      throw new UserInvalidException("获取用户名失败");
    }
    if (username == null) {
      return null;
    }
    UserInfo user = this.getUserByUsername(username);
    FrontUserRespDTO frontUser = new FrontUserRespDTO();
    BeanUtils.copyProperties(user, frontUser);
    List<PermissionInfo> permissionInfos = this.getPermissionByUsername(username);
    Stream<PermissionInfo> menus = permissionInfos.parallelStream().filter((permission) -> {
      return permission.getType().equals(CommonConstants.RESOURCE_TYPE_MENU);
    });
    frontUser.setMenus(menus.collect(Collectors.toList()));
    Stream<PermissionInfo> elements = permissionInfos.parallelStream().filter((permission) -> {
      return !permission.getType().equals(CommonConstants.RESOURCE_TYPE_MENU);
    });
    frontUser.setElements(elements.collect(Collectors.toList()));
    return frontUser;
  }

  public List<MenuTreeRespDTO> getMenusByUsername(String token) {
    String username = null;
    try {
      username = userAuthUtil.getInfoFromToken(token).getUniqueName();
    } catch (Exception e) {
      throw new UserInvalidException("获取用户名失败");
    }
    if (username == null) {
      return null;
    }
    BaseUserRespDTO user = baseUserService.selectByUserName(username);
    List<BaseMenuRespDTO> menus = baseMenuService.getUserAuthorityMenuByUserId(user.getId());
    return getMenuTree(menus, AdminCommonConstant.ROOT);
  }

  public Mono<CheckPermissionInfo> checkUserPermission(String username, String requestUri,
      String requestMethod) {
    CheckPermissionInfo checkPermissionInfo = new CheckPermissionInfo();
    List<PermissionInfo> allPermission = this.getAllPermission();
    // 判断当前访问资源是否有权限控制
    List<PermissionInfo> matchPermission = allPermission.parallelStream().filter(permissionInfo -> {
      String uri = permissionInfo.getUri();
      if (uri.indexOf("{") > 0) {
        uri = uri.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
      }
      String regEx = "^" + uri + "$";
      return (Pattern.compile(regEx).matcher(requestUri).find())
          && requestMethod.equals(permissionInfo.getMethod());
    }).collect(Collectors.toList());
    // 说明当前访问资源不做权限控制
    if (matchPermission.size() == 0) {
      checkPermissionInfo.setIsAuth(true);
      return Mono.just(checkPermissionInfo);
    }
    // 判断当前用户是否拥有该访问资源的权限
    List<PermissionInfo> permissions = this.getPermissionByUsername(username);
    PermissionInfo current = null;
    for (PermissionInfo info : permissions) {
      boolean anyMatch = matchPermission.parallelStream()
          .anyMatch(permissionInfo -> permissionInfo.getCode().equals(info.getCode()));
      if (anyMatch) {
        current = info;
        break;
      }
    }
    if (current == null) {
      // 当前用户不拥有该权限
      checkPermissionInfo.setIsAuth(false);
    } else {
      // 当前用户拥有该资源的访问权限
      checkPermissionInfo.setIsAuth(true);
      checkPermissionInfo.setPermissionInfo(current);
    }
    return Mono.just(checkPermissionInfo);
  }


}
