/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service.impl;

import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.service.IViewReportSrv;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Training
 */
@Service
@Qualifier("HTMLView")
public class HTMLViewReportSrv implements IViewReportSrv {
    
    @Override
    public void view(LoanReport loan, HttpServletRequest request, HttpServletResponse response)  {
        try {
            HttpSession session = request.getSession();
             //set report attribute
            session.setAttribute("report", loan);
            //redirect the loan to the display loan jsp
            request.getRequestDispatcher("/WEB-INF/views/displayloan.jsp")
                    .forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(HTMLViewReportSrv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HTMLViewReportSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
