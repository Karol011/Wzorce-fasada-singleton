package com.sda.wzorce.systemy;

import java.time.LocalDateTime;

final class SystemLotow {
    private static final SystemLotow instance = new SystemLotow();

    public static SystemLotow get() {
        return instance;
    }

    private SystemLotow() {
    }

    public Potwierdzenie zarezerwujLot(String kierunek, LocalDateTime dataWylotu) {
        if (kierunek == null || kierunek.length() != 3) {
            throw new RuntimeException("Nieprawidłowy kierunek lotu!");
        }
        if (dataWylotu == null || dataWylotu.compareTo(LocalDateTime.now()) <= 0) {
            throw new RuntimeException("Nieprawidłowa data lotu!");
        }
        // prawdziwy strzał do API z pytaniem o rezerwację
        return new Potwierdzenie("Rezerwacja lotu do " + kierunek.toUpperCase() + " na datę " + dataWylotu);
    }
}
