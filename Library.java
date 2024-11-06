import java.util.Hashtable;

/**
 * represents a library that extends the Building class, addition of ability to manage a collection of books
 */
public class Library extends Building {

  private Hashtable < String, Boolean > collection;
  private boolean hasElevator;

  /**
   * constructs a new library with the specified parameters:
   * 
   * @param name name of library
   * @param address address of the library
   * @param nFloors number of floors in library
   * @param hasELVTR whether library has elevator
   */
  public Library(String name, String address, int nFloors, boolean hasELVTR) {
    super(name, address, nFloors);
    collection = new Hashtable < String, Boolean > ();
    hasElevator = hasELVTR;
    System.out.println("You have built a library: 📖");
  }

  /**
   * constructs a new library with a name, address, and number of floors, sets hasElevator to default false
   * 
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors) {
    this(name, address, nFloors, false);
  }

  /**
   * returns whether library has an elevator
   * 
   */
  public boolean hasElevator() {
    return hasElevator;
  }

  /**
   * adds a title to the library's collection
   * 
   * @param title title of book being added
   */
  public void addTitle(String title) {
    collection.put(title, true);
    System.out.println(title + " has been added to the " + this.getName() + " Library Collection");
  }

  /**
   * removes a title from the library's collection
   * 
   * @param title title of book attempting to be removed
   * @return message indicating success/failure of removal
   */
  public String removeTitle(String title) {
    if (collection.containsKey(title)) {
      collection.remove(title);
      return (title + " has been removed from the " + this.getName() + " Library Collection");
    } else {
      return (title + " could not be found in the " + this.getName() + " Library Collection");
    }
  }

  /**
   * checks out a title from library
   * 
   * @param title title of book attempting to be checked out
   */
  public void checkOut(String title) {
    if ((collection.containsKey(title)) && (collection.get(title) == true)) {
      collection.replace(title, false);
      System.out.println(title + " has sucessfully been checked out.");
    } else if ((collection.containsKey(title)) && (collection.get(title) == false)) {
      System.out.println(title + " has already been checked out. Please try another book.");
    } else {
      System.out.println(title + " is not in the " + this.name + " Library Collection.");
    }
  }

  /**
   * returns a title to the library
   * 
   * @param title title of the book attempting to be returned
   */
  public void returnBook(String title) {
    if ((collection.containsKey(title)) && (collection.get(title) == false)) {
      collection.replace(title, true);
      System.out.println(title + " has sucessfully been returned.");
    } else if ((collection.containsKey(title)) && (collection.get(title) == true)) {
      System.out.println(title + " has already been returned.");
    } else {
      System.out.println(title + " is not in the " + this.name + " Library Collection.");
    }

  }

  /**
   * checks if library contains a specific title
   * 
   * @param title title of book being checked
   * @return true if the title is in the collection, false otherwise
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * checks if a specific title is available for checkout
   * 
   * @param title title of the book to check
   * @return true if title is available, false otherwise
   */
  public boolean isAvailable(String title) {
    if (collection.containsKey(title)) {
      return collection.get(title);
    } else {
      System.out.println(title + " is not in the " + this.name + " Library Collection.");
      return false;
    }
  }

  /**
   * prints the library's collection of books along with whether they are available to be checked out
   */
  public void printCollection() {
    for (String title: collection.keySet()) {

      System.out.println(title + " : " + collection.get(title));
    }
  }

  /**
   * prints the library's collection of books of the specified availability
   * 
   * @param availability availability of books
   */
  public void printCollection(boolean availability) {
    for (String title: collection.keySet()) {
      if (collection.get(title) == availability) {
        System.out.println(title + " : " + collection.get(title));
      }
    }
  }

  /**
   * shows options of actions a user can take when navigating campus
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(t)\n + removeTitle(t)\n + checkOut(t)\n + returnBook(t)\n + containsTitle(t)\n + isAvailable(t)\n + printCollection()");

  }

  /**
   * allows for a user to automatically change floor of library they are on if the library has an elevator
   * 
   * @throws RuntimeException if user is not in the house, trying to move to an invalid floor, or not in a house with an elevator
   */
  public void goToFloor(int floorNum) {
    if (this.hasElevator() == true) {
      super.goToFloor(floorNum);
    } else {

      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
      }
      throw new RuntimeException(this.name + " does not have an elevator. Please navigate using the goUp() and goDown() methods.");

    }
  }
  public static void main(String[] args) {

  }

}