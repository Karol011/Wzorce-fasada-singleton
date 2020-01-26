package com.sda.wzorce.systemy;

import java.time.LocalDateTime;

final class SystemTaxi {
    private static final SystemTaxi instance = new SystemTaxi();

    public static SystemTaxi get() {
        return instance;
    }

    private SystemTaxi() {
    }

    public Potwierdzenie zamowTaksowke(String miasto, LocalDateTime dataPrzybycia) {
        if (miasto == null || miasto.length() <= 3) {
            throw new RuntimeException("Nieprawidłowa nazwa miasta!");
        }
        if (dataPrzybycia == null || dataPrzybycia.compareTo(LocalDateTime.now()) <= 0) {
            throw new RuntimeException("Nieprawidłowa data przybycia!");
        }
        // prawdziwy strzał do API z pytaniem o rezerwację taksówki

        return new Potwierdzenie("Rezerwacja taksówki w mieście " + miasto + " na " + dataPrzybycia);
    }
}
