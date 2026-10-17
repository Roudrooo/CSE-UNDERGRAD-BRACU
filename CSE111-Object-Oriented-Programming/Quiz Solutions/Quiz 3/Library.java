// Library.java
public class Library {
  private static double totalShelfSpace = 5.0;
  private static int nextId = 1;
  
  private int id;
  private String title;
  private double width;
  private boolean onShelf;
  
  public Library(String title, double width) {
    this.id = nextId++;
    this.title = title;
    this.width = width;
    this.onShelf = false;
  }
  
  public void addToShelf() {
    if (!onShelf && width <= totalShelfSpace) {
      onShelf = true;
      totalShelfSpace -= width;
      System.out.println("Book " + id + " added to shelf.");
    } else {
      System.out.println("Cannot add book, exceeds shelf space.");
    }
  }
  
  public void removeFromShelf() {
    if (onShelf) {
      onShelf = false;
      totalShelfSpace += width;
      System.out.println("Book " + id + " removed from shelf.");
    }
  }
  
  public void details() {
    System.out.println("Book ID: " + id + ", Title: " + title + 
                       ", Width: " + width + ", On Shelf: " + onShelf);
  }
  
  public static double getShelfSpace() {
    return totalShelfSpace;
  }
}