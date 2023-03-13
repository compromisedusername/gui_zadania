package gui_02;
public class Test {

    public static void main(String[] args) {

        Muzyk[] muzycy = {new Skrzypek("Aleks", 2),				// Imie, czas wystapienia (w godz.)
                new Wiolonczelista("Bartek", 1),
                new Flecista("Czarek", 0.5)};
        for (Muzyk m : muzycy)
            System.out.println("Muzyk: " + m.imie() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "Czas wystąpienia: " + m.czas() + " godz. " + '\n' +
                    "Stawka godzinowa: " + m.stawka() + '\n');

        System.out.println(Muzyk.maxHonorarium(muzycy));		// muzyk otrzymujący najwyższe honorarium za występ

    }
}


abstract class Muzyk {



    private final String imie;
    private final double czas;

    // konstruktor
    protected Muzyk(String imie, double czas) {
        this.czas  = czas;
        this.imie = imie;

    }

    // metoda getter
    protected String imie() {
        return this.imie;
    }

    // metoda getter
    protected double czas() {
        return this.czas;
    }

    // metody abstrakcyjne
    abstract protected String instrument();
    abstract protected int stawka();


    public String toString() {
        return "Muzyk o imieniu: " + imie() + ", jego stawka wynosi: " + stawka() + ", grajacy na " + instrument();
    }


    public static Muzyk maxHonorarium(Muzyk[] muzycy)
    {
        for(int i = 0 ; i < muzycy.length-1; i++){
            int max = 0;
            for(int j = i ; j < muzycy.length-1; j++){
                if(muzycy[j].stawka()>muzycy[j].stawka())
                {
                    max = j;
                }
            }
            Muzyk tymczasowyMuzyk = muzycy[i];
            muzycy[i] = muzycy[max];
            muzycy[max] = tymczasowyMuzyk;
        }
        return muzycy[0];
    }

}

// podklasa dziedzicząca po klasie abstrakcyjnej
class Flecista extends Muzyk {

    // konstruktor
    public Flecista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Flet";
    }

    @Override
    public int stawka() {
        return 300;
    }
}
class Skrzypek extends Muzyk {

    // konstruktor
    public Skrzypek(String imie, double czas) {
            super(imie, czas);

    }

    @Override
    public String instrument() {
        return "Skrzypcule";
    }

    @Override
    public int stawka() {
        return 999;
    }
}
class Wiolonczelista extends Muzyk {

    // konstruktor
    public Wiolonczelista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Wiolonczela";
    }

    @Override
    public int stawka() {
        return 1500;
    }
}
