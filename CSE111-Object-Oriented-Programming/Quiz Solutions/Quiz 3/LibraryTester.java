// LibraryTester.java
public class LibraryTester {
  public static void main(String[] args) {
    System.out.println("Total shelf space: " + Library.getShelfSpace());
    System.out.println("#############################");
    Library book1 = new Library("The Great Gatsby", 1.2);
    book1.details();
    book1.addToShelf();
    System.out.println("#############################");
    Library book2 = new Library("To Kill a Mockingbird", 1.5);
    book2.addToShelf();
    System.out.println("Available shelf space: " + Library.getShelfSpace());
    System.out.println("#############################");
    Library book3 = new Library("War and Peace", 2.8);
    book3.addToShelf();
    book3.details();
    System.out.println("#############################");
    book2.removeFromShelf();
    System.out.println("Available shelf space: " + Library.getShelfSpace());
    System.out.println("#############################");
    book3.addToShelf();
    book2.details();
    System.out.println("Available shelf space: " + Library.getShelfSpace());
  }
}