/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp;

import java.io.IOException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Training
 */
public interface IRestClient {

    Response makeRequest(String method, String path) throws IOException;
    
    Response makeRequest(String method, String path, Object param) throws IOException;

    <T> T makeRequest(String method, String path, Class<T> cls) throws IOException;

    <T> T makeRequest(String method, String path, Object param, Class<T> cls) throws IOException;
}
