public class Course2 {
    public String name;
    public String code;
    public String[] syllabus;
    public Course2(){
        name=null;
        code=null;
        syllabus=new String[4];
    }
    public void createCourse(String name,String code){
        this.name=name;
        this.code=code;
    }
    public int i=0;

    // The difference in task 6 and task 7 is, unlike task 6, task 7 was done by using method overloading.

    public void addContent(String cont){
        if(i<4){
            syllabus[i++]=cont;
            System.out.println(cont+" was added.");
        }else{
            System.out.println("Cannot add more content");
        }
    }
    public void addContent(String cont1,String cont2){
        if(i<4){
            syllabus[i++]=cont1;
            System.out.println(cont1+" was added.");
            if(i<4){
                syllabus[i++]=cont2;
                System.out.println(cont2+" was added.");
            }else{
                System.out.println("Cannot add more content");
            }
        }else{
            System.out.println("Cannot add more content");
        }
    }
    public void printDetails(){
        System.out.println("Course details:\nCourse Name: "+name+"\nCourse code: "+code+"\nCourse Syllabus:");
        int checker=0;
        for(int j=0;j<4;j++){
            if(!(syllabus[j]==null)){
                if(checker>0) System.out.print(", ");
                System.out.print(syllabus[j]);
                checker++;
            }
        }
        if(checker==0) System.out.println("No content yet.");
        else System.out.println();
    }
}
