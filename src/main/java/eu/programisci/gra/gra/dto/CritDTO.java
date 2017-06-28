package eu.programisci.gra.gra.dto;

import eu.programisci.gra.gra.enums.EGatunek;

public class CritDTO {
    EGatunek gatunek;
    Integer rokWydania;

    public CritDTO() {
    }

    public CritDTO(EGatunek gatunek, Integer rokWydania) {
        this.gatunek = gatunek;
        this.rokWydania = rokWydania;
    }

    public EGatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(EGatunek gatunek) {
        this.gatunek = gatunek;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }
}
