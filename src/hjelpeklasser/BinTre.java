package hjelpeklasser;

public class BinTre<T>           // et generisk binærtre
  {
    private static final class Node<T>  // en indre nodeklasse
    {
      private T verdi;            // nodens verdi
      private Node<T> venstre;    // referanse til venstre barn/subtre
      private Node<T> høyre;      // referanse til høyre barn/subtre

      private Node(T verdi, Node<T> v, Node<T> h)    // konstruktør
      {
        this.verdi = verdi; venstre = v; høyre = h;
      }

      private Node(T verdi) { this.verdi = verdi; }  // konstruktør

    } // class Node<T>

    private Node<T> rot;      // referanse til rotnoden
    private int antall;       // antall noder i treet

    public BinTre() { rot = null; antall = 0; }          // konstruktør

    public BinTre(int[] posisjon, T[] verdi)  // konstruktør
    {
      if (posisjon.length > verdi.length) throw new
              IllegalArgumentException("Verditabellen har for få elementer!");

      for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i],verdi[i]);
    }

    public final void leggInn(int posisjon, T verdi) {
      if (posisjon < 1) throw new
              IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

      Node<T> p = rot, q = null;    // nodereferanser

      int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

      while (p != null && filter > 0)
      {
        q = p;
        p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
        filter >>= 1;  // bitforskyver filter
      }

      if (filter > 0) throw new
              IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
      else if (p != null) throw new
              IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

      p = new Node<>(verdi);          // ny node

      if (q == null) rot = p;         // tomt tre - ny rot
      else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
        q.venstre = p;                // venstre barn til q
      else
        q.høyre = p;                  // høyre barn til q

      antall++;                       // en ny verdi i treet
    }

    public int antall() { return antall; }               // returnerer antallet

    public boolean tom() { return antall == 0; }         // tomt tre?

    private Node<T> finnNode(int posisjon)  // finner noden med gitt posisjon
    {
      if (posisjon < 1) return null;

      Node<T> p = rot;   // nodereferanse
      int filter = Integer.highestOneBit(posisjon >> 1);   // filter = 100...00

      for (; p != null && filter > 0; filter >>= 1)
        p = (posisjon & filter) == 0 ? p.venstre : p.høyre;

      return p;   // p blir null hvis posisjon ikke er i treet
    }

    public boolean finnes(int posisjon)
    {
      return finnNode(posisjon) != null;
    }

    public T hent(int posisjon)
    {
      Node<T> p = finnNode(posisjon);

      if (p == null) throw new
              IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

      return p.verdi;
    }

    public T oppdater(int posisjon, T nyverdi)
    {
      Node<T> p = finnNode(posisjon);

      if (p == null) throw new
              IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

      T gammelverdi = p.verdi;
      p.verdi = nyverdi;

      return gammelverdi;
    }

    public static void main(String[] args) {
      int[] pos = {1,2,3,4,7,8,15,16,31,32,63,64,127,128,255};
      Integer[] verdier = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
      BinTre<Integer> tre = new BinTre<>(pos,verdier);

      BinTre<Integer> tre2 = new BinTre<>();
      int n = 2;
      for (int i = 1; i <= 7; i++) {
        tre2.leggInn(n,2*i);
        tre2.leggInn(2*n-1,2*i+1);
        n *= 2;
      }




    }

  } // class BinTre<T>