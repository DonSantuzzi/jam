package com.unitedinternet.jam.konten.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Created by agrunow on 23.01.17.
 */
public class LoginPage extends WebPage {

    public LoginPage() {
        add(new Label("message", "Willkommen auf der LoginSeite!"));
    }
}
