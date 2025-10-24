package Main;

import BackEnd.Student;
import BackEnd.StudentDataBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
   public static void main(String args[]) throws FileNotFoundException{
    Student kk=new Student(9006,"Ahmed Elsa",25,"Male","lol",4);
    Student mm=new Student(9008,"Ahmed Hassan Farag",21,"Male","lol",2);
    Student ll=new Student(9003,"Ahmed Atas",21,"Male","lol",3);
//    System.out.println(kk.getAge());
//     System.out.println(kk.getFullName());
//      System.out.println(kk.getGPA());
//       System.out.println(kk.getStudentID());
//        System.out.println(kk.getGender());
        StudentDataBase sd=new StudentDataBase();
        sd.add(kk);
        sd.add(mm);
        sd.add(ll);
        sd.Display();
             System.out.println(kk.getStudentID());
        sd.delete(kk.getStudentID());
               System.out.println(kk.getStudentID());
         sd.Display();
         Student n=sd.search("Ahmed Hassan Farag");
          System.out.println(n.getFullName());
          n=sd.search("9003");
           System.out.println(n.getFullName());
             
}
}
