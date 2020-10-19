package hjelpeklasser;

import java.util.Comparator;

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

  public int antall()        // antall verdier i treet
  {
    return antall;
  }

  public boolean tom()       // er treet tomt?
  {
    return antall == 0;
  }

  public void nullstill()
  {
    rot = null; antall = 0;
  }

  public static void main(String[] args) {
    SBinTre<String> tre1 = SBinTre.sbintre();          // 1. konstruksjonsmetode

    Comparator<String> c = Comparator.naturalOrder();
    SBinTre<String> tre2 = SBinTre.sbintre(c);         // 2. konstruksjonsmetode

    System.out.println(tre1.antall() + " " + tre2.antall());
  }
} // class SBinTre 