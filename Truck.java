package com.assignments.assignmentone;

public interface Truck {



    int axles();
    int weight();




}
interface ToolBooth
{


    void calculateToll(Truck truck);
    void displayData();
    void collectingReceipt();
    void resetReceipt();
}

