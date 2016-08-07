package com.unitedinternet.jam.konten.konto;

import com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException;

public abstract class Konto implements Comparable<Konto> {

    private final String kontonummer;

    protected float saldo;

    public Konto(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public abstract float getSaldo();

    public abstract void einzahlen(float betrag);

    public abstract void auszahlen(float betrag) throws KontoNichtGedecktException;

    public String getKontonummer() {
        return kontonummer;
    }

    @Override
    public String toString() {
        return "Ktnr: " + getKontonummer() + " Saldo: " + saldo;
    }

    @Override
    public int compareTo(Konto o) {
        return getKontonummer().compareTo(o.getKontonummer());
    }
}
