import Enums.typeOfLibMaterial;

import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    public static void displayPrincipalMenu(){
        System.out.println("========================================");
        System.out.println("----- PRINCIPAL MENU-----");
        System.out.println("1. LOAN MENU");
        System.out.println("2. USER MENU");
        System.out.println("3. TEXT MENU");
        System.out.println("4. AUDIO MENU");
        System.out.println("5. VIDEO MENU");
        System.out.println("6. EXIT");
        System.out.println("========================================");
    }
    public static void displayLoanMenu(){
        System.out.println("========================================");
        System.out.println("----- USER MENU-----");
        System.out.println("1. CREATE LOAN");
        System.out.println("2. RETURN LOAN");
        System.out.println("3. DISPLAY LOANS");
        System.out.println("4. DELETE LOAN");
        System.out.println("5. FINDS LOANS BY USER ID");
        System.out.println("6. RETURN MAIN MENU");
        System.out.println("========================================");
    }

    public static void displayUserMenu(){
        System.out.println("========================================");
        System.out.println("----- USER MENU-----");
        System.out.println("1. CREATE USER");
        System.out.println("2. DISPLAY USERS");
        System.out.println("3. DELETE USER");
        System.out.println("4. UPDATE USER");
        System.out.println("5. EXIT");
        System.out.println("========================================");
    }

    public static void displayLibMenu(String typeOfAVT){
        System.out.println("========================================");
        System.out.println("----- " + typeOfAVT.toUpperCase() +" MENU-----");
        System.out.println("1. CREATE " + typeOfAVT.toUpperCase() );
        System.out.println("2. SHOW " + typeOfAVT.toUpperCase() );
        System.out.println("3. DELETE " + typeOfAVT.toUpperCase() );
        System.out.println("4. UPDATE " + typeOfAVT.toUpperCase() );
        System.out.println("5. EXIT");
        System.out.println("========================================");
    }



}
