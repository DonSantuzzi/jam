package com.unitedinternet.jam.konten.main;

import com.unitedinternet.jam.konten.konto.Girokonto;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KontoStream {

    public static void main(String[] args) throws IOException {

        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(
                    Paths.get("/Users/agrunow/Documents/workspace_intellij/jam-konten/src/main/resources/konten.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        allLines.parallelStream()
                .map(s -> s.split(","))
                .map(s -> new Girokonto(s[0], Float.parseFloat(s[1])))
                .filter(g -> g.getSaldo() > 0)
                .forEach(System.out::println);

                //.mapToDouble(g -> g.getSaldo())
                //.sum());

    }
}
