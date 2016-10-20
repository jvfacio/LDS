/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.service;

import com.hxwr.lds.model.LoanReport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** A service for generating a LoanReport view.
 *
 * @author Training
 */
public interface IViewReportSrv {
    
    /** Generates a view. Implementations should use t he request/response objects
     *  to forward/redirect users to the correct resource (HTML, PDF, etc).
     * @param loan
     * @param request
     * @param response 
     */
    public void view(LoanReport loan, HttpServletRequest request, HttpServletResponse response);

}
