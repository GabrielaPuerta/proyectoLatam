package co.edu.usbcali.LatamKG.serviciosVuelo;
import co.edu.usbcali.LatamKG.otros.infoVuelo;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class servicio2 implements servicio1 {

    @Override
    public infoVuelo guardarVuelo(infoVuelo vueloDTO) throws Exception {
        if(vueloDTO == null) {
            throw new Exception("El Vuelo no cuenta con datos");
        }
        if(vueloDTO.getId()== null || vueloDTO.getId().trim().equals("")) {
            throw new Exception("Id no valido");
        }
        if(vueloDTO.getOrigen()== null || vueloDTO.getOrigen().trim().equals("")) {
            throw new Exception("Origen no valido");
        }
        if(vueloDTO.getDestino()== null || vueloDTO.getDestino().trim().equals("")) {
            throw new Exception("Destino no valido");
        }
        if(vueloDTO.getIdAvion()== null || vueloDTO.getIdAvion().trim().equals("")) {
            throw new Exception("idAvion no valido");
        }

        //Aquí se llama al Repository

        return vueloDTO;
    }

    @Override
    public infoVuelo obtenerVuelo() {
        return infoVuelo.builder()
                .origen("Miami")
                .destino("Los Angeles")
                .fechaHoraSalida(new Date())
                .fechaHoraLlegada(new Date())
                .id("66865").idAvion("94491").build();
    }

    @Override
    public List<infoVuelo> obtenerVuelos() {
        return Arrays.asList(
                infoVuelo.builder()
                        .origen("Miami")
                        .destino("Los Angeles")
                        .fechaHoraSalida(new Date())
                        .fechaHoraLlegada(new Date())
                        .id("66865").idAvion("94491").build(),
                new infoVuelo("Los Angeles",
                        "Miami",
                        new Date(),
                        new Date(),
                        "240207",
                        "240207"
                ),
                new infoVuelo("Los Angeles",
                        "Miami",
                        new Date(),
                        new Date(),
                        "672003",
                        "672003"
                )
        );
    }
}
