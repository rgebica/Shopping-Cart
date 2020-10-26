package pl.shopping.main;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements ShoppingCartOperation {

    private final List<Product> products = new ArrayList<>();

    @Override
    public boolean addProducts(String productName, int price, int quantity) {
        if(getCurrentQuantity() + quantity > PRODUCTS_LIMIT || quantity <= 0 || price <= 0 || productName.isEmpty()) {
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
        return false;
    }

    @Override
    public int getQuantityOfProduct(String productName) {
        return 0;
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
