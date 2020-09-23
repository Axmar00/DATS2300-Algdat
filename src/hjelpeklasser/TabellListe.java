package hjelpeklasser;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TabellListe<T> implements Liste<T>
  {
    private T[] a;
    private int antall;
    private int endringer;

    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse)       // konstruktør
    {
      a = (T[])new Object[størrelse];       // oppretter tabellen
      antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe()                    // standardkonstruktør
    {
      this(10);                             // startstørrelse på 10
    }

    /*public TabellListe(T[] b)                    // en T-tabell som parameter
    {
      this(b.length);                            // kaller den andre konstruktøren

      for (T verdi : b)
      {
        if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
      }
    }*/
    public TabellListe(T[] a)               // en T-tabell som parameter
    {
      this.a = a.clone();                   // kloner parametertabellen
      antall = a.length;                    // alle i tabellen
    }

    public int antall()
    {
      return antall;          // returnerer antallet
    }

    public boolean tom()
    {
      return antall == 0;     // listen er tom hvis antall er 0
    }

    @Override
    public void nullstill() {
      if(a.length > 10){
        a = (T[])new Object[10];
      }
      else{
        for(int i = 0; i < antall; i++){
          a[i] = null;
        }
        antall = 0;
      }
      endringer++;
    }

    public T hent(int indeks)
    {
      indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
      return a[indeks];                // returnerer er tabellelement
    }

    public int indeksTil(T verdi)
    {
      for (int i = 0; i < antall; i++)
      {
        if (a[i].equals(verdi)) return i;   // funnet!
      }
      return -1;   // ikke funnet!
    }

    @Override
    public T oppdater(int indeks, T verdi) {
      Objects.requireNonNull(verdi, "null er ulovlig!");

      indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig

      T gammelverdi = a[indeks];      // tar vare på den gamle verdien
      a[indeks] = verdi;              // oppdaterer
      endringer++;
      return gammelverdi;
    }

    @Override
    public boolean fjern(T verdi) {
      Objects.requireNonNull(verdi, "null er ulovlig!");

      for(int i = 0; i < antall; i++){
        if(a[i].equals(verdi)){
          antall--;
          System.arraycopy(a,i+1,a,i,antall-i);
          a[antall] = null;
          endringer++;
          return true;
        }
      }
      return false;
    }

    @Override
    public T fjern(int indeks) {
      indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig
      T verdi = a[indeks];

      antall--; // sletter ved å flytte verdier mot venstre
      System.arraycopy(a, indeks + 1, a, indeks, antall - indeks);
      a[antall] = null;   // tilrettelegger for "søppeltømming"

      endringer++;
      return verdi;
    }

    @Override
    public boolean leggInn(T verdi) {
      Objects.requireNonNull(verdi, "null er ulovlig!");

      // En full tabell utvides med 50%
      if (antall == a.length)
      {
        a = Arrays.copyOf(a,(3*antall)/2 + 1);
      }

      a[antall++] = verdi;   // setter inn ny verdi

      endringer++;
      return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
      Objects.requireNonNull(verdi, "null er ulovlig!");

      indeksKontroll(indeks, true);  // true: indeks = antall er lovlig

      // En full tabell utvides med 50%
      if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);

      // rydder plass til den nye verdien
      System.arraycopy(a, indeks, a, indeks + 1, antall - indeks);

      a[indeks] = verdi;     // setter inn ny verdi

      antall++;
      endringer++;
    }

    public boolean inneholder(T verdi)
    {
      return indeksTil(verdi) != -1;
    }

    @Override
    public String toString(){
      if(antall == 0) return "[]";

      StringBuilder s = new StringBuilder();
      s.append("[").append(a[0]);

      for(int i = 1; i < antall; i++){
        s.append(",").append(" ").append(a[i]);
      }
      s.append("]");
      return s.toString();
    }

    public void forEach(Consumer<? super T> action){
      for(int i = 0; i < antall; i++){
        action.accept(a[i]);
      }
    }

    public boolean fjernHvis(Predicate<? super T> p)  // betingelsesfjerning
    {
      Objects.requireNonNull(p);                       // kaster unntak

      int nyttAntall = antall;

      for (int i = 0, j = 0; j < antall; j++)
      {
        if (p.test(a[j])) nyttAntall--;   // a[j] skal fjernes
        else a[i++] = a[j];               // forskyver
      }

      for (int i = nyttAntall; i < antall; i++)
      {
        a[i] = null;   // tilrettelegger for "søppeltømming"
      }

      boolean fjernet = nyttAntall < antall;

      if(fjernet) endringer++;

      antall = nyttAntall;
      return fjernet;
    }


  @Override
    public Iterator<T> iterator() {
      return new TabellListeIterator();
    }

    //Indre klasse i class TabellListe
    private class TabellListeIterator implements Iterator<T>
    {
      private int denne = 0;       // instansvariabel
      private int iteratorendringer = endringer;

      public boolean hasNext()     // sjekker om det er flere igjen
      {
        return denne < antall;     // sjekker verdien til denne
      }

      private boolean fjernOK = false;   // ny instansvariabel i TabellListeIterator

      public T next()                    // ny versjon
      {
        if (iteratorendringer != endringer)
        {
          throw new ConcurrentModificationException("Listen er endret!");
        }

        if (!hasNext())
          throw new NoSuchElementException("Tomt eller ingen verdier igjen!");

        T denneVerdi = a[denne];   // henter aktuell verdi
        denne++;                   // flytter indeksen
        fjernOK = true;            // nå kan remove() kalles

        return denneVerdi;         // returnerer verdien
      }

      public void remove()         // ny versjon
      {
        if (iteratorendringer != endringer) throw new
                ConcurrentModificationException("Listen er endret!");

        if (!fjernOK) throw
                new IllegalStateException("Ulovlig tilstand!");

        fjernOK = false;           // remove() kan ikke kalles på nytt

        // verdien i denne - 1 skal fjernes da den ble returnert i siste kall
        // på next(), verdiene fra og med denne flyttes derfor en mot venstre
        antall--;           // en verdi vil bli fjernet
        denne--;            // denne må flyttes til venstre

        System.arraycopy(a, denne + 1, a, denne, antall - denne);  // tetter igjen
        a[antall] = null;   // verdien som lå lengst til høyre nulles

        endringer++;
        iteratorendringer++;
      }

      public void forEachRemaining(Consumer<? super T> action){
        while (denne < antall)
        {
          action.accept(a[denne++]);
        }
      }

    }  // TabellListeIterator

    public static void main(String[] args) {
      String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

      Liste<String> liste = new TabellListe<>();

      for(String navn : s) liste.leggInn(navn);
      System.out.println("Henter " + liste.hent(2));
      System.out.println("Oppdaterer Ole til " + liste.oppdater(3,"Ola"));
      System.out.println(liste.fjern(4) + " er sletta");
      System.out.println(liste);
      liste.fjernHvis(x -> x.equals("Jens"));
      liste.forEach(x -> System.out.print(x + " "));


    }

  }