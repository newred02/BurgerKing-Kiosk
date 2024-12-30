package kiosk;

import javax.print.attribute.standard.PrinterName;
import java.util.ArrayList;
import java.util.Scanner;

public class Screen {

    public static void mainScreen(ArrayList<ShoppingCart> shoppingCarts){
        int homeInput = 0;
        boolean programEnd = false;

        while (!programEnd){
            Printer.printHome();
            homeInput = Getter.getUserInput();
            switch (homeInput){
                case 1:
                    if(shoppingCarts.size() == 50){
                        System.out.println("장바구니가 다 찼습니다.");
                        break;
                    }
                    Screen.hamburgerMenuScreen(shoppingCarts);
                    break;
                case 2:
                    if(shoppingCarts.size() == 50){
                        System.out.println("장바구니가 다 찼습니다.");
                        break;
                    }
                    Screen.sideMenuScreen(shoppingCarts);
                    break;
                case 3:
                    if(shoppingCarts.size() == 50){
                        System.out.println("장바구니가 다 찼습니다.");
                        break;
                    }
                    Screen.beverageMenuScreen(shoppingCarts);
                    break;
                case 4:
                    Screen.shoppingCartScreen(shoppingCarts);
                    break;
                case 5:
                    programEnd = true;
                    System.out.println("프로그램 종료!");
                    System.exit(0);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public static void hamburgerMenuScreen (ArrayList<ShoppingCart> shoppingCarts){
        int hamburgerMenu = 0;
        ShoppingCart shoppingCart = new ShoppingCart();

        Printer.printHamburgerMenu();
        hamburgerMenu = Getter.getMenuNumber();
        if(!(hamburgerMenu == 0)){
            shoppingCart.addHamburgerToShoppingCart(hamburgerMenu);
            shoppingCarts.add(shoppingCart);
        }
    }

    public static void sideMenuScreen(ArrayList<ShoppingCart> shoppingCarts){
        int sideMenu = 0;
        ShoppingCart shoppingCart = new ShoppingCart();

        Printer.printSideMenu();
        sideMenu = Getter.getMenuNumber();
        if(!(sideMenu == 0)){
            shoppingCart.addSideMenuToShoppingCart(sideMenu);
            shoppingCarts.add(shoppingCart);
        }
    }

    public static void beverageMenuScreen(ArrayList<ShoppingCart> shoppingCarts){
        int beverageMenu = 0;
        ShoppingCart shoppingCart = new ShoppingCart();

        Printer.printBeverageMenu();
        beverageMenu = Getter.getMenuNumber();
        if(!(beverageMenu == 0)){
            shoppingCart.addBeverageMenuToShoppingCart(beverageMenu);
            shoppingCarts.add(shoppingCart);
        }
    }

    public static void shoppingCartScreen(ArrayList<ShoppingCart> shoppingCarts){
        int shoppingCartOption = 0;

        Printer.printShoppingCart(shoppingCarts);
        shoppingCartOption = Getter.getUserInput();
        switch (shoppingCartOption){
            case 0:
                mainScreen(shoppingCarts);
                break;
            case 1:
                System.out.println("주문 성공!");
                System.exit(0);
                break;
            case 2:
                Printer.printChangeQuantityOfMenuScreen(shoppingCarts);
                break;
            case 3:
                Printer.printDeleteMenuScreen(shoppingCarts);
                break;
        }
    }

}
