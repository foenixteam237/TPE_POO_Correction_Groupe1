public class Rectangle {
    protected Point p;
    private double width, height;
    static int nbr;
    
    public Rectangle(Point p, double w, double h) {
        this.p = p;
        width = w;
        height = h;
        nbr++;
    }
    
    public double surface() { return width * height; }
    public void translate(double dx, double dy) { p.translate(dx, dy); }
    public boolean contains(Point pt) {
        return pt.getX() >= p.getX() && pt.getX() <= p.getX() + width &&
               pt.getY() >= p.getY() && pt.getY() <= p.getY() + height;
    }
    
    public boolean equals(Rectangle other) {
        return this.p.getX() == other.p.getX() && this.p.getY() == other.p.getY() &&
               this.width == other.width && this.height == other.height;
    }
}
