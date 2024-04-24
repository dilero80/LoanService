import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    public static void displayPrincipalMenu(){
        System.out.println("========================================");
        System.out.println("----- PRINCIPAL MENU-----");
        System.out.println("1. LOAN MENU");
        System.out.println("2. USER MENU");
        System.out.println("3. AUDIO / VIDEO / TEXT MENU");
        System.out.println("4. EXIT");
        System.out.println("========================================");
    }
    public static void displayLoanMenu(){
        System.out.println("========================================");
        System.out.println("----- USER MENU-----");
        System.out.println("1. CREATE LOAN");
        System.out.println("2. DISPLAY NUMBERS OF LOANS");
        System.out.println("3. RETURN LOAN");
        System.out.println("4. DELETE LOAN");
        System.out.println("6. RETURN MAIN MENU");
        System.out.println("========================================");
    }

    public static void displayUserMenu(){
        System.out.println("========================================");
        System.out.println("----- USER MENU-----");
        System.out.println("1. CREATE USER");
        System.out.println("2. DISPLAY USER");
        System.out.println("3. DELETE USER");
        System.out.println("4. UPDATE USER");
        System.out.println("6. EXIT");
        System.out.println("========================================");
    }

    public static void displayLibMenu(){
        System.out.println("========================================");
        System.out.println("----- TEXT / AUDIO / VIDEO MENU-----");
        System.out.println("1. CREATE TEXT");
        System.out.println("2. SHOW TEXT");
        System.out.println("3. DELETE TEXT");
        System.out.println("4. UPDATE TEXT");
        System.out.println("6. EXIT");
        System.out.println("========================================");
    }

}
