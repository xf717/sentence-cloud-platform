package com.db.chaomaxs.common.framework.rest;

import com.db.chaomaxs.common.framework.biz.BaseBiz;
import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.Query;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author xiaofeng
 * @create 2017-06-15 8:48
 */
@Deprecated
@Slf4j
public class BaseController<Biz extends BaseBiz, Entity> {

  @Autowired
  protected HttpServletRequest request;
  @Autowired
  protected Biz baseBiz;

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseBody
  public ObjectRestResponse<Entity> add(@RequestBody Entity entity) {
    baseBiz.insertSelective(entity);
    return new ObjectRestResponse<Entity>();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ObjectRestResponse<Entity> get(@PathVariable int id) {
    ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
    Object o = baseBiz.selectById(id);
    entityObjectRestResponse.data((Entity) o);
    return entityObjectRestResponse;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseBody
  public ObjectRestResponse<Entity> update(@RequestBody Entity entity) {
    baseBiz.updateSelectiveById(entity);
    return new ObjectRestResponse<Entity>();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public ObjectRestResponse<Entity> remove(@PathVariable int id) {
    baseBiz.deleteById(id);
    return new ObjectRestResponse<Entity>();
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  @ResponseBody
  public ObjectRestResponse<List<Entity>> all() {
    return new ObjectRestResponse<>().data(baseBiz.selectListAll());
  }

  @RequestMapping(value = "/page", method = RequestMethod.GET)
  @ResponseBody
  public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params) {
    //查询列表数据
    Query query = new Query(params);
    return baseBiz.selectByQuery(query);
  }

  public String getCurrentUserName() {
    return BaseContextHandler.getUsername();
  }
}
