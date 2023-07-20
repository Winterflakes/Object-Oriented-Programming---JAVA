/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionDemo;

import java.util.HashSet;

/**
 *
 * @author Kanak
 */
public class HashsetDemo {
    public static void main(String[] args) {
            
        HashSet<String> hs=new HashSet<>(5, .5F);
        hs.add("a");
        hs.add("g");
        hs.add("d");
        hs.add("j");
        System.out.println("capacity is " + hs.size());
        hs.add("l");
        System.out.println(hs);
        System.out.println(hs.contains("p"));
        System.out.println(hs.remove("g")); 
        System.out.println(hs.isEmpty());
        
        HashSet<Book> hb=new HashSet<>(10,0.5F);
        hb.add(new Book(12, "Java", "Herbert Schildt",500));
        hb.add(new Book(11, "C++", "Balguruswamy",300));
        hb.add(new Book(10, "OS", "Galvin",700));
        
        for(Book b:hb)
        {
            b.Display();
        }
 
        
 }

    }

class Book //implements Comparable<Book>{
 {  int issn;
    String BookName;
    String AuthorName;
    int price;
    public int compareTo(Book ob)
    {
        return BookName.compareTo(ob.BookName);
    }
    public Book(int issn, String BookName, String AuthorName, int price) {
        this.issn = issn;
        this.BookName = BookName;
        this.AuthorName = AuthorName;
        this.price = price;
    }

void Display()
{
    System.out.println("ISSN: " + issn);
    System.out.println("BookName: " + BookName);
    System.out.println("AuthorName: " + AuthorName);
    System.out.println("Price: " + price);
}
    
}

    

