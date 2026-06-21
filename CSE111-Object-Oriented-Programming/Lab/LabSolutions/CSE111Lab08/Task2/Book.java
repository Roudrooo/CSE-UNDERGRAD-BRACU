public class Book{
    public static int total_books_sold;
    public static double total_revenue;
    public String name;
    public double price=150;
    public Book(String name,double discount){
        total_books_sold++;
        this.name=name;
        this.price=price-(price*discount/100);
        total_revenue+=price;
    }
    public void bookDetails(){
        System.out.println("Book Name: "+name+"\nPrice: "+price+" TK");
    }
}