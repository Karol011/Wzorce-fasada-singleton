package com.sda.wzorce.systemy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class SystemBiuraPodrozy {
    public static final SystemBiuraPodrozy INSTANCE = new SystemBiuraPodrozy();

    Map<String, String> mapaKodowLotnisk = new HashMap<>();

    private SystemBiuraPodrozy() {
        mapaKodowLotnisk.put("Gdańsk", "GDN");
        mapaKodowLotnisk.put("Warszawa", "WAW");
        mapaKodowLotnisk.put("Dubaj", "DXB");
        mapaKodowLotnisk.put("Nairobi", "NBO");
    }

    public Potwierdzenie zarezerwujWycieczkeISamochod(String miastoDocelowe, LocalDate dataRozpoczeciaWycieczki, int liczbaDni) {
        LocalDateTime dataWylotu = LocalDateTime.of(dataRozpoczeciaWycieczki, LocalTime.of(15,0));
        Potwierdzenie potwierdzenieLotu = SystemLotow.get().zarezerwujLot(mapaKodowLotnisk.get(miastoDocelowe),dataWylotu);

        return potwierdzenieLotu;
    }


    public Potwierdzenie zarezerwujWycieczke(String miastoDocelowe, LocalDate dataRozpoczeciaWycieczki, int liczbaDni) {
        LocalDateTime dataIGodzinaWylotu = LocalDateTime.of(dataRozpoczeciaWycieczki.getYear(),
                dataRozpoczeciaWycieczki.getMonth(),
                dataRozpoczeciaWycieczki.getDayOfMonth(),
                8, 0);
        String kodLotniskaDocelowego = mapaKodowLotnisk.get(miastoDocelowe);
        Potwierdzenie potwierdzenieLotuDocelowego = SystemLotow.get().zarezerwujLot(kodLotniskaDocelowego, dataIGodzinaWylotu);

        LocalDate dataPowrotuZWycieczki = dataRozpoczeciaWycieczki.plusDays(liczbaDni);

        Potwierdzenie potwierdzennieHotelu = PelnomocnikSystemuHotelowego.INSTANCE.zarezerwujHotel(miastoDocelowe, dataRozpoczeciaWycieczki, dataPowrotuZWycieczki);

        LocalDateTime dataIGodzinaPrzylotu = dataIGodzinaWylotu.plusHours(3);

        Potwierdzenie potwierdzenieTaksowki = SystemTaxi.get().zamowTaksowke(miastoDocelowe, dataIGodzinaPrzylotu);

        return new Potwierdzenie("Rezerwacja wycieczki:\n" +
                "   " + potwierdzenieLotuDocelowego + "\n" +
                "   " + potwierdzenieTaksowki + "\n" +
                "   " + potwierdzennieHotelu);
    }
}
