package eu.programisci.gra.gra.api;

import eu.programisci.gra.gra.dto.CritDTO;
import eu.programisci.gra.gra.dto.GraDTO;
import eu.programisci.gra.gra.enums.EGatunek;
import eu.programisci.gra.gra.service.IGraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/gra")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class GraRestController {

    @Autowired
    IGraService graService;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GraDTO findOne(@RequestParam("id") Long aId) {
        return graService.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> findAll() {
        return graService.findAll();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        graService.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GraDTO save(@RequestBody GraDTO graDTO) {
        return graService.save(graDTO);
    }

    @RequestMapping(value = "/saveBatch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> saveBatch(@RequestBody List<GraDTO> listGraDTO) {
        return graService.saveBatch(listGraDTO);
    }

    @RequestMapping(value = "/znajdzStarszeNiz", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> znajdzStarszeNiz(@RequestParam("rokWydania") Integer rokWydania) {
        return graService.znajdzStarszeNiz(rokWydania);
    }

    @RequestMapping(value = "/znajdzWgGatunku", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> znajdzWgGatunku(@RequestParam("gatunek") EGatunek gatunek) {
        return graService.znajdzWgGatunku(gatunek);
    }

    @RequestMapping(value = "/znajdzTytulyZawierajace", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> znajdzTytulyZawierajace(@RequestParam("partial") String partial) {
        return graService.znajdzTytulyZawierajace(partial);
    }

    @RequestMapping(value = "/znajdzWgGatunkuIRokuWydania", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> znajdzWgGatunkuIRokuWydania(@RequestBody CritDTO critDTO) {
        return graService.znajdzWgGatunkuIRokuWydania(critDTO);
    }

}
