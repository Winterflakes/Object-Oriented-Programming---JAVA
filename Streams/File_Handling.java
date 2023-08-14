package Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_Handling {
    public static void main(String[] args) throws FileNotFoundException {
    // writing to a file - f2.txt
    try {
        FileWriter fw = new FileWriter("D:\\Object Oriented Programming - JAVA\\Streams\\f2.txt",true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Hi, this is Sakshi");
        }
    }
    catch(IOException e){
        System.out.println("error");
    }

    // Reading from file - f2.txt
    try {
        FileReader fr = new FileReader("D:\\Object Oriented Programming - JAVA\\Streams\\f2.txt");
        try (BufferedReader br = new BufferedReader(fr)) {
            System.out.println(br.readLine());
        }
    } 
    catch (IOException e) {
        System.out.println("eror");
    }
}
}
