package com.sda.wzorce.systemy;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PelnomocnikSystemuHotelowego {
    public static final PelnomocnikSystemuHotelowego INSTANCE = new PelnomocnikSystemuHotelowego();

    private int licznikRezerwacji = 0;
//    private Map<String, List<PrzedzialCzasowyRezerwacjiHotelowej>> ramyCzasoweInsteniacychPerMisto;
    private List<PrzedzialCzasowyRezerwacjiHotelowej> ramyCzasoweInsteniacychRezerwacji = new ArrayList<>();

    private PelnomocnikSystemuHotelowego() {
    }

    public Potwierdzenie zarezerwujHotel(String miasto, LocalDate dataPrzybycia, LocalDate dataWymeldowania) {
        PrzedzialCzasowyRezerwacjiHotelowej ramyCzasowe = new PrzedzialCzasowyRezerwacjiHotelowej(dataPrzybycia, dataWymeldowania);
        for (PrzedzialCzasowyRezerwacjiHotelowej istniejaceRezerwacje : ramyCzasoweInsteniacychRezerwacji) {
            if (istniejaceRezerwacje.czyNakladaSieZ(ramyCzasowe)) {
                throw new IllegalArgumentException("Rezerwacje nakładają się!");
            }
        }


        System.out.println("Podjęto próbę rezerwacji hotelu w mieście " + miasto);
        Potwierdzenie potwierdzenie = SystemHotelowy.get().zarezerwujHotel(miasto, dataPrzybycia, dataWymeldowania);
        licznikRezerwacji++;
        ramyCzasoweInsteniacychRezerwacji.add(ramyCzasowe);

        return new Potwierdzenie(potwierdzenie.getTresc() + " Życzymy udanego pobytu!");
    }

    public int ileRezerwacjiWykonano() {
        return licznikRezerwacji;
    }

}
