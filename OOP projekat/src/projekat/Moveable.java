package projekat;

public interface Moveable {

    //ove metode su po defaultu apstraktne i javne, tako da se ne mora navoditi public abstract
    //pomeri na
//    void moveOn(int x, int y);


    //pomeri za, dx i dy predstavljaju relativn pomeranje po jednoj ili drugoj osi
    void moveBy(int dx, int dy);
}
