package Services;

import Entities.Text;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LibMaterialService {
    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    LibMaterialService ms = new LibMaterialService();
    public LibMaterialService() {
    }

    public Text createText(){
        Text text = new Text();
        System.out.println("Enter Text ID");
        text.setId(read.next());
        System.out.println("Enter Author");
        text.setAuthor(read.next());
        System.out.println("Enter Number of pages");
        text.setNumPages(read.nextInt());
        text.setAvaliable(true);

        return text;

    }
}
