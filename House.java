import java.util.ArrayList;

/**
 * represents a house that extends the Building class, adds attributes that manage residents and whether the house has a dining room
 */

public class House extends Building {

  private ArrayList < String > residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * constructs a house with the specified parameters:
   * 
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors of house
   * @param hasDR whether house has a dining room
   * @param hasELVTR whether house has elevator
   */
  public House(String name, String address, int nFloors, boolean hasDR, boolean hasELVTR) {
    super(name, address, nFloors);
    residents = new ArrayList < String > ();
    hasDiningRoom = hasDR;
    hasElevator = hasELVTR;

    System.out.println("You have built a house: 🏠");
  }

  /**
   * constructs a house with a name, address, and number of floors, and default valuse of hasDiningRoom and hasElevator to false
   * 
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors of house
   */
  public House(String name, String address, int nFloors) {
    this(name, address, nFloors, false, false);
  }

  /**
   * constructs a house with default values except for the address 
   * 
   * @param address address of house
   */
  public House(String address) {
    super();
    this.address = address;
  }

  /**
   * returns whether house has dining room
   * 
   * @return true if house has a dining room, false otherwise
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  public boolean hasElevator() {
    return hasElevator;
  }

  /**
   * returns number of residents in a house
   * 
   * @return number of residents
   */
  public int nResidents() {

    System.out.println(this.name + " has " + residents.size() + " residents.");
    return residents.size();
  }

  /**
   * allows a person to move into a house
   * 
   * @param name name of person attempting to move in
   */
  public void moveIn(String name) {
    if (residents.contains(name)) {
      System.out.println(name + "has already moved in.");
    } else {
      residents.add(name);
      System.out.println(name + " has moved into " + this.getName());

    }

  }

  /**
   * allows a resident to move out of a house
   * 
   * @param name name of person attempting to move out
   * @return name or person who move out or a message if unsucessful
   */
  public String moveOut(String name) {
    if (residents.contains(name)) {
      residents.remove(name);
      System.out.println(name + " has moved out of " + this.getName());
      return name;
    } else
      System.out.println(name + " does not appear to live in " + this.getName());
    return (name + " does not appear to live in " + this.getName());
  }

  /**
   * checks if a person is a resident of a house
   * 
   * @param person the name of the person to check
   * @return true if person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }

  /**
   * shows options of actions a user can take when navigating campus
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom()\n + nResidents()\n + moveIn(n)\n + moveOut(n)\n + isResident(n)");
  }

  /**
   * allows for a user to automatically change floor of the house they are on if the house has an elevator
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