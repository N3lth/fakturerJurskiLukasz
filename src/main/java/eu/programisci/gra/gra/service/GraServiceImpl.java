package eu.programisci.gra.gra.service;

import eu.programisci.gra.gra.converter.GraConverter;
import eu.programisci.gra.wydanie.converter.WydanieConverter;
import eu.programisci.gra.gra.dto.CritDTO;
import eu.programisci.gra.gra.dto.GraDTO;
import eu.programisci.gra.gra.enums.EGatunek;
import eu.programisci.gra.gra.model.GraOB;
import eu.programisci.gra.gra.repository.IGraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraServiceImpl implements IGraService{


    @Autowired
    private IGraRepository graRepository;
    @Autowired
    private GraConverter graConverter;
    @Autowired
    private WydanieConverter wydanieConverter;

    @Override
    public GraDTO findOne(Long id) {
        GraOB ob = graRepository.findOne(id);
        GraDTO dto = graConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<GraDTO> findAll() {
        List<GraOB> obList = graRepository.findAll();
        List<GraDTO> dtoList = graConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        graRepository.delete(id);
    }

    @Override
    public GraDTO save(GraDTO graDTO) {
        if (graDTO.getId() == null) {
            return graConverter.obToDto(create(graDTO));
        } else {
            return graConverter.obToDto(update(graDTO));
        }
    }

    @Override
    public List<GraDTO> saveBatch(List<GraDTO> graDTO) {
        List<GraDTO> outList = new ArrayList<>();
        for (GraDTO in : graDTO)
            outList.add(save((in)));
        return outList;
    }

    private GraOB create(GraDTO dto) {
        GraOB ob = graConverter.dtoToOb(dto);
        ob.setDataUtworzenia(new Date());
        ob = graRepository.saveAndFlush(ob);
        return ob;
    }

    private GraOB update(GraDTO dto) {
        GraOB ob = graRepository.findOne(dto.getId());
        ob.setDeveloper(dto.getDeveloper());
        Set<EGatunek> gatunki;
        if(dto.getGatunki()==null)
            gatunki = new HashSet<>(dto.getGatunki());
        else
            gatunki = new HashSet<>();
        ob.setGatunki(gatunki);
        ob.setTytul(dto.getTytul());
        ob.setWydania(new HashSet<>(wydanieConverter.dtoListToObList(new ArrayList<>(dto.getWydania()))));
        ob = graRepository.save(ob);
        return ob;
    }

    @Override
    public List<GraDTO> znajdzStarszeNiz(Integer rokWydania) {
        List<GraOB> obList = graRepository.znajdzStarszeNiz(rokWydania);
        List<GraDTO> dtoList = graConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public List<GraDTO> znajdzWgGatunku(EGatunek gatunek) {
        List<GraOB> obList = graRepository.znajdzWgGatunku(gatunek);
        List<GraDTO> dtoList = graConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public List<String> znajdzTytulyZawierajace(String partial) {
        List<String> titleList = graRepository.znajdzTytulyZawierajace(partial);
        return titleList;
    }

    @Override
    public List<GraDTO> znajdzWgGatunkuIRokuWydania(CritDTO critDTO) {
        List<GraOB> obList = graRepository.znajdzTytulyZawierajace(critDTO.getGatunek(), critDTO.getRokWydania());
        List<GraDTO> dtoList = graConverter.obListToDtoList(obList);
        return dtoList;
    }
}