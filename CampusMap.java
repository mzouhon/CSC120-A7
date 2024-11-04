import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        
        
       Building ford= new Building("Ford Hall", "100 Green Street, Northampton, MA 01063", 4);
       Building bass=new Building("Bass Hall", "4 Tyler Court, Northampton, MA 01063", 4);
       Building burton=new Building("Burton Hall","46 College Ln, Northampton, MA 01063",4);
       Building mwangi=new Building("Mwangi Cultural Center", "12 Prospect St, Northampton, MA 01063",1 );
       Building alumGym=new Building("Alumnae Gym", "83 Green St, Northampton, MA 01063", 3);
       House tyler=new House("Tyler House", "164 Green St, Northampton, MA 01060",4, true, false);
       House unknownHouse=new House("165 Green St, Northampton, MA 01060");
       House baldwin=new House("Baldwin House", "15 Bedford Terrace, Northampton, MA 01060", 5);
       Cafe compassCafe=new Cafe("Compass Cafe","7 Neilson Drive, Northampton, MA 01063", 1, 150,50,50,50 );
       Cafe ccCafe=new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063",1);
       Library neilson=new Library("Neilson Library","7 Neilson Drive, Northampton, MA 01063",5,true);
       Library hillyer=new Library("Hillyer Library","22 Elm St, Northampton, MA 01063",2);

       neilson.addTitle("Percy Jackson #1");
       neilson.addTitle("Percy Jackson #2");
       neilson.addTitle("Percy Jackson #3");
       neilson.addTitle("Percy Jackson #4");
       neilson.addTitle("Percy Jackson #5");
       neilson.checkOut("Percy Jackson #1");
       neilson.checkOut("Percy Jackson #3");


        myMap.addBuilding(ford);
        myMap.addBuilding(bass);
        myMap.addBuilding(burton);
        myMap.addBuilding(mwangi);
        myMap.addBuilding(alumGym);
        myMap.addBuilding(tyler);
        myMap.addBuilding(unknownHouse);
        myMap.addBuilding(baldwin);
        myMap.addBuilding(compassCafe);
        myMap.addBuilding(ccCafe);
        myMap.addBuilding(neilson);
        myMap.addBuilding(hillyer);
        compassCafe.enter();
        compassCafe.sellCoffee(150,50,2);
        compassCafe.sellCoffee(true, false);
        compassCafe.exit();
       
        neilson.enter();
        neilson.printCollection();
        neilson.printCollection(true);
        


    
}
}
