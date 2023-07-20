
package Generics;
public class Genwildcard {
    public static void main(String args[]) {
        Integer inums[] = { 1, 2, 3, 4, 5 };
        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats1<Integer> iob = new Stats1<Integer>(inums);
        Stats1<Double> dob = new Stats1<Double>(dnums);
        if(iob.sameAvg(dob))
        System.out.println("Averages are the same.");
        else
        System.out.println("Averages differ.");
   }
}
class Stats1<T extends Number>{
    T[] nums; 
    Stats1(T[] o) 
    {
        nums = o;
    }
    double average() 
    {
        double sum = 0.0;
        for(int i=0; i < nums.length; i++)
            sum += nums[i].doubleValue();
        return sum / nums.length;
    }
    boolean sameAvg(Stats1<?> ob) {
        if(average() == ob.average())
             return true;
    return false;
    }

    
}

