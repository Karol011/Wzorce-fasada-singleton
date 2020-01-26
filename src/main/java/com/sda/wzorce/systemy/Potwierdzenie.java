package com.sda.wzorce.systemy;

public class Potwierdzenie {
    private final String tresc;

    public Potwierdzenie(String tresc) {
        this.tresc = tresc;
    }

    public String getTresc() {
        return tresc;
    }

    @Override
    public String toString() {
        return "Potwierdzenie: " + tresc;
    }
}
