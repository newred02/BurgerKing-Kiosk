package kiosk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.lang.model.type.NullType;
import java.util.ArrayList;


class ShoppingCartTest {

    @Test
    void addHamburgerToShoppingCartTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addHamburgerToShoppingCart(1);
        Assertions.assertEquals(shoppingCart.getMenu(),"와퍼");
        Assertions.assertEquals(shoppingCart.getPrice(),6900);
        Assertions.assertEquals(1, shoppingCart.getQuantityOfMenu());
    }

    @Test
    void addSideMenuToShoppingCartTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addSideMenuToShoppingCart(1);
        Assertions.assertEquals(shoppingCart.getMenu(),"너겟킹");
        Assertions.assertEquals(shoppingCart.getPrice(),2500);
        Assertions.assertEquals(1, shoppingCart.getQuantityOfMenu());
    }

    @Test
    void addBeverageMenuToShoppingCartTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBeverageMenuToShoppingCart(1);
        Assertions.assertEquals(shoppingCart.getMenu(),"코카콜라");
        Assertions.assertEquals(shoppingCart.getPrice(),2000);
        Assertions.assertEquals(1, shoppingCart.getQuantityOfMenu());
    }

    @Test
    void changeQuantityOfSelectedMenuTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();
        int selectedMenuQuantity = 0;

        shoppingCart.addHamburgerToShoppingCart(1);
        shoppingCarts.add(shoppingCart);
        shoppingCart.changeQuantityOfSelectedMenu(shoppingCarts, 1, 20);
        for(ShoppingCart selectedShoppingCart: shoppingCarts){
            selectedMenuQuantity = selectedShoppingCart.getQuantityOfMenu();
        }
        Assertions.assertEquals(20,selectedMenuQuantity);
    }

    @Test
    void deleteMenuFromShoppingCartTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();
        ArrayList<ShoppingCart> modifiedShoppingCarts = new ArrayList<>();
        ArrayList<ShoppingCart> expectedShoppingCarts = new ArrayList<>();

        shoppingCart.addHamburgerToShoppingCart(3);
        shoppingCarts.add(shoppingCart);
        shoppingCart = new ShoppingCart();
        shoppingCart.addBeverageMenuToShoppingCart(2);
        shoppingCarts.add(shoppingCart);
        expectedShoppingCarts.add(shoppingCart);
        modifiedShoppingCarts = shoppingCart.deleteMenuFromShoppingCart(shoppingCarts, 1);
        Assertions.assertEquals(expectedShoppingCarts, modifiedShoppingCarts);
    }

    @Test
    void calculateTotalPriceTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();

        shoppingCart.addHamburgerToShoppingCart(1);
        shoppingCarts.add(shoppingCart);
        shoppingCart = new ShoppingCart();
        shoppingCart.addSideMenuToShoppingCart(2);
        shoppingCarts.add(shoppingCart);
        shoppingCart = new ShoppingCart();
        shoppingCart.addBeverageMenuToShoppingCart(3);
        shoppingCarts.add(shoppingCart);

        Assertions.assertEquals(10700,shoppingCart.calculateTotalPrice(shoppingCarts));
    }

}