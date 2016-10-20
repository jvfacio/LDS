package com.hxwr.lds.core.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.model.LoanReport;

/**
 *
 * @author 35194
 */
public interface ICreateReportSrv {
    
    /**
     * Generate the loan report object
     * @param loan loan data
     * @param customer Customer data
     * @return a loan report data
     */
    
    public LoanReport CreateReport(Loan loan, Client client);
}
