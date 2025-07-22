package chap05_jstl;

public class Product {
  
  private String model;
  private int price;
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  @Override
  public String toString() {
    return "Product [model=" + model + ", price=" + price + "]";
  }

}
