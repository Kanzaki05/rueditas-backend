package pe.edu.Cibertec.rueditas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.Cibertec.rueditas_backend.dto.PlacaRequestDTO;
import pe.edu.Cibertec.rueditas_backend.dto.PlacaResponseDTO;
import pe.edu.Cibertec.rueditas_backend.service.VerificacionService;

@RestController
@RequestMapping("/verificacion")
public class VerificacionController {

    @Autowired
    VerificacionService verificacionService;

    @PostMapping("/buscarauto")
    public PlacaResponseDTO placa(@RequestBody PlacaRequestDTO placaRequestDTO){

        try {

            String[] datosPlaca = verificacionService.mostrarDatos(placaRequestDTO);
            if (datosPlaca == null){
                return new PlacaResponseDTO("01","Error: No se encontró un vehículo para la placa ingresada","","","","","");
            }
            return new PlacaResponseDTO("00","",datosPlaca[0],datosPlaca[1],datosPlaca[2],datosPlaca[3],datosPlaca[4]);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new PlacaResponseDTO("99","Error: Ocurrio un problema","","","","","");

        }

    }

}
