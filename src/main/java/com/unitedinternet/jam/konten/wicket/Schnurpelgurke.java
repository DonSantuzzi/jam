package com.unitedinternet.jam.konten.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Created by agrunow on 23.01.17.
 */
public class Schnurpelgurke extends WebPage{

    public Schnurpelgurke() {
        add(new Label("message", "Juhu, ich bin da"));
    }
}
