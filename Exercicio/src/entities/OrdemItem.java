package entities;

public class OrdemItem {
    private Integer quantity;
    private Double price;
    private Product productName;

    public OrdemItem(Integer quantity, Double price, Product productName) {
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getName() {
        return productName;
    }

    public void setName(Product name) {
        this.productName = name;
    }

    public double subTotal() {
        return quantity * price;
    }

    public String toString() {
        return String.format("%s, $%.2f, Quantity: %d, Subtotal: $%.2f", productName, price, quantity, subTotal());
    }

    public OrdemItem() {

    }
}
