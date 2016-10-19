/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

public class Client implements java.io.Serializable{

    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String salary;
    private String lastName;
    private String nickName;
    @JsonIgnore
    private String pass;
    private Set<Loan> loans = new HashSet<Loan>();
    
    public Client() { super(); }
    
    public Client(String namec,String phoneNumberc, String addressc, String salaryc, String lastnamec, String nicknamec, String passc){
        setName(namec);
        setPhoneNumber(phoneNumberc);
        setAddress(addressc);
        setSalary(salaryc);
        setlastName(lastnamec);
        setNickName(nicknamec);
        setPass(passc);
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the loans
     */
    public Set<Loan> getLoans() {
        return loans;
    }

    /**
     * @param loans the loans to set
     */
    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public boolean addLoan(Loan loan) {
        return loans.add(loan);
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return the Lastname
     */
    public String getlastName() {
        return lastName;
    }

    /**
     * @param Lastname the Lastname to set
     */
    public void setlastName(String Lastname) {
        this.lastName = Lastname;
    }

}
