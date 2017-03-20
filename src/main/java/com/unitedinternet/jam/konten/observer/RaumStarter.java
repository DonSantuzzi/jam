package com.unitedinternet.jam.konten.observer;

/**
 * Created by agrunow on 20.03.17.
 */
public class RaumStarter {

    public static void main(String[] args) {
        Tuer eingangLinks = new Tuer("links");
        Tuer eingangRechts = new Tuer("rechts");

        Raum r5215 = new Raum(eingangLinks, eingangRechts);
        eingangLinks.registerTuerListener(r5215);
        eingangRechts.registerTuerListener(r5215);

        Person christian = new Person("Christian");
        Person cem = new Person("Cem");
        Person heike = new Person("Heike");
        Person thomas = new Person("Thomas");
        Person bartosz = new Person("Bartosz");
        Person andre = new Person("Andre");
        Person sebastian = new Person("Sebastian");

        eingangLinks.reingehen(christian);
        eingangRechts.reingehen(cem);
        eingangLinks.reingehen(heike);
        eingangRechts.reingehen(thomas);
        eingangLinks.reingehen(bartosz);
        eingangRechts.reingehen(andre);
        eingangRechts.reingehen(sebastian);
        eingangRechts.rausgehen(sebastian);
    }
}
