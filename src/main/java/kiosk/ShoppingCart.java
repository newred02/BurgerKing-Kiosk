package kiosk;

import java.util.ArrayList;

public class ShoppingCart {

    private String menu;
    private int quantityOfMenu;
    private int price;

    public ShoppingCart(){
        menu = null;
        quantityOfMenu = 0;
        price = 0;
    }

    public int calculateTotalPrice(ArrayList<ShoppingCart> shoppingCarts){
        int totalPrice = 0;
        for(ShoppingCart storedMenu: shoppingCarts){
            totalPrice += storedMenu.getPrice()*storedMenu.getQuantityOfMenu();
        }

        return totalPrice;
    }

    public ArrayList<ShoppingCart> changeQuantityOfSelectedMenu(ArrayList<ShoppingCart> shoppingCarts, int selectedMenu, int newQuantity){
        ArrayList<ShoppingCart> modifiedShoppingCarts = new ArrayList<>();
        int countMenuNumber = 0;

        for (ShoppingCart menu: shoppingCarts){
            countMenuNumber++;
            if(countMenuNumber == selectedMenu){
                menu.setQuantityOfMenu(newQuantity);
                modifiedShoppingCarts.add(menu);
            }else{
                modifiedShoppingCarts.add(menu);
            }
        }
        return modifiedShoppingCarts;
    }

    public ArrayList<ShoppingCart> deleteMenuFromShoppingCart(ArrayList<ShoppingCart> shoppingCarts, int selectedMenu){
        ArrayList<ShoppingCart> modifiedShoppingCarts = new ArrayList<>();
        int countMenuNumber = 0;

        for(ShoppingCart menu: shoppingCarts){
            countMenuNumber++;
            if(!(countMenuNumber == selectedMenu)){
                modifiedShoppingCarts.add(menu);
            }
        }
        return  modifiedShoppingCarts;
    }

    public void addHamburgerToShoppingCart(int menuNumber){
        switch (menuNumber){
            case 1:
                setMenu("와퍼");
                setPrice(6900);
                break;
            case 2:
                setMenu("큐브 스테이크 와퍼");
                setPrice(8900);
                break;
            case 3:
                setMenu("콰트로 치즈 와퍼");
                setPrice(7900);
                break;
            case 4:
                setMenu("몬스터 와퍼");
                setPrice(9300);
                break;
            case 5:
                setMenu("통새우 와퍼");
                setPrice(7900);
                break;
            case 6:
                setMenu("블랙바베큐 와퍼");
                setPrice(9300);
                break;
            default:
                break;
        }
        setQuantityOfMenu(1);
        System.out.println("장바구니에 담기 완료!");
    }

    public void addSideMenuToShoppingCart(int menuNumber){
        switch (menuNumber){
            case 1:
                setMenu("너겟킹");
                setPrice(2500);
                break;
            case 2:
                setMenu("해쉬 브라운");
                setPrice(1800);
                break;
            case 3:
                setMenu("치즈스틱");
                setPrice(1200);
                break;
            case 4:
                setMenu("어니언링");
                setPrice(2400);
                break;
            case 5:
                setMenu("바삭킹");
                setPrice(3000);
                break;
            case 6:
                setMenu("감자튀김");
                setPrice(2000);
                break;
            default:
                break;
        }
        setQuantityOfMenu(1);
        System.out.println("장바구니에 담기 완료!");
    }

    public void addBeverageMenuToShoppingCart(int menuNumber){
        switch (menuNumber){
            case 1:
                setMenu("코카콜라");
                break;
            case 2:
                setMenu("코카콜라 제로");
                break;
            case 3:
                setMenu("펩시");
                break;
            case 4:
                setMenu("펩시 제로");
                break;
            case 5:
                setMenu("스프라이트");
                break;
            case 6:
                setMenu("스프라이트 제로");
                break;
        }
        setPrice(2000);
        setQuantityOfMenu(1);
        System.out.println("장바구니에 담기 완료!");
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getQuantityOfMenu() {
        return quantityOfMenu;
    }

    public void setQuantityOfMenu(int quantityOfMenu) {
        this.quantityOfMenu = quantityOfMenu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
