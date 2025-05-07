import java.util.Scanner;

public class CorrectionHeritage {
 
    // Exercice 1-3: SlantedRectangle
    static class SlantedRectangle extends Rectangle {
        double angle;
        
        public SlantedRectangle(Point p, double w, double h, double a) {
            super(p, w, h);
            angle = a;
        }
        
        public void rotate(double da) { angle += da; }
        
        @Override
        public boolean contains(Point pt) {
            // Implémentation simplifiée pour l'exemple
            return super.contains(pt); // Ne tient pas compte de l'angle réellement
        }
        
        @Override
        public String toString() {
            return super.toString() + " angle=" + angle;
        }
    }

    // Exercice 8-10: Classes A et B
    static class A {
        void f(A o) { System.out.println("f(A) dans A"); }
    }

    static class B extends A {
        @Override void f(A o) { System.out.println("f(A) dans B"); }
        void f(B o) { System.out.println("f(B) dans B"); }
    }

    // Exercice 13: Classes C et D
    static class C {
        char ch = 'C';
        char getCh() { return ch; }
    }

    static class D extends C {
        char ch = 'D';
        @Override char getCh() { return ch; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n=== CORRECTION TD  POO: HERITAGE et MASQUAGE ===");
            System.out.println("1. Exercice 1-3 (SlantedRectangle)");
            System.out.println("4. Exercice 4 (Appels méthodes)");
            System.out.println("5. Exercice 5 (Dessin avec Slanted)");
            System.out.println("7. Exercice 7 (equals)");
            System.out.println("8. Exercice 8 (Sortie A/B)");
            System.out.println("11. Exercice 11 (instanceof)");
            System.out.println("13. Exercice 13 (Champs vs Methodes)");
            System.out.println("0. Quitter");
            System.out.print("Choix: ");
            choix = sc.nextInt();
            
            switch(choix) {
                case 1: ex1_3(); break;
                case 4: ex4(); break;
                case 5: ex5(); break;
                case 7: ex7(); break;
                case 8: ex8(); break;
                case 11: ex11(); break;
                case 13: ex13(); break;
            }
        } while(choix != 0);
        sc.close();
    }

    static void ex1_3() {
        SlantedRectangle sr = new SlantedRectangle(new Point(0,0), 5, 3, 45);
        System.out.println("Création SlantedRectangle: " + sr);
        sr.rotate(15);
        System.out.println("Après rotation: " + sr);
        System.out.println("Contains(2,1): " + sr.contains(new Point(2,1)));
    }

    static void ex4() {
        A a = new A();
        B b = new B();
        A ab = new B();
        
        System.out.println("\nTest a.f(b):");
        a.f(b); // f(A) dans A
        System.out.println("Test ab.f(b):");
        ab.f(b); // f(A) dans B
        System.out.println("Test b.f(b):");
        b.f(b); // f(B) dans B
    }

    static void ex5() {
        Rectangle[] dessin = {
            new Rectangle(new Point(0,0), 2, 3),
            new SlantedRectangle(new Point(1,1), 2, 2, 30)
        };
        System.out.println("Surface totale: " + (dessin[0].surface() + dessin[1].surface()));
    }

    static void ex7() {
        Rectangle r1 = new Rectangle(new Point(0,0), 2, 3);
        Rectangle r2 = new Rectangle(new Point(0,0), 2, 3);
        System.out.println("r1.equals(r2): " + r1.equals(r2));
    }

    static void ex8() {
        System.out.println("Sortie Exercice 8:");
        A a = new A();
        A ab = new B();
        B b = new B();
        
        a.f(a);    // f(A) dans A
        ab.f(ab);  // f(A) dans B
        b.f(b);    // f(B) dans B
    }

    static void ex11() {
        A ab = new B();
        System.out.println("ab instanceof A: " + (ab instanceof A));
        System.out.println("ab instanceof B: " + (ab instanceof B));
    }

    static void ex13() {
        C c = new C();
        D d = new D();
        C cd = new D();
        
        System.out.println("c.ch: " + c.ch);         // C
        System.out.println("c.getCh(): " + c.getCh()); // C
        System.out.println("cd.ch: " + cd.ch);       // C
        System.out.println("cd.getCh(): " + cd.getCh()); // D
    }
}