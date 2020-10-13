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

}
