package co.edu.usbcali.LatamKG.serviciosVuelo;
import co.edu.usbcali.LatamKG.otros.infoVuelo;

import java.util.List;

public interface servicio1 {

    infoVuelo guardarVuelo(infoVuelo vueloDTO) throws Exception;
    infoVuelo obtenerVuelo();
    List<infoVuelo> obtenerVuelos();

}