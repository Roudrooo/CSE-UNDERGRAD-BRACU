public class BBAStudent extends Student{
    public BBAStudent(){
        updateName("Default");
        updateDepartment("BBA");
    }
    public BBAStudent(String name){
        updateName(name);
        updateDepartment("BBA");
    }
}