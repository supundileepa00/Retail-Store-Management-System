/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import util.Utility.JUtility;

public class Item {
   String iID = null;
   String iName = null;
   int iQuantity = 0;
   double iBuyingPrice = 0;
   double iSellingPrice = 0;
   double iTotalCost = 0;
   String iStockDate = null;

    public Item() {
    }
    public Item( String iID, String iName, int iQuantity, double iBuyingPrice, double iSellingPrice, double iTotalCost, String iStockDate) {
        this.iID = JUtility.addPrefix("IS", iID);
        this.iName = iName;
        this.iQuantity = iQuantity;
        this.iBuyingPrice = iBuyingPrice;
        this.iSellingPrice = iSellingPrice;
        this.iTotalCost = iTotalCost;
        this.iStockDate = iStockDate;
    }
    

    public String getiID() {
        return iID;
    }

    public void setiID(String iID) {
        this.iID = iID;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public int getiQuantity() {
        return iQuantity;
    }

    public void setiQuantity(int iQuantity) {
        this.iQuantity = iQuantity;
    }

    public double getiBuyingPrice() {
        return iBuyingPrice;
    }

    public void setiBuyingPrice(double iBuyingPrice) {
        this.iBuyingPrice = iBuyingPrice;
    }

    public double getiSellingPrice() {
        return iSellingPrice;
    }

    public void setiSellingPrice(double iSellingPrice) {
        this.iSellingPrice = iSellingPrice;
    }

    public double getiTotalCost() {
        return iTotalCost;
    }

    public void setiTotalCost(double iTotalCost) {
        this.iTotalCost = iTotalCost;
    }

    public String getiStockDate() {
        return iStockDate;
    }

    public void setiStockDate(String iStockDate) {
        this.iStockDate = iStockDate;
    }
   
   
}
