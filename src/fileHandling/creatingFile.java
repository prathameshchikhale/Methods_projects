package fileHandling;

import java.io.File;
import java.io.IOException;

public class creatingFile {
    public static void main(String[] args) {
        File f = new File("D:\\pratham.txt");
        try {
            f.createNewFile();
            System.out.println("File is created");
        } catch (IOException e) {
            System.out.println("File Not Created");
        }
        System.out.println(f.length());

    }
}

