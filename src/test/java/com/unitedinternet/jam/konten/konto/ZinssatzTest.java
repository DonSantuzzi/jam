package com.unitedinternet.jam.konten.konto;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by agrunow on 29.08.16.
 */
public class ZinssatzTest {

    @Test
    public void gibWertVonOf() throws Exception {
        Zinssatz zinssatz = new Zinssatz(0.0f);

        assertThat(zinssatz.gibWert(), is(0.0f));
    }

    @Test
    public void gibWertVonO2f() throws Exception {
        Zinssatz zinssatz = new Zinssatz(0.2f);

        assertThat(zinssatz.gibWert(), is(0.2f));
    }

    @Test
    public void gibWertVonO5f() throws Exception {
        Zinssatz zinssatz = new Zinssatz(0.5f);

        assertThat(zinssatz.gibWert(), is(0.5f));
    }

    @Test
    public void gibWertVonO6f() throws Exception {
        Zinssatz zinssatz = new Zinssatz(0.6f);

        assertThat(zinssatz.gibWert(), is(0.5f));
    }

    @Test (expected = IllegalArgumentException.class)
    public void gibWertVonMinusO5f() throws Exception {
        new Zinssatz(-0.5f);
    }

    @Test
    public void gibWertVonMinus00f() throws Exception {
        Zinssatz zinssatz = new Zinssatz(-0.0f);

        assertThat(zinssatz.gibWert(), is(-0.0f));
    }
}
