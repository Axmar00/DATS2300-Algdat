package hjelpeklasser;

import java.util.NoSuchElementException;

public class LenketKø<T> implements Kø<T>
{
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;        // nodens verdi
        private Node<T> neste;  // peker til neste node

        Node(Node<T> neste)     // nodekonstruktør
        {
            verdi = null; this.neste = neste;
        }
    }   // class Node

    private Node<T> fra, til;  // fra: først i køen, til: etter den siste
    private int antall;        // antall i køen

    private static final int START_STØRRELSE = 8;

    public LenketKø(int størrelse)  // konstruktør
    {
        til = fra = new Node<>(null);  // lager den første noden

        Node<T> p = fra;               // en hjelpevariabel
        for (int i = 1; i < størrelse; i++)
        {
            p = new Node<>(p);           // lager resten av nodene
        }
        fra.neste = p;                 // for å få en sirkel

        antall = 0;                    // ingen verdier foreløpig
    }

    public LenketKø()  // standardkonstruktør
    {
        this(START_STØRRELSE);
    }

    public int antall()
    {
        return antall;
    }

    public boolean tom()
    {
        return fra == til;  // eller antall == 0
    }

    @Override
    public void nullstill() {

    }

    public boolean leggInn(T verdi)   // null-verdier skal være tillatt
    {
        til.verdi = verdi;              // legger inn bakerst

        if (til.neste == fra)           // køen vil bli full - må utvides
        {
            til.neste = new Node<>(fra);  // ny node mellom til og fra
        }

        til = til.neste;                // flytter til
        antall++;                       // øker antallet

        return true;                    // vellykket innlegging
    }

    public T kikk()
    {
        if (tom()) throw new NoSuchElementException("Køen er tom!");
        return fra.verdi;           // returnerer verdien
    }

    public T taUt()
    {
        if (tom()) throw new NoSuchElementException("Køen er tom!");

        T tempverdi = fra.verdi;    // tar vare på verdien i fra
        fra.verdi = null;           // nuller innholdet i fra

        fra = fra.neste;            // flytter fra
        antall--;                   // reduserer antallet

        return tempverdi;           // returnerer verdien
    }

    @Override
    public String toString(){
        if(tom()) return "[]";

        StringBuilder s = new StringBuilder();
        Node<T> p = fra;
        s.append("[").append(p.verdi.toString());
        p = p.neste;

        while(p != til){
            s.append(", ").append(p.verdi.toString());
            p = p.neste;
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        LenketKø<String> kø = new LenketKø<>();
        kø.leggInn("A");
        kø.leggInn("B");
        kø.leggInn("C");
        System.out.println(kø);
    }

} // class LenketKø
