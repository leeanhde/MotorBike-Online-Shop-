/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author leede
 */
public class DAOProduct extends MyDAO {

    public ArrayList<Product> listProduct() {
        ArrayList<Product> productlist = new ArrayList<>();
        xSql = "select * from Product";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("description"));
                p.setCatID(rs.getInt("catId"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setAmount(rs.getInt("amount"));
                p.setImgLink(rs.getString("imgLink"));
                p.setIdDetail(rs.getInt("IdDetail"));
                productlist.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Product List");
        }
        return productlist;
    }

    public Product insertProduct(Product p) {
        xSql = "INSERT INTO [dbo].[Product]\n"
                + "           ([ProductID]\n"
                + "           ,[ProductName]\n"
                + "           ,[Description]\n"
                + "           ,[OriginalPrice]\n"
                + "           ,[SellPrice]\n"
                + "           ,[CatID]\n"
                + "           ,[Amount]\n"
                + "           ,[ImgLink]\n"
                + "           ,[IdDetail])\n"
                + "     VALUES\n"
                + "           ?,\n"
                + "		   ?,\n"
                + "		   ?,\n"
                + "		   ?,\n"
                + "		   ?,\n"
                + "		   ?,\n"
                + "		   ?,\n"
                + "		   ?,\n"
                + "		   ?,\n"
                + "		   ?";
        try {

        } catch (Exception e) {
            System.out.println("Insert Product");
        }
        return null;
    }
}
