package devsuperior.functionallambda.comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<Product> {

    @Override
    public int compare(Product product, Product otherProduct) {
        return product.getName().toUpperCase()
                .compareTo(otherProduct.getName().toUpperCase());
    }
}
