package assignments;

import java.util.*;

public class CollectionAssignment {


    public static void main(String[] args) {
     //ASSIGNMENT-1
        ArrayList<String> colors=new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        System.out.println(colors.toString());
        Iterator itr=colors.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        colors.add(0,"black");
        System.out.println(colors.get(1));
        colors.remove(2);
        System.out.println(colors.contains("red"));
        Collections.sort(colors);

        List copyList=(List)colors.clone();
        Collections.shuffle(copyList);
        Collections.reverse(copyList);
        System.out.println(copyList.subList(1,3).toString());
         copyList.set(1,"yellow");




    //ASSIGNMENT-2
//
      Set<Integer> set1=new HashSet<>(Arrays.asList(0,1,2,3,4,5));
      Set<Integer> set2=new HashSet<>(Arrays.asList(7,8,9));
        set1.addAll(set2);
        set1.retainAll(set2);
        System.out.println(set1);
        set1.removeAll(set2);
        System.out.println(set1);

        // ASSIGNMENT-3
        Map<Integer,Employee> employees=new HashMap<>();
        employees.put(1,new Employee(1,"raj","bangalore"));
        employees.put(2,new Employee(2,"ram","chennai"));
        employees.put(3,new Employee(3,"aravind","mumbai"));
        for(int i=1;i<=employees.size();i++)
        {
            System.out.println(employees.get(i).toString());
        }


        System.out.println(new Scanner(System.in).nextLine());


    }
   static class Employee
    {
        int id;
        String city,name;
        public Employee(int id,String name,String city)
        {
            this.id=id;
            this.name=name;
            this.city=city;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", city='" + city + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
