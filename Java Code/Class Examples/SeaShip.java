public class SeaShip extends Ship {
    private int numberOfCannons = 0;
    private boolean pirate = false;
    private int bootyPlundered = 0;

    public SeaShip(String captain, int maxSpeed, int numberOfCannons, Boolean pirate) {
        super(captain, maxSpeed);
        this.numberOfCannons = numberOfCannons;
        this.pirate = pirate;
    }
    public String toString(){
        String outputSuper = super.toString();
        String output = outputSuper + "\nNumber of cannons: " + getNumberOfCannons() + "\nPirate: " + getPirate()+ "\nBooty Plundered (kg): " + getBootyPlundered();
        return output;
    }
    public int getNumberOfCannons() {
        return numberOfCannons;
    }
    public void setNumberOfCannons(int numberOfCannons) {
        this.numberOfCannons = numberOfCannons;
    }
    public void setPirate(boolean pirate) {
        this.pirate = pirate;
    }
    public boolean getPirate() {
        return pirate;        
    }
    public int getBootyPlundered() {
        return bootyPlundered;
    }
    public void setBootyPlundered(int bootyPlundered) {
        this.bootyPlundered = bootyPlundered;
    }

   
    public static void main(String[] args) {
        SeaShip myShip = new SeaShip("Robert",30,120,false);
        SpaceShip mySpaceShip = new SpaceShip("Robert", 12000, false, "Earth");
        System.out.println(mySpaceShip.toString());
        System.out.println(myShip.toString());
        System.out.println("Space ship is " + Ship.compareSpeed(mySpaceShip, myShip) + " times faster than my sea ship");
    }
        
}
