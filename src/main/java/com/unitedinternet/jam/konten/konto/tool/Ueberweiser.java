package com.unitedinternet.jam.konten.konto.tool;

import com.unitedinternet.jam.konten.konto.Zahlungsverkehrsfaehig;

/**
 * Created by agrunow on 28.09.15.
 */
public class Ueberweiser {

    public void ueberweise(Zahlungsverkehrsfaehig sender, Zahlungsverkehrsfaehig empfaenger, float betrag) {
        if (sender.istBetragGedeckt(betrag)) {
            sender.auszahlen(betrag);
            empfaenger.einzahlen(betrag);
            System.out.println("Betrag in Höhe von " + betrag + " wurde erfolgreich überwiesen.");
        } else {
            System.out.println("Vom com.unitedinternet.jam.konten.konto.Konto kann nicht überwiesen werden!");
        }
    }

    // TODO Trick mit dynamischem Typ
}
