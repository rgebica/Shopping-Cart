package pl.shopping.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart implements ShoppingCartOperation {

    private final List<Product> products = new ArrayList<>();
    private final int NO_PRODUCT = 0;

    @Override
    public boolean addProducts(String productName, int price, int quantity) {
        if (getCurrentQuantity() + quantity > PRODUCTS_LIMIT || quantity <= 0 || price <= 0 || productName.isEmpty()) {
            return false;
        }
        if (isAlreadyInCart(productName)) {
            products.stream()
                    .filter(product -> product.getProductName().equals(productName))
                    .map(product -> {
                        product.setQuantity(product.getQuantity() + quantity);
                        return true;
                    });
        }
        products.add(new Product(productName, price, quantity));
        return true;
    }


    @Override
    public boolean deleteProducts(String productName, int quantity) {

        if (quantity <= 0) {
            return false;
        }

        Optional<Product> product = products.stream()
                .filter(p -> p.getProductName().equals(productName))
                .findFirst();

        return product
                .map(p -> {
                    if (quantity > p.getQuantity()) {
                        return false;
                    } else {
                        p.setQuantity(p.getQuantity() - quantity);
                    }
                    return true;
                })
                .orElse(false);
    }

    @Override
    public int getQuantityOfProduct(String productName) {

        Optional<Product> product = products.stream()
                .filter(p -> p.getProductName().equals(productName))
                .findFirst();

        return product
                .map(Product::getQuantity)
                .orElse(NO_PRODUCT);
    }

    @Override
    public int getSumProductsPrices() {
        return 0;
    }

    @Override
    public int getProductPrice(String productName) {
        return 0;
    }

    @Override
    public List<String> getProductsNames() {
        return null;
    }

    public int getCurrentQuantity() {
        return products.stream()
                .mapToInt(Product::getQuantity)
                .sum();
    }

    private boolean isAlreadyInCart(String productName) {
        return products.stream()
                .anyMatch(product -> product.getProductName().equals(productName));
    }

}
