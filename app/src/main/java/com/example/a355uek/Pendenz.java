package com.example.a355uek;

import java.text.DateFormat;

public class Pendenz {
    private int id;
    private String titel;
    private String beschreibung;
    private String dringlichkeit;
  //  private DateFormat datum;

    public Pendenz(int id, String titel, String beschreibung, String dringlichkeit /*DateFormat datum*/) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.dringlichkeit = dringlichkeit;
        //this.datum = datum;
    }

    public Pendenz(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getDringlichkeit() {
        return dringlichkeit;
    }

    public void setDringlichkeit(String dringlichkeit) {
        this.dringlichkeit = dringlichkeit;
    }

   /* public DateFormat getDatum() {
        return datum;
    }

    public void setDatum(DateFormat datum) {
        this.datum = datum;
    }*/

    @Override
    public String toString() {
        return "Pendenz{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", dringlichkeit='" + dringlichkeit + '\'' +
                ", datum=" +// datum +
                '}';
    }
}
