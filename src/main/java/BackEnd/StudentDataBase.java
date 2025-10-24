package BackEnd;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentDataBase {
private ArrayList<Student>Students=new ArrayList<>();
public boolean contains(int key){
    if(Students==null) return false;
      for(int i=0;i<Students.size();i++){
     if(Students.get(i).getStudentID()==key)
         return true;
      }
      return false;
    }
public void add(Student s) throws FileNotFoundException{
    if(contains(s.getStudentID()))
        System.out.println("The id already exist!!");
    else Students.add(s);
    saveToFile();
}
public void Display() throws FileNotFoundException{
      Student min=Students.get(0);
   for (int i=0;i<Students.size()-1;i++) {
        int minIndex = i;
        for (int j=i+1;j<Students.size();j++) {
            if (Students.get(j).getGPA() < Students.get(minIndex).getGPA()) {
                minIndex = j;
            }
        }
        Student temp =Students.get(i);
        Students.set(i,Students.get(minIndex));
        Students.set(minIndex,temp);
    }
   saveToFile();
for(Student i:Students) System.out.println(i.getFullName());
}
public void delete(int key) throws FileNotFoundException{
    for(int i=0;i<Students.size();i++){
   if(Students.get(i).getStudentID()==key){
       Students.remove(Students.get(i));
       saveToFile();
       return;
   }
       }
    System.out.println("The id does not exist!!");
    
}
public static boolean isDigit(String s) {
        for (char i:s.toCharArray()) {
            if (!Character.isDigit(i)) 
                return false;
            
        }
        return true;
    }
public Student search(String nameID){
if(isDigit(nameID)){
 for(int i=0;i<Students.size();i++){
     if(Students.get(i).getStudentID()==Integer.parseInt(nameID))
         return Students.get(i) ;
      }
}
else {
for(int i=0;i<Students.size();i++){
     if(Students.get(i).getFullName().equals(nameID))
         return Students.get(i) ;
      }
}
return null;
}
public void saveToFile() throws FileNotFoundException{
PrintWriter pr = new PrintWriter("student.txt");
 for (int i = 0; i < Students.size(); i++) {
                pr.println(Students.get(i).lineRepresentation());
            }
  pr.close();
}
}
