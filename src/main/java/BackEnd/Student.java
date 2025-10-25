package BackEnd;
import java.util.Random;
public class Student {
private int StudentID;
 private String FullName;
private int Age;
private String Gender;
private String Department;
 private double GPA;
 public Student(int StudentID,String FullName,int Age,String Gender,String Department ,double GPA){
     if(9000<=StudentID&&StudentID<10000){
     this.StudentID=StudentID;
     }
     else{
         int randomnumber=getRandomNumber(9000,10000);
           this.StudentID=randomnumber;
     }
     if(checkerFullName(FullName)){
     this.FullName=FullName;
     }
     else{
         System.out.println("Something Wrong in FullName"); 
     }
     
     if(Age>0){
     this.Age=Age;
     }
     else{
     System.out.println("Age is't True"); 
     }
     if("Male".equals(Gender) || "Female".equals(Gender)){
       this.Gender=Gender;  
     }
     else{
      System.out.println("Gender is't True");
     }
     this.Department=Department;
     if(0<=GPA&&GPA<=4){
    this.GPA=GPA;
     }
     else{
      System.out.println("GPA is't True");
     }
 } 
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    } public String getDepartment() {
        return Department;
    }
    public void setDepartment(String Department) {
        this.Department = Department;
    }
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }   
public static int getRandomNumber(int min,int max){
Random rand=new Random();
return rand.nextInt(max-min+1)+min;
}
public boolean checkerFullName(String FullName){
for(int i=0;i<FullName.length();i++){ 
    if(Character.isDigit(FullName.charAt(i))){
        return false;
    }
}
return true;
}
  public String lineRepresentation(){
      String a=String.valueOf(Age);
      String g=String.valueOf(GPA);
      String i=String.valueOf(StudentID);
          return i+","+FullName+"," +a+","+Gender+","+Department+","+g;
        }
}