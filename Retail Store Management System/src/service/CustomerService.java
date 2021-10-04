/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Utility.JUtility;
import util.connection.DBConnection;
import util.query.CustomerQuery;

public class CustomerService {
    public ArrayList<Customer> loadCustomerList() {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        Connection connection = DBConnection.getDBConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQuery.LOAD_ALL_CUSTOMER_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return customerList;
    }
    public Customer loadSpecificCustomer(String customerID) {
        Customer customer = null;
        Connection connection = DBConnection.getDBConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQuery.LOAD_SPECIFIC_CUSTOMER_DATA);
            preparedStatement.setInt(1, JUtility.seperateID(customerID));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return customer;
    }
}
