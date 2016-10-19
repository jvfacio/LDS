/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service.impl.dummy;

import com.hxwr.lds.service.ICreateReportSrv;
import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.model.Payment;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.stereotype.Service;

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
        Calendar c = GregorianCalendar.getInstance();
        for(int i = 0; i < 20; i++) {
            payments.add(new Payment(100 * Math.random(), 100 * Math.random(), c));
            c = (Calendar) c.clone();
            c.add(Calendar.MONTH, 1);
        }
        return lr;
    }
}
