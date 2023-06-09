/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
/**
 *
 * @author leede
 */
public class DAOCategory extends MyDAO {

    public ArrayList<Category> listCate() {
        ArrayList<Category> listcate = new ArrayList<>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {                
               Category c = new Category();
               c.setId(rs.getInt("id"));
               c.setCategoryname(rs.getString("categoryname"));
               listcate.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Category List");
        }
        return listcate;
    }
}
