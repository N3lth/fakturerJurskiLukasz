package eu.programisci.gra.gra.service;

import eu.programisci.gra.gra.dto.CritDTO;
import eu.programisci.gra.gra.dto.GraDTO;
import eu.programisci.gra.gra.enums.EGatunek;

import java.util.List;

public interface IGraService {

    GraDTO findOne(Long id);
    List<GraDTO> findAll();
    void deleteOne(Long id);
    GraDTO save(GraDTO graDTO);
    List<GraDTO> saveBatch(List<GraDTO> graDTO);

    List<GraDTO> znajdzStarszeNiz(Integer rokWydania);
    List<GraDTO> znajdzWgGatunku(EGatunek gatunek);
    List<String> znajdzTytulyZawierajace(String partial);
    List<GraDTO> znajdzWgGatunkuIRokuWydania(CritDTO critDTO);
}
