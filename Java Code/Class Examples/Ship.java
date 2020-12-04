public class Ship{
    private String captain = "";
    private int maxSpeed = 0;
    private int crewSize =0;

    public Ship(String captain, int maxSpeed){
        this.captain = captain;
        this.maxSpeed = maxSpeed;
    }

    //Object data to string
    public String toString(){
        String output = "\nCaptain: " + getCaptain() + "\nShip max speed: " + getMaxSpeed()+ "\nCrew Size: " + getCrewSize();
        return output;
    }

    //Getter and Setter methods
    public String getCaptain() {
        return captain;
    }
    public void setCaptain(String captain) {
        this.captain = captain;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public int getCrewSize() {
        return crewSize;
    }
    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    //Method to compare two Ship object Speed
    public static int compareSpeed(Ship shipA, Ship shipB) {
        int shipASpeed  = shipA.getMaxSpeed();
        int shipBSpeed  = shipB.getMaxSpeed();
        if (shipASpeed>shipBSpeed){
            return shipASpeed/shipBSpeed;
        }else{
            return shipBSpeed/shipASpeed;
        }
        // return shipA.getMaxSpeed()/shipB.getMaxSpeed();        
    }
    public static Ship fastestShip(Ship[] ships) {
        Ship fastestShip = null;
        int currentMaxSpeed = 0;
        for (Ship ship : ships) {
            if (ship.getMaxSpeed() > currentMaxSpeed) {
                currentMaxSpeed = ship.getMaxSpeed();
                fastestShip = ship;
            }
        }
        return fastestShip;
    }


    public static void main(String[] args) {
        Ship myShip = new Ship("Robert",60);
        System.out.println(myShip.toString());
        myShip.setCaptain("Jack Sparrow");
        myShip.setMaxSpeed(70);
        System.out.println(myShip.toString());
    }
}