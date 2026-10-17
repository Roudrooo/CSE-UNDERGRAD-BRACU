public class Book{
    public String title;
    public String author;
    public int price;
    public Book(String title){
        this.title=title;
    }
    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }
    public Book(String title,String author,int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public void setDetails(int price){
        this.price=price;
    }
    public void setDetails(String author,int price){
        this.author=author;
        this.price=price;
    }
    public void displayDetails(){
        System.out.print("Title: "+this.title);
        if(this.author!=null) System.out.print(", Author: "+this.author);
        if(this.price!=0) System.out.print(", Price: "+this.price);
        System.out.println();
    }
}