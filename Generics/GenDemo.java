package Generics;

class Gen<T>{
    T ob;
    Gen(T o)
    {            ob=o;       }
    T ReturnObject()
    {            return ob;        }
    void ShowType()
    {         ob.getClass().getName();
     } 
}

public class GenDemo {
    public static void main(String ar[])
    {        
        Gen<Integer> IntOb=new Gen<>(88);
        int i= IntOb.ReturnObject();
        System.out.println("i=" + i);
        Gen<String> StrOb=new Gen<>("Hello");
        String s= StrOb.ReturnObject();
        System.out.println("s=" + s);        
        //IntOb=StrOb;
        i= IntOb.ReturnObject();
        System.out.println("i=" + i);
}   }

