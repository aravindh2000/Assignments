package employeedatabase;

import java.util.ArrayList;
import java.util.List;

public class Media <T>{
    private T mediaType;
    List<T> lst=new ArrayList<>();

    public  Media(T mediaType)
    {
        this.mediaType=mediaType;
        lst.add(mediaType);
    }



    void showData()
    {
       for (T a:lst)
       {
           Book bk=null;
           Video vd=null;
           if(t instanceof Book)
           {
               bk=(Book)t;
               System.out.println(bk.getName());

           }
       }
    }

    public static void main(String[] args) {
        Media<Book> media1=new Media<>(new Book("Harry"));
        media1.showData();
    }

}
class Book
{
    String name;
    Book(String name){this.name=name;}

    public String getName() {
        return name;
    }
}
class Video
{
    String name;
    Video(String name){this.name=name;}

    public String getName() {
        return name;
    }
}
class NewsPaper
{

    String name;
    NewsPaper(String name){this.name=name;}

    public String getName() {
        return name;
    }
}

