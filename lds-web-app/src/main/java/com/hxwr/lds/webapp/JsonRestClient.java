/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.io.IOException;
import java.net.URI;
import javax.ws.rs.client.Client;
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
 * 
 * A Spring service for accessing lds-rest-api via a JSON/HTTP client
 */
@Service("jsonRestClient")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JsonRestClient implements IRestClient {
    
    private static final URI DEFAULT_URI = 
            UriBuilder.fromUri("http://192.168.10.50:8081/lds-api")
            .build();
    
    final ObjectMapper mapper = new ObjectMapper();
    final MediaType mediaType = MediaType.APPLICATION_JSON_TYPE;
    
    public WebTarget target;
    
    public JsonRestClient(URI uri) {
        Client client = ClientBuilder.newClient();
        client.register(JacksonJsonProvider.class);
        target = client.target(uri);
    }
    
    public JsonRestClient() {
        this(DEFAULT_URI);
    }
    
    public JsonRestClient(String basePath) {
        this(UriBuilder.fromUri(basePath).build());
    }
    
    @Override
    public Response makeRequest(String method, String path)
        throws IOException
    {
        return makeInvocationBuilder(path).method(method);
    }
    
    @Override
    public Response makeRequest(String method, String path, Object param) 
        throws IOException
    {
        return makeInvocationBuilder(path).method(method, Entity.entity(param, mediaType));
    }
    
    @Override
    public <T> T makeRequest(String method, String path, Class<T> cls) 
        throws IOException
    {
        return makeInvocationBuilder(path).method(method, cls);
    }
    
    @Override
    public <T> T makeRequest(String method, String path, Object param, Class<T> cls) 
        throws IOException
    {
        return makeInvocationBuilder(path).method(method, Entity.entity(param, mediaType), cls);
    }
    
    private Invocation.Builder makeInvocationBuilder(String path) 
        throws IOException
    {
        return target.path(path).request(MediaType.APPLICATION_JSON);
    }
}
