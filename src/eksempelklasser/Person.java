package eksempelklasser;

import hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Person implements Comparable<Person>
{
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {   /*
        Objects.requireNonNull(fornavn, "fornavn er null");
        Objects.requireNonNull(etternavn, "etternavn er null");
        Annen måte enn den under.
         */
        if(fornavn == null){
            throw new NullPointerException("Fornavn er null");
        }
        if(etternavn == null){
            throw new NullPointerException("Etternavn er null");
        }
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }

    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true;
        if(o == null) return false;
        //if (!(o instanceof Person)) return false;
        if (getClass() != o.getClass()) return false;  // er det rett klasse?
        //return compareTo((Person)o) == 0;
        final Person p = (Person)o;           // typekonvertering
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public boolean equals(Person p)         // Person som parametertype
    {
        if (p == this) return true;           // er det samme objekt?
        if (p == null) return false;          // null-argument
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public int hashCode() { return Objects.hash(etternavn, fornavn); }

    public String toString() {
        //return fornavn + " " + etternavn;
        return String.join(" ",fornavn,etternavn);
        }

    public static void main(String[] args){
        Person[] p = new Person[7];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");
        p[1] = new Person("Boris","Zukanovic");
        p[2] = new Person("Ali","Kahn");
        p[3] = new Person("Azra","Zukanovic");
        p[4] = new Person("Kari","Pettersen");
        p[5] = new Person("Kris","Ludvigsen");
        p[6] = new Person("Jens","Follo");

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Arrays.sort(p);               // generisk sortering
        System.out.println(Arrays.toString(p));

        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);
        //Over kan skrives slik:
        //Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }


}