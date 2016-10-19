/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller.rest;

import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.service.ILoanSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Training
 */
@RestController
@RequestMapping("/rest")
public class LoanRestController {
    
    @Autowired
    private ILoanSrv iLoanSrv;
    
    @GetMapping("/client/#id/createLoan")
    public void addLoan(@RequestBody  Loan loan){
        iLoanSrv.addLoanDetails(loan);
    }
    @GetMapping("/loan/{#id}")
    public Loan getLoanById(@PathVariable("id") int id){
     
        return iLoanSrv.fetchLoanByID(id);
    }
}
