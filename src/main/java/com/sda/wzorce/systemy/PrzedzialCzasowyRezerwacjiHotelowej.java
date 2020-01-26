package com.sda.wzorce.systemy;

import java.time.LocalDate;

public class PrzedzialCzasowyRezerwacjiHotelowej {
    private LocalDate dataPrzybycia;
    private LocalDate dataWyjazdu;

    public PrzedzialCzasowyRezerwacjiHotelowej(LocalDate dataPrzybycia, LocalDate dataWyjazdu) {
        this.dataPrzybycia = dataPrzybycia;
        this.dataWyjazdu = dataWyjazdu;
    }

    public LocalDate getDataPrzybycia() {
        return dataPrzybycia;
    }

    public LocalDate getDataWyjazdu() {
        return dataWyjazdu;
    }

    public boolean czyNakladaSieZ(PrzedzialCzasowyRezerwacjiHotelowej ramyCzasowe) {
        // TOOD dokoncz mnie
        if (this.dataWyjazdu.isAfter(ramyCzasowe.dataPrzybycia)) {
            return true;
        }
        return false;
    }
}
