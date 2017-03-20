package com.unitedinternet.jam.konten.observer;

/**
 * Created by agrunow on 20.03.17.
 */
public class TuerEvent {

    private Tuer tuer;

    private Person person;

    private Tuer.Richtung richtung;

    public TuerEvent(Tuer tuer, Person person, Tuer.Richtung richtung) {
        this.tuer = tuer;
        this.person = person;
        this.richtung = richtung;
    }

    public Tuer getTuer() {
        return tuer;
    }

    public Person getPerson() {
        return person;
    }

    public Tuer.Richtung getRichtung() {
        return richtung;
    }
}
