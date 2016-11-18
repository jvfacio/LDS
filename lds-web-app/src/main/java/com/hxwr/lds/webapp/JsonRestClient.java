/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import javax.ws.rs.core.MediaType;
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
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class JsonRestClient implements IRestClient, Serializable {
    
    private static final URI DEFAULT_URI = 
            UriBuilder.fromUri("http://localhost:8080/lds-api")
            .build();
    
    private final MediaType mediaType = MediaType.APPLICATION_JSON_TYPE;
    private URI baseUri;
    private Client client;
    
    public JsonRestClient() {
        this(DEFAULT_URI);
    }
    
    public JsonRestClient(URI uri) {
        this.baseUri = uri;
        
        //Configure the HTTP client
        ClientConfig clientConfig = new DefaultClientConfig();
        // Allow Jersey Client to support JSON.
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);   
        // Create jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // Create JacksonJaxbJsonProvider and add to client config
        JacksonJsonProvider jacksonProvider = new JacksonJsonProvider()
            .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        jacksonProvider.setMapper(mapper);
        clientConfig.getSingletons().add(jacksonProvider); 

        this.client = Client.create(clientConfig);
    }
    
    public JsonRestClient(String basePath) {
        this(UriBuilder.fromUri(basePath).build());
    }
    
    @Override
    public void makeRequest(String method, String path)
        throws IOException
    {
        makeRequestBuilder(path).method(method);
    }
    
    @Override
    public void makeRequest(String method, String path, Object param) 
        throws IOException
    {
        makeRequestBuilder(path).method(method, param);
    }
    
    @Override
    public <T> T makeRequest(String method, String path, Class<T> cls) 
        throws IOException
    {
        return makeRequestBuilder(path).method(method, cls);
    }
    
    @Override
    public <T> T makeRequest(String method, String path, Object param, Class<T> cls) 
        throws IOException
    {
        return makeRequestBuilder(path).method(method, cls, param);
    }
    
    private WebResource.Builder makeRequestBuilder(String path) 
        throws IOException
    {
        URI uri = UriBuilder.fromUri(baseUri)
                            .path(path)
                            .build();
        return client.resource(uri).type(mediaType).accept(mediaType);
    }

    /**
     * @return the baseUri
     */
    public URI getBaseUri() {
        return baseUri;
    }

    /**
     * @param baseUri the baseUri to set
     */
    public void setBaseUri(URI baseUri) {
        this.baseUri = baseUri;
    }
}
