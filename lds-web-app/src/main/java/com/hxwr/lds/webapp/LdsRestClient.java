/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp;

import java.net.URI;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 *
 * @author Training
 */
@Service("ldsRestClient")
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class LdsRestClient implements IRestClient {
    
    private static final URI DEFAULT_URI = 
            UriBuilder.fromUri("http://192.168.10.50:8081/lds-api")
            .build();
    
    public WebTarget target;
    
    public LdsRestClient(URI uri) {        
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        target = client.target(uri);
    }
    
    public LdsRestClient() {
        this(DEFAULT_URI);
    }
    
    public LdsRestClient(String basePath) {
        this(UriBuilder.fromUri(basePath).build());
    }
    
    @Override
    public Response makeRequest(String method, String path) {
        return makeInvocationBuilder(path).method(method);
    }
    
    @Override
    public Response makeReuqest(String method, String path, Entity<?> param) {
        return makeInvocationBuilder(path).method(method, param);
    }
    
    @Override
    public <T> T makeRequest(String method, String path, Class<T> cls) {
        return makeInvocationBuilder(path).method(method, cls);
    }
    
    @Override
    public <T> T makeRequest(String method, String path, Entity<?> param, Class<T> cls) {
        return makeInvocationBuilder(path).method(method, param, cls);
    }
    
    private Invocation.Builder makeInvocationBuilder(String path) {
        return target.path(path).request(MediaType.APPLICATION_JSON);
    }
}
