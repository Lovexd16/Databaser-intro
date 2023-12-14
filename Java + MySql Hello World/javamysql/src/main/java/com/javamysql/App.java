package com.javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String url = "jdbc:mysql://localhost:3306/javamysql";
        String user = "javamysql";
        String password = "javamysql";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

            String insertQuery = "INSERT INTO hello (name) VALUES ('mysql')";
            conn.createStatement().executeUpdate(insertQuery); //Skapar nytt värde i databasen

            String query = "SELECT * FROM hello"; //Skriv SQL kommandon med stora bokstäver
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) { //next betyder så länge det finns nånting mer att loopa igenom
                System.out.println("Hello " + rs.getString("name") + "!");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
