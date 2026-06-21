public class Student{
    public static int totalStudents,cseStudents,otherStudents;
    public String name;
    public static int id=0;
    public double cgpa;
    public String department;
    public Student(String name,double cgpa){
        this.name=name;
        id++;
        this.cgpa=cgpa;
        this.department="CSE";
        totalStudents++;
        cseStudents++;
    }
    public static Student createStudent(String name,double cgpa,String department){
        if(department.equals("CSE")){
            return new Student(name,cgpa,department);
        }
        else{
            return new Student(name,cgpa,department);
        }
        
    }
    public Student(String name,double cgpa,String department){
        this.name=name;
        id++;
        this.cgpa=cgpa;
        this.department=department;
        totalStudents++;
        otherStudents++;
    }
    public void individualDetail(){
        System.out.println("ID: "+id+"\nName: "+name+"\nCGPA: "+cgpa+"\nDepartment: "+department);
    }
    public static void printDetails(){
        System.out.println("Total Student(s): "+totalStudents+"\nCSE Student(s): "+cseStudents+"\nOther Department Student(s): "+otherStudents);
    }
}