package com.db.chaomaxs.security.auth.mapper;

import com.db.chaomaxs.security.auth.entity.ClientService;
import tk.mybatis.mapper.common.Mapper;

public interface ClientServiceMapper extends Mapper<ClientService> {
    void deleteByServiceId(int id);
}
