/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.query;

public class CustomerQuery {
    public static final String LOAD_ALL_CUSTOMER_DATA = "SELECT * FROM customer";
    public static final String LOAD_SPECIFIC_CUSTOMER_DATA = "SELECT * FROM customer WHERE customerID = ?";
}
