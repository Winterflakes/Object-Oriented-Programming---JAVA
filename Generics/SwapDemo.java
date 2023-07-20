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
public class SwapDemo {
    public static void main(String[] args) {
    //swapelems<Integer> sint=new swapelems<>();
    Integer i1[]={88,99,101,4,89};
    Integer i2=Integer.valueOf(99);
    swapelems.swap(i1, 2,3);
        System.out.println("i1: " + i1[2] + " i2: " + i1[3]);
    String s1="hello";
    String s2="World";
    //swapelems<String> ss=new swapelems<>();
    swapelems.swap1(s1, s2);
    System.out.println("s1: " + s1 + " s2: " + s2);
            
    
    }
    
}
class swapelems
{
    static <T> void swap(T[] arr,int a, int b)
    {
        T temp;
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        //System.out.println(" a=" + a +" b=" + b);
    }
    
    static void swap1(Object a, Object b)
    {
        Object temp;
        temp=a;
        a=b;
        b=temp;
        System.out.println(" a=" + a +" b=" + b);
    }
}

