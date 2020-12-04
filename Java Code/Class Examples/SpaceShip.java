public class SpaceShip extends Ship {
    private boolean warpCapable = false;
    private String homePlanet = "";

    public SpaceShip(String captain, int maxSpeed, boolean warpCapable, String homePlanet) {
        super(captain, maxSpeed);
        this.warpCapable = warpCapable;
        this.homePlanet = homePlanet;
    }
    public String toString(){
        String outputSuper = super.toString();
        // String output = "\nCaptain: " + this.captain + "\nShip max speed: " + this.maxSpeed + "\nWarp capable: " + this.warpCapable + "\nHome Planet: " +this.homePlanet;
        String output = outputSuper + "\nWarp capable: " + getWarpCapable() + "\nHome Planet: " + getHomePlanet();
        return output;
    }
    public String getHomePlanet() {
        return homePlanet;
    }
    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }
    public boolean getWarpCapable() {
        return warpCapable;
    }
    public void setWarpCapable(Boolean warpCapable) {
        this.warpCapable = warpCapable;
    }
   
    public static void main(String[] args) {
        SpaceShip myShip = new SpaceShip("Robert",60000,false,"Earth");
        System.out.println(myShip.toString());
        myShip.setMaxSpeed(120000);
        myShip.setWarpCapable(true);
        myShip.setHomePlanet("Pluto");
        System.out.println(myShip.toString());
    }
        
}
