package com.sda.wzorce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MainInterator {
    public static void main(String[] args) {


        String[] tablica = {"Barbara", "Alicja", "Cecylia", "Agnieszka", "Zosia", "Aleksandra", "Małgorzata", "Anna"};
        List<String> lista = new ArrayList<>(Arrays.asList(tablica));
        //Collections.sort(lista);
        System.out.println(lista);
        System.out.println(Arrays.toString(tablica));
        //lista.remove(2);


        for (int i = 0; i < lista.size(); i++) {
            String imie = lista.get(i);
        }


        lista.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String imie) {
                        return !imie.startsWith("A");
                    }
                });

        lista.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Drukuje " + s);
            }
        });

        for (String imie : lista) {
            System.out.println("Drukuje po raz drugi: " + imie);
        }


        Iterator<String> iterator = lista.iterator();
        while (iterator.hasNext()) {
            String imie = iterator.next();
            if (imie.startsWith("A")) {
                iterator.remove();
                System.out.println("Usuwam z listy " + imie);
            } else {
                System.out.println(imie);
            }
        }
    }
}

