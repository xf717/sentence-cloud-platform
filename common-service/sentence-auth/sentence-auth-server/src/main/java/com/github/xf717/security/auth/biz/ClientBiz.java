package com.github.xf717.security.auth.biz;

import com.github.xf717.common.framework.biz.BaseBiz;
import com.github.xf717.security.auth.entity.Client;
import com.github.xf717.security.auth.entity.ClientService;
import com.github.xf717.security.auth.mapper.ClientMapper;
import com.github.xf717.security.auth.mapper.ClientServiceMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author xiaofeng
 * @date 2017-12-26 19:43:46
 */
@Service
public class ClientBiz extends BaseBiz<ClientMapper, Client> {

  @Autowired
  private ClientServiceMapper clientServiceMapper;
  @Autowired
  private ClientServiceBiz clientServiceBiz;

  public List<Client> getClientServices(int id) {
    return mapper.selectAuthorityServiceInfo(id);
  }

  public void updateClientServices(int id, String clients) {
    clientServiceMapper.deleteByServiceId(id);
    if (!StringUtils.isEmpty(clients)) {
      String[] mem = clients.split(",");
      for (String m : mem) {
        ClientService clientService = new ClientService();
        clientService.setServiceId(m);
        clientService.setClientId(id + "");
        clientServiceBiz.insertSelective(clientService);
      }
    }
  }
}
