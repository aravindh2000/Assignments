package employeedatabase;

public class Pair<K,V> {

 private K first;
 private V second;
 public Pair(K first,V second)
 {

     this.first=first;
     this.second=second;
 }

    public K getFirst() {
        return first;
    }



    public V getSecond() {
        return second;
    }


    public static void main(String[] args) {

     Pair<Integer,String> pair1=new Pair<>(1,"siva");
        System.out.println(pair1.getFirst()+" "+ pair1.getSecond());

        Pair<Integer,Double> pair2=new Pair<>(1,1.0);
        System.out.println(pair2.getFirst()+" "+ pair2.getSecond());

    }
}
