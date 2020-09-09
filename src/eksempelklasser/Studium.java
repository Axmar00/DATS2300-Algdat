package eksempelklasser;

import hjelpeklasser.Tabell;

public enum Studium
{
    Data ("Ingeniørfag - data"),         // enumkonstanten Data
    IT ("Informasjonsteknologi"),        // enumkonstanten IT
    Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
    Elektro("Ingeniørfag - elektronikk og informasjonsteknologi"), // enumkonstanten Elektro
    Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne

    private final String fulltnavn;      // instansvariabel
    private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

    @Override
    public String toString() { return fulltnavn; }

}
