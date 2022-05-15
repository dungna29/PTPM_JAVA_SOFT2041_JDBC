/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import DomainModels.Category;
import java.math.BigDecimal;


public class QLProduct {
  private Long id;
  private String name;
  private BigDecimal price; 
  private Category category;
  private double priceVAT; 
  private String check;

  public QLProduct() {
  }

  
  public QLProduct(Long id, String name, BigDecimal price, Category category) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.category = category;   
  }

  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public double getPriceVAT() { 
    return (((10/100)*getPrice().doubleValue())+ getPrice().doubleValue());

  }

  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }

  
  
}
