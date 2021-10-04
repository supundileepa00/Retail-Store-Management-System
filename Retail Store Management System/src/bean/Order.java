/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import util.Utility.JUtility;

public class Order {
    String oID = null;
    String oIID = null;
    String oIName = null;
    int oQuantity = 0;
    double oTotalPrice = 0;
    String oCID = null;
    String oCName = null;
    String oDate = null;

    public Order() {
    }
    
    public Order(String oID,  String oIID, String oIName, int oQuantity, double oTotalPrice, String oCID, String oCName, String oDate) {
        this.oID = JUtility.addPrefix("ORD", oID);
        this.oIID = JUtility.addPrefix("IS", oIID);
        this.oIName = oIName;
        this.oQuantity = oQuantity;
        this.oTotalPrice = oTotalPrice;
        this.oCID = JUtility.addPrefix("C", oCID);
        this.oCName = oCName;
        this.oDate = oDate;
    }
    

    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getoIID() {
        return oIID;
    }

    public void setoIID(String oIID) {
        this.oIID = oIID;
    }

    public String getoIName() {
        return oIName;
    }

    public void setoIName(String oIName) {
        this.oIName = oIName;
    }

    public int getoQuantity() {
        return oQuantity;
    }

    public void setoQuantity(int oQuantity) {
        this.oQuantity = oQuantity;
    }

    public double getoTotalPrice() {
        return oTotalPrice;
    }

    public void setoTotalPrice(double oTotalPrice) {
        this.oTotalPrice = oTotalPrice;
    }

    public String getoCID() {
        return oCID;
    }

    public void setoCID(String oCID) {
        this.oCID = oCID;
    }

    public String getoDate() {
        return oDate;
    }

    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    public String getoCName() {
        return oCName;
    }

    public void setoCName(String oCName) {
        this.oCName = oCName;
    }
    
    
    
    
    
}
