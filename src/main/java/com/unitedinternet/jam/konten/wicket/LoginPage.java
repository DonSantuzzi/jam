package com.unitedinternet.jam.konten.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

/**
 * Created by agrunow on 23.01.17.
 */
public class LoginPage extends WebPage {

    public LoginPage() {
       add(new Label("message", "Willkommen auf der LoginSeite!"));
       add(new Link("meinZiel") {
           @Override
           public void onClick() {
               System.out.println("Juhu, ich wurde gedrückt.");
               LoginPage.this.setResponsePage(new Schnurpelgurke());
           }
       });
    }
}
