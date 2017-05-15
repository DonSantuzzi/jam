package com.unitedinternet.jam.konten.konto;

import com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException;

/**
 * Created by agrunow on 28.09.15.
 */
public interface Zahlungsverkehrsfaehig {

    void auszahlen(float betrag) throws KontoNichtGedecktException;

    void einzahlen(float betrag);

    boolean istBetragGedeckt(float betrag);

    default void bucheTransferGebuehren()  {
        try {
            auszahlen(10);
        } catch (KontoNichtGedecktException e) {
            System.out.println("Gebühren können nicht abgezogen werden!");
        }
    }}
