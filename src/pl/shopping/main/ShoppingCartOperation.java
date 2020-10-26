package pl.shopping.main;

import java.util.List;

interface ShoppingCartOperation {

    int PRODUCTS_LIMIT = 500;

    boolean addProducts(String productName, int price, int quantity);

    /** Usuwa odpowiednia ilosc istniejacych produktow z koszyka */
    boolean deleteProducts(String productName, int quantity);

    /** Pobiera ilosc konkretnego produktu dostepnego w koszyku */
    int getQuantityOfProduct(String productName);

    /** Pobiera cene wszystkich produktow dostepnych w koszyku */
    int getSumProductsPrices();

    /** Pobiera cene konkretnego produktu z koszyka zakupowego
     * @return*/
    int getProductPrice(String productName);

    /** Pobiera nazwy wszystkich dostepnych produktow w koszyku */
    List<String> getProductsNames();
}