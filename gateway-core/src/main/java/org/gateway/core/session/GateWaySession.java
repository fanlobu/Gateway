package org.gateway.core.session;

import org.gateway.core.mapping.IGenericService;

import java.util.Map;

public interface GateWaySession {
     // session 的作用是建立请求和响应映射的连接
     // 1.获取泛化对象
     // 2.发起服务调用

     Configuration getConfiguration();


     IGenericService getMappendService(String uri);

     Object get(String methodName, Map<String,Object> params);
}
