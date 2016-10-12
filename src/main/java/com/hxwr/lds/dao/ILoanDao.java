/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.dao;

import com.hxwr.lds.entities.Loan;

/**
 *
 * @author Training
 */
public interface ILoanDao {
    
    public void addLoanDetails(Loan loan);
    public Loan getByLoanID(Integer loanID);
}
