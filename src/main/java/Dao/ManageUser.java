package Dao;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageUser {
    static Connection connection = ConnectionSQL.getConnection();

    public static ArrayList<User> showUser() throws Exception {
        String sqlSelect = "select * from user" ;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        ArrayList<User> listUser = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ten = resultSet.getString("ten");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String diachi = resultSet.getString("diachi");
            String birthday = resultSet.getString("birthday");
            String userName = resultSet.getString("userName");
            String passWord = resultSet.getString("passWord");

            listUser.add(new User(id,ten,sdt,email,diachi,birthday,userName,passWord));

        }
        return listUser;
    }
    public static void saveUser(User user) throws Exception {
        String sqlSave = "insert into user(ten,sdt,email,diachi,birthday,userName,passWord) value (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSave);

        preparedStatement.setString(1,user.getTen());
        preparedStatement.setString(2,user.getSdt());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getDiachi());
        preparedStatement.setString(5,user.getBirthday());
        preparedStatement.setString(6,user.getUserName());
        preparedStatement.setString(7,user.getPassWord());
        preparedStatement.execute();
    }

    public static void deleteUser(int id) throws Exception {
        String sqlDelete = "delete from user where id = ?" ;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
}
