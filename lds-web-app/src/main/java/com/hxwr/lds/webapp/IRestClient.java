/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Training
 */
public interface IRestClient {

    Response makeRequest(String method, String path);

    <T> T makeRequest(String method, String path, Class<T> cls);

    <T> T makeRequest(String method, String path, Entity<?> param, Class<T> cls);
    
    <T> T makeRequest(String method, String path, GenericType<T> cls);

    <T> T makeRequest(String method, String path, Entity<?> param, GenericType<T> cls);

    Response makeReuqest(String method, String path, Entity<?> param);
    
}
