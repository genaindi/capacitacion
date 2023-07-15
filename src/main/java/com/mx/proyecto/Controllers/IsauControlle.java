package com.mx.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mx.proyecto.Dto.MisEmpleadosDTO;
import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Services.MisEmpleadosService;

@Controller
@RequestMapping(value = "misEmpleados")
public class MisEmpleadosController {

	@Autowired
	private MisEmpleadosService misEmpleadosService;// es la inyeccion de dependencias

	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/getEmpleadosPorRfc", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto getEmpleadosPorRfc(@RequestBody MisEmpleadosDTO rfc) {

		return misEmpleadosService.getEmpleadosPorRfc(rfc);
	}

	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/getEmpleadasFemeninas", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto getEmpleadasFemeninas(@RequestBody MisEmpleadosDTO datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		return misEmpleadosService.getEmpleadasFemeninas(datos);
	}

	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/getEmpleadosMasculinos2", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto getEmpleadosMasculinos2(@RequestBody MisEmpleadosDTO datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		return misEmpleadosService.getEmpleados(datos);
	}

	// SERVICION PARA ELIMINAR REGISTRO PARTE 3
	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/eliminarEmpleado3", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto eliminarEmpleado3(@RequestBody MisEmpleadosDTO idEmpleado) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		return misEmpleadosService.eliminarEmpleado3(idEmpleado);
	}

	// SERVICIO PARA ACTUALIZAR EMPLEADOS ACTIVOS
	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/actualizarActivos", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto actualizarActivos(@RequestBody MisEmpleadosDTO idEmpleado) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		return misEmpleadosService.actualizarActivos(idEmpleado);
	}

	// SERVICIO PARA ACTUALIZAR EMPLEADOS ACTIVOS
	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/insertMisEmpleados", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto insertMisEmpleados(@RequestBody MisEmpleadosDTO datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		return misEmpleadosService.insertMisEmpleados(datos);
	}
	
	//SERVICIO PARA INSERTAR UN USUARIO
		@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
		@RequestMapping(value="/insertMisEmpleados2", method= RequestMethod.POST, produces = "application/json")
		ResponseEntity <ResponseDto> insertMisEmpleados2(@RequestBody MisEmpleadosDTO nuevoUsuario){
			final HttpHeaders httpHeaders = new HttpHeaders();
			
			ResponseDto response = misEmpleadosService.insertMisEmpleados2(nuevoUsuario);
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);
		}
		
		//SERVICIO PARA INSERTAR UN EMPLEADO QUE NO ESTA EN LA BASE DE DATOS
		@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
		@RequestMapping(value = "/insertMisEmpleados3", method = RequestMethod.POST, produces = "application/json")
		public ResponseDto insertMisEmpleados3(@RequestBody MisEmpleadosDTO nuevoUsuario) {

			return misEmpleadosService.insertMisEmpleados3(nuevoUsuario);
		}

	}// FIN DE LA CLASE
