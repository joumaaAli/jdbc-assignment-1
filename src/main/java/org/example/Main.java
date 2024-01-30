package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/systemDis";
        String user = "postgres";
        String password = "aallii11";

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Process the results
            while (resultSet.next()) {
                String column1 = resultSet.getString("first_name");
                String column2 = resultSet.getString("last_name");

                // Process the data as needed
                System.out.println(column1 + ", " + column2);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
