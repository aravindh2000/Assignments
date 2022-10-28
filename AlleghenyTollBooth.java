package com.assignments.assignmentone;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlleghenyTollBooth implements ToolBooth {
    Truck truck;
    int data;
    static int totalDues,truckCount;
    @Override
    public void calculateToll(Truck truck) {
        this.truck=truck;
        truckCount++;
        data=(truck.axles()*5+((truck.weight()/500)*10));
        totalDues+=data;
    }
      @Override
      public void collectingReceipt()
     {
         System.out.println("************Collecting Receipts***********\nTotals since the last collection - Receipts: $"+totalDues+" Trucks: "+truckCount);
     }
     @Override
    public void resetReceipt()
     {
             totalDues=0;
             truckCount=0;
         System.out.println("************Reset Receipts***********\nTotals since the last collection - Receipts: $"+totalDues+" Trucks: "+truckCount);

     }


    @Override
    public void displayData() {
        System.out.println("Truck arrival - Axles: "+truck.axles()+" Total weight: "+truck.weight()+" Toll due: $"+this.data);

    }
}




//Ford Truck
class Ford implements Truck
{
   private int axles,weight;

    public Ford(int axles,int weight)
    {
        this.weight=weight;
        this.axles=axles;

    }

    @Override
    public int axles() {
         return axles;
    }

    @Override
    public int weight() {
       return weight;
    }
}




//Nissan Truck
class Nissan implements Truck

{
    int axles,weight;
    public Nissan(int axles,int weight) {

        this.axles=axles;
        this.weight=weight;
    }
    @Override
    public int axles() {
        return axles;
    }

    @Override
    public int weight() {
        return weight;
    }
}




//Daewoo Truck
class Daewoo implements Truck

{
    int axles,weight;
    public Daewoo(int axles,int weight) {

        this.axles=axles;
        this.weight=weight;
    }
    @Override
    public int axles() {
        return axles;
    }

    @Override
    public int weight() {
        return weight;
    }
}


// Main method class (Testing)
class TestTollBooth
{


    public static void main(String[] args) {

        ToolBooth tb=new AlleghenyTollBooth();
        Truck ford=new Ford(5,12500);
        Truck nissan=new Nissan(2,5000);
        Truck daewoo=new Daewoo(6,17000);

        tb.calculateToll(ford);
        tb.displayData();
        tb.calculateToll(nissan);
        tb.displayData();
          tb.collectingReceipt();
          tb.resetReceipt();

          tb.calculateToll(daewoo);
          tb.displayData();

  Functionality fn=new Functionality() {
      @Override
      public void add(int a, int b) {
          System.out.println(a+b);
      }
  };

List<Integer> ins=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(ins.stream().reduce(0,(i,j)->i+j));


    }
}




interface Functionality
{



    void add(int a,int b);

}







