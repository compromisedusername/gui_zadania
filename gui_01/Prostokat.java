package gui_01;

public class Prostokat {

    private static int licznik = 0;

    private int szerokosc;
    private int wysokosc;

    public Prostokat(int szerokosc, int wysokosc){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        licznik++;
    }

    void rysuj() throws ProstokatException {
        System.out.println("Zwykly prostokat rozmiar " + getSzerokosc() + " x " + getWysokosc());
        if(szerokosc == 0 || wysokosc == 0){
            throw new ProstokatException();
        }
        System.out.println();
    }


    public int getWysokosc(){
        return this.wysokosc;
    }
    public int getSzerokosc(){
        return this.szerokosc;
    }
    public static int getIloscObiektow(){
        return licznik;
    }


}
