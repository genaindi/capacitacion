package com.mx.proyecto.Services;

import com.mx.proyecto.Dto.MisEmpleadosDTO;
import com.mx.proyecto.Dto.ResponseDto;

public interface MisEmpleadosService {

	ResponseDto getEmpleadosPorRfc(MisEmpleadosDTO rfc);//OK

	ResponseDto getEmpleadasFemeninas(MisEmpleadosDTO datos);

	ResponseDto getEmpleados(MisEmpleadosDTO datos);

	ResponseDto eliminarEmpleado3(MisEmpleadosDTO idEmpleado);

	ResponseDto actualizarActivos(MisEmpleadosDTO idEmpleado);

	ResponseDto insertMisEmpleados(MisEmpleadosDTO datos);

	ResponseDto insertMisEmpleados2(MisEmpleadosDTO nuevoUsuario);

	ResponseDto insertMisEmpleados3(MisEmpleadosDTO nuevoUsuario);


}//FIN DE LA CLASE
