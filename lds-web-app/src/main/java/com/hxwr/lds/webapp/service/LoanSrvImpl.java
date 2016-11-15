package com.hxwr.lds.webapp.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.hxwr.lds.core.service.ILoanSrv;
import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.webapp.IRestClient;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Training
 */
@Service
public class LoanSrvImpl implements ILoanSrv {
    @Autowired 
    IRestClient restClient;
    private static Loan loan;
    
    @Override
     public Loan fetchLoanByID(int loanID)throws IOException{
         loan=restClient.makeRequest("GET","/loan/" + loanID, Loan.class);
         return loan;
     }
     
     @Override
     public void addLoanDetails(Loan loan)throws IOException {        
        restClient.makeRequest("POST", "/client/"+ loan.getClient().getId()+ "/createLoan", loan);
     }
    
}
