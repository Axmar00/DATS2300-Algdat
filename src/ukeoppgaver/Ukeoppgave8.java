package ukeoppgaver;

public class Ukeoppgave8 {
    /*-------5.1.1-------*/
    /*Delopg1

    a)Treet har 6 nivåer.
    b)Noder på nivå 2: L O B
    c)Noder på nivå 3: A E N G
    d)Nivå 3 kan innholde 4 flere noder (dvs totalt 8 tilsammen)
    e)Nivå 4 kan inneholde 13 noder til(totalt 16 tilsammen).
    f)Etterkommere til A-noden: K F C
    g)Forgjengere til A-noden: L I D
    h)Noder som er besteforeldre: D H O I L A
    i)Enebarn: L K
    j)Treets høyde er 5.
    k)Dyben til D-noden: 0
    l)Høyden til I-nodens subtre: Venstresubtre: -1 og høyresubtre: 3
    m)7 bladnoder
    n)8 indre noder
    o)
     */

    /*Delopg2
    a)Treet har 5 nivåer.
    b)Noder på nivå 2: G A H K
    c)Noder på nivå 3: L O D N
    d)Nivå 3 kan innholde 4 noder til.
    e)Nivå 4 kan inneholde 12 noder til.
    f)Etterkommere til A-noden: L O M C
    g)Forgjengere til A-noden: I E
    h)Noder som er besteforeldre: E I B A K
    i)Enebarn: D N
    j)Treets høyde er 4.
    k)Dybden til D-noden: 3.
    l)I-nodens venstresubtre: 0 og høyresubtre: 2
    m)7 bladnoder
    n)8 indre noder
     */

    /*Delopg3
    a)Nodene med minst ett søskenbarn: L O B. En node kan ha maks 2 søskenbarn.
    b)Nodenne med minst en tremening:A E N G. En node kan ha maks 4 tremeninger.
     */

    /*-------5.1.5------*/
    /*Delopg2
      int[] pos = {1,2,3,5,6,7,10,11,12,13,21,24,25,42,43};
      char[] c = "DIHLOBAENGKMJFC".toCharArray();
      BinTre<Character> tre1 = new BinTre<Character>();
      for(int i = 0; i < pos.length; i++)tre1.leggInn(pos[i],c[i]);

      int[] pos2 = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};
      char[] c2 ="EIBGAHKLODNMCJF".toCharArray();
      BinTre<Character> tre2 = new BinTre<Character>();
      for(int i = 0; i < pos2.length; i++) tre2.leggInn(pos2[i],c2[i]);
     */

    /*Delopg4
      int[] pos = {1,2,3,5,10,11,22,23,44,47};
      Integer[] tall = {4,8,2,5,3,6,10,1,7,9};
      BinTre<Integer> tre = new BinTre<Integer>(pos,tall);
     */

    /*Delopg5
      BinTre<Integer> tre = new BinTre<>();
      for (int i = 1; i <= 15; i++) tre.leggInn(i,i);
     */

    /*Delopg6
    int[] pos = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384};
      Integer[] verdier = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
      BinTre<Integer> tre = new BinTre<>(pos,verdier);

      BinTre<Integer> tre2 = new BinTre<>();
      int n = 1;
      for (int i = 1; i <= 15; i++) {
        tre2.leggInn(n, i);
        n *= 2;
      }
     */

    /*Delopg7
    int[] pos = {1,2,3,4,7,8,15,16,31,32,63,64,127,128,255};
      Integer[] verdier = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
      BinTre<Integer> tre = new BinTre<>(pos,verdier);

      BinTre<Integer> tre2 = new BinTre<>();
      int n = 2;
      for (int i = 1; i <= 7; i++) {
        tre2.leggInn(n,2*i);
        tre2.leggInn(2*n-1,2*i+1);
        n *= 2;
     */

    /*-------5.1.6-------*/
    /*Delopg1
    Tre1:D IH LOB AENG KMJ FC
    Tre2: E IB GAHK LODN MCJF
     */

    /*Delopg4
     BinTre<Character> tre = new BinTre<>();
      int[] posisjon = {1, 2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
      String verdi = "EIBGAHKLODNMCJF";              // verdier i nivåorden

      for(int i = 0; i < posisjon.length;i++) tre.leggInn(posisjon[i],verdi.charAt(i));

      StringJoiner sj = new StringJoiner(", ","[","]");

      tre.nivåorden(c -> sj.add(c.toString()));

      System.out.println(sj);
     */

    /*Delopg5
    BinTre<Character> tre = new BinTre<>();
      int[] posisjon = {1, 2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
      String verdi = "EIBGAHKLODNMCJF";              // verdier i nivåorden

      for(int i = 0; i < posisjon.length;i++) tre.leggInn(posisjon[i],verdi.charAt(i));

      StringJoiner sj = new StringJoiner(", ","[","]");


      tre.nivåorden(c ->{
        if(c.compareTo('D') > 0){     //Kan også bruke c > 'D'
          sj.add(c.toString());
        }
      });

      System.out.println(sj);
     */

    /*Delopg8
    int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
      String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

      BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør
      String[] a = {"a"};
      tre.nivåorden(c1 -> {
                if(c1.compareTo(a[0]) > 0) a[0] = c1;
              }
              );
      System.out.println(a[0]);
     */

    /*Delopg10
    int[] p = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,17,18,19,21,23,26,27,29};
      Character[] c = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'};
      BinTre<Character> tre = new BinTre<>(p,c);

      int[] nivåer = tre.nivåer();
      System.out.println("Nivåer: " + Arrays.toString(nivåer));
      System.out.println("Treets bredde: " + nivåer[Tabell.maks(nivåer)]);
      System.out.println("Treets høyde: " + (nivåer.length - 1));
     */

    /*-------5.1.7-------*/
    /*Delopg1
    Tre1:
        *Pre:  D I L A K F C E H O N M J G B
        *In:   I A F K C L E D M N J O G H B
        *Post: F C K A E L I M J N G O B H D

    Tre2:
        *Pre:  E I G A L O M C B H D K N J F
        *In:   G I L A M O C E H D B J N F K
        *Post: G L M C O A I D H J F N K B E
     */

    /*Delopg2
    Tre1:
        *Pre:  O G K I D P M F R A B E N C Q H L J
        *In:
        *Post:

    Tre2:
        *Pre:
        *In:
        *Post:
     */

    /*Delopg5
    int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
      String[] verdi = "ABICDJLEFKMGHNO".split("");              // verdier i nivåorden
      BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

      StringJoiner s = new StringJoiner(", " ,"[", "]");         // StringJoiner
      tre.preorden(tegn -> s.add(tegn));                         // tegn = String
      System.out.println(s);
     */

    /*Delopg6
    int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
      String[] verdi = "HBKADIOCFJMEGLN".split("");              // verdier i nivåorden
      BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

      StringJoiner s = new StringJoiner(", " ,"[", "]");         // StringJoiner
      tre.inorden(tegn -> s.add(tegn));                         // tegn = String
      System.out.println(s);
     */

    /*-------5.1.10-------*/
    /*Delopg1
    while (true)
    {
      oppgave.utførOppgave(p.verdi);
      if (p.venstre != null) preorden(p.venstre,oppgave);
      if (p.høyre == null) return;      // metodekallet er ferdig
      p = p.høyre;
    }
     */

    /*Delopg4
    while (true)
    {
      if (p.venstre != null) inorden(p.venstre,oppgave);
      oppgave.utførOppgave(p.verdi);
      if (p.høyre == null) return;      // metodekallet er ferdig
      p = p.høyre;
    }
     */

    /*-------5.1.11-------*/
    /*Delopg5
      Min måte:
      int[] posisjon = {1,2,3,4,5,6,7,8,9,10};             // posisjoner og
      String[] verdi = "ABCDEFGHIJ".split("");             // verdier i nivåorden

      BinTre<String> tre = new BinTre<>(posisjon, verdi);  // konstruktør

      System.out.println();
      for(String s : tre){
        if(s.equals("F")) {
          System.out.println("Stopper.");
          return;
        }
        System.out.print(s + " ");
      }

      Fasiten:
      char c = 'F';

  for (Iterator<Character> i = tre.iterator(); i.hasNext(); )
  {
    if (i.next() == c)
    {
      System.out.println("Fant " + c + "!" );
      break;
    }
  }
     */





}
