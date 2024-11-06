/**
 * represents a cafe that extends the Building class and adds attributes that manage cafe supplies
 */
public class Cafe extends Building {

  private int nCoffeeOunces;
  private int nSugarPackets;
  private int nCreams;
  private int nCups;

  /**
   * constructs a new cafe with parameters:
   * 
   * @param name name of cafe
   * @param address address of cafe
   * @param nFloors number of floors of cafe
   * @param nCO initial number of ounces of coffee stocked in cafe
   * @param nSP initial number of sugar packets stocked in cafe
   * @param nCr initial number of creams stocked in cafe
   * @param nCu initial number of cups stocked in cafe
   */
  public Cafe(String name, String address, int nFloors, int nCO, int nSP, int nCr, int nCu) {
    super(name, address, nFloors);
    nCoffeeOunces = nCO;
    nSugarPackets = nSP;
    nCreams = nCr;
    nCups = nCu;
    System.out.println("You have built a cafe: ☕");
  }

  /**
   * constructs a new cafe with a name, address, and number of floors
   * 
   * @param name name of cafe
   * @param address address of cafe
   * @param nFloors number of floors of cafe 
   */
  public Cafe(String name, String address, int nFloors) {
    this(name, address, nFloors, 100, 20, 20, 20);
  }

  /**
   * sells a specified size coffee with the reqested number of of sugars and creams
   * restocks inventory when items run out
   * 
   * @param size size of coffee in ounces
   * @param nSugarPackets number of sugar packets for coffee
   * @param nCreams number of creams for coffee
   */
  public void sellCoffee(int size, int nSugarPackets, int nCreams) {
    int restockCu = 0;
    int restockCO = 0;
    int restockSP = 0;
    int restockCr = 0;

    if ((this.nCups > 0) && (size <= this.nCoffeeOunces) && (nSugarPackets <= this.nSugarPackets) && (nCreams <= this.nCreams)) {
      this.nCups--;
      this.nCoffeeOunces = this.nCoffeeOunces - size;
      this.nSugarPackets = this.nSugarPackets - nSugarPackets;
      this.nCreams = this.nCreams - nCreams;
    } else {
      if (this.nCups == 0) {
        System.out.println("Need more cups.");
        restockCu = 25;
      }
      if (this.nCoffeeOunces < size) {
        System.out.println("Not enough coffee to fufill this order.");
        restockCO = 10 * size;
      }
      if (this.nSugarPackets < nSugarPackets) {
        System.out.println("Not enough sugar packets to fufill this order.");
        restockSP = 10 * nSugarPackets;
      }
      if (this.nCreams < nCreams) {
        System.out.println("Not enough creams to fufill this order.");
        restockCr = 10 * nCreams;
      }
      System.out.println("Currently restocking!");
      restock(restockCO, restockSP, restockCr, restockCu);

      this.nCups--;
      this.nCoffeeOunces = this.nCoffeeOunces - size;
      this.nSugarPackets = this.nSugarPackets - nSugarPackets;
      this.nCreams = this.nCreams - nCreams;

    }
    System.out.println("You have sold a coffee.");
  }
  /**
   * sells an 8 ounce coffee with sugar and cream if specified and restocks inventory through original sellCoffee method
   * 
   * 
   * @param sugar whether sugar is wanted in the coffee
   * @param cream whether cream is wanted in the coffee
   */
  public void sellCoffee(boolean sugar, boolean cream) {
    if ((sugar == true) && (cream == true)) {
      this.sellCoffee(8, 2, 1);
    } else if ((sugar == true) && (cream == false)) {
      this.sellCoffee(8, 2, 0);
    } else if ((sugar == false) && (cream == true)) {
      this.sellCoffee(8, 0, 1);
    } else {
      this.sellCoffee(8, 0, 0);
    }

  }

  /**
   * restocks cafe inventory with specified amounts of items
   * 
   * @param nCoffeeOunces ounces of coffees to be restocked
   * @param nSugarPackets number of sugar packets to be restocked
   * @param nCreams number of creams to be restocked
   * @param nCups number of cups to be restocked
   */
  private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
    this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
    this.nSugarPackets = this.nSugarPackets + nSugarPackets;
    this.nCreams = this.nCreams + nCreams;
    this.nCups = this.nCups + nCups;
  }

  /**
   * shows options of actions a user can take when navigating campus
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + sellCoffee(s,sp,cr)");

  }
  /**
   *  disallows use of goToFloor method for Building class through throwing a runtime Exception
   * 
   * @throws RuntimeException if user attempts to use method
   */
  public void goToFloor(int floorNum) {
    throw new RuntimeException("This cafe does not have an elevator. Please navigate using the goUp(n) and goDown(n) methods.");

  }
  public static void main(String[] args) {

  }

}