package com.sda.wzorce.systemy;

import java.time.LocalDateTime;

final class SystemWynajmuAut {
    private static final SystemWynajmuAut instance = new SystemWynajmuAut();

    public static SystemWynajmuAut get() {
        return instance;
    }

    private SystemWynajmuAut() {
    }

    public Potwierdzenie wynajmijAuto(String miasto, LocalDateTime dataRozpoczeciaRezerwacji, int liczbaDni) {
        if (miasto == null || miasto.length() <= 3) {
            throw new RuntimeException("Nieprawidłowa nazwa miasta!");
        }
        if (dataRozpoczeciaRezerwacji == null || dataRozpoczeciaRezerwacji.compareTo(LocalDateTime.now()) <= 0) {
            throw new RuntimeException("Nieprawidłowa data rozpoczecia rezerwacji!");
        }
        if (liczbaDni < 1) {
            throw new RuntimeException("Nie można wynając auto na mniej niż jeden dzień!");
        }
        // prawdziwy strzał do API z pytaniem o rezerwację taksówki

        return new Potwierdzenie("Wynajem auta w mieście " + miasto + " od " + dataRozpoczeciaRezerwacji + " do " + dataRozpoczeciaRezerwacji.plusDays(liczbaDni));
    }
}
