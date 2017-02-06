package com.unitedinternet.jam.konten.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Created by agrunow on 23.01.17.
 */
public class HomePage extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return Schnurpelgurke.class;
    }
}
