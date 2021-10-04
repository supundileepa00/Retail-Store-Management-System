/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    /*
     * Singleton design pattern is implemented to avoid creation of multiple instances of DBConnetion
     */
    private DBConnection() {
    }

    /*
     * initiates a new connection to database or returns the existing connection
     * @param {}
     * @returns java.sql.Connection
     */

    public static Connection getDBConnection(){

        if (conn == null) {
            DBConnection.setConnection();
        }
        return conn;
    }

    
    private static void setConnection(){
        /*
         * local mysql database credentials
         */
        String url = "jdbc:mysql://localhost/";
        String dbname = "rsms";
        String ssl = "?useSSL=false";
        //?allowPublicKeyRetrieval=true&
        String username = "root";
        String password = "1234";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + dbname +ssl , username, password);
        }catch(SQLException | ClassNotFoundException exception ){
            exception.printStackTrace();
        }

    }
}
