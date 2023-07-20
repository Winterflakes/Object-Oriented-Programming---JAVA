package Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class productcompare implements Comparator<product>
{

    @Override
    public int compare(product o1, product o2) {
        if(o1.getQ()>o2.getQ())
            return 1;
        else if(o1.getQ()<o2.getQ())
                return -1;
        else if(o1.getQ()==o2.getQ())
                {
                    if(o1.getP()>o2.getP())
                        return 1;
                    else
                        if(o1.getP()<o2.getP())
                            return -1;
                                
                }
        return 0;
    }
    
}
class product implements Comparable<product>
{
    private String Name;
    private int q;
    private double p;

    public product(String Name, int q, double p) {
        this.Name = Name;
        this.q = q;
        this.p = p;
    }
    void display()
    {
        System.out.println("Name :" +Name + "Quantity: " + q + "Price: " + p + " Amount: " + getamount());
    }
    double getamount()
    {
        return p*q;
    }

    public int getQ() {
        return q;
    }

    public double getP() {
        return p;
    }

    public int compareTo(product o) {
        if(p>o.getP())
            return 1;
        if(p<o.getP())
            return -1;
        return 0;
    }   
}

public class ProductDemo {
    public static void main(String[] args) {
        ArrayList<product> ap=new ArrayList<>();
        ap.add(new product("a",10,50));
        ap.add(new product("b",15,150));
        ap.add(new product("c",20,250));
        ap.add(new product("d",15,70));
        int sum=0;
        for(int i =0 ; i<ap.size();i++)
        {
            product p=ap.get(i);
            sum += p.getamount();
            p.display();
        }
        System.out.println("Total amount is: " + sum);
        Collections.sort(ap);
        for(int i =0 ; i<ap.size();i++)
        {
            product p=ap.get(i);
            p.display();
        }
    }
}
    
    
    
    







