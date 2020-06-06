package test;

//iz ove klase TestGeo pristupamo obelezjima objekta klase Point
//kljucna rec import.naziv paketa.naziv klase
import projekat.*;

//import nije potreban kada klasa koristi funkcionalnost druge klase u okviru istog paketa

//da bi smo ilistrovali kako se pristupa objektima neke klase
public class TestGeo {
    public static void main(String[] args){

        //PRIMER IZ KNJIGE KADA JE PUBLIC U POINT*****
        //sa leve strane - deklaracija promenljive point1
        //sa desne strane - kreiranje novog objekta klase Point
        //preko point1 je moguce pristupati obelezjima objekta koji ona referencira (str. 130)
//        Point point1 = new Point();
//        Point point2 = new Point();
//
//        point1.x = 100;
//        point1.y = 120;
//
//        point2.x = -330;
//        point2.y = 320;
//        point2.selected = true;
//
//        System.out.println(point1.x);
//        System.out.println(point1.y);
//        System.out.println(point1.selected);
//
//        System.out.println(point2.x);
//        System.out.println(point2.y);
//        System.out.println(point2.selected);

        //sa kljucnom reci new uvek kreiramo novi objekat
        Point point1 = new Point();
        point1.setX(100);
        point1.setY(120);
        point1.setSelected(true);
       System.out.println("x: " + point1.getX() + "\n" + "y: " + point1.getY() + "\n" + "selected: " + point1.isSelected());


        System.out.println("======================== DISTANCE metoda");


        //pozivanje metode distance

        //I nacin
//        Point p1 = new Point(5, 10);
//        Point p2 = new Point(10, 12);
//        double distance = p1.distance(p2);


        //II nacin
        Point point2 = new Point();
        point2.setX(150);
        point2.setY(200);
        point2.setSelected(true);


        double distance = point1.distance(point2.getX(), point2.getY());
        System.out.println(distance);

        //ZADATAK 1 ***
        // 1. Inicijalizovati x koordinatu tacke point1
        // na vrednost y koordinate tacke point2
        System.out.println("-- Zadatak 1");
        point1.setX(point1.getY());
        System.out.println("x od point 1 na y od point2: " + point1.getX());


        System.out.println("======================== LENGTH metoda (Line 2)");

        System.out.println("-- Zadatak 2");
        // 2. Postaviti za pocetnu tacku linije l2 tacku point1, a
        // za krajnju tacku linije l1 tacku p1
        Line2 l2 = new Line2();
        l2.setStartPoint(point1);
        l2.setEndPoint(point2);

        System.out.println("start point: " + l2.getStartPoint() + "\n" + "end point: " + l2.getEndPoint());

        System.out.println("-- Zadatak 3");
        // 3. Postaviti y koordinatu krajnje tacke l2 na 23
        l2.getEndPoint().setY(23);
        System.out.println("y koordinata kranje tacke l2: " + l2.getEndPoint().getY());

        System.out.println("-- Zadatak 4");
        // 4. Inicijalizovati x koordinatu pocetne tacke linije l2
        // na vrednost y koordinate krajnje tacke linije l2

        l2.getEndPoint().setX(l2.getEndPoint().getY());
        System.out.println("x koord. pocetne tacke linije l2 na vredn. krajnje tacke l2: " + l2.getStartPoint().getX());

        System.out.println("-- Zadatak 5");
        // 5. Postaviti x koordinatu krajnje tacke l2 na vrednost
        // duzine linije l2 umanjene za vrednost zbira x i y
        // koordinate pocetne tacke linije l2

        l2.getEndPoint().setX((int) (l2.lenghth() - (l2.getStartPoint().getX() + l2.getStartPoint().getY())));
        System.out.println("x koordinata krajnje tacke l2 na duzinu l2 umanjene za vredn. zbira x i y od l2: " + l2.getEndPoint().getX());


        System.out.println("======================== RECTANGLE");

        System.out.println("-- Zadatak 6");
        // 6. Postaviti x koordinatu tacke gore levo pravougaonika
        // r1 na vrednost 10 i y koordinatu na vrednost 15

        Rectangle r1 = new Rectangle();
        r1.setUpperLeft(point1);
        r1.getUpperLeft().setX(10);
        r1.getUpperLeft().setY(15);

        System.out.println("x od upper left: " + r1.getUpperLeft().getX() + "\n" + "y od upper left: " + r1.getUpperLeft().getY());


        System.out.println("======================== CIRCLE");

        System.out.println("-- Zadatak 7");
        // 7. Postaviti centar kruga c1 na koordinate tacke
        // gore levo od r1
        Circle c1 = new Circle();
        c1.setCenter(r1.getUpperLeft());

        System.out.println("-- Zadatak 8");
        // 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
        // povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
        r1.setWidth(10);
        r1.setHeight(20);
        c1.getCenter().setX(r1.area() - l2.getStartPoint().getY());

        System.out.println("x od c1 iznosi: " + c1.getCenter().getX());

        System.out.println("======================== Primer metode equals");
        Point pp1 = new Point(30, 50);
        Point pp2 = new Point(30, 50);
        Point pp3 = pp1;

        if (pp1 == pp2){
         System.out.println("p1 i p2 referenciraju isti objekat");
        }else {
         System.out.println("p1 i p2 referenciraju razlicite objekte");
        }

     if (pp1.equals(pp2)){
      System.out.println("p1 i p2 referenciraju isti objekat");
     }else {
      System.out.println("p1 i p2 referenciraju razlicite objekte");
     }

     if (pp1 == pp3){
      System.out.println("p1 i p3 referenciraju isti objekat");
     }else {
      System.out.println("p1 i p3 referenciraju razlicite objekte");
     }

     if (pp1.equals(pp3)){
      System.out.println("p1 i p3 referenciraju isti objekat");
     }else {
      System.out.println("p1 i p3 referenciraju razlicite objekte");
     }

     Dount d1 = new Dount();
     if(d1 instanceof Dount){
      System.out.println("d1 je tipa Dount");
     }else {
      System.out.println("d1 nije tipa Dount");
     }

     if(d1 instanceof Circle){
      System.out.println("d1 je tipa Circle");
     }else {
      System.out.println("d1 nije tipa Circle");
     }

     //toString metoda iz Point
     Point ps = new Point(10, 20);
     System.out.println(ps.toString());
     System.out.println(ps);

     Point ps2 = new Point(11, 21);
     Line2 ls = new Line2();
     ls.setStartPoint(ps);
     ls.setEndPoint(ps2);
     System.out.println(ls.toString());


    }
}
