/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author tulsi
 */
public class establishConnection {
//jdbc:postgresql://localhost:5432/Lab01        jdbc:postgresql://localhost:5432/

    public Connection conn = null;
    static String user = null;
    static String pass = null;
    static String db = null;

    establishConnection() {
        user = null;
        pass = null;
        db = null;
    }

    public String testForNull() {
        return user;
    }

    public establishConnection(String user, String pass, String db) {
        this.user = user;
        this.pass = pass;
        this.db = db;
    }

    public Connection establishConn() {

        try {
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String serverPort = "5432";
//            db = "solus";
//            user = "postgres";
//            pass = "password";
            String url = "jdbc:postgresql://" + serverName + ":" + serverPort + "/" + db;
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Successfully Connected to database!");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find database driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Could not connect to the database " + e.getMessage());
        }
        return conn;
    }

}
