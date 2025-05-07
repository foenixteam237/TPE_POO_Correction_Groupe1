
// Exercice 1-3: SlantedRectangle

class SlantedRectangle extends Rectangle {
    double angle;

    public SlantedRectangle(Point p, double w, double h, double a) {
        super(p, w, h);
        angle = a;
    }

    public SlantedRectangle(Point p, double w, double h) {
        super(p, w, h);
    }

    public void rotate(double da) {
        angle += da;
    }

    @Override
    public boolean contains(Point pt) {
        // Implémentation simplifiée pour l'exemple
        return super.contains(pt); // Ne tient pas compte de l'angle réellement
    }

    // Ceci est une redéfinition de la fonction toString() qui existe dans la
    // bibliothèque de java
    @Override
    public String toString() {
        return super.toString() + " angle=" + angle;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SlantedRectangle))
            return false;
        SlantedRectangle other = (SlantedRectangle) obj;
        return super.equals(obj) && this.angle == other.angle;
    }
}