/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import model.CartProduct;

/**
 *
 * @author leede
 */
public class DAOCart extends MyDAO {

    public ArrayList<CartProduct> viewcart(int id) {
        ArrayList<CartProduct> viewcart = new ArrayList<>();
        xSql = "select p.ImgLink, p.ProductName, p.SellPrice, cp.Amount \n"
                + "from Product p left join CartProduct cp \n"
                + "on p.ProductID = cp.productId left join Cart c \n"
                + "on cp.cartId = c.ID left join Account a \n"
                + "on c.UserID = a.Id\n"
                + "where a.Id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("view cart");
        }
        return viewcart;
    }

    public void addtocart(CartProduct t) {
        xSql = "INSERT INTO CartProduct (cartId,productId,Amount) VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, t.getCartid());
            ps.setInt(2, t.getProductid());
            ps.setDouble(3, t.getAmount());
        } catch (SQLException e) {
            System.out.println("add to cart");
        }
    }

}
