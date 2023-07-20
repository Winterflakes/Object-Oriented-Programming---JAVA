/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genericsdemo;

/**
 *
 * @author Kanak
 */
class TwoGen<T, V> {
T ob1;
V ob2;
TwoGen(T o1, V o2) {
ob1 = o1;
ob2 = o2; }
void showTypes() {
System.out.println("Type of T is " + ob1.getClass().getName());
System.out.println("Type of V is " + 
ob2.getClass().getName()); }
T getob1() { return ob1; }
V getob2() { return ob2; }
}

public class TwoGenDemo {
public static void main(String args[]) {
TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Generics");
// Show the types.
tgObj.showTypes();
// Obtain and show values.
int v = tgObj.getob1();
System.out.println("value: " + v);
String str = tgObj.getob2();
             System.out.println("value: " + str);
}
}
