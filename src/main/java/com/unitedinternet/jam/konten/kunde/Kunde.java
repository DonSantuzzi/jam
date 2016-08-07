package com.unitedinternet.jam.konten.kunde;

import com.unitedinternet.jam.konten.konto.Girokonto;
import com.unitedinternet.jam.konten.konto.Zinssatz;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Write a description of class com.unitedinternet.jam.konten.kunde.Kunde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kunde implements Iterable<Girokonto>
{
    private static int kontozaehler = 0;

    private String name;
    private Set<Girokonto> girokonten = new HashSet<Girokonto>();
    
    public Kunde(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void erzeugeGirokonto(Zinssatz zinssatz) {
        Girokonto girokonto = new Girokonto(zinssatz, String.valueOf(++kontozaehler));
        girokonten.add(girokonto);
    }

    public float getGesamtSaldo() {
        float gesamtSaldo = 0.0f;

        Iterator<Girokonto> iterator = girokonten.iterator();

        while (iterator.hasNext()) {
            gesamtSaldo += iterator.next().getSaldo();
        }

        for (Girokonto konto : girokonten) {
            gesamtSaldo += konto.getSaldo();
        }

        return gesamtSaldo;
    }

    @Override
    public Iterator<Girokonto> iterator() {
        return girokonten.iterator();
    }
}




























