package mappeeksamen;

import hjelpeklasser.Oppgave;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;

public class EksamenSBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        //Kopiert fra koden i kompendiet 5.2.3

        if (verdi == null) throw new NullPointerException("Ulovlig nullverdi!");

        Node<T> p = rot, q = null;               // p starter i roten, q vil tilslutt bli forelder
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi,q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi) {
        //Kopiert fra kompendiet 5.2.8

        if (verdi == null) return false;  // treet har ingen nullverdier

        Node<T> p = rot, q = null;   // q skal være forelder til p

        while (p != null)            // leter etter verdi
        {
            int cmp = comp.compare(verdi,p.verdi);      // sammenligner
            if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
            else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
            else break;    // den søkte verdien ligger i p
        }
        if (p == null) return false;   // finner ikke verdi

        if (p.venstre == null || p.høyre == null)  // Tilfelle 1) og 2)
        {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn
            if (p == rot) {
                rot = b;
                if(rot != null) b.forelder = null;
            }

            else if (p == q.venstre){     //Hvis venstrebarnet skal fjernes
                q.venstre = b;
                if(b != null){            //Oppdaterer foreldrepeker, hvis barn != null
                    b.forelder = q;
                }
            }
            else{                         //Hvis høyrebarnet skal fjernes
                q.høyre = b;
                if(b != null){            //Oppdaterer foreldrepeker, hvis barn != null
                    b.forelder = q;
                }
            }
        }
        else  // Tilfelle 3)
        {
            Node<T> s = p, r = p.høyre;   // finner neste i inorden
            while (r.venstre != null)
            {
                s = r;    // s er forelder til r
                r = r.venstre;
            }

            p.verdi = r.verdi;   // kopierer verdien i r til p

            if (s != p){
                s.venstre = r.høyre;
                if(r.høyre != null) {
                    s.venstre.forelder = s;    //Oppdaterer forelderpeker
                }
            }
            else{
                s.høyre = r.høyre;
                if(r.høyre != null) {
                    s.høyre.forelder = s;      //Oppdaterer forelderpeker
                }
            }
        }

        antall--;   // det er nå én node mindre i treet
        return true;
    }

    public int fjernAlle(T verdi) {
        int antallFjernet = 0;   //Teller for antall verdier som fjernes

        while(fjern(verdi)){//Fjerner alle forekomster av T verdi
            antallFjernet++;  //Øker antallet som fjernes
        }
        return antallFjernet;   //Returnerer antallet som fjernes
    }

    public int antall(T verdi) {
        int antall = 0;
        Node<T> p = rot;
        while(p != null){
            int komp = comp.compare(verdi,p.verdi);

            if(komp > 0) p = p.høyre;

            else if(komp < 0) p = p.venstre;

            else{ antall+=1; p = p.høyre;}
        }
        return antall;
    }

    public void nullstill() {
        if(tom()) return;
        nullstill(rot);
        rot = null;
        antall = 0;

        /*if(!tom()){
            int antall = antall();
            Node<T> p = førstePostorden(rot);

            T fjernVerdi = p.verdi;

            for(int i = 0; i < antall; i++){
                fjernVerdi = p.verdi;
                p = nestePostorden(p);
                fjern(fjernVerdi);
            }
        }*/
    }

    private void nullstill(Node<T> p){
        if(p.venstre != null){
            nullstill(p.venstre);
            p.venstre = null;
        }
        if(p.høyre != null){
            nullstill(p.høyre);
            p.høyre = null;
        }
        p.verdi = null;
        p.forelder = null;
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        while(true){
            if(p.venstre != null) p = p.venstre;
            else if(p.høyre != null) p = p.høyre;
            else return p;
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        Node<T> curr = p.forelder;
        while(curr != null){
            if(curr.venstre == p){
                if(curr.høyre == null){
                    return curr;
                }
                else{
                    return førstePostorden(curr.høyre);
                }
            }
            else if(curr.høyre == p){
                return curr;
            }
        }
        return null;
    }

    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> p = førstePostorden(rot);
        while(p != null){
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if(p.venstre != null) postordenRecursive(p.venstre,oppgave);
        if(p.høyre != null) postordenRecursive(p.høyre,oppgave);
        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        ArrayList<T> list = new ArrayList<>();
        ArrayList<Node <T>> hjelpelist = new ArrayList<>();     //Hjelpe arraylist, behandles som en kø
        hjelpelist.add(rot);

        while(!hjelpelist.isEmpty()){
            Node<T> p = hjelpelist.remove(0);
            list.add(p.verdi);

            if(p.venstre != null) hjelpelist.add(p.venstre);
            if(p.høyre != null) hjelpelist.add(p.høyre);
        }
        return list;
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        EksamenSBinTre<K> tre = new EksamenSBinTre<>(c);

        for(K verdi : data){
            tre.leggInn(verdi);
        }
        return tre;
    }

} // ObligSBinTre
