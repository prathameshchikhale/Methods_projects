package fileHandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class wriTing {
    public static void main(String[] args) {
        try {
            FileWriter f = new FileWriter("D:\\pratham.txt");
            try {
                f.write("Hello");
            } finally {
                f.close();
            }
            System.out.println("Data wrote in file");
        } catch (IOException U) {
            System.out.println("Exception Handalled");
        }
        try {
            FileReader p = new FileReader("D:\\pratham.txt");
            int q;
            while ((q = p.read()) != -1) {
                System.out.println((char) q);
            }
        } catch (IOException A) {
            System.out.println("Exception ");
        }
    }

}
