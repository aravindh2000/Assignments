package assignments;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Std implements Serializable {


    int roll;
    String name,course;

    public Std(int roll, String name, String course) {
        this.roll = roll;
        this.name = name;
        this.course = course;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

public class StudentManagementUsingSerialization   {

   static FileInputStream fis;
    static ObjectInputStream ois;
    static ArrayList<Std> listobj;

    static {
    listobj=new ArrayList<>();


    }
    static void addStudent(Std std)  {

   listobj.add(std);
        System.out.println("Added..");
        try {
            new ObjectOutputStream(new FileOutputStream("D:\\Java\\src\\Objects")).writeObject(listobj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   static Object deserialize()throws IOException
    {
        FileInputStream fis=new FileInputStream("D:\\Java\\src\\Objects");
        ObjectInputStream ois=new ObjectInputStream(fis);
       return ois;
    }

    static  void serialize()throws IOException
    {
        new ObjectOutputStream(new FileOutputStream("D:\\Java\\src\\Objects")).writeObject(listobj);

    }


    static void readData() throws IOException, ClassNotFoundException {

        ObjectInputStream ois=(ObjectInputStream) deserialize();

        List s=(List) ois.readObject();
      for(Object l:s)
      {
          Std std=(Std)l;
          System.out.println("Name :"+std.getName()+" Roll :"+std.getRoll()+" Course : "+std.getCourse());

      }

    }



    static void deleteStd(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=(ObjectInputStream) deserialize();
        List s=(List)ois.readObject();

        for(int i=0;i<s.size();i++)
        {
            Std std=(Std)s.get(i);
           if(std.getName().equals(name))
           {   s.remove(i);
               new ObjectOutputStream(new FileOutputStream("D:\\Java\\src\\Objects")).writeObject(s);
               System.out.println("deleted successfully");
               return;

           }



        }


    }
   static void showStudent(String name)throws IOException,ClassNotFoundException
   {
       ObjectInputStream ois=(ObjectInputStream) deserialize();
       List list=(List)ois.readObject();
       for (Object o:list)
       {
           Std std=(Std)o;
           if(std.getName().equals(name))
           {
               System.out.println(std.getName()+" "+std.getRoll()+" "+std.getCourse());
               return;
           }

       }

       System.out.println("No student exist in the given name");
   }





    public static void main(String[] args)throws Exception {
        Scanner s=new Scanner(System.in);
        boolean flag=true;
        String name;

        while (flag)
        {
            System.out.println("1 to add\n2 to delete\n3 to show\n4 to print all\n5 to exit");
            int choice=s.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter name :");
                    s.nextLine();
                    String n=s.nextLine();
                    System.out.print("Enter roll :");
                    int id=s.nextInt();
                    System.out.print("Enter course :");
                    s.nextLine();
                    String cr=s.nextLine();
                    addStudent(new Std(id,n,cr));break;

                case 2:
                    System.out.print("Enter name to delete :");
                    s.nextLine();
                    name=s.nextLine();
                    deleteStd(name);
                    break;
                case 3:
                    System.out.print("Enter name to show details : ");
                    s.nextLine();
                    name=s.nextLine();
                    showStudent(name);
                    break;

                case 4:
                    readData();
                    break;
                case 5:
                    flag=false;
                    break;




            }
        }


    }


}
