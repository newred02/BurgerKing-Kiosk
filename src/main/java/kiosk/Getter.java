package kiosk;

import java.util.Scanner;

public class Getter {

    public static int getMenuNumber(){
        int menuNumber = 0;

        java.util.Scanner input = new java.util.Scanner(System.in);
        try{
            menuNumber = input.nextInt();
            if(menuNumber > 6 || menuNumber < 0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException IllegalArgumentException){
            throw new IllegalArgumentException();
        }
        return menuNumber;
    }

    public static int getUserInput(){
        int option = 0;

        java.util.Scanner input = new java.util.Scanner(System.in);
        try{
            option = input.nextInt();
            if(option < 0 || option > 50){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException IllegalArgumentException){
            throw new IllegalArgumentException();
        }

        return option;
    }

}
