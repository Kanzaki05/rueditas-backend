package pe.edu.Cibertec.rueditas_backend.service;

import pe.edu.Cibertec.rueditas_backend.dto.PlacaRequestDTO;

import java.io.IOException;

public interface VerificacionService {

    String[] mostrarDatos(PlacaRequestDTO placaRequestDTO) throws IOException;

}
