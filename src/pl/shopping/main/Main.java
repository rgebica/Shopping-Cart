package pl.shopping.main;

public class Main {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProducts("Orange", 12, 5);
        shoppingCart.addProducts("Apple", 12, 499);

        shoppingCart.addProducts("Milk", 12, 2);
        shoppingCart.deleteProducts("Apple", 12);
    }
}
