package dao;

import models.SanPham;

import java.sql.*;
import java.util.ArrayList;

public class CrudSanPham {
    ConnectionCSDL connectionCSDL;
    Connection connection = connectionCSDL.getConnection();

    public ArrayList<SanPham> showSp() throws SQLException {
        String sqlselect = "select *from sanpham";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlselect);
        ArrayList<SanPham> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ten = resultSet.getString("ten");
            Double gia = resultSet.getDouble("gia");
            int idloai = resultSet.getInt("idloai");
            String img = resultSet.getString("img");
            list.add(new SanPham(id, ten, gia, idloai, img));

        }
        return list;

    }

    public void saveSp(SanPham sanPham) throws SQLException {
        String sqlsave = "insert into sanpham value(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlsave);
        preparedStatement.setInt(1, sanPham.getId());
        preparedStatement.setString(2, sanPham.getTen());
        preparedStatement.setDouble(3, sanPham.getGia());
        preparedStatement.setInt(4, sanPham.getIdloai());
        preparedStatement.setString(5, sanPham.getImg());
        preparedStatement.execute();

    }

    public void editSp(int indexedit, SanPham sanPham) throws SQLException {
        String sqledit = "update sanpham set ten=? , gia=? , idloai=? , img=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqledit);
        preparedStatement.setInt(5, sanPham.getId());
        preparedStatement.setString(1, sanPham.getTen());
        preparedStatement.setDouble(2, sanPham.getGia());
        preparedStatement.setInt(3, sanPham.getIdloai());
        preparedStatement.setString(4, sanPham.getImg());
        preparedStatement.execute();

    }

    public void deleteSp(int id) throws SQLException {
        String sqldelete = "delete from sanpham where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqldelete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();

    }
}

