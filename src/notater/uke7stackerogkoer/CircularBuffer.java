package notater.uke7stackerogkoer;

public class CircularBuffer {
    char[] buffer;
    int head;         //peker til starten av køen
    int tail;        //peker til slutten av køen
    int size;
    int count;       //Antall elementer som er i køen nå

    CircularBuffer(int size) {
        this.buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    void pushBack(char value){
        if(count + 1 > size) throw new IndexOutOfBoundsException();
        this.buffer[tail] = value;
        tail = (tail+1) % size;
        count++;
    }

    char popFront(){
        if(count <= 0) throw new IndexOutOfBoundsException();
        char retval = buffer[head];
        System.out.print(head);
        head = (head+1) % size;
        count--;
        return retval;
    }

    int count(){
        return count;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(6);

        char[] values = "ABCDEFGHIJKLMNO".toCharArray();

        for(int i = 0; i < values.length; ) {
            //Legg inn tre bokstaver i bufferet
            for (int j = 0; j < 6; j++) {
                if (values.length > i + j) {
                    buffer.pushBack(values[i+j]);
                }
            }

            //Ta ut alt fra bufferet
            while(buffer.count() > 0){
                System.out.print(buffer.popFront());
            }
            System.out.println();
            i = i + 6;
        }
    }

   /* public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer();

        char[] chars = "AVCSKDKEJDOSDLWPKDIOP".toCharArray();

        for(int i = 0; i < chars.length; i++){
            for(int j = 0; j < 5; j++){
                buffer.pushBack(chars[i]);
            }

            for(int j = 0; j < 5; j++){
                System.out.print(buffer.popFront());
            }
            System.out.println();
        }
    }

    CircularBuffer(){
        size = 14;
        values = new char[size];
    }

    void pushBack(char value){
        values[back] = value;
        back =(back + 1) % size;

    }

    char popFront(){
        char retval = values[front];
        front = (front + 1) % size;
        return retval;
    }*/

}
