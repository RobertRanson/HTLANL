
public class Triangle extends Shape {
    private int hypotinose;
    private double area;
    private double angle;

    public Triangle() {
        super();
    }
    //1/2 LxB Initalisation
    public Triangle(int height, int width) {
        this.setHeight(height);
        this.setWidth(width);
        this.setArea(areaLxB());

    }
    //Side lenghts Initalisation
    public Triangle(int height, int width, int hypotinose){
        this.setHeight(height);
        this.setWidth(width);
        this.setHypotinose(hypotinose);
        this.setArea(areaLxBxH());
    }
    //trigonomety initalisation
    public Triangle(int sideB, int sideC, double angleA){
        this.setHeight(sideB);
        this.setWidth(sideC);
        this.setAngle(angleA);
        this.setArea(areaTrig());

    }

    //Getters and Setters
    public void setHypotinose(int hypotinose) {
        this.hypotinose = hypotinose;
    }
    public int getHypotinose() {
        return hypotinose;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public double area() {
        return area;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public double getAngle() {
        return angle;
    }
    
    //Area Length x Breath
    public double areaLxB() {
        return 0.5*this.getHeight()*this.getWidth();
    }

    //Area Side lengths
    public double calculateSemiperimeter() {
        return (0.5*(this.getHeight()+this.getWidth()+this.getHypotinose()));        
    }
    public double areaLxBxH(){
        double s = this.calculateSemiperimeter();
        return (Math.sqrt(s*(s-this.getHeight())*(s-this.getWidth())*(s-this.getHypotinose())));
    }
    public double areaTrig() {
        int bc = this.getHeight()*this.getWidth();
        double radians = Math.toRadians(this.getAngle());
        return((bc/2)*Math.sin(radians));        
    }
    public static void main(String[] args) {
        Triangle myTriangle1  = new Triangle(4,3);
        Triangle myTriangle2 = new Triangle(4,3,5);
        Triangle myTriangle3 = new Triangle(150,231,123.0);
        System.out.println(myTriangle1.area());
        System.out.println(myTriangle2.area());
        System.out.println(myTriangle3.area());

    }


}
