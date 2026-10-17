public class Assignment{
    public int tasks;
    public String difficulty;
    public boolean submission;
    public Assignment(){
        this.tasks=0;
        this.difficulty=null;
        this.submission=false;
    }
    public void printDetails(){
        System.out.println("Number of tasks: "+tasks);
        System.out.println("Difficulty level: "+difficulty);
        System.out.println("Submission required: "+submission);
    }
    public void makeOptional(){
        if(submission==true){
            System.out.println("Assignment will not require submission");
            submission=false;
        } else{
            System.out.println("Submission is already not required");
        }
    }
}