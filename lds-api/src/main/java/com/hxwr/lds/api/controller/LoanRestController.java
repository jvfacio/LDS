/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.controller;

import com.hxwr.lds.core.dao.ILoanDao;
import com.hxwr.lds.core.entities.Loan;
import javax.ws.rs.Consumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Training
 */
@RestController
public class LoanRestController {
    
    @Autowired
    private ILoanDao iLoanDao;
    
    @PostMapping("/client/{id}/createLoan")
    @Consumes("application/json")
    public void addLoan(@RequestBody  Loan loan){
        iLoanDao.addLoanDetails(loan);
    }
    @GetMapping("/loan/{id}")
    public Loan getLoanById(@PathVariable("id") int id){
     
        return iLoanDao.getByLoanID(id);
    }
}
