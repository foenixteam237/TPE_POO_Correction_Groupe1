public class Point {
    private double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    public double getX(){
        return this.x;
    }
    public double getY(){ return this.y;}
    public void translate(double dx, double dy) { x += dx; y += dy; }
    public String toString() { return "(" + x + "," + y + ")"; }
    
}
