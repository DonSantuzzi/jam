package com.unitedinternet.jam.konten.konto;

import com.unitedinternet.jam.konten.konto.Konto;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Kontenverwalter {

	private SortedSet<Konto> konten = new TreeSet<>(new Comparator<Konto>() {
        @Override
        public int compare(Konto o1, Konto o2) {
            return ((Float) o1.getSaldo()).compareTo(o2.getSaldo());
        }
    });
//	private SortedSet<com.unitedinternet.jam.konten.konto.Konto> konten = new TreeSet<>();

	public void verwalteKonto(Konto konto) {

		if (kontoMaximumErreicht()) {
            System.out.println("Konto Maximum überschritten!");
            return;
        }

        if (hatKonto(konto)) {
            System.out.println("Konto schon vorhanden!");
            return;
        }
		
		konten.add(konto);
	}

    public boolean hatKonto(Konto konto) {
        return konten.contains(konto);
    }

    private boolean kontoMaximumErreicht() {
        return konten.size() >= 10;
    }

    public SortedSet<Konto> getKonten() {
        return konten;
    }
}
