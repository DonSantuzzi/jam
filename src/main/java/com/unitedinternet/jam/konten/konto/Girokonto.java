package com.unitedinternet.jam.konten.konto;

import com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Write a description of class com.unitedinternet.jam.konten.konto.Girokonto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Girokonto extends Konto implements Zahlungsverkehrsfaehig, Serializable
{
    private float dispo;
    private Optional<Zinssatz> sollZinssatz;
    private float kontoFuehrungsGebuehren = 10;
    public static long serialVersionUID = 1;

    public Girokonto(String kontonummer) {
        this(null, kontonummer);
    }

    public Girokonto(String kontonummer, float saldo) {
        this(kontonummer);
        this.saldo = saldo;
    }

    public Girokonto(Zinssatz sollZinssatz, String kontonummer) {
        super(kontonummer);
        this.sollZinssatz = Optional.ofNullable(sollZinssatz);
    }

    /**
     * Zahlt ein
     * @param betrag
     * @exception Falls der Betrag negativ ist, wird eine {@link IllegalArgumentException} geworfen.
     */
    public void einzahlen(float betrag) {

        if (betrag < 0.0f) {
            throw new IllegalArgumentException("Betrag darf nicht kleiner 0 sein");
        }

        saldo += betrag;
    }

    @Override
    public boolean istBetragGedeckt(float betrag) {
        if (betrag < 0.0f) {
            throw new IllegalArgumentException("Betrag darf nicht kleiner 0 sein");
        }

        return getSaldo() + getDispo() >= betrag;
    }

    public void auszahlen(float betrag) throws KontoNichtGedecktException {

        if (betrag < 0.0f) {
            throw new IllegalArgumentException("Betrag ist negativ!");
        }

        if (! istBetragGedeckt(betrag)) {
            throw new KontoNichtGedecktException(saldo + dispo);
        }

        saldo -= betrag;
    }
    
    public float getSaldo() {
        return saldo;
    }
    
    public void setDispo(float dispo) {
        this.dispo = dispo;
    }
    
    public float getDispo() {
        return dispo;
    }
    
    public Optional<Zinssatz> getSollZinssatz() {
        return sollZinssatz;
    }
    
    public void setSollZinssatz(Zinssatz sollZinssatz) {
        this.sollZinssatz = Optional.ofNullable(sollZinssatz);
    }
    
    public float berechneSollzinsen() {

        if (! sollZinssatz.isPresent()) {
            return 0;
        }

        float wert = sollZinssatz.orElse(new Zinssatz(0.1F)).gibWert();

        if (saldo < 0) {
            return saldo / 100 * sollZinssatz.get().gibWert() / 360 * -1;
        }
        
        return 0;
    }
    
    public void macheJahresAbschluss() {
        saldo -= berechneSollzinsen() * 360;
        saldo -= kontoFuehrungsGebuehren;
    }
}
