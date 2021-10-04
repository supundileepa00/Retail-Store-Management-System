/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.query;


public class OrderQuery {
    public static final String LOAD_ALL_ORDER_DATA = "SELECT * FROM orders";
    public static final String LOAD_SPECIFIC_ORDER_DATA = "SELECT * FROM orders WHERE orderID = ?";
    public static final String INSERT_ORDER_DATA = "INSERT INTO orders (itemID, quantity, totalPrice, customerID, orderDate) VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_ORDER_DATA = "UPDATE orders SET itemID = ?, quantity = ?, totalPrice = ?, customerID = ?, orderDate = ? WHERE orderID = ?";
    public static final String DELETE_ORDER_DELETE = "DELETE FROM orders WHERE orderID = ?";
}
