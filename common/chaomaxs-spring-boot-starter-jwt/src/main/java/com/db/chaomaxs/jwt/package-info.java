/**
 * jwt 原先放在auth-client中，这是一个公共的服务，不涉及到登录，如果放入该服务中， 会导致调用该服务的其它服务都必须配置jwt
 * 相关的信息，耦合度很高，所以这里抽出来主要是给涉及到登录模块使用,有user-service、company-service,system-service三个服务会涉及到登录
 */
package com.db.chaomaxs.jwt;
