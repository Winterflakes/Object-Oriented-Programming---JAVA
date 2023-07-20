package Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kanak
 */

class desccompare implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1<o2)
            return 1;
        else if(o1>o2)
            return -1;
        return 0;
    }
    
}
public class ArrayListSort {
        public static void main(String args[])
        {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(450);
        list.add(550); 
        list.add(200);
        list.add(50);
        System.out.println(list);
        Collections.sort(list);
        System.out.println("ascending list: " + list);
        Collections.sort(list,new desccompare());
        System.out.println("descending list: " + list);
    }

    
}
