package com.unitedinternet.jam.konten;

/**
 * Created by agrunow on 29.09.16.
 */
public class Mitarbeiter {
    private String vorname;

    private String nachname;

    public Mitarbeiter(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mitarbeiter)) return false;

        Mitarbeiter that = (Mitarbeiter) o;

        if (vorname != null ? !vorname.equals(that.vorname) : that.vorname != null) return false;
        return nachname != null ? nachname.equals(that.nachname) : that.nachname == null;

    }

    @Override
    public int hashCode() {
        int result = vorname != null ? vorname.hashCode() : 0;
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        return result;
    }
}
