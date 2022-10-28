package assignments;

import java.util.Scanner;

public class ExceptionDemo {


    static long computePower(double x,double y ) throws Exception {
        long result=0;


        if(x<0||y<0)
        {
            throw new Exception("x or y cannot be negative");
        }
        else if(x==0||y==0)
        {
            throw new Exception("x or y cannot be zero");
        }
        else{
            result =(long)Math.pow(x,y);
        }

        return result;
    }


    public static void main(String[] args) throws Exception {

        Scanner s=new Scanner(System.in);
        double val1=s.nextDouble();
        double val2=s.nextDouble();

        System.out.println( computePower(val1,val2));
    }
}
