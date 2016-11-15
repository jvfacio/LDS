/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.core.service;

import com.hxwr.lds.core.entities.Loan;
import java.io.IOException;

/**
 *
 * @author Training
 */
public interface ILoanSrv {
    
    public Loan fetchLoanByID(int loanID) throws IOException;
    public void addLoanDetails(Loan loan) throws IOException;
}
