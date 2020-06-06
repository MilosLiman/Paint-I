package projekat;

//klasa LineString treba da omoguci rad sa nizovima linija ili polilinijama
public class LineString {

    private Line2[] segments = new Line2[10];
    private int lastIndex = -1;

    public LineString() {

    }

    //dodavanje novog segmenta u poliliniju
    public boolean addSegment(Line2 l) {
        //prvi uslov koji treba zadovoljiti da bi se uspesno dodalo
        //polinija ima manje od 10 segmenata (indeks od 0 do 9 = 10)
        if (this.lastIndex < 9) {
            //drugi uslov
            //segment koji se dodaje nastavlja se na trenutno poslednji segment polilinije
            if (lastIndex == -1) {
                segments[++lastIndex] = l;
                return true;
            } else {
                Line2 last = this.segments[lastIndex];
                if (last.getStartPoint().equals(l.getStartPoint()) ||
                        last.getStartPoint().equals(l.getEndPoint()) ||
                        last.getEndPoint().equals(l.getStartPoint()) ||
                        last.getEndPoint().equals(l.getEndPoint())) {
                    segments[++lastIndex] = l;
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    //uklanjanje poslednjeg segmenta polilinije
    public Line2 removeLastSegment() {
        if (lastIndex > -1) {
            Line2 lastSegment = segments[lastIndex--];
            return lastSegment;
        } else {
            return null;
        }
    }

    public Line2[] getSegments() {
        return this.segments;
    }

//    public double length() {
//        double l = 0;
//        for (int i = 0; i < this.segments.length; i++) {
//            if (this.segments[i] == null) {
//                break;
//                l = l + this.segments[i].length();
//            }
//            return l;
//        }
//    }
}