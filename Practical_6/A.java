package Practical_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class A {
    public static void main(String[] args) throws Exception {
         
    Product p1 = new Product("1","Wheat",50,100);
    Product p2 = new Product("2","Rice",20,100);
    Product p3 = new Product("3","Sugar",100,50);
     
    Customer c1 = new Customer("Sakshi");
    Customer c2 = new Customer("Soni");
    Customer c3 = new Customer("Jalna");
    c1.addProduct(p1, 20);
    c2.addProduct(p2,10);
    c3.addProduct(p3,10);
    }
}
class Customer {
    String CustomerId; String name;
    Product[] productDetails = new Product[10]; static int it = 0;
    static int i = 1; Customer(String name){
    this.name = name; if(i<=9){


    this.CustomerId = "C00"+Integer.toString(i);
    i++;
    }
   
    else if(i<=99){
    this.CustomerId = "C0"+Integer.toString(i);
    i++;
    }
    else{
    this.CustomerId = "C"+Integer.toString(i);
    i++;
    }
    }
   
   
   
    void addProduct(Product pr,int quantity){
        if(quantity>pr.quantity){
            System.out.println("Quantity unavailable");
            return;
    }
    productDetails[it++] = pr;
    pr.updateProduct(pr, pr.quantity-quantity);
    pr.quantity-=quantity;
    this.writeSales(pr, quantity);
    }
   
   
   
    void writeSales(Product pr,int quantity){
        try{


    FileWriter writer = new FileWriter("sales.txt",true);
    BufferedWriter buffer = new BufferedWriter(writer);
    buffer.write("Customer ID:"+this.CustomerId+"\n");
    buffer.write("Name:"+this.name+"\n");
    buffer.write("Item Name :"+pr.name+"\n");
    buffer.write("Quantity:"+quantity+"\n");
    buffer.write("Total cost:"+quantity*pr.price+"\n");
    buffer.write("\n");
    buffer.close(); writer.close();
    }
    catch(IOException e){
        e.printStackTrace();
    }
    }
}
class Product implements Serializable {
 
    String id; String name; int quantity; int price;
    Product(String id,String name,int quantity,int price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.writeProduct();
   
    }
   
   
    void writeProduct(){ try{
    FileWriter writer = new FileWriter("product.txt",true);
    BufferedWriter buffer = new BufferedWriter(writer);
    // wrapper class buffer.write("ID:"+this.id+"\t\n");
    buffer.write("Name:"+this.name+"\t\n");
    buffer.write("Quantity:"+this.quantity+"\t\n");


    buffer.write("Price:"+this.price+"\t\n");
    buffer.write("\n");
    buffer.close();
    writer.close();
    }
   
    catch(IOException e){
        e.printStackTrace();
    }
    }
   
   
   
    void updateProduct(Product pr,int newQuantity){
    String s ="ID:"+pr.id+"\n"+"Name:"+this.name+"\n"+"Quantity:"+this.quantity+"\n"+"Pri ce:"+pr.price;
    String s1 ="ID:"+pr.id+"\n"+"Name:"+this.name+"\n"+"Quantity:"+newQuantity+"\n"+"Pr ice:"+pr.price;
    try{
    FileReader fr=new FileReader("product.txt");
    BufferedReader br=new BufferedReader(fr);
    String line = br.readLine();
    String oldContent = "";
    while (line != null)
    {
   
    oldContent = oldContent + line + "\n";


    line = br.readLine();
    }
   
    System.out.println(oldContent.contains(s));
    String newContent = oldContent.replace(s, s1);
    // System.out.println(newContent);
    FileWriter writer = new FileWriter("product.txt");
    BufferedWriter buffer = new BufferedWriter(writer);
    buffer.write(newContent);
    buffer.close();
    fr.close();
    }
    catch(IOException e){ e.printStackTrace();
    }
}
}





