package com.unitedinternet.jam.konten.main;

import com.unitedinternet.jam.konten.Mitarbeiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a description of class com.unitedinternet.jam.konten.main.Skurril here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skurril {

    public static void main(String[] args) {

//        Mitarbeiter hans = new Mitarbeiter("Hans");
//
//        Collection<Mitarbeiter> meineMitarbeiter = new HashSet<>();
//        meineMitarbeiter.add(hans);
//
//        System.out.println("Hans enthalten: " + meineMitarbeiter.contains(hans));
//
//        Mitarbeiter hans2 = new Mitarbeiter("Hans");
//
//        System.out.println("Hans2 enthalten: " + meineMitarbeiter.contains(hans2));
//        System.out.println("HashCode Hans: " + hans.hashCode());
//        System.out.println("HashCode Hans2: " + hans2.hashCode());


























//        Set<Integer> test = new HashSet<>();
//
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i < 100000; ++i) {
//            test.add(i);
//        }
//
//        long ende = System.currentTimeMillis();
//
//        System.out.println("Dauer: " + (ende - start));
//
//        List<Integer> test2 = new ArrayList<>();
//
//        long start2 = System.currentTimeMillis();
//
//        for (int i = 0; i < 100000; ++i) {
//            test2.add(i);
//        }
//
//        long ende2 = System.currentTimeMillis();
//
//        System.out.println("Dauer2: " + (ende2 - start2));
//
//        long start3 = System.currentTimeMillis();
//        boolean bool1 = test.contains(5000000);
//        long ende3 = System.currentTimeMillis();
//
//        System.out.println("Finden im Hash: " + (ende3 - start3));
//
//        long start4 = System.currentTimeMillis();
//        boolean bool2 = test2.contains(5000000);
//        long ende4 = System.currentTimeMillis();
//
//        System.out.println("Finden in der Liste: " + (ende4 - start4));

//
//
//        Mitarbeiter anna = new Mitarbeiter("Anna");
//        Mitarbeiter sebastian = new Mitarbeiter("Anna");
//        Set<Mitarbeiter> kekse = new HashSet<>();
//        kekse.add(anna);
//        kekse.add(sebastian);
//        System.out.println("Elemente: " + kekse.size());


        Mitarbeiter mueller = new Mitarbeiter("Hans", "Müller");
        Mitarbeiter mueller2 = new Mitarbeiter("Hans", "Müller");


        Set<Mitarbeiter> s = new HashSet<>();
        s.add(mueller);
//        s.add(mueller2);

        System.out.println("mueller enthalten: " + s.contains(mueller));
        System.out.println("mueller enthalten: " + s.contains(mueller2));
    }
}





































