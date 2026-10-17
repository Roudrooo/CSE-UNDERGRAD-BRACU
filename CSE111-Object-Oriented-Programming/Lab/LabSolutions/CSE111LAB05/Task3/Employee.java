public class Employee {
    public String name;
    public float salary;
    public String designation;
    public void newEmployee(String s){
        name=s;
        salary=30000;
        designation="junior";
    }
    public void displayInfo(){
        System.out.println("Employee Name: "+name+"\nEmployee Salary: "+salary+" Tk\nEmployee Designation: "+designation);
    }
    public void calculateTax(){
        float tax;
        if(salary>30000&&salary<=50000){
            tax=salary*0.1f;
        }else if(salary>50000){
            tax=salary*0.3f;
        }else{
            tax=0;
        }
        if(tax==0){
            System.out.println("No need to pay tax");
        }else{
            System.out.printf(name+" Tax Amount: %.2f Tk\n",tax);
        }
    }
    public void promoteEmployee(String s){
        if(s.equals("senior")){
            salary+=25000;
        }else if(s.equals("lead")){
            salary+=50000;
        }else if(s.equals("manager")){
            salary+=75000;
        }
        designation=s;
        System.out.println(name+" has been promoted to "+s+"\nNew salary: "+salary+" Tk");
    }
}