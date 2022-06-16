package devsuperior.functionallambda.comparator;

public class Product {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }

    public static boolean staticProductPredicate(Product product) {
        return product.getPrice() >= 100;
    }

    public boolean nonStaticProductPredicate() {
        return this.price >= 100;
    }

    public static void staticPriceUpdate(Product product) {
        product.setPrice(product.getPrice() * 2);
    }

    public void nonStaticPriceUpdate() {
        this.price *= 2;
    }

    public static String staticUpperCaseName(Product product) {
        return product.getName().toUpperCase();
    }

    public String nonStaticUpperCaseName() {
        return this.name.toUpperCase();
    }
}
