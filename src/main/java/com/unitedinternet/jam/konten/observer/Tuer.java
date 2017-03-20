package com.unitedinternet.jam.konten.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agrunow on 20.03.17.
 */
public class Tuer {

    private List<TuerListener> tuerListenerList = new ArrayList<>();

    private String id;

    public Tuer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void reingehen(Person person) {
        TuerEvent event = new TuerEvent(this, person, Richtung.REIN);
        update(event);
    }

    public void rausgehen(Person person) {
        TuerEvent event = new TuerEvent(this, person, Richtung.RAUS);
        update(event);
    }

    public void registerTuerListener(TuerListener tuerListener) {
        tuerListenerList.add(tuerListener);
    }

    public void update(TuerEvent tuerEvent) {
        for (TuerListener tuerListener : tuerListenerList) {
            tuerListener.update(tuerEvent);
        }
    }

    @Override
    public String toString() {
        return getId();
    }

    public enum Richtung {
        REIN, RAUS;
    }
}
