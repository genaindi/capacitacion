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
import com.mx.proyecto.Dto.AforeDTO;
import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Entity.Afore;
import com.mx.proyecto.Entity.UsuariosAdmin;
import com.mx.proyecto.Services.AforeService;

@Controller
@RequestMapping(value = "guardarAfore")
public class AforeController {
	
	@Autowired
	private AforeService aforeService;
	
	@RequestMapping(value="/vistaAfiliados")// SERVICIO PARA REDIRECCIONAR AL MODULO USUARIOS ADMIN
	public String redireccionaVistaAfiliados() {
		
		return "VistaAfiliados";//REDIRECCIONA A LA VISTA DE USUARIOS ADMIN
		
	}

	// SERVICIO PARA INSERTAR UN EMPLEADO QUE NO ESTA EN LA BASE DE DATOS
	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/insertAfiliado", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto insertAfiliado(@RequestBody AforeDTO nuevoTrabajador) {

		return aforeService.insertAfiliado(nuevoTrabajador);
	}

	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/getMostrarTabla", method = RequestMethod.GET, produces = "application/json")
	public ResponseDto getMostrarTabla() {
		final HttpHeaders httpHeaders = new HttpHeaders();

		return aforeService.getMostrarTabla();
	}

	// SERVICIO PARA INSERTAR UN USUARIO
	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/insertAfiliado2", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> insertAfiliado2(@RequestBody AforeDTO nuevoAfiliado) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto response = aforeService.insertAfiliado2(nuevoAfiliado);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}

	// SERVICIO PARA CONSULTAR LA INFORMACION POR ID
	// SELECT * FROM TABLA WHERE ID = 5
	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/getAfiliadoPorId", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto getAfiliadoPorId(@RequestBody AforeDTO datoId) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		return aforeService.getAfiliadoPorId(datoId);
	}

	// SERVICION PARA ELIMINAR REGISTRO
	@ResponseBody // NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value = "/eliminarAfiliado", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> eliminarAfiliado(@RequestBody AforeDTO idAfiliado) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto respuesta = aforeService.eliminarAfiliado(idAfiliado);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<ResponseDto>(respuesta, httpHeaders, HttpStatus.OK);
	}	
	
	
	//SERVICION PARA ACTUALIZAR UN REGISTRO
			@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
			@RequestMapping(value="/actualizarAfiliado", method= RequestMethod.POST, produces = "application/json")
			ResponseEntity <ResponseDto> actualizarAfiliado(@RequestBody Afore datos){
				final HttpHeaders httpHeaders = new HttpHeaders();
				
				ResponseDto respuesta = aforeService.actualizarAfiliado(datos);
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);
			}	

}// FIN DE LA CLASE
