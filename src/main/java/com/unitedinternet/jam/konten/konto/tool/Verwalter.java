package com.unitedinternet.jam.konten.konto.tool;

import com.unitedinternet.jam.konten.konto.Konto;

import java.util.HashSet;
import java.util.Set;

public class Verwalter<T extends Konto> {

	private Set<T> konten = new HashSet<T>();

	public void verwalte(T konto) {

		if (kontoMaximumErreicht()) {
            System.out.println("com.unitedinternet.jam.konten.konto.Konto Maximum überschritten!");
            return;
        }

        if (hat(konto)) {
            System.out.println("com.unitedinternet.jam.konten.konto.Konto schon vorhanden!");
            return;
        }
		
		konten.add(konto);
	}

    public boolean hat(T konto) {
        return konten.contains(konto);
    }

    private boolean kontoMaximumErreicht() {
        return konten.size() <= 10;
    }
}
