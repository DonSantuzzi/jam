package com.unitedinternet.jam.konten.konto;

import java.io.Serializable;

/**
 * Write a description of class com.unitedinternet.jam.konten.konto.Girokonto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Girokonto extends Konto implements Zahlungsverkehrsfaehig, Serializable
{
    private float dispo;
    private Zinssatz sollZinssatz;
    private float kontoFuehrungsGebuehren = 10;
    private String keks;
    private String lolly;
    private String pop;
    public static long serialVersionUID = 1;
    
    public Girokonto(Zinssatz sollZinssatz, String kontonummer) {
        super(kontonummer);
        this.sollZinssatz = sollZinssatz;
    }

    public void einzahlen(float betrag) {
        saldo += betrag;
    }

    @Override
    public boolean istBetragGedeckt(float betrag) {
        return getSaldo() + getDispo() >= betrag;
    }

    public void auszahlen(float betrag) {
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
    
    public Zinssatz getSollZinssatz() {
        return sollZinssatz;
    }
    
    public void setSollZinssatz(Zinssatz sollZinssatz) {
        this.sollZinssatz = sollZinssatz;
    }
    
    public float berechneSollzinsen() {
        if (saldo < 0) {
            return saldo / 100 * sollZinssatz.gibWert() / 360 * -1;
        }
        
        return 0;
    }
    
    public void macheJahresAbschluss() {
        saldo -= berechneSollzinsen() * 360;
        saldo -= kontoFuehrungsGebuehren;
    }
}















