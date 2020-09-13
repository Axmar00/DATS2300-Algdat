package eksempelklasser;

public class Klokkeslett implements Comparable<Klokkeslett> {
    private int timer, min;

    public Klokkeslett(String klokkeslett) {
        if (klokkeslett.length() != 5 || klokkeslett.charAt(2) != ':')
            throw new IllegalArgumentException("Klokkeslett må ha formen tt:mm");

        timer = Integer.parseInt(klokkeslett.substring(0,2));

        if (timer < 0 || timer > 23)
            throw new IllegalArgumentException
                    ("Timetallet " + timer + " er ulovlig!");

        min = Integer.parseInt(klokkeslett.substring(3));

        if (min < 0 || min > 59)
            throw new IllegalArgumentException
                    ("Minutttallet " + min + " er ulovlig!");
    }

    @Override
    public int compareTo(Klokkeslett k)
    {
        if (timer < k.timer) return -1;
        else if (timer > k.timer) return 1;
        else return min - k.min;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Klokkeslett)) return false;
        Klokkeslett k = (Klokkeslett)o;
        return timer == k.timer && min == k.min;
    }

    public boolean equals(Klokkeslett k){
        return timer == k.timer && min == k.min;
    }

    @Override
    public int hashCode()  // generert av NetBeans
    {
        int hash = 7;
        hash = 29 * hash + this.timer;
        hash = 29 * hash + this.min;
        return hash;
    }

    @Override
    public String toString()                      // toString
    {
        StringBuilder s = new StringBuilder();
        if (timer < 10) s.append('0'); s.append(timer);
        s.append(':');
        if (min < 10) s.append('0'); s.append(min);
        return s.toString();
    }



}
