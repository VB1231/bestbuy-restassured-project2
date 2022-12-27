package com.bestbuy.model;

import java.util.List;

public class ProductPojo {
    private Integer id;
    private String name;
  //  private String type;
    private Integer price;
  //  private Integer upc;
   // private Integer shipping;
  //  private String description;
    private String manufacturer ;
    private String model;
    //private String url;
 //   private String image;
    private Integer createdAt;
   // private Integer updatedAt;
    private List<String>categories ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
