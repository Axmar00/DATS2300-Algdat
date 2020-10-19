package hjelpeklasser;

import java.util.Comparator;
import java.util.stream.Stream;

public class SBinTre<T> // implements Beholder<T>
{
  private static final class Node<T> // en indre nodeklasse
  {
    private T verdi;                 // nodens verdi
    private Node<T> venstre, høyre;  // venstre og høyre barn

    private Node(T verdi, Node<T> v, Node<T> h)  // konstruktør
    {
      this.verdi = verdi; venstre = v; høyre = h;
    }

    private Node(T verdi)  // konstruktør
    {
      this(verdi, null, null);
    }
  } // class Node

  private Node<T> rot;                       // peker til rotnoden
  private int antall;                        // antall noder
  private final Comparator<? super T> comp;  // komparator

  public SBinTre(Comparator<? super T> c)    // konstruktør
  {
    rot = null; antall = 0; comp = c;
  }

  public static <T extends Comparable<? super T>> SBinTre<T> sbintre()
  {
    return new SBinTre<>(Comparator.naturalOrder());
  }

  public static <T> SBinTre<T> sbintre(Comparator<? super T> c)
  {
    return new SBinTre<>(c);
  }

  public static <T> SBinTre<T> komparatorTre(T[] a, Comparator<? super T> c)
  {
    SBinTre<T> tre = new SBinTre<>(c);          // komparatoren c
    for (T verdi : a) tre.leggInn(verdi);       // bygger opp treet
    return tre;                                 // treet returneres
  }

  public static <T extends Comparable<? super T>> SBinTre<T> naturligOrdenTre(T[] a)
  {
    return komparatorTre(a, Comparator.naturalOrder());  // naturlig ordning
  }

  public int antall()        // antall verdier i treet
  {
    return antall;
  }

  public boolean tom()       // er treet tomt?
  {
    return antall == 0;
  }

  public boolean leggInn(T verdi)    // skal ligge i class SBinTre
  {
    if (verdi == null) throw new NullPointerException("Ulovlig nullverdi!");

    Node<T> p = rot, q = null;               // p starter i roten
    int cmp = 0;                             // hjelpevariabel

    while (p != null)       // fortsetter til p er ute av treet
    {
      q = p;                                 // q er forelder til p
      cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
      p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
    }

    // p er nå null, dvs. ute av treet, q er den siste vi passerte

    p = new Node<>(verdi);                   // oppretter en ny node

    if (q == null) rot = p;                  // p blir rotnode
    else if (cmp < 0) q.venstre = p;         // venstre barn til q
    else q.høyre = p;                        // høyre barn til q

    antall++;                                // én verdi mer i treet
    return true;                             // vellykket innlegging
  }

  private static int høyde(Node<?> p)  // ? betyr vilkårlig type
  {
    if (p == null) return -1;          // et tomt tre har høyde -1

    return 1 + Math.max(høyde(p.venstre), høyde(p.høyre));
  }

  public int høyde()
  {
    return høyde(rot);                 // kaller hjelpemetoden
  }

  public void nullstill()
  {
    rot = null; antall = 0;
  }

  public String toString()                   // hører til SBinTre
  {
    StringBuilder s = new StringBuilder();   // StringBuilder
    s.append('[');                           // starter med [
    if (!tom()) toString(rot,s);             // den rekursive metoden
    s.append(']');                           // avslutter med ]
    return s.toString();                     // returnerer
  }

  private static <T> void toString(Node<T> p, StringBuilder s)
  {
    if (p.venstre != null)                   // p har et venstre subtre
    {
      toString(p.venstre, s);                // komma og mellomrom etter
      s.append(',').append(' ');             // den siste i det venstre
    }                                        // subtreet til p

    s.append(p.verdi);                       // verdien i p

    if (p.høyre != null)                     // p har et høyre subtre
    {
      s.append(',').append(' ');             // komma og mellomrom etter
      toString(p.høyre, s);                  // p siden p ikke er den
    }                                        // siste noden i inorden
  }

  public static <T> SBinTre<T> sbintre(Stream<T> s, Comparator<? super T> c)
  {
    SBinTre<T> tre = new SBinTre<>(c);             // komparatoren c
    s.forEach(tre::leggInn);                       // bygger opp treet
    return tre;                                    // treet returneres
  }

  public static <T extends Comparable<? super T>> SBinTre<T> sbintre(Stream<T> s)
  {
    return sbintre(s, Comparator.naturalOrder());  // naturlig ordning
  }

  public static void main(String[] args) {
    String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
    SBinTre tre2 = SBinTre.sbintre(Stream.of(s));
    System.out.println(tre2);
    
  }
} // class SBinTre 