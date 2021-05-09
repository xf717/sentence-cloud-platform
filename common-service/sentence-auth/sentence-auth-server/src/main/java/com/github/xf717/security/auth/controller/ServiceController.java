package com.github.xf717.security.auth.controller;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.rest.BaseController;
import com.github.xf717.security.auth.biz.ClientBiz;
import com.github.xf717.security.auth.entity.Client;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaofeng
 * @create 2017/12/26.
 */
@RestController
@RequestMapping("service")
public class ServiceController extends BaseController<ClientBiz, Client> {

  @RequestMapping(value = "/{id}/client", method = RequestMethod.PUT)
  @ResponseBody
  public ObjectRestResponse updateUsers(@PathVariable int id, String clients) {
    baseBiz.updateClientServices(id, clients);
    return new ObjectRestResponse();
  }

  @RequestMapping(value = "/{id}/client", method = RequestMethod.GET)
  @ResponseBody
  public ObjectRestResponse<List<Client>> getUsers(@PathVariable int id) {
    return new ObjectRestResponse<List<Client>>().data(baseBiz.getClientServices(id));
  }
}
