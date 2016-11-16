/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hxwr.lds.core.entities.notusefullfornow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.entities.PaymentDetail;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Training
 */
public class loansApproved  implements Serializable {
    private int loanid;
    @JsonIgnore
    private Loan loan;
    private Date dateApproved;
    private Set<PaymentDetail> payDetail = new HashSet<PaymentDetail>(0);

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
    
    public Set<PaymentDetail> getPayDetail() {
        return payDetail;
    }

    public void setPayDetail(Set<PaymentDetail> payDetail) {
        this.payDetail = payDetail;
    }

    public int getLoanid() {
        return loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }
    
    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

}
