package com.github.xf717.security.auth.service;


import java.util.List;

/**
 *
 * @author xiaofeng
 * @date 2017/9/10
 */
public interface AuthClientService {

    /**
     * 获取授权的客户端列表
     * @param serviceId
     * @param secret
     * @return
     */
    public List<String> getAllowedClient(String serviceId, String secret);

    /**
     * 获取服务授权的客户端列表
     * @param serviceId
     * @return
     */
    public List<String> getAllowedClient(String serviceId);

    public void registryClient();

    public void validate(String clientId, String secret) throws Exception;
}
