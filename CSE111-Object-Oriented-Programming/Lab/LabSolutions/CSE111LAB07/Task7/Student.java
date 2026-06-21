public class Student{
    private String[] course;
    private int id;
    private double cg;
    private int idx=0;
    public Student(int id){
        this.id=id;
        course=new String[4];
    }

    public Student(int id,double cg){
        this.id=id;
        this.cg=cg;
        course=new String[4];
    }
    public void setCG(double cg){
        this.cg=cg;
    }
    public double getCG(){
        return this.cg;
    }
    public void setID(int id){
        this.id=id;
    }
    public int getID(){
        return this.id;
    }
    public void addCourse(String course){
        if(this.cg!=0){
            if(this.cg>=3.0){
                for(int i=0;i<4;i++){
                    this.course[i]=course;
                }
            }else{
                for(int i=0;i<3;i++){
                    this.course[i]=course;
                }
            }
        }else{
            System.out.println("Failed to add "+course+"\nSet CG first");
        }
    }
    public void rmAllCourse(){
        for(int i=0;i<4;i++){
            this.course[i]=null;
        }
    }
    public void addCourse(String[] courses){
        if(this.cg!=0){
            if(this.cg>3.0){
                for(int i=0;i<4;i++){
                    this.course[i]=courses[i];
                }
            }else{
                for(int i=0;i<3;i++){
                    this.course[i]=courses[i];
                }
            }
        }else{
            System.out.println("Failed to add "+course+"\nSet CG first");
        }
    }
    public void showAdvisee(){
        System.out.println("Student ID: "+this.id+", CGPA: "+this.cg);
    }
}