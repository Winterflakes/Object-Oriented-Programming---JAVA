
package Generics;

public class NonGenDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NonGen IntOb=new NonGen(88);
        int i=(int) IntOb.ReturnObject();
        System.out.println("i=" + i);
        NonGen StrOb=new NonGen("Hello");
        String s=(String) StrOb.ReturnObject();
        System.out.println("s=" + s);        
        IntOb=StrOb;
        i=(int) IntOb.ReturnObject();
        System.out.println("i=" + i);
    }
    
}

class NonGen{
    Object ob;
    NonGen(Object o)
    {            ob=o;       }
    Object ReturnObject()
    {            return ob;        }
    void ShowType()
    {         ob.getClass().getName();
     } 
}





