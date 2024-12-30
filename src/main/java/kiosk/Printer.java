package kiosk;

import java.util.ArrayList;

public class Printer {

    public static void printHome(){
        System.out.println("=====홈=====");
        System.out.println("\n1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료");
        System.out.print("\n메뉴선택: ");
    }

    public static void printHamburgerMenu(){
        System.out.println("=====햄버거 메뉴=====");
        System.out.println("\n1. 와퍼 (6900원)");
        System.out.println("2. 큐브 스테이크 와퍼 (8900원)");
        System.out.println("3. 콰트로 치즈 와퍼 (7900원)");
        System.out.println("4. 몬스터 와퍼 (9300원)");
        System.out.println("5. 통새우 와퍼 (7900원)");
        System.out.println("6. 블랙바베큐 와퍼 (9300원)");
        printMessageForMenuSelection();
    }

    public static void printSideMenu(){
        System.out.println("=====사이드 메뉴=====");
        System.out.println("\n1. 너겟킹 (2500원)");
        System.out.println("2. 해쉬 브라운 (1800원)");
        System.out.println("3. 치즈스틱 (1200원)");
        System.out.println("4. 어니언링 (2400원)");
        System.out.println("5. 바삭킹 (3000원)");
        System.out.println("6. 감자튀김 (2000원)");
        printMessageForMenuSelection();
    }

    public static void printBeverageMenu(){
        System.out.println("=====음료 메뉴=====");
        System.out.println("\n1. 코카콜라 (2000원)");
        System.out.println("2. 코카콜라 제로 (2000원)");
        System.out.println("3. 펩시 (2000원)");
        System.out.println("4. 펩시 제로 (2000원)");
        System.out.println("5. 스프라이트 (2000원)");
        System.out.println("6. 스프라이트 제로 (2000원)");
        printMessageForMenuSelection();
    }

    public static void printShoppingCart(ArrayList<ShoppingCart> shoppingCarts){
        System.out.println("===== 장바구니 =====\n");
        for(ShoppingCart storedMenu: shoppingCarts){
            System.out.println("- " + storedMenu.getMenu() + " " + storedMenu.getQuantityOfMenu() + "개");
        }
        System.out.println("\n====================");
        System.out.println("1. 주문하기 ");
        System.out.println("2. 수량 조절하기");
        System.out.println("3. 삭제하기\n");
        System.out.print("총 가격: ");
        printTotalPriceOfShoppingCart(shoppingCarts);
        printMessageForMenuSelection();
    }

    public static void printMessageForMenuSelection(){
        System.out.print("\n메뉴선택 (0을 선택 시 홈으로): ");
    }

    public static void printPresentShoppingCart(ArrayList<ShoppingCart> shoppingCarts){
        int shoppingCartListNumber = 1;
        System.out.println("현재 장바구니\n");
        for(ShoppingCart storedMenu: shoppingCarts){
            System.out.println(shoppingCartListNumber + ". " + storedMenu.getMenu() + " " + storedMenu.getQuantityOfMenu() + "개");
            shoppingCartListNumber++;
        }
    }

    public static void printTotalPriceOfShoppingCart(ArrayList<ShoppingCart> shoppingCarts){
        int totalPrice = 0;
        ShoppingCart shoppingCart = new ShoppingCart();

        totalPrice = shoppingCart.calculateTotalPrice(shoppingCarts);
        System.out.println(totalPrice + "원");
    }

    public static void printChangeQuantityOfMenuScreen(ArrayList<ShoppingCart> shoppingCarts){
        int selectedMenu = 0;
        int newQuantity = 0;
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println("===== 수량 조절하기 =====\n");
        printPresentShoppingCart(shoppingCarts);
        System.out.print("\n수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        try{
            selectedMenu = Getter.getUserInput();
            if(selectedMenu > shoppingCarts.size()){
                throw new IllegalArgumentException();
            }
            if(!(selectedMenu == 0)) {
                System.out.print("변경할 수량을 입력하세요: ");
                newQuantity = Getter.getUserInput();
                shoppingCarts = shoppingCart.changeQuantityOfSelectedMenu(shoppingCarts, selectedMenu, newQuantity);
                System.out.println("수량 변경이 완료되었습니다.\n");
                Screen.shoppingCartScreen(shoppingCarts);
            }
        }catch (IllegalArgumentException IllegalArgumentException){
            throw new IllegalArgumentException();
        }
    }

    public static void printDeleteMenuScreen(ArrayList<ShoppingCart> shoppingCarts){
        int selectedMenu = 0;
        int deleteConfirm = 0;
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println("===== 삭제하기 =====\n");
        printPresentShoppingCart(shoppingCarts);
        System.out.print("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        selectedMenu = Getter.getUserInput();
        System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
        deleteConfirm = Getter.getUserInput();
        if((!(selectedMenu == 0)) && (!(deleteConfirm == 0))){
            shoppingCarts = shoppingCart.deleteMenuFromShoppingCart(shoppingCarts, selectedMenu);
            System.out.println("삭제를 완료하였습니다.\n");
            Screen.shoppingCartScreen(shoppingCarts);
        }
    }

}
