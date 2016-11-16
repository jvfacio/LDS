/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.service;

import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.service.IViewReportSrv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * A service for generating a LoanReport view.
 *
 * @author Training
 */
@Service
@Qualifier("PDFView")
public class PDFViewReportSrv implements IViewReportSrv {

    /**
     * Generates a view. Implementations should use t he request/response
     * objects to forward/redirect users to the correct resource (HTML, PDF,
     * etc).
     *
     * @param loan
     * @param request
     * @param response
     */
    @Override
    public void view(Loan loan, HttpServletRequest request, HttpServletResponse response) {

        Document document = new Document();

        try {
            response.setContentType("application/pdf");
            ServletOutputStream os = response.getOutputStream();
            PdfWriter.getInstance(document, os);

            document.open();

            document.addTitle("Loan Report");

            //add client information pdf
            document.add(new Paragraph("Name: " + loan.getClient().getName() + " " + loan.getClient().getlastName()));
            document.add(new Paragraph("Address: " + loan.getClient().getAddress()));
            document.add(new Paragraph("Phone Number: " + loan.getClient().getPhoneNumber()));
            document.add(new Paragraph("Salary: " + loan.getClient().getSalary()));

            //add loan information to pdf
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Loan Type: " + loan.getLoanType()));
            document.add(new Paragraph("Loan Amount: " + loan.getAmount()));
            document.add(new Paragraph("Loan Period: " + loan.getLoanPeriod()));
            document.add(Chunk.NEWLINE);

            //create table of payment objects
            PdfPTable table = new PdfPTable(4);

            //add table headers
            table.setHeaderRows(1);
            table.addCell("Payment #");
            table.addCell("Date");
            table.addCell("Payment");
            table.addCell("Balance");

            //add dates, payments, and balance to table
            for (int i = 0; i < loan.getPaymentDetail().size(); i++) {

                table.addCell(String.valueOf(i+1));
                //add date to table
                table.addCell(loan.getPaymentDetail().get(i).getFormattedDate());

                //add payment amount to table
                table.addCell(String.valueOf(loan.getAmount()));

                //add balance to table
                table.addCell(String.valueOf(loan.getPaymentDetail().get(i).getPrincipal()));

            }

            //add table rows to pdf
            document.add(table);

        } catch (IOException | DocumentException ex) {
            Logger.getLogger(PDFViewReportSrv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            document.close();
        }

    }

}
