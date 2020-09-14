package notater.uke4generisk;

//07.09.2020 TernaryIf

public class TenaryIf {
    public static int myTernaryIfTest(int value){
    /*    if(value < 5){
            return 0;
        }
        else{
            return 98;
        }*/
        //Dette over^ kan skrives slik:
        return (value < 5) ? 0 : 98;
    }
}
