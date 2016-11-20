/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.controller;

import com.hxwr.lds.core.dao.ICustomerDao;
import com.hxwr.lds.core.dao.ILoanDao;
import com.hxwr.lds.core.dao.IPaymentDetailDao;
import com.hxwr.lds.core.entities.Loan;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
    @Autowired
    private ICustomerDao customerDao;
     @Autowired
    private IPaymentDetailDao paymentDao;
    
    @PostMapping("/client/{id}/createLoan")
    @Consumes("application/json")
    @Produces("application/json")
    public Loan addLoan(@PathVariable("id") int id, @RequestBody Loan loan){
        loan.setClientId(id);
        iLoanDao.addLoanDetails(loan);
        return loan;
    }
    @GetMapping("/loan/{id}")
    @Produces("application/json")
    public Loan getLoanById(@PathVariable("id") int id){
        return iLoanDao.getByLoanID(id);
    }
    
//    @GetMapping("/loan/total/{id}")
//    public List<PaymentDetail> getTotalsbyLoanID(@PathVariable("id") int id){
//        Loan loan = iLoanDao.getByLoanID(id);
//        return paymentDao.getTotalsbyLoanID(loan);
//    }
}
