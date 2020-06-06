package projekat;

import java.awt.*;

//Kreiramo klasu Point
public class Point extends Shape{

    //za kord. pocetak se uzima gornji levi ugao
    //x vrednosti rastu na desno
    //y vredn. rastu na dole
    //svaka tacka mora da ima indikator da li je selektovana ili ne
    //isSelected ukazuje na to da li primenjujemo modifikaciju ili brisanje

    //deklaracija obelezja sadrzi modifikator pristupa (public), tip podatka (int), naziv promenljive(x,y..)
    private int x;
    private int y;
//    private boolean selected;

    //kreiranje konstruktora
    //imaju zadatak da izvrse kreiranje objekata i inicijalizaciju njegovih obelezja na odredjene vrendosti
    public  Point(){

    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, boolean selected){
        this(x, y); //da ne bi duplirali isti kod, skracena verzija
        this.selected = selected;
    }


    //primena enkapsulacije / skrivanja informacija
    //obelezja u klasi ce biti deklarisana kao privatna, dok ce metode koje treba da budu dostupne objektima drugih klasa biti javne

    // get metoda pristupa za citanje vredn. obelezja
    // getX vraca vrednost kordiante x onog objekta na koji ukazuje referenca
    public int getX() {
        return x;
    }

    // set metoda pristupa za postavljanje
    // public - metoda je dostupna objektima bilo koje druge klase
    // void - metoda ne vraca nikakvu vrednost
    public void setX(int x) {
        // this referencira objekat na koji je pozvana metoda
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //kreiranje metoda u klasi
    //metoda distance - putem pitagorine teoreme izracunava trazenu udaljenost
    //lokalne promenljive dx i dy predstavljaju razlike vrednosti x i y kodrdinata dve tacke
    //potom se d dodeljuje vrednost kvadratnog korena zbira kvadrata po kordinatama x i y koji izracunava stat. metoda sqrt klase Math

    public  double distance(int x2, int y2){
        int dx = this.x - x2;
        int dy = this.y - y2;
        double d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    //redefinisanje metode sa nazivom equals
    //metoda equals je definisana u klasi Object (postoji 9 metoda)
    //namena metode equals je da poredi dva objekta
    public boolean equals(Object obj){
        //instanceof provera tipa objekta
        //sa leve strane se navodi referenca na objekat a sa desne tip tj naziv klase
        //proveravamo da li je prosledjeni parametar tipa Point
        if(obj instanceof Point){
            //ako jeste izvrsava se promena tipa tzv. downcast
            Point p = (Point) obj;
            //ako su vrednosti kordinata parametara jednake vredn. koord. objekta za koji je pozvana metoda vrati true
            if (p.x == this.x && p.y == this.y){
                return true;
            }else {
                //ako se vrednosti koordinata razlikuju ili parametar nije tipa Point vrati false
                return false;
            }
        }else{
            return false;
        }
    }

    // redefinisanje metode toString
    //da bi se umesto nekih xy oznaka prikazivale konkretne vrednosti koordinata objekta na koji je pozvana metoda toString
    //vraca reprezentaciju stanaj objekata koja korisniku ukazuje ne vrednost koodrinata
    //inace bi nam bi nam ispisivlo (<x>,<y>) za stanje nekom objekta, ovako mi odredjujemo ispis i bio bi (x,y)
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    //crtanje tacke
    //dodajemo metodu koja iscrtava liniju duzine jednog piksela
    //graficki kontekst obezbedjuje metodu drawLine(int, int, int, int)
    //za x pocetno i x krajnje prosledice se ista vrednost, isto vazi i za y

    //NACIN KADA SE CRTA TACKA JEDNOG PIKSESA (1 kvadrat)
//    public void draw(Graphics g){
//        g.drawLine(this.x, this.y, this.x, this.y);
//        if(selected){
//            g.drawRect(this.x - 3, this.y - 3, 6, 6);
//        }
//    }

    //crtanje tacke u obliku krstica +
    public void draw(Graphics g){
        g.drawLine(this.x - 1, this.y, this.x + 1, this.y);
        g.drawLine(this.x, this.y -1, this.x, this.y + 1);
        if(selected){
            g.drawRect(this.x - 3, this.y - 3, 6, 6);
        }
    }

    //metoda za detekciju sadrzavanja mesta sa zadatim koordinatama
    //nakon klika na oblik treba da se prodje kroz sve oblike i nadje onaj koji sadrzi onaj gde je korisnik kliknuo
    //public boolean contains(int x, int y)

    //tesko moze korisnik pogoditi jedan piksel(tacku), pa metoda treba da dozvoli toleranciju tj da vrati true i kada korisnik klikne oko tacke
    //predpostavicemo da je tolerancija 5px
    public boolean contains(int x, int y){
//        Point clickPosition = new Point(x, y);
//        return this.distance(clickPosition) < 5;
        //drugi nacin, manje od 3px
        return this.distance(x, y) <= 3;
    }

    //metoda za pomeranje
    @Override
    public void moveBy(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

}
