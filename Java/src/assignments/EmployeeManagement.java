package assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Employee
{
    String name,dept;
    int id;


    public Employee(String name, int id,String dept) {
        this.name = name;
        this.id = id;
        this.dept=dept;

    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class EmployeeManagement {

 static List<Employee> employees=new ArrayList<>();
   static void addEmployee(Employee emp)
    {
        employees.add(emp);
        System.out.println("Added Successfully");
    }
  static   void deleteEmployee(String name)
    {
        Iterator itr=employees.iterator();
        while (itr.hasNext())
        { Employee e=(Employee) itr.next();
            if(e.getName().equals(name))
            {
                employees.remove(e);
                System.out.println("Deleted...");
                return;
            }
        }
        System.out.println("Emp not found");

    }
  static void    displayEmployee()
    {
        for (Employee e:employees)
        {
            System.out.println("Name :"+e.getName()+" id : "+e.getId()+" Dept : "+e.getDept());
        }
    }
   static boolean searchEmployee(String name)
    {
        Iterator itr=employees.iterator();
        boolean flag=false;
        while (itr.hasNext())
        { Employee e=(Employee) itr.next();
            if(e.getName().equals(name))
            {
                flag=true;
                System.out.println(" ID : "+e.getId()+" Name : "+e.getName());
                break;

            }
        }
        return flag;

    }



    public static void main(String[] args) {
        boolean flag=true;
        String name;
        while(flag)
        {
            System.out.println("1 to add\n2 to delete0\n3 to display\n4 to search\n5 to exit");
            Scanner s=new Scanner(System.in);
            int choice=s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter name :");
                   s.nextLine();
                   name=s.nextLine();

                    System.out.print("Enter ID : ");
                    int id=s.nextInt();
                    System.out.print("Enter the dept : ");
                    s.nextLine();
                String dept=s.nextLine();
                    addEmployee(new Employee(name,id,dept));
                    break;
                case 2:
                    System.out.print("Enter name of emp to delete : ");
                    s.nextLine();
                    name=s.nextLine();
                    deleteEmployee(name);
                    break;
                case 3:
                    displayEmployee();
                    break;
                case 4:
                    System.out.print("Enter name to search : ");
                    s.nextLine();
                    name=s.nextLine();
                   if(searchEmployee(name))
                   {
                       System.out.println("Employee found");
                   }
                   else {
                       System.out.println("No emp exist");
                   }
                    break;

                case 5:
                    flag=false;
                    break;
            }
        }


    }
}
