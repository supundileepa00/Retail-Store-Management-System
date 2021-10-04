/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.connection.DBConnection;
import util.query.UserQuery;

public class UserService {
    public User loadSpecificUser(String uID) {
        User user = new User();
        Connection connection = DBConnection.getDBConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.LOAD_SPECIFIC_USER_DATA);
            preparedStatement.setString(1,uID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return user;
    }
}
