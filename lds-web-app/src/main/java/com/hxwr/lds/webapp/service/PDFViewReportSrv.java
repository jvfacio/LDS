/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.service;

import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.service.ICustomerSrv;
import com.hxwr.lds.core.service.IViewReportSrv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ICustomerSrv customerSrv;
    
    
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
    public void view(Loan loan, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Document document = new Document();
        Client client = customerSrv.getCustomer(loan.getClientId());
        ServletOutputStream os = null;
        try {
            response.setContentType("application/pdf");
            os = response.getOutputStream();
            PdfWriter.getInstance(document, os);
            response.setHeader("Content-Disposition", "attachment; filename=\"LoanReport.pdf\"");
            Font headerFont = new Font(FontFamily.UNDEFINED, 15.0f, Font.UNDERLINE | Font.BOLD);
            Font contentFont = new Font(FontFamily.UNDEFINED, 10.0f);
            DecimalFormat df = new DecimalFormat("0.00");

            double total_interest = 0;

            document.open();

            document.addTitle("Loan Report");

            //add client information pdf
            document.add(new Paragraph("Customer Details", headerFont));
            document.add(new Paragraph("Name: " + client.getName() + " " + client.getlastName(), contentFont));
            document.add(new Paragraph("Address: " + client.getAddress(), contentFont));
            document.add(new Paragraph("Phone Number: " + client.getPhoneNumber(), contentFont));
            document.add(new Paragraph("Salary: $" + df.format(client.getSalary()), contentFont));

            //add loan information to pdf
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Overview", headerFont));
            document.add(new Paragraph("Type: " + loan.getLoanType(), contentFont));
            document.add(new Paragraph("Period: " + loan.getLoanPeriod() + " Years", contentFont));
            document.add(new Paragraph("Interest: " + loan.getInterest() + "%", contentFont));
            document.add(new Paragraph("Principal: $" + df.format(loan.getAmount()), contentFont));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Payment Summary", headerFont));
            double paymentAmount = loan.getPaymentDetail().get(1).getInterest()+loan.getPaymentDetail().get(1).getPrincipal();
            document.add(new Paragraph("Monthly Payment: $" + df.format(paymentAmount), contentFont));
            document.add(new Paragraph("Total of " + loan.getPaymentDetail().size() + " Payments", contentFont));

            //get the sum of interest paid
            for (int i = 0; i < loan.getPaymentDetail().size(); i++) {
                total_interest += loan.getPaymentDetail().get(i).getInterest();
            }
            document.add(new Paragraph("Total Interest Paid: $" + df.format(total_interest), contentFont));

            //create table of payment objects
            PdfPTable table = new PdfPTable(6);
            document.add(Chunk.NEWLINE);

            //add table headers
            table.setHeaderRows(1);
            table.addCell("#");
            table.addCell("Date");
            table.addCell("Beginning Balance");
            table.addCell("Interest Paid");
            table.addCell("Principal Paid");
            table.addCell("Ending Balance");

            //add dates, payments, and balance to table
            for (int i = 0; i < loan.getPaymentDetail().size(); i++) {

                //add payment number to table
                table.addCell(new PdfPCell(new Phrase(String.valueOf(loan.getPaymentDetail().get(i).getNumOfPayment()), contentFont)));

                //add date to table
                table.addCell(loan.getPaymentDetail().get(i).getFormattedDate());

                //add beginning balance to table
                table.addCell(new PdfPCell(new Phrase("$" + df.format(loan.getPaymentDetail().get(i).getBeginningBalance()), contentFont)));

                //add interest to table
                table.addCell(new PdfPCell(new Phrase("$" + df.format(loan.getPaymentDetail().get(i).getInterest()), contentFont)));

                //add principal to table
                table.addCell(new PdfPCell(new Phrase("$" + df.format(loan.getPaymentDetail().get(i).getPrincipal()), contentFont)));

                //add ending balance to table
                table.addCell(new PdfPCell(new Phrase("$" + df.format(loan.getPaymentDetail().get(i).getEndingBalance()), contentFont)));

            }

            //add table rows to pdf
            document.add(table);

        } catch (DocumentException | IOException ex) {
            Logger.getLogger(PDFViewReportSrv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            document.close();
            if (os != null) {
                os.flush();
                os.close();
            }

        }

    }

}
