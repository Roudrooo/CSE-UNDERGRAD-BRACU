public class Shelf{
    public int capacity;
    public int numberOfBooks;
    Shelf(){
        capacity=0;
        numberOfBooks=0;
    }
    public void addBooks(int n){
        numberOfBooks+=n;
        if(capacity==0){
            System.out.println("Zero capacity. Cannot add books.");
            numberOfBooks-=n;
        }else if(capacity<numberOfBooks){
            System.out.println("Exceeds capacity");
            numberOfBooks-=n;
        }else{
            System.out.println(n+" books added to shelf");
        }
    }
    public void showDetails(){
        System.out.println("Shelf capacity: "+capacity);
        System.out.println("Number of books: "+numberOfBooks);
    }
}