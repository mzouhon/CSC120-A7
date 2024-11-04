import javax.management.RuntimeErrorException;

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
//overloaded constructor #1
    public Cafe(String name, String address, int nFloors){
      this(name, address, nFloors,100,20,20,20);
    }
  
    /**
     * sells a specified size cofffee with the reqested number of of sugars and creams
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
    //overloaded sellCoffee method
    public void sellCoffee(boolean sugar, boolean cream){
      if ((sugar==true) && (cream==true)){
        this.sellCoffee(8,2,1);
      }else if((sugar==true)&& (cream==false)){
        this.sellCoffee(8,2,0);
      }else if((sugar==false)&&(cream==true)){
        this.sellCoffee(8,0,1);
      }else{
        this.sellCoffee(8,0,0);
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

    public void showOptions() {
      super.showOptions();
      System.out.println(" + sellCoffee(s,sp,cr)");

  }

    public void goToFloor(int floorNum){
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    throw new RuntimeException("This cafe does not have an elevator. Please navigate using the  goUp(n) and goDown(n) methods.");

    }
    public static void main(String[] args) {

    
  
    }
    
  }