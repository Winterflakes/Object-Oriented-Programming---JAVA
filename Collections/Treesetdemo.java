/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionDemo;

import java.util.TreeSet;

/**
 *
 * @author Kanak
 */
public class Treesetdemo {
    public static void main(String[] args) {
        TreeSet<Character> t =new TreeSet<>();
        for(int i='a';i<='z';i++)
        {
            t.add((char)i);
        }
       // t.remove('b');
        System.out.println(t);
        System.out.println(t.contains('c'));
        System.out.println(t.ceiling('b'));
         // returns the element if present 
        System.out.println(t.floor('b'));
        System.out.println(t.first());
        System.out.println(t.last());
        System.out.println(t.lower('p'));// strictly lower than p
       
    }
 
}
