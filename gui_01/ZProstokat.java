package gui_01;

public class ZProstokat extends Prostokat {
    private static int licznikProstokat = 0;
    private static int licznikKwadrat = 0;
    private int licznikObiektu;
    private final char znakBrzeg;
    private final char znakWentrze;
    private boolean czyProstokat = true;
    private int iloscBrzegowych;
    private int iloscWewnetrznych;

    public ZProstokat(int wysokosc, int szerokosc, char znakBrzeg, char znakWentrze) {
        super(wysokosc, szerokosc);
        this.znakBrzeg = znakBrzeg;
        this.znakWentrze = znakWentrze;
        if(szerokosc == wysokosc){
            licznikObiektu = ++licznikKwadrat;
            czyProstokat = false;
        }else{
            licznikObiektu = ++licznikProstokat;
        }
        for(int i = 0 ; i < wysokosc; i++){
            for(int j = 0 ; j < szerokosc; j++){
                if(i == 0 || j == 0 || i == getWysokosc()-1 || j == getSzerokosc()-1 )
                    ++iloscBrzegowych;
                else
                    ++iloscWewnetrznych;
            }
        }

    }
    public ZProstokat(int bok, char znakBrzeg, char znakWentrze){
        this(bok, bok, znakBrzeg, znakWentrze);
    }
    @Override
    void rysuj() throws ProstokatException{
        System.out.println( "Zwykly "+(czyProstokat?"prostokat ":"kwadrat") +"("+getLicznikObiektu()+")"+" rozmiaru "  + getSzerokosc() + " x " + getWysokosc() + (", " + getZnakBrzeg() +" = " + getIloscBrzegowych()) + (!(getSzerokosc()<=1 || getWysokosc()<=1)?(", " + getZnakWentrze() + " = " + getIloscWewnetrznych()):" "));
        if(getZnakBrzeg() != getZnakWentrze() && (getWysokosc() == 1 || getSzerokosc() == 1)){
            throw new ProstokatException();
        }
        for(int i = 0 ; i < getWysokosc(); i++){
            for(int j = 0 ; j < getSzerokosc(); j++){
                if(i == 0 || j == 0 || i == getWysokosc()-1 || j == getSzerokosc()-1 ){
                    System.out.print(znakBrzeg);
                }
                else {
                    System.out.print(znakWentrze);
                }
            }
            System.out.println("");
        }
        System.out.println();
    }

    public int getLicznikObiektu(){
        return licznikObiektu;
    }

    public char getZnakBrzeg() {
        return znakBrzeg;
    }

    public char getZnakWentrze() {
        return znakWentrze;
    }

    public int getIloscBrzegowych() {
        return iloscBrzegowych;
    }

    public int getIloscWewnetrznych() {
        return iloscWewnetrznych;
    }
}

