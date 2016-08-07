package com.unitedinternet.jam.konten.main;

import com.unitedinternet.jam.konten.konto.Girokonto;
import com.unitedinternet.jam.konten.konto.Kontenverwalter;
import com.unitedinternet.jam.konten.konto.Konto;
import com.unitedinternet.jam.konten.konto.Zinssatz;
import com.unitedinternet.jam.konten.kunde.Kunde;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

public class KontenStarter {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Zinssatz zinssatz = new Zinssatz(0.3f);
//		com.unitedinternet.jam.konten.kunde.Kunde kunde = new com.unitedinternet.jam.konten.kunde.Kunde("Meier");
//		kunde.erzeugeGirokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto girokonto = kunde.getGirokonto(0);
//		System.out.println("com.unitedinternet.jam.konten.konto.Girokonto 0: " + girokonto.getSaldo() + " EUR");
//		System.out.println("com.unitedinternet.jam.konten.konto.Girokonto xy: " + girokonto);
//
//		com.unitedinternet.jam.konten.konto.Zinssatz habenZinssatz = new com.unitedinternet.jam.konten.konto.Zinssatz(2);
//		com.unitedinternet.jam.konten.konto.Sparbuch sparbuch = new com.unitedinternet.jam.konten.konto.Sparbuch(habenZinssatz);
//		sparbuch.einzahlen(100);
//		sparbuch.auszahlen(200);
//		sparbuch.macheJahresAbschluss();
//		System.out.println(sparbuch.getSaldo());
//
//
//		com.unitedinternet.jam.konten.konto.Kontenverwalter heinrich = new com.unitedinternet.jam.konten.konto.Kontenverwalter();
//		heinrich.verwalteKonto(girokonto);
//		heinrich.verwalteKonto(girokonto);
//
//		com.unitedinternet.jam.konten.konto.Girokonto konto2 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto3 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto4 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto5 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto6 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto7 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto8 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto9 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto10 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//		com.unitedinternet.jam.konten.konto.Girokonto konto11 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//
//        heinrich.verwalteKonto(konto2);
//        heinrich.verwalteKonto(konto3);
//        heinrich.verwalteKonto(konto4);
//        heinrich.verwalteKonto(konto5);
//        heinrich.verwalteKonto(konto6);
//        heinrich.verwalteKonto(konto7);
//        heinrich.verwalteKonto(konto8);
//        heinrich.verwalteKonto(konto9);
//        heinrich.verwalteKonto(konto10);
//        heinrich.verwalteKonto(konto11);
//
//        boolean konto10Vorhanden = heinrich.hatKonto(konto10);
//        boolean konto11Vorhanden = heinrich.hatKonto(konto11);
//
//        System.out.println("com.unitedinternet.jam.konten.konto.Konto 10 vorhanden: " + konto10Vorhanden);
//        System.out.println("com.unitedinternet.jam.konten.konto.Konto 11 vorhanden: " + konto11Vorhanden);
//
//        int positionKonto10 = heinrich.gibPosition(konto10);
//
//        System.out.println("com.unitedinternet.jam.konten.konto.Konto 10 hat Position " + positionKonto10);
//
//        com.unitedinternet.jam.konten.konto.Konto kontoAnDerStelle9 = heinrich.gibKonto(9);
//        System.out.println("Das com.unitedinternet.jam.konten.konto.Konto an der Stelle 9 ist: " + kontoAnDerStelle9);

//		com.unitedinternet.jam.konten.konto.Girokonto sender = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//        sender.setDispo(500.0F);
//		com.unitedinternet.jam.konten.konto.Girokonto empfaenger = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//
//        System.out.println("Saldo com.unitedinternet.jam.konten.konto.Konto sender: " + sender.getSaldo());
//        System.out.println("Saldo com.unitedinternet.jam.konten.konto.Konto empfaenger: " + empfaenger.getSaldo());
//
//		com.unitedinternet.jam.konten.konto.tool.Ueberweiser ueberweiser = new com.unitedinternet.jam.konten.konto.tool.Ueberweiser();
//
//        ueberweiser.ueberweise(sender, empfaenger, 100.0F);
//
//        System.out.println("Saldo com.unitedinternet.jam.konten.konto.Konto sender: " + sender.getSaldo());
//        System.out.println("Saldo com.unitedinternet.jam.konten.konto.Konto empfaenger: " + empfaenger.getSaldo());
//
//        int x = 12;
//        double y = Math.sqrt(x);
//
//        System.out.println("Wurzel aus " + x + " ist: " + Math.PI);
//
//        for (int i = 0; i < args.length; ++i) {
//            System.out.println("parameter " + i + ": " + args[i]);
//        }

//        com.unitedinternet.jam.konten.konto.Girokonto g1 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//        System.out.println("Ktnr g1: " + g1.gibKontonummer());
//        com.unitedinternet.jam.konten.konto.Girokonto g2 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//        System.out.println("Ktnr g2: " + g2.gibKontonummer());
//        com.unitedinternet.jam.konten.konto.Girokonto g3 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//        System.out.println("Ktnr g3: " + g3.gibKontonummer());
//
//        int frischeKontonummer = com.unitedinternet.jam.konten.konto.Girokonto.gibFrischeKontonummer();
//
//        System.out.println("Frische Kontonummer: " + frischeKontonummer);
//
//        com.unitedinternet.jam.konten.konto.Girokonto g4 = new com.unitedinternet.jam.konten.konto.Girokonto(zinssatz);
//        System.out.println("Ktnr g4: " + g4.gibKontonummer());
//
//        com.unitedinternet.jam.konten.konto.Sparbuch s = new com.unitedinternet.jam.konten.konto.Sparbuch(zinssatz);
//
//            s.einzahlen(99);
//        try {
//            s.auszahlen(200);
//        } catch (com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException e) {
//            e.printStackTrace();
//            e.getCause();
//        }
//
//        g1.einzahlen(100);
//        g2.einzahlen(100);
//        g3.einzahlen(100);

        Kunde mueller = new Kunde("Hans Mueller");
        mueller.erzeugeGirokonto(zinssatz);
        mueller.erzeugeGirokonto(zinssatz);
        mueller.erzeugeGirokonto(zinssatz);


        System.out.println(mueller.getGesamtSaldo());
//
//        for (com.unitedinternet.jam.konten.konto.Girokonto konto : mueller) {
//            konto.getDispo();
//        }


        Kontenverwalter kontenverwalter = new Kontenverwalter();

        for (Girokonto konto : mueller) {
            konto.einzahlen((int) (new Random().nextFloat() * 100));
            kontenverwalter.verwalteKonto(konto);
        }

        System.out.println(kontenverwalter.getKonten());

        Set<Konto> unmodifiableSet = Collections.unmodifiableSet(kontenverwalter.getKonten());
        Girokonto girokonto = new Girokonto(new Zinssatz(0.0f), "1");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("konten.obj"));
        out.writeObject(girokonto);
        out.close();

//        ObjectInputStream in = new ObjectInputStream(new FileInputStream("konten.obj"));
//        Object o = in.readObject();
//        System.out.println(o);

    }


}
















