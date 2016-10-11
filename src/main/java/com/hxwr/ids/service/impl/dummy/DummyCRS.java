/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.ids.service.impl.dummy;

import com.hxwr.ids.service.ICreateReportSrv;
import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.model.Payment;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 35194
 */
public class DummyCRS implements ICreateReportSrv {

    @Override
    public LoanReport CreateReport(Loan loan, Client client) {
        LoanReport lr = new LoanReport();
        lr.setLoan(loan);
        lr.setClient(client);
        List<Payment> payments = lr.getMonthPaymentLst();
        Date d = new Date();
        for(int i = 0; i < 20; i++) {
            payments.add(new Payment(100 * Math.random(), 100 * Math.random(), d));
            d = (Date)d.clone();
            d.setMonth(d.getMonth() + 1);
        }
        return lr;
    }
}
