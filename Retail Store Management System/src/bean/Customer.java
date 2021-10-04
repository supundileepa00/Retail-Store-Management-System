/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import util.Utility.JUtility;

public class Customer {
    String cID = null;
    String cName = null;
    String cAddress = null;
    String cNIC = null;
    String cEmail = null;
    String cPhone = null;

    public Customer() {
    }
    public Customer( String cID, String cName, String cAddress, String cNIC, String cEmail, String cPhone) {
        this.cID = JUtility.addPrefix("C", cID);
        this.cName = cName;
        this.cAddress = cAddress;
        this.cNIC = cNIC;
        this.cEmail = cEmail;
        this.cPhone = cPhone;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcNIC() {
        return cNIC;
    }

    public void setcNIC(String cNIC) {
        this.cNIC = cNIC;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
    
    
}
