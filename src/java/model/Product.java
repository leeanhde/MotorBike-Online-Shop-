/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tu
 */
public class Product {
    
    private int productId;
    private String ProductName;
    private String description;
    private int catID;
    private int originalPrice;
    private int sellPrice;
    private int amount;
    private String imgLink;
    private int IdDetail;

    public Product() {
    }

    public Product(int productId, String ProductName, String description, int catID, int originalPrice, int sellPrice, int amount, String imgLink, int IdDetail) {
        this.productId = productId;
        this.ProductName = ProductName;
        this.description = description;
        this.catID = catID;
        this.originalPrice = originalPrice;
        this.sellPrice = sellPrice;
        this.amount = amount;
        this.imgLink = imgLink;
        this.IdDetail = IdDetail;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public int getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(int IdDetail) {
        this.IdDetail = IdDetail;
    }
    
    
}
