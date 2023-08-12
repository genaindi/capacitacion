package com.mx.proyecto.Services;

import com.mx.proyecto.Dto.AforeDTO;
import com.mx.proyecto.Dto.MisEmpleadosDTO;
import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Entity.Afore;

public interface AforeService {

	ResponseDto insertAfiliado(AforeDTO nuevoTrabajador);

	ResponseDto getMostrarTabla();

	ResponseDto insertAfiliado2(AforeDTO nuevoAfiliado);

	ResponseDto getAfiliadoPorId(AforeDTO datoId);

	ResponseDto eliminarAfiliado(AforeDTO idAfiliado);

	ResponseDto actualizarAfiliado(Afore datos);

}//FIN DE LA CLASE
