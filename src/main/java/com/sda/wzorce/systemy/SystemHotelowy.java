package com.sda.wzorce.systemy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

final class SystemHotelowy {
    private static final SystemHotelowy instance = new SystemHotelowy();

    public static SystemHotelowy get() {
        return instance;
    }

    private SystemHotelowy() {
    }

    public Potwierdzenie zarezerwujHotel(String miasto, LocalDate dataPrzybycia, LocalDate dataWymeldowania) {
        if (miasto == null || miasto.length() <= 3) {
            throw new RuntimeException("Nieprawidłowa nazwa miasta!");
        }
        if (dataPrzybycia == null || dataPrzybycia.compareTo(LocalDate.now()) <= 0) {
            throw new RuntimeException("Nieprawidłowa data przybycia!");
        }
        if (dataWymeldowania == null || dataWymeldowania.compareTo(LocalDate.now()) <= 0) {
            throw new RuntimeException("Nieprawidłowa data przybycia!");
        }
        if (dataWymeldowania.compareTo(dataPrzybycia) <= 0) {
            throw new RuntimeException("Data wymeldowania nie może być wcześniejsza lub równa dacie przybycia!");
        }
        // prawdziwy strzał do API z pytaniem o rezerwację hotelu

        LocalDateTime data1 = LocalDateTime.of(dataPrzybycia, LocalTime.of(15, 0));
        LocalDateTime data2 = LocalDateTime.of(dataWymeldowania, LocalTime.of(11, 0));
        return new Potwierdzenie("Rezerwacja hotelu w mieście " + miasto + " od " + data1 + " do " + data2);
    }
}
