package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDataBase {
private ArrayList<Student>Students=new ArrayList<>();
 public void readFromFile() {
        Students.clear();
        try (Scanner input = new Scanner(new File("student.txt"))) {
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (!line.isEmpty()) {
                    Students.add(createRecordFrom(line));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " );
        }
    }

    public ArrayList<Student> getStudents() {
        return Students;
    }
 
     public Student createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Student(Integer.parseInt(parts[0].trim()),parts[1].trim(),Integer.parseInt(parts[2].trim()),parts[3].trim(),parts[4].trim(),Double.parseDouble(parts[5].trim()));
    }  
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
public boolean delete(int key) throws FileNotFoundException{
    for(int i=0;i<Students.size();i++){
   if(Students.get(i).getStudentID()==key){
       Students.remove(Students.get(i));
       saveToFile();
       return true;
   }
       }
    System.out.println("The id does not exist!!");
    return false;
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
public void update(int idOld,int idNew,String n,int age,double gpa) throws FileNotFoundException{
 for(int i=0;i<Students.size();i++){
   if(Students.get(i).getStudentID()==idOld){
       if(9000<=idNew&&idNew<10000)
      Students.get(i).setStudentID(idNew);
             else{
         idNew=Student.getRandomNumber(9000,10000);
          Students.get(i).setStudentID(idNew);
     }
      Students.get(i).setFullName(n);
      Students.get(i).setAge(age);
      Students.get(i).setGPA(gpa);
       saveToFile();
}
 }
}
public void saveToFile() throws FileNotFoundException{
PrintWriter pr = new PrintWriter("student.txt");
 for (int i = 0; i < Students.size(); i++) {
                pr.println(Students.get(i).lineRepresentation());
            }
  pr.close();
}
}

