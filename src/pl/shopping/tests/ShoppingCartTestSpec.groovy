package pl.shopping.tests

import pl.shopping.main.ShoppingCart
import spock.lang.Specification

class ShoppingCartTestSpec extends Specification {

    def "shouldAddProductToCart"() {
        given:
        def shoppingCart = new ShoppingCart()

        when:
        boolean result = shoppingCart.addProducts("Apple", 123, 1)

        then:
        result == true
    }

    def "shouldNotAddProductToCart"() {
        given:
        def shoppingCart = new ShoppingCart()

        when:
        boolean result = shoppingCart.addProducts(productName, price, quantity)

        then:
        result == expected

        where:
        productName || price || quantity || expected
        "Apple"     || 123   || -1       || false
        "Milka"     || -123  || 0        || false
    }

    def "shouldDeleteProducts"() {

        given:
        def shoppingCart = new ShoppingCart()
        shoppingCart.addProducts("Apple", 123, 32)

        expect:
        shoppingCart.deleteProducts(productName, quantity) == expected

        where:
        productName | quantity | expected
        "Apple"     | 1        | true
    }

    def "checkQuantityAfterDelete"() {

        given:
        def shoppingCart = new ShoppingCart()
        shoppingCart.addProducts("Apple", 123, 32)

        when:
        shoppingCart.deleteProducts(productName, quantity)

        then:
        int quantityValue = shoppingCart.currentQuantity
        quantityValue == expected

        where:
        productName || quantity || expected
        "Apple"     || 1        || 31
        "Apple"     || 32       || 0
    }

    def "shouldNotDeleteProductQuantityTooBig"() {

        given:
        def shoppingCart = new ShoppingCart()
        shoppingCart.addProducts("Apple", 123, 32)

        expect:
        shoppingCart.deleteProducts(productName, quantity) == expected

        where:
        productName || quantity || expected
        "Apple"     || 55       || false
        "Apple"     || 55       || false
    }

    def "shouldGetQuantityOfProduct"() {
        given:
        def shoppingCart = new ShoppingCart()
        shoppingCart.addProducts("Apple", 123, 12)
        shoppingCart.addProducts("Milk", 321, 15)

        expect:
        shoppingCart.getQuantityOfProduct(productName) == expected

        where:
        productName | expected
        "Apple"     | 12
        "Milk"      | 15
    }

    def "shouldNotGetQuantityOfProduct"() {
        given:
        def shoppingCart = new ShoppingCart()
        shoppingCart.addProducts("Apple", 123, 12)
        shoppingCart.addProducts("Milk", 321, 15)

        expect:
        shoppingCart.getQuantityOfProduct(productName) == expected

        where:
        productName | expected
        "Coffe"     | 0
        "Tea"       | 0
    }

    def "GetSumProductsPrices"() {
    }

    def "GetProductPrice"() {
    }

    def "GetProductsNames"() {
    }

    def "GetCurrentQuantity"() {
    }
}
