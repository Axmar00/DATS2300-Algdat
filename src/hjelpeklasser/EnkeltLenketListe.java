package hjelpeklasser;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EnkeltLenketListe<T> implements Liste<T>, Kø<T>
{
    private static final class Node<T>       // en indre nodeklasse
    {
        private T verdi;                       // nodens verdi
        private Node<T> neste;                 // den neste noden

        private Node(T verdi,Node<T> neste)    // konstruktør
        {
            this.verdi = verdi;
            this.neste = neste;
        }
    }  // Node

    private Node<T> hode, hale;  // pekere til første og siste node
    private int antall;          // antall verdier/noder i listen
    private int endringer;        // endringer i listen

    public EnkeltLenketListe()   // standardkonstruktør
    {
        hode = hale = null;        // hode og hale til null
        antall = 0;                // ingen verdier - listen er tom
        endringer = 0;             // ingen endringer når vi starter
    }

    public EnkeltLenketListe(T[] a){    //Konstruktør

        this();  // alle variabelene er nullet

        // Finner den første i a som ikke er null
        int i = 0; for (; i < a.length && a[i] == null; i++);

        if (i < a.length)
        {
            Node<T> p = hode = new Node<>(a[i], null);  // den første noden
            antall = 1;                                 // vi har minst en node

            for (i++; i < a.length; i++)
            {
                if (a[i] != null)
                {
                    p = p.neste = new Node<>(a[i], null);   // en ny node
                    antall++;
                }
            }
            hale = p;
        }
    }

    private Node<T> finnNode(int indeks)
    {
        Node<T> p = hode;
        for (int i = 0; i < indeks; i++) p = p.neste;
        return p;
    }

    @Override
    public boolean leggInn(T verdi)   // verdi legges bakerst
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        if (antall == 0)  hode = hale = new Node<>(verdi, null);  // tom liste
        else hale = hale.neste = new Node<>(verdi, null);         // legges bakerst

        endringer++;     //en endring har blitt gjort
        antall++;        // en mer i listen
        return true;     // vellykket innlegging
    }

    @Override
    public T kikk() {
        return null;
    }

    @Override
    public T taUt() {
        return null;
    }

    @Override
    public void leggInn(int indeks, T verdi)    // verdi til posisjon indeks
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, true);        // true: indeks = antall er lovlig

        if (indeks == 0)                     // ny verdi skal ligge først
        {
            hode = new Node<>(verdi, hode);    // legges først
            if (antall == 0) hale = hode;      // hode og hale peker på samme node
        }
        else if (indeks == antall)           // ny verdi skal ligge bakerst
        {
            hale = hale.neste = new Node<>(verdi, null);  // legges bakerst
        }
        else
        {
            Node<T> p = hode;                  // p flyttes indeks - 1 ganger
            for (int i = 1; i < indeks; i++) p = p.neste;

            p.neste = new Node<>(verdi, p.neste);  // verdi settes inn i listen
        }
        endringer++;     //en endring har blitt gjort
        antall++;                            // listen har fått en ny verdi
    }

    @Override
    public boolean inneholder(T verdi)
    {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi)
    {
        if (verdi == null) return -1;

        Node<T> p = hode;

        for(int i = 0; i < antall; i++){
            if(verdi.equals(p.verdi)) return i;
            p = p.neste;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T verdi)
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, false);  //false: indeks = antall er ulovlig

        Node<T> p = finnNode(indeks);
        T gammelVerdi = p.verdi;

        p.verdi = verdi;
        endringer++;     //en endring har blitt gjort
        return gammelVerdi;
    }

    @Override
    public T fjern(int indeks)
    {
        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig

        T temp;                              // hjelpevariabel

        if (indeks == 0)                     // skal første verdi fjernes?
        {
            temp = hode.verdi;                 // tar vare på verdien som skal fjernes
            hode = hode.neste;                 // hode flyttes til neste node
            if (antall == 1) hale = null;      // det var kun en verdi i listen
        }
        else
        {
            Node<T> p = finnNode(indeks - 1);  // p er noden foran den som skal fjernes
            Node<T> q = p.neste;               // q skal fjernes
            temp = q.verdi;                    // tar vare på verdien som skal fjernes

            if (q == hale) hale = p;           // q er siste node
            p.neste = q.neste;                 // "hopper over" q
        }
        endringer++;     //en endring har blitt gjort
        antall--;                            // reduserer antallet
        return temp;                         // returner fjernet verdi
    }

    @Override
    public boolean fjern(T verdi)
    {
        if(verdi == null) return false;

        Node<T> q = hode, p = null;
        if(inneholder(verdi)) {
            for(int i = 0; i < antall; i++){
                if(q.verdi.equals(verdi)) break; //fant verdien, går ut av løkka
                p = q; q = q.neste;
            }
            if(q == hode){      //første verdien skal fjernes
                hode = hode.neste;
            }
            else{
                p.neste = q.neste;   //hopper over q
            }

            if(q == hale) hale = p;

            q.verdi = null;     //nuller ut q
            q.neste = null;

            endringer++;     //en endring har blitt gjort
            antall--;                            // reduserer antallet
            return true;
        }
        return false;
    }

    @Override
    public int antall()
    {
        return antall;
    }

    @Override
    public boolean tom()
    {
        return antall == 0;
    }

    @Override
    public void nullstill()
    {
        Node<T> p = hode, q = null;

        while (p != null)
        {
            q = p.neste;
            p.neste = null;
            p.verdi = null;
            p = q;
        }

        hode = hale = null;

        endringer++;     //en endring har blitt gjort
        antall = 0;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        if(!tom()){
            Node<T> p = hode;
            s.append(p.verdi);
            p = p.neste;

            while(p != null){
                s.append(", ").append(p.verdi);
                p = p.neste;
            }
        }

        s.append("]");
        return s.toString();
    }

    public boolean fjernHvis(Predicate<? super T> predikat){
        Objects.requireNonNull(predikat, "null-predikat!");

        Node<T> p = hode, q = null;
        int antallFjernet = 0;

        while (p != null)
        {
            if (predikat.test(p.verdi))
            {
                antallFjernet++;
                endringer++;

                if (p == hode)
                {
                    if (p == hale) hale = null;
                    hode = hode.neste;
                }
                else if (p == hale) q.neste = null;
                else q.neste = p.neste;
            }
            q = p;
            p = p.neste;
        }

        antall -= antallFjernet;

        return antallFjernet > 0;
    }

    public void forEach(Consumer<? super T> handling)
    {
        Objects.requireNonNull(handling, "handling er null!");

        Node<T> p = hode;
        while (p != null)
        {
            handling.accept(p.verdi);
            p = p.neste;
        }
    }

    public void forEachRemaining(Consumer<? super T> handling)
    {
        Objects.requireNonNull(handling, "handling er null!");
       /* while (p != null)
        {
            handling.accept(p.verdi);
            p = p.neste;
        }*/
    }

    @Override
    public Iterator<T> iterator()
    {
        return new EnkeltLenketListeIterator();
    }

    private class EnkeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> p = hode;         // p starter på den første i listen
        private boolean fjernOK = false;  // blir sann når next() kalles
        private int iteratorendringer = endringer;  // startverdi

        @Override
        public boolean hasNext() {
            return p != null;  // p er ute av listen hvis den har blitt null
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            fjernOK = true;            // nå kan remove() kalles
            T denneVerdi = p.verdi;    // tar vare på verdien i p
            p = p.neste;               // flytter p til den neste noden

            return denneVerdi;         // returnerer verdien
        }

        public void remove()
        {
            if (!fjernOK) throw new IllegalStateException("Ulovlig tilstand!");

            fjernOK = false;               // remove() kan ikke kalles på nytt
            Node<T> q = hode;              // hjelpevariabel

            if (hode.neste == p)           // skal den første fjernes?
            {
                hode = hode.neste;           // den første fjernes
                if (p == null) hale = null;  // dette var den eneste noden
            }
            else
            {
                Node<T> r = hode;            // må finne forgjengeren
                // til forgjengeren til p
                while (r.neste.neste != p)
                {
                    r = r.neste;               // flytter r
                }

                q = r.neste;                 // det er q som skal fjernes
                r.neste = p;                 // "hopper" over q
                if (p == null) hale = r;     // q var den siste
            }

            q.verdi = null;                // nuller verdien i noden
            q.neste = null;                // nuller nestereferansen

            endringer++;             // en endring i listen
            iteratorendringer++;    // en endring av denne iteratoren
            antall--;                      // en node mindre i listen
        }

    } // class EnkeltLenketListeIterator

    public static void main(String[] args) {
        Liste<Integer> list = new EnkeltLenketListe<>();
        for (int i = 1; i <= 10; i++) list.leggInn(i);
        list.fjernHvis(x -> x % 2 != 0);
        list.forEach(x -> System.out.print(x+" "));
    }

}  // EnkeltLenketListe