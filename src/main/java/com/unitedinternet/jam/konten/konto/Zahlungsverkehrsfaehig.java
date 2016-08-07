package com.unitedinternet.jam.konten.konto;

/**
 * Created by agrunow on 28.09.15.
 */
public interface Zahlungsverkehrsfaehig {

    void auszahlen(float betrag);

    void einzahlen(float betrag);

    boolean istBetragGedeckt(float betrag);
}
