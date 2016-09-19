package com.unitedinternet.jam.konten.konto;

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


}