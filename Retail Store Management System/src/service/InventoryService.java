/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
import util.query.ItemQuery;
import util.query.OrderQuery;

public class InventoryService {
    public ArrayList<Item> loadInventoryItemsList() {
        ArrayList<Item> itemList = new ArrayList<Item>();
        Connection connection = DBConnection.getDBConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ItemQuery.LOAD_ALL_ITEM_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                itemList.add(new Item(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7)));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return itemList;
    }
    public Item loadSpecificCustomer(String itemID) {
        Item item = null;
        Connection connection = DBConnection.getDBConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ItemQuery.LOAD_SPECIFIC_ITEM_DATA);
            preparedStatement.setInt(1, JUtility.seperateID(itemID));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                item = new Item(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getString(7));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return item;
    }
    public boolean updateItemQuantity(Item item) {
        Connection connection = DBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ItemQuery.UPDATE_ORDER_QUANTITY_DATA);
            preparedStatement.setInt(1, item.getiQuantity());
            preparedStatement.setInt(2, JUtility.seperateID(item.getiID()));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
