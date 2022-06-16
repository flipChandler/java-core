package devsuperior.functionallambda.consumer;

import devsuperior.functionallambda.comparator.Product;

import java.util.function.Consumer;

public class PriceUpdate implements Consumer<Product> {

    @Override
    public void accept(Product product) {
        product.setPrice(product.getPrice() * 2);
    }
}
