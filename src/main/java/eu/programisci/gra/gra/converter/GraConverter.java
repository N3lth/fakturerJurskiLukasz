package eu.programisci.gra.gra.converter;

import eu.programisci.gra.gra.dto.GraDTO;
import eu.programisci.gra.gra.model.GraOB;
import eu.programisci.gra.wydanie.converter.WydanieConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class GraConverter {

    @Autowired
    WydanieConverter wydanieConverter;

    public GraDTO obToDto(GraOB in) {
        GraDTO out = new GraDTO();
        out.setId(in.getId());
        out.setTytul(in.getTytul());
        out.setGatunki(new ArrayList<>(in.getGatunki()));
        out.setDeveloper(in.getDeveloper());
        out.setWydania(new HashSet<>(wydanieConverter.obListToDtoList(new ArrayList<>(in.getWydania()))));
        return out;
    }

    public GraOB dtoToOb(GraDTO in) {
        GraOB out = new GraOB();
        out.setId(in.getId());
        out.setTytul(in.getTytul());
        out.setGatunki(new HashSet<>(in.getGatunki()));
        out.setDeveloper(in.getDeveloper());
        out.setWydania(new HashSet<>(wydanieConverter.dtoListToObList(new ArrayList<>(in.getWydania()))));
        return out;
    }


    public List<GraDTO> obListToDtoList(List<GraOB> inList) {
        if (inList == null) {
            return null;
        }
        List<GraDTO> outList = new ArrayList<>();
        for (GraOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
