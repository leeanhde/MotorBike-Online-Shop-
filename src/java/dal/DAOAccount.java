/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import model.Product;

/**
 *
 * @author hieub
 */
public class DAOAccount extends MyDAO {

    public Account login(String user, String pass) {

        try {
            String sql = "SELECT * from Account\n"
                    + "where Username = ? and Password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {

                int userId = rs.getInt("Id");
                String userName = rs.getString("Username");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String phoneNum = rs.getString("PhoneNum");
                String displayname = rs.getString("Displayname");

                return new Account(userId, userName, password, email, phoneNum, displayname);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void change(Account a) {
        xSql = "update Account set password=? where username=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void updateProfile(Account a) {
        xSql = "Update Account Set Username = ?, Email = ?, PhoneNum = ?\n"
                + "Where Id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getPhoneNum());
            ps.setInt(4, a.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update Profile");
        }
    }

    public Account getUserById(int id) {
        xSql = "SELECT * FROM Account WHERE Id = ?";
        Account a = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account();
                a.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setEmail(rs.getString("email"));
                a.setPhoneNum(rs.getString("phoneNum"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("getUserById");
        }
        return a;
    }

    public ArrayList<Product> listProduct() {
        ArrayList<Product> productlist = new ArrayList<>();
        xSql = "select * from Product";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("ProductName"));
                p.setDescription(rs.getString("description"));
                p.setColor(rs.getString("color"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setAmount(rs.getInt("amount"));
                p.setImgLink(rs.getString("imgLink"));
                productlist.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Product List");
        }
        return productlist;
    }
}
