package com.unitedinternet.jam.konten.konto.exception;

/**
 * Created by agrunow on 07.12.15.
 */
public class KontoNichtGedecktException extends Exception {

    private float auszahlbarerBetrag;

    public KontoNichtGedecktException(Throwable cause, float auszahlbarerBetrag) {
        super("Konto nicht gedeckt", cause);
    }

    public KontoNichtGedecktException(float auszahlbarerBetrag) {
        super("Konto ist nicht gedeckt!");
        this.auszahlbarerBetrag = auszahlbarerBetrag;
    }

    public float getAuszahlbarerBetrag() {
        return auszahlbarerBetrag;
    }
}
