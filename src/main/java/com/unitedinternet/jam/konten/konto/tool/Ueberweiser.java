package com.unitedinternet.jam.konten.konto.tool;

import com.unitedinternet.jam.konten.konto.Konto;
import com.unitedinternet.jam.konten.konto.Zahlungsverkehrsfaehig;
import com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException;

/**
 * Created by agrunow on 28.09.15.
 */
public class Ueberweiser {

    public void ueberweise(Zahlungsverkehrsfaehig sender, Zahlungsverkehrsfaehig empfaenger, float betrag)
            throws KontoNichtGedecktException {
        if (sender.istBetragGedeckt(betrag)) {
            sender.auszahlen(betrag);
            empfaenger.einzahlen(betrag);
            sender.bucheTransferGebuehren();
            System.out.println("Betrag in Höhe von " + betrag + " wurde erfolgreich überwiesen.");
        } else {
            System.out.println("Vom Konto " + ((Konto)sender).getKontonummer() + " kann nicht überwiesen werden!");
        }
    }
}