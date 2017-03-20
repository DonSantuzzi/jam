package com.unitedinternet.jam.konten.observer;

/**
 * Created by agrunow on 20.03.17.
 */
public class Raum implements TuerListener {

    private Tuer tuerLinks;

    private Tuer tuerRechts;

    private int anzahlPersonen;

    public Raum(Tuer tuerLinks, Tuer tuerRechts) {
        this.tuerLinks = tuerLinks;
        this.tuerRechts = tuerRechts;
    }

    public Tuer getTuerLinks() {
        return tuerLinks;
    }

    public Tuer getTuerRechts() {
        return tuerRechts;
    }

    @Override
    public void update(TuerEvent tuerEvent) {
        System.out.println("Tür betätigt: \n\t"
                + "Tür: " + tuerEvent.getTuer() + "\n\t"
                + "Person: " + tuerEvent.getPerson().getName() + "\n\t"
                + "Richtung: " + tuerEvent.getRichtung());

        switch (tuerEvent.getRichtung()) {
            case REIN: ++anzahlPersonen; break;
            case RAUS: --anzahlPersonen; break;
        }

        System.out.println("Aktuelle Anzahl Personen: " + anzahlPersonen);
    }
}
