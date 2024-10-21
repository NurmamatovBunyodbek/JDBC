package uz.bunyodbek;

import java.sql.*;

public class MyDatabase {

    String databaseURL = "jdbc:postgresql://localhost:5432/nurbek";
    String usernamedatabse = "postgres";
    String passworddatabase = "root";


    public void create(User user) {

        try {
            Connection connection = DriverManager.getConnection(databaseURL, usernamedatabse, passworddatabase);
            Statement statement = connection.createStatement();

            String query = "insert into nurbek(id, name , surname , phonenumber) values (" + user.getId() + ",'" + user.getName() + "','" + user.getSurname() + "','" + user.getPhonenumber() + "');";
            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void read() {
        try {
            Connection connection = DriverManager.getConnection(databaseURL, usernamedatabse, passworddatabase);
            Statement statement = connection.createStatement();
            String query = "select * from nurbek";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString(4);

                User user = new User(id, name, surname, phone);
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) {

        try {
            Connection connection = DriverManager.getConnection(databaseURL, usernamedatabse, passworddatabase);
            Statement statement = connection.createStatement();
            String query = "delete from nurbek where id=" + id;

            statement.execute(query);
            System.out.println("O'chirildi");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update( int id , String newname) {

        try {
            Connection connection = DriverManager.getConnection(databaseURL, usernamedatabse, passworddatabase);
            Statement statement = connection.createStatement();

            String query = "update nurbek set name='" + newname + "' where id=" + id;
            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateSurname( int id , String newsurname) {

        try {
            Connection connection = DriverManager.getConnection(databaseURL, usernamedatabse, passworddatabase);
            Statement statement = connection.createStatement();

            String query = "update nurbek set surname='" + newsurname + "' where id=" + id;
            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
