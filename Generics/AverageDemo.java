package Genericsdemo;

class AverageDemo
{
    public static void main(String[] args) {
        Integer arr[]={1,2};
        genAverage<Integer> intob=new genAverage<>(arr);
        double avg=intob.average();
        System.out.println("Average is :" + avg);
        String s[]={"a", "b"};
        Double d1[]={1.0,2.0};
        genAverage<Double> dob=new genAverage<>(d1);
        boolean b=intob.isSameAvg(dob);
        System.out.println("is same"+ b);
        
    }
    
}

class genAverage<T extends Number>
{
    T ar[];

    public genAverage(T[] ar) {
        this.ar = ar;
    }

    boolean isSameAvg(genAverage<?> ob)
    {
        if(average()==ob.average())
            return true;
        return false;
    }
    double average()
    {
        double sum=0;
        for(int i=0;i<ar.length;i++)
        {
            sum += ar[i].doubleValue();
        }
        
        return sum/ar.length;
            
        
    }
    
}