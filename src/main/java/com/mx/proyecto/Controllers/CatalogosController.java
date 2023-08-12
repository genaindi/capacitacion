package com.mx.proyecto.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mx.proyecto.Entity.catEstados;
import com.mx.proyecto.Entity.catRoles;
import com.mx.proyecto.Services.CatalogosService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="catalogos")
public class CatalogosController {
	
	@Autowired
	private CatalogosService catalogosService;

	// UNA CONSULTA PARA OBTENER TODOS LOS ROLES EXISTENTES PRESENTARLOS EN UN COMBO
	// BOX PARA QUE EL USUARIO ELIJA EL ROL
	@ResponseBody
	@RequestMapping(value = "/getRoles", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<catRoles>> obtenerRoles() {
		final HttpHeaders httpHeaders = new HttpHeaders();

		List<catRoles> respuesta = catalogosService.getRoles();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<List<catRoles>>(respuesta, httpHeaders, HttpStatus.OK);
	}


	// UNA CONSULTA PARA OBTENER TODOS LOS ROLES EXISTENTES PRESENTARLOS EN UN COMBO
	// BOX PARA QUE EL USUARIO ELIJA EL ESTADO
	@ResponseBody
	@RequestMapping(value = "/getEstados", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<catEstados>> obtenerEstados() {
		final HttpHeaders httpHeaders = new HttpHeaders();

		List<catEstados> respuesta = catalogosService.getEstados();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<List<catEstados>>(respuesta, httpHeaders, HttpStatus.OK);
	}

}//FIN DE LA CLASE
