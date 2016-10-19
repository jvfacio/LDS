/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

/**
 *
 * @author Training
 */
import com.hxwr.lds.ClientSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"clientSession"})
public abstract class AbstractSessionAwareController {
    
    @ModelAttribute("clientSession")
    
    public ClientSession defaultClientSession() {
        return new ClientSession();
    }
}
