package com.unitedinternet.jam.konten.main;

import com.unitedinternet.jam.konten.konto.Girokonto;
import com.unitedinternet.jam.konten.konto.Kontenverwalter;
import com.unitedinternet.jam.konten.konto.Konto;
import com.unitedinternet.jam.konten.konto.Sparbuch;
import com.unitedinternet.jam.konten.konto.Zinssatz;
import com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException;
import com.unitedinternet.jam.konten.konto.tool.Ueberweiser;
import com.unitedinternet.jam.konten.kunde.Kunde;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

public class KontenStarter {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Zinssatz zinssatz = new Zinssatz(0.3f);


        Kunde mueller = new Kunde("Hans Mueller");
        mueller.erzeugeGirokonto(zinssatz);
        mueller.erzeugeGirokonto(zinssatz);
        mueller.erzeugeGirokonto(zinssatz);


        Kontenverwalter kontenverwalter = new Kontenverwalter();

        for (Girokonto konto : mueller) {
            konto.einzahlen((int) (new Random().nextFloat() * 100));
            kontenverwalter.verwalteKonto(konto);
        }

        SortedSet<Konto> konten = kontenverwalter.getKonten();

        for (Konto konto : konten) {
            System.out.println("Konto Nr. " + konto.getKontonummer() + " hat Saldo: " + konto.getSaldo());
        }

        System.out.println("Jetzt kommen die Kontoführungsgebühren...");

        Girokonto kontoAuszahlen = (Girokonto) kontenverwalter.getKonten().first();
        Girokonto kontoEinzahlen = (Girokonto) kontenverwalter.getKonten().last();

        try {
            new Ueberweiser().ueberweise(kontoAuszahlen, kontoEinzahlen, 5);
        } catch (KontoNichtGedecktException e) {
            System.out.println("Auszahlung von Konto " + kontoAuszahlen.getKontonummer() + " nicht möglich");
        }

        System.out.println("Neue Kontostände...");

        for (Konto konto : konten) {
            System.out.println("Konto Nr. " + konto.getKontonummer() + " hat Saldo: " + konto.getSaldo());
        }

        Sparbuch sparbuch = new Sparbuch(zinssatz, "100");
        sparbuch.einzahlen(100);

        try {
            new Ueberweiser().ueberweise(sparbuch, kontoEinzahlen, 10);
        } catch (KontoNichtGedecktException e) {
            System.out.println("Auszahlung von Sparbuch " + kontoAuszahlen.getKontonummer() + " nicht möglich");
        }
    }
}
















