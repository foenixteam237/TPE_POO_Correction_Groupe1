/*
 * Groupe 1 TPE
 * 
 * 1-AANOPELBA DIEBALBE DILANE 24ENSPM352
 * 2-ADIDAI DJELE RAPHAEL 24ENSPM442
 * 3-ANYEKUM RAHIM NJIKE	24ENSPM444
 * 4-ASTA-ADJI AISSATOU SIDDIKI	22E0458EP
 * 4-BADAWE FRINE ANGE DAYANG	22E0460EP
 * 
 * 
 * 
 */


import java.util.Scanner;

public class CorrectionHeritage {

    // Exercice 8-10: Classes A et B
    static class A {
        void f(A o) {
            System.out.println("f(A) dans A");
        }
    }

    static class B extends A {
        @Override
        void f(A o) {
            System.out.println("f(A) dans B");
        }

        void f(B o) {
            System.out.println("f(B) dans B");
        }
    }

    // Exercice 13: Classes C et D
    static class C {
        char ch = 'C';

        char getCh() {
            return ch;
        }
    }

    static class D extends C {
        char ch = 'D';

        @Override
        char getCh() {
            return ch;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n=== CORRECTION TD  POO GROUPE 1: HERITAGE et MASQUAGE ===");
            System.out.println("1. Exercice 1-3 (SlantedRectangle)");
            System.out.println("4. Exercice 4 (Appels méthodes)");
            System.out.println("5. Exercice 5 (Dessin avec Slanted)");
            System.out.println("7. Exercice 7 (equals)");
            System.out.println("8. Exercice 8 (Sortie A/B)");
            System.out.println("11. Exercice 11 (instanceof)");
            System.out.println("13. Exercice 13 Sorti");
            System.out.println("0. Quitter");
            System.out.print("Choix: ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    ex1_3();
                    break;
                case 4:
                    ex4();
                    break;
                case 5:
                    ex5();
                    break;
                case 7:
                    ex7();
                    break;
                case 8:
                    ex8();
                    break;
                case 11:
                    ex11();
                    break;
                case 13:
                    ex13();
                    break;
            }
        } while (choix != 0);
        sc.close();
    }

    static void ex1_3() {
        SlantedRectangle sr = new SlantedRectangle(new Point(0, 0), 5, 3, 45);
        System.out.println("Création SlantedRectangle: " + sr);
        sr.rotate(15);
        System.out.println("Après rotation: " + sr);
        System.out.println("Contains(2,1): " + sr.contains(new Point(2, 1)));
    }

    static void ex4() {
        Point p = new Point(1, 2);
        Rectangle r = new Rectangle(p, 2, 3);
        Rectangle t = new SlantedRectangle(p, 2, 3);
        SlantedRectangle s = new SlantedRectangle(p, 2, 3);

        System.out.println("La surface du rectangle est:" + r.surface()); // Appelle Rectangle.surface()
        // r.rotate(2); // Erreur de compilation (rotate() non défini dans Rectangle)
        System.out.println("La reponse est " + r.contains(p));// Appelle Rectangle.contains()

        System.out.println("La surface est " + t.surface()); // Appelle SlantedRectangle.surface() si redéfini
        // t.rotate(2); // Erreur de compilation (t est de type Rectangle)
        System.out.println("La surface est: " + s.surface()); // Appelle SlantedRectangle.surface()
        s.rotate(2); // Appelle SlantedRectangle.rotate()
    }

    static void ex5() {
        Rectangle[] dessin = {
                new Rectangle(new Point(0, 0), 2, 3),
                new SlantedRectangle(new Point(1, 1), 2, 2, 30)
        };
        System.out.println("Surface totale: " + (dessin[0].surface() + dessin[1].surface()));
    }

    static void ex7() {
        Rectangle r1 = new Rectangle(new Point(0, 0), 2, 3);
        Rectangle r2 = new Rectangle(new Point(0, 0), 2, 3);
        System.out.println("r1.equals(r2): " + r1.equals(r2));
    }

    static void ex8() {
        System.out.println("Sortie Exercice 8:");
        A a = new A();
        A ab = new B();
        B b = new B();

        /*
         * a.f(a); // f(A) dans A
         * ab.f(ab); // f(A) dans B
         * b.f(b); // f(B) dans B
         */
        a.f(a);
        a.f(ab);
        a.f(b);
        ab.f(a);
        ab.f(ab);
        ab.f(b);
        b.f(a);
        b.f(ab);
        b.f(b);
    }

    static void ex11() {
        A ab = new B();
        A a = new A();
        B b = new B();
        System.out.println("ab instanceof A: " + (ab instanceof A));
        System.out.println("ab instanceof B: " + (ab instanceof B));
        System.out.println("a instanceof A " + (a instanceof A));
        System.out.println("ab instanceof A " + (ab instanceof A));
        System.out.println("b instanceof A " + (b instanceof A));
        System.out.println("a instanceof B " + (a instanceof B));
        System.out.println("ab instanceof B " + (ab instanceof B));
        System.out.println("b instanceof B " + (b instanceof B));
    }

    static void ex13() {
        C c = new C();
        D d = new D();
        C cd = new D();

        System.out.println("c.ch: " + c.ch); // C
        System.out.println("c.getCh(): " + c.getCh()); // C
        System.out.println("cd.ch: " + cd.ch); // C
        System.out.println("cd.getCh(): " + cd.getCh()); // D
        System.out.println("d.ch " +d.ch);//D
        System.out.println("d.getch " +d.getCh());//D
    }
}