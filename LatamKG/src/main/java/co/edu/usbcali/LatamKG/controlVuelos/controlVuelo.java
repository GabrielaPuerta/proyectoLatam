package co.edu.usbcali.LatamKG.controlVuelos;
import co.edu.usbcali.LatamKG.otros.messageVuelo;
import co.edu.usbcali.LatamKG.otros.infoVuelo;
import co.edu.usbcali.LatamKG.serviciosVuelo.servicio1;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class controlVuelo {

    private servicio1 vueloService;

    public controlVuelo(servicio1 vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/obtenerVuelo")
    public ResponseEntity<infoVuelo> obtenerVuelo(){
        return new ResponseEntity(vueloService.obtenerVuelo(), HttpStatus.OK);
    }

    @GetMapping("/obtenerVuelos")
    public ResponseEntity<List<infoVuelo>> obtenerVuelos(){
        return new ResponseEntity(vueloService.obtenerVuelos(), HttpStatus.OK);
    }

    @PostMapping(path = "/guardarVuelo",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarVuelo(@RequestBody infoVuelo vueloDTO) {
        try {
            return new ResponseEntity(vueloService.guardarVuelo(vueloDTO), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(messageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

}