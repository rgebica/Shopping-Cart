package pl.shopping.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.shopping.main.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;


class ShoppingCartTest {
    @DisplayName("Should add products to cart")
    @ParameterizedTest
    @CsvSource({
            "Apple, 14, 1",
            "Orange, 7, 3",
            "Milk, 1, 2"
    })
    void shouldAddProductsToCart(String productName, int price, int quantity) {
        //given
        final ShoppingCart shoppingCart = new ShoppingCart();
        //when
        final boolean result = shoppingCart.addProducts(productName, price, quantity);
        //then
        assertTrue(result);
    }

    @DisplayName("Should not add products to cart")
    @ParameterizedTest
    @CsvSource({
            "Apple, 14, -2",
            "Orange, 0, 3",
            "Milk, 1, -2"
    })
    void shouldNotAddProductsToCart(String productName, int price, int quantity) {
        //given
        final ShoppingCart shoppingCart = new ShoppingCart();
        //when
        final boolean result = shoppingCart.addProducts(productName, price, quantity);
        //then
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void deleteProducts() {
    }

    @org.junit.jupiter.api.Test
    void getQuantityOfProduct() {
    }

    @org.junit.jupiter.api.Test
    void getSumProductsPrices() {
    }

    @org.junit.jupiter.api.Test
    void getProductPrice() {
    }

    @org.junit.jupiter.api.Test
    void getProductsNames() {
    }
}