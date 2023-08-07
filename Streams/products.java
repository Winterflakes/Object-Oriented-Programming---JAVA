package Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class products {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("D:\\Object Oriented Programming - JAVA\\Streams\\f1.txt");
        BufferedReader in = new BufferedReader(new FileReader(f));
        double price;
        int unit;
        String Desc;
        order o[] = new order[5];
        int i = 0;
        String str;
        try{
            FileWriter fw = new FileWriter("D:\\Object Oriented Programming - JAVA\\Streams\\f2.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("Your order is :"+ new order(10, 10, "item"));
            }
            
        }
        catch(IOException e){
            System.out.println(e);
        }
        try {
            while ((str = in.readLine()) != null) {
                String[] ssplit = str.split(" ");
                Desc = ssplit[0];
                price = Double.parseDouble(ssplit[1]);
                unit = Integer.parseInt(ssplit[2]);
                o[i] = new order(price, unit, Desc);
                o[i].display();

            }
        } catch (EOFException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class order {
    double price;
    int unit;
    String Desc;
    
    order(double price, int unit, String Desc) {
        this.Desc = Desc;
        this.price = price;
        this.unit = unit;
        
    }

    int getbill() {
        return (int) (price * unit);
    }

    void display() {
        System.out.println("Your order is :: " + getbill());
    }
}