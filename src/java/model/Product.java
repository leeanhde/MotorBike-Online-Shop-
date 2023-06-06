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
    private String color;
    private int originalPrice;
    private int sellPrice;
    private Category category;
    private Account seller;
    private int amount;
    private String imgLink;

    public Product() {
    }

    public Product(int productId, String ProductName, String description, String color, int originalPrice, int sellPrice, Category category, Account seller, int amount, String imgLink) {
        this.productId = productId;
        this.ProductName = ProductName;
        this.description = description;
        this.color = color;
        this.originalPrice = originalPrice;
        this.sellPrice = sellPrice;
        this.category = category;
        this.seller = seller;
        this.amount = amount;
        this.imgLink = imgLink;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getSeller() {
        return seller;
    }

    public void setSeller(Account seller) {
        this.seller = seller;
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

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", ProductName=" + ProductName + ", description=" + description + ", color=" + color + ", originalPrice=" + originalPrice + ", sellPrice=" + sellPrice + ", category=" + category + ", seller=" + seller + ", amount=" + amount + ", imgLink=" + imgLink + '}';
    }
    
    
}
