/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service.impl;

import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.service.IViewReportSrv;

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

/** A service for generating a LoanReport view.
 *
 * @author Training
 */
public class PDFViewReportSrv implements IViewReportSrv {
    
    /** Generates a view. Implementations should use t he request/response objects
     *  to forward/redirect users to the correct resource (HTML, PDF, etc).
     * @param loan
     * @param request
     * @param response 
     */
    @Override
    public void view(LoanReport loan, HttpServletRequest request, HttpServletResponse response){
        
        
        Document document = new Document();
        
        try {
            response.setContentType("application/pdf");
            ServletOutputStream os = response.getOutputStream();
            PdfWriter.getInstance(document, os);
            
            document.open();
            
            document.addTitle("Loan Report");
            
            //add client information pdf
            document.add(new Paragraph("Name: " + loan.getClient().getName()+" " + loan.getClient().getlastName()));
            document.add(new Paragraph("Address: " + loan.getClient().getAddress()));
            document.add(new Paragraph("Phone Number: " + loan.getClient().getPhoneNumber()));
            document.add(new Paragraph("Salary: " + loan.getClient().getSalary()));
            
            //add loan information to pdf
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Loan Type: " + loan.getLoan().getLoanType()));
            document.add(new Paragraph("Loan Amount: " + loan.getLoan().getAmount()));
            document.add(new Paragraph("Loan Period: " + loan.getLoan().getLoanPeriod()));
            document.add(Chunk.NEWLINE);
            //create table of payment objects
            PdfPTable table = new PdfPTable(3);
          
            //add table headers
            table.setHeaderRows(1);
            table.addCell("Date");
            table.addCell("Payment");
            table.addCell("Balance");
            
            //add dates, payments, and balance to table
            for(int i = 0; i < loan.getMonthPaymentLst().size(); i++){
                
                //add date to table
                table.addCell(loan.getMonthPaymentLst().get(i).getFormattedDate());
                
                //add payment amount to table
                table.addCell(""+loan.getMonthPaymentLst().get(i).getAmount());
                
                //add balance to table
                table.addCell(""+loan.getMonthPaymentLst().get(i).getPrincipal());
                
                //add table row to pdf
                document.add(table);
            }
            
            
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(PDFViewReportSrv.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            document.close();
        }
    
    }
    
}
