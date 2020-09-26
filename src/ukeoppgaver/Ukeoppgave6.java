package ukeoppgaver;

public class Ukeoppgave6 {
    /*-------3.2.2-------*/
    /*Delopg2
    String[] s ={"Sohil",null,"Per","Thanh","Ann","Kari","Jon",null};
      Liste<String> list = new TabellListe<>(s);
      System.out.println(list.hent(4));
      System.out.println(list.indeksTil("Kari"));
      System.out.println(list.inneholder("Ann"));
     */

    /*Delopg3
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
     */

    /*-------3.2.5-------*/
    /*Delopg2
    String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

      Liste<String> liste = new TabellListe<>();

      for(String navn : s) liste.leggInn(navn);
      System.out.println("Henter " + liste.hent(2));
      System.out.println("Oppdaterer Ole til " + liste.oppdater(3,"Ola"));
      System.out.println(liste.fjern(4) + " er sletta");
      System.out.println(liste);
      liste.fjernHvis(x -> x.equals("Jens"));
      liste.forEach(x -> System.out.print(x + " "));
     */

}
