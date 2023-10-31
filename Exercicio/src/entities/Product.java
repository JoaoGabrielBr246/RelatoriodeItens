package entities;

public class Product {
    private String productName;
    private Double price;

    public Product(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    public Product(String productName) {
        this.productName = productName;
        // Se desejar, pode inicializar o preço aqui também
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}

