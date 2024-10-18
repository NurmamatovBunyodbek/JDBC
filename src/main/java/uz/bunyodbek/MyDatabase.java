package uz.bunyodbek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabase {

    String databaseURL = "jdbc:postgresql://localhost:5432/nurbek";
    String usernamedatabse="postgres";
    String passworddatabase="root";


    public void  create(User user){

        try {
            Connection connection= DriverManager.getConnection(databaseURL,usernamedatabse,passworddatabase);
            Statement statement = connection.createStatement();

            String query="insert into nurbek(id, name , surname , phonenumber) values ("+user.getId()+",'"+user.getName()+"','"+ user.getSurname()+"','"+user.getPhonenumber()+"');";
            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }






}
