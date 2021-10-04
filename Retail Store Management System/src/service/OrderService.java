/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Customer;
import bean.Item;
import bean.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utility.JUtility;
import util.connection.DBConnection;
import util.query.OrderQuery;

public class OrderService {
    public ArrayList<Order> loadOrderList() {
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection connection = DBConnection.getDBConnection();
        
        CustomerService customerService = new CustomerService();
        InventoryService inventoryService = new InventoryService();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(OrderQuery.LOAD_ALL_ORDER_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = customerService.loadSpecificCustomer(JUtility.addPrefix("C", resultSet.getString(5)));
                Item item = inventoryService.loadSpecificCustomer(JUtility.addPrefix("I", resultSet.getString(2)));
                orderList.add(new Order(resultSet.getString(1),  resultSet.getString(2), item.getiName(), resultSet.getInt(3), resultSet.getDouble(4),resultSet.getString(5), customer.getcName(), resultSet.getString(6)));

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return orderList;
    }

    public boolean addOrder(Order order) {
        Connection connection = DBConnection.getDBConnection();
        InventoryService inventoryService = new InventoryService();
        Item existingItem = inventoryService.loadSpecificCustomer(order.getoIID());
        Item itemUpdate = new Item(); 
        itemUpdate.setiID(existingItem.getiID());
        System.out.println("ex: " +existingItem.getiQuantity() ) ;            
        System.out.println("ex: " +order.getoQuantity()) ;   
        itemUpdate.setiQuantity(existingItem.getiQuantity() - order.getoQuantity());
        System.out.println("ex `: " +itemUpdate.getiQuantity()) ;   
        if(inventoryService.updateItemQuantity(itemUpdate)){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(OrderQuery.INSERT_ORDER_DATA);
                preparedStatement.setInt(1, JUtility.seperateID(order.getoIID()));
                preparedStatement.setInt(2, order.getoQuantity());
                preparedStatement.setDouble(3, order.getoTotalPrice());
                preparedStatement.setInt(4, JUtility.seperateID(order.getoCID()));
                preparedStatement.setString(5, order.getoDate());
                preparedStatement.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }else{
            return false;
        }
        

    }

    public boolean updateOrder(Order order) {
        Connection connection = DBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(OrderQuery.UPDATE_ORDER_DATA);
            preparedStatement.setInt(1, JUtility.seperateID(order.getoIID()));
            preparedStatement.setInt(2, order.getoQuantity());
            preparedStatement.setDouble(3, order.getoTotalPrice());
            preparedStatement.setInt(4, JUtility.seperateID(order.getoCID()));
            preparedStatement.setString(5, order.getoDate());
            preparedStatement.setInt(5, JUtility.seperateID(order.getoID()));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deleteOrder(String id) {
        Connection connection = DBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(OrderQuery.DELETE_ORDER_DELETE);

            preparedStatement.setInt(1, JUtility.seperateID(id));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
