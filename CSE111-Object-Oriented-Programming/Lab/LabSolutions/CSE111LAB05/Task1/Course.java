public class Course{
    public String cName;
    public String code;
    public int credit;
    public void createCourse(String s1,String s2,int n){
        cName=s1;
        code=s2;
        credit=n;
    }
    public void displayCourse(){
        System.out.println("Course Name: "+cName+"\nCourse Code: "+code+"\nCourse Credit: "+credit);
    }
    public void updateCourse(String s1,String s2,int n){
        cName=s1;
        code=s2;
        credit=n;
    }
}