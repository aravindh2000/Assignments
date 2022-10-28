package employeedatabase;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * model class of employee that holds the properties of the employee
 */
 class Employee {


    int EMP_ID,experience;
    String name,bloodGroup,dob,designation;
    double salary;

    public Employee(int EMP_ID, int experience, String name, String bloodGroup, String dob, String designation, double salary) {
        this.EMP_ID = EMP_ID;
        this.experience = experience;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.dob = dob;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(int EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
/**
 * database to store the data in the form of collection
 */
class Data
{
   static LinkedList<Employee> employeeData=new LinkedList<>();

   static void printData(LinkedList<Employee> ptd)
   {
        for (Employee e:employeeData)
       {System.out.println(e.getName()+"        "+e.EMP_ID+"          "+e.bloodGroup+"     "+e.dob+"      "+e.designation+"     "+e.getExperience()+"       "+e.salary);
       }


   }





}
class Controller
{
    static int sampId=1000;
    static void addEmployeeToTheTable(LinkedList<Employee> listObj)
    {   String desig;
       double salary;
        Scanner s=new Scanner(System.in);
        System.out.println("Create your employee account by providing details");
        System.out.print("Enter your name : ");

        String nameOfEmpToAdd=s.nextLine();
        System.out.print("Enter DOB : ");
        String dobOfEmp=s.nextLine();
        System.out.print("Enter Blood grp : ");
        String bg=s.nextLine();
        System.out.print("Enter experience in years : ");
        int exp=s.nextInt();
        if(exp<=5&&exp>=3)
        {
            desig="Senior Software Engineer";
            salary=90000;

        }
        else if(exp>=6&&exp<=8)
        {
            desig="Technical Lead";
            salary=100000;

        }
        else{
            desig="Junior Programmer";
            salary=50000;
        }
        listObj.add(new Employee(sampId++,exp,nameOfEmpToAdd,bg,dobOfEmp,desig,salary));

        System.out.println("Added Successfully");



    }

   static void removeEmployeeFromTable(LinkedList<Employee> listObj)
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the name of employee to be deleted from the table : ");
        String nameOfEmployeeToDelete=s.nextLine();

        boolean fl=false;
        for(Employee e:listObj)
        {

            if(e.getName().equals(nameOfEmployeeToDelete))
            {
                fl=true;
                listObj.remove(e);
            }
        }
        if (fl==false)
        {
            System.out.println("Employee not found");
        }

        else
        {
            System.out.println("Removed");
        }


    }










}

public class Testing
{


    static void add()
    {

       Controller.addEmployeeToTheTable(Data.employeeData);

    }
   static void delete()
    {
        Controller.removeEmployeeFromTable(Data.employeeData);
    }
   static void show()
    {
       Data.printData(Data.employeeData);
    }


    public static void main(String[] args) {

        boolean flag=true;
        while(flag)
        {
            System.out.println("Press 1 to add employee\nPress 2 to remove employee\nPress 3 to show data");
            Scanner ip=new Scanner(System.in);
            int i=ip.nextInt();
            switch (i){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    show();
                    break;

            }
            System.out.println("press 0 to Quit or Any to continue");
            int q=ip.nextInt();
            if(q==0)
            {
                flag=false;
            }
        }




    }
}


