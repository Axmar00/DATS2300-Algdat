package eksempelklasser;

import java.util.Objects;

public class Dato implements Comparable<Dato>
{
    private final int dag, mnd, år;              // instansvariabler

    public Dato(int dag, int mnd, int år)        // konstruktør
    {
        this.dag = dag; this.mnd = mnd; this.år = år;
    }

    public Dato(int dag, Måned måned, int år)  // konstruktør
    {
        this.dag = dag;
        mnd = måned.mndnr();
        this.år = år;
    }

    public int compareTo(Dato d)                 // compareTo
    {
        if (år < d.år) return -1;
        else if (år > d.år) return 1;
        else if (mnd < d.mnd) return -1;
        else if (mnd > d.mnd) return 1;
        else return dag - d.dag;
    }

    @Override
    public boolean equals(Object o)              // equals
    {
        if (o == this) return true;
        if (!(o instanceof Dato)) return false;
        return compareTo((Dato)o) == 0;
    }

    public boolean equals(Dato d){
        return år == d.år && mnd == d.mnd && dag == d.dag;
    }

    @Override
    public String toString()                      // toString
    {
        StringBuilder s = new StringBuilder();
        s.append(dag).append('.').append(' ').
                append(Måned.toString(mnd)).append(' ').append(år);
        return s.toString();
    }


} // class Dato
