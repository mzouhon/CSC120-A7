/**
 * class represents a building that can be navigated by a user 
 */
public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building
  
    /**
     * constructs a building with no parameters, uses default valuse for name, address, and number of floors
     */
    public Building() {
      this("<Name Unknown>", "<Address Unknown>", 1);
    }
  
    /**
     * constructs a building that only takes the address parameter, uses default values for name and number of floors
     * 
     * @param address address of building
     */
    public Building(String address) {
      this(); // Call default constructor
      this.address = address; // Override address
    }
  
    /**
     * constructs a building that takes a name and address parameter, uses default value for number of floors
     * 
     * @param name name of building
     * @param address address of building
     */
    public Building(String name, String address) {
      this(name, address, 1); // Call full constructor with hard-coded # floors
    }
  
    /**
     * constructs a building that takes a name, address, and number of floors as parameters
     * 
     * @param name name of building
     * @param address address of building
     * @param nFloors number of floors of building
     */
    public Building(String name, String address, int nFloors) {
      if (name != null) {
        this.name = name;
      }
      if (address != null) {
        this.address = address;
      }
      if (nFloors < 1) {
        throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
      }
      this.nFloors = nFloors;
    }
  
    /**
     * returns name of building
     * 
     * @return name of building
     */
    public String getName() {
      return this.name;
    }
  
    /**
     * returns address of building
     * 
     * @return address of building
     */
    public String getAddress() {
      return this.address;
    }
  
    /**
     * returns number of floors of building
     * 
     * @return number of floors of building
     */
    public int getFloors() {
      return this.nFloors;
    }
  
    /**
     * allows a building to be entered
     * 
     * @return building object 
     */
    public Building enter() {
      if (activeFloor != -1) {
        throw new RuntimeException("You are already inside this Building.");
      }
      this.activeFloor = 1;
      System.out.println("You are now inside " + this.name + " on the ground floor.");
      return this; // Return a pointer to the current building
    }
  
    /**
     * allows for a building to be exited
     * 
     * @return null as a user is no longer "in" a building
     * @throws RuntimeException if user is not in building or is trying to exit on a floor that is not the ground floor
     */
    public Building exit() {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
      }
      if (this.activeFloor > 1) {
        throw new RuntimeException("You have fallen out a window from floor #" + this.activeFloor + "!");
      }
      System.out.println("You have left " + this.name + ".");
      this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
      return null; // We're outside now, so the building is null
    }
  
    /**
     * allows for a user to change floor of building they are on
     * 
     * @param floorNum floor number 
     */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
  
    /**
     * allows user to go up one floor 
     */
    public void goUp() {
      this.goToFloor(this.activeFloor + 1);
    }
  
    /**
     * allows user to go down one floor
     */
    public void goDown() {
      this.goToFloor(this.activeFloor - 1);
    }
  
    /**
     * shows options of actions a user can take when navigating campus
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }
  
    /**
     * returns a string representation of object containing information about the building
     * 
     * @return string representation of object
     */
    public String toString() {
      return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }
  
    public static void main(String[] args) {
      System.out.println("------------------------------------");
      System.out.println("Test of Building constructor/methods");
      System.out.println("------------------------------------");
  
      Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
      System.out.println(fordHall);
      fordHall.showOptions();
  
      System.out.println("-----------------------------------");
      System.out.println("Demonstrating enter/exit/navigation");
      System.out.println("-----------------------------------");
      fordHall.enter();
      fordHall.goUp();
      fordHall.goDown();
      fordHall.exit();
    }
  
  }