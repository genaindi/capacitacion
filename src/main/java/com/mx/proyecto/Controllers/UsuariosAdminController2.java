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
import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Entity.UsuariosAdmin;
import com.mx.proyecto.Services.UsuariosAdminService2;

@Controller
@RequestMapping(value="usuariosHibernate2")
public class UsuariosAdminController2 {
	
	@Autowired
	private UsuariosAdminService2 usuariosAdminService2;//es la inyeccion de dependencias
	
	@RequestMapping(value="/vistaUsuarios")// SERVICIO PARA REDIRECCIONAR AL MODULO USUARIOS ADMIN
	public String redireccionaVistasUsuarios() {
		
		return "VistasUsuariosAdmin";//REDIRECCIONA A LA VISTA DE USUARIOS ADMIN
		
	}
	
	
	@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value="/getUsuariosAdmin", method= RequestMethod.GET, produces = "application/json")
	public ResponseDto  getUsuariosAdmin(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		return usuariosAdminService2.getUsuarios();
	}
	
	
	//SERVICIO PARA INSERTAR UN USUARIO
	@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value="/insertUsuarios", method= RequestMethod.POST, produces = "application/json")
	ResponseEntity <ResponseDto> insertUsuarios(@RequestBody UsuariosAdminDTO nuevoUsuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseDto response = usuariosAdminService2.insertUsuariosAdmin(nuevoUsuario);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);
	}
	
	//SERVICION PARA ELIMINAR REGISTRO
	@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
	@RequestMapping(value="/eliminarUsuario", method= RequestMethod.POST, produces = "application/json")
	ResponseEntity <ResponseDto> eliminarUsuario(@RequestBody UsuariosAdminDTO idUser){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseDto respuesta = usuariosAdminService2.eliminarUsuario(idUser);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);
	}	
	
	//SERVICION PARA ACTUALIZAR UN REGISTRO
		@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
		@RequestMapping(value="/actualizarDatos", method= RequestMethod.POST, produces = "application/json")
		ResponseEntity <ResponseDto> actualizarDatosUsuario(@RequestBody UsuariosAdmin datos){
			final HttpHeaders httpHeaders = new HttpHeaders();
			
			ResponseDto respuesta = usuariosAdminService2.actualizarUsuario(datos);
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);
		}	
		
		//SERVICIO PARA HACER UNA BUSQUEDA POR X DATO
		//SELECT * FROM  TABLA WHERE CURP/RFC/STATUS = "SDFASDFA"
		@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
		@RequestMapping(value="/getUsuariosPorEstado", method= RequestMethod.POST, produces = "application/json")
		public ResponseDto  getUsuariosPorEstado(@RequestBody UsuariosAdminDTO datos){
			final HttpHeaders httpHeaders = new HttpHeaders();
			
			return usuariosAdminService2.getUsuariosPorEstado(datos);
		}
		
		//SERVICIO PARA CONSULTAR LA INFORMACION POR ID
		//SELECT * FROM TABLA WHERE ID = 5
		@ResponseBody //NOS PERMITE RETORNAR DATOS Y NO SOLO UNA VISTA
		@RequestMapping(value="/getUsuariosPorId", method= RequestMethod.POST, produces = "application/json")
		public ResponseDto  getUsuariosPorId(@RequestBody UsuariosAdminDTO datos){
			final HttpHeaders httpHeaders = new HttpHeaders();
			
			return usuariosAdminService2.getUsuariosPorId(datos);
		}

}//FIN DE LA CLASE
