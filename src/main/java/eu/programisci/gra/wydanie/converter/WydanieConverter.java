package eu.programisci.gra.wydanie.converter;

import eu.programisci.gra.wydanie.dto.WydanieDTO;
import eu.programisci.gra.wydanie.model.WydanieOB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WydanieConverter {

    public WydanieDTO obToDto(WydanieOB in) {
        WydanieDTO out = new WydanieDTO();
        out.setId(in.getId());
        out.setWydawca(in.getWydawca());
        out.setPlatforma(in.getPlatforma());
        out.setRokWydania(in.getRokWydania());
        return out;
    }

    public WydanieOB dtoToOb(WydanieDTO in) {
        WydanieOB out = new WydanieOB();
        out.setId(in.getId());
        out.setWydawca(in.getWydawca());
        out.setPlatforma(in.getPlatforma());
        out.setRokWydania(in.getRokWydania());
        return out;
    }


    public List<WydanieDTO> obListToDtoList(List<WydanieOB> inList) {
        if (inList == null) {
            return null;
        }
        List<WydanieDTO> outList = new ArrayList<>();
        for (WydanieOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }

    public List<WydanieOB> dtoListToObList(List<WydanieDTO> inList) {
        if (inList == null) {
            return null;
        }
        List<WydanieOB> outList = new ArrayList<>();
        for (WydanieDTO in : inList) {
            outList.add(dtoToOb(in));
        }
        return outList;
    }
}
