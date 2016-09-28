package com.unitedinternet.jam.konten.konto;

import com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by agrunow on 05.09.16.
 */
public class GirokontoTest {
    private Girokonto girokonto1;
    private Girokonto girokonto2;

    @Before
    public void setUp() throws Exception {
        girokonto1 = new Girokonto(new Zinssatz(0.1f), "1");
        girokonto2 = new Girokonto(new Zinssatz(0.1f), "2");
    }

    @Test
    public void einzahlen0Grenzwerte() throws Exception {
        assertThat(girokonto1.getSaldo(), is(0.0f));
        girokonto1.einzahlen(0.1f);
        assertThat(girokonto1.getSaldo(), is(0.1f));
    }

    @Test
    public void einzahlenMinimumUndMaximumFloat() throws Exception {
        assertThat(girokonto1.getSaldo(), is(0.0f));
        girokonto1.einzahlen(Float.MIN_VALUE);
        assertThat(girokonto1.getSaldo(), is(Float.MIN_VALUE));

        assertThat(girokonto2.getSaldo(), is(0.0f));
        girokonto2.einzahlen(Float.MAX_VALUE);
        assertThat(girokonto2.getSaldo(), is(Float.MAX_VALUE));
    }

    @Test
    public void einzahlenMinimumUndMaximumFloatGleichzeitig() throws Exception {
        assertThat(girokonto1.getSaldo(), is(0.0f));
        girokonto1.einzahlen(Float.MAX_VALUE);
        assertThat(girokonto1.getSaldo(), is(Float.MAX_VALUE));
        girokonto1.einzahlen(Float.MIN_VALUE);
        assertThat(girokonto1.getSaldo(), is(Float.MAX_VALUE));
    }

    @Test
    public void einzahlen100_000() throws Exception {
        assertThat(girokonto1.getSaldo(), is(0.0f));
        girokonto1.einzahlen(100_000);
        assertThat(girokonto1.getSaldo(), is(100_000F));
    }

    @Test
    public void einzahlenMaximumPlus1() throws Exception {
        assertThat(girokonto1.getSaldo(), is(0.0f));
        girokonto1.einzahlen(Float.MAX_VALUE + 1);
        assertThat(girokonto1.getSaldo(), is(Float.MAX_VALUE));
    }

    @Test (expected = IllegalArgumentException.class)
    public void einzahlenMinimumMinus1() throws Exception {
        assertThat(girokonto1.getSaldo(), is(0.0f));
        girokonto1.einzahlen(Float.MIN_VALUE - 1);
        // assertThat(girokonto1.getSaldo(), is(-1f));
    }

    @Test (expected = IllegalArgumentException.class)
    public void einzahlenNegativerBetrag() throws Exception {
        girokonto1.einzahlen(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void istBetragGedecktNegativerBetrag() {
        girokonto1.istBetragGedeckt(-5);
    }

    @Test
    public void istBetragGedecktPositiv() {
        assertThat(girokonto1.istBetragGedeckt(5), is(false));
        girokonto1.einzahlen(20);
        assertThat(girokonto1.istBetragGedeckt(5), is(true));
    }

    @Test
    public void istBetragGedeckt00() {
        assertThat(girokonto1.istBetragGedeckt(0.0f), is(true));
    }

    @Test
    public void istBetragGedecktSaldo0PositiverDispo() {
        assertThat(girokonto1.istBetragGedeckt(5), is(false));
        girokonto1.setDispo(5);
        assertThat(girokonto1.istBetragGedeckt(5), is(true));
    }

    @Test
    public void istBetragGedecktSaldoNegativDispoGesetzt() throws KontoNichtGedecktException {
        assertThat(girokonto1.istBetragGedeckt(5), is(false));
        girokonto1.setDispo(10);
        girokonto1.auszahlen(5);
        assertThat(girokonto1.istBetragGedeckt(5), is(true));
    }

    @Test
    public void istBetragGedecktSaldoNegativDispoReichtNichtAus() throws KontoNichtGedecktException {
        assertThat(girokonto1.istBetragGedeckt(5), is(false));
        girokonto1.setDispo(5);
        girokonto1.auszahlen(5);
        assertThat(girokonto1.istBetragGedeckt(5), is(false));
    }

    @Test (expected = KontoNichtGedecktException.class)
    public void auszahlen10Saldo0() throws Exception {
        girokonto1.auszahlen(10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void auszahlenNegativerBetrag() throws Exception {
        girokonto1.auszahlen(-1);
    }

    @Test (expected = KontoNichtGedecktException.class)
    public void auszahlenDispo5Auszahlen10() throws Exception {
        girokonto1.setDispo(5);
        girokonto1.auszahlen(10);
    }

    @Test (expected = KontoNichtGedecktException.class)
    public void auszahlenEinzahlen5Auszahlen10() throws Exception {
        girokonto1.einzahlen(5);
        girokonto1.auszahlen(10);
    }

    @Test
    public void auszahlen5Einzahlen5Auszahlen() throws KontoNichtGedecktException {
        girokonto1.einzahlen(5);
        assertThat(girokonto1.getSaldo(), is(5.0f));
        girokonto1.auszahlen(5);
        assertThat(girokonto1.getSaldo(), is(0.0f));
    }

    @Test
    public void auszahlen5Einzahlen2Auszahlen() throws KontoNichtGedecktException {
        girokonto1.einzahlen(5);
        assertThat(girokonto1.getSaldo(), is(5.0f));
        girokonto1.auszahlen(2);
        assertThat(girokonto1.getSaldo(), is(3.0f));
    }

    @Test
    public void auszahlen10EinzahlenMehrfachAuszahlen() throws KontoNichtGedecktException {
        girokonto1.einzahlen(10);
        assertThat(girokonto1.getSaldo(), is(10.0f));
        girokonto1.auszahlen(5);
        assertThat(girokonto1.getSaldo(), is(5.0f));
        girokonto1.auszahlen(3);
        assertThat(girokonto1.getSaldo(), is(2.0f));
    }

    @Test
    public void auszahlen5Einzahlen5Dispo5Auszahlen() throws KontoNichtGedecktException {
        girokonto1.einzahlen(5);
        assertThat(girokonto1.getSaldo(), is(5.0f));
        girokonto1.setDispo(5);
        assertThat(girokonto1.getSaldo(), is(5.0f));
        girokonto1.auszahlen(5);
        assertThat(girokonto1.getSaldo(), is(0.0f));
    }
}