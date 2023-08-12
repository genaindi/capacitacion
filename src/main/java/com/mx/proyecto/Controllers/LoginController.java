package com.mx.proyecto.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value = "LoginService")//LOGIN SE MANDA A LLAMAR DESDE INDEX.JSP, SE USA PARA REDIRECCIONAR AL ARCHIVO LOGIN.JSP
	public String Login() {
		
		return "Login";//LOGIN --> ES EL ARCHIVO LOGIN.JSP QUE SE ENCUENTRA EN LA RUTA WEB-INF/VIEWS/LOGIN.JSP
	}
	
	@RequestMapping(value = "Inicio")//Inicio SE MANDA A LLAMAR DESDE SECUTIRYCONFIG
	public String Inicio() {
		
		return "Inicio";//LOGIN --> ES EL ARCHIVO LOGIN.JSP QUE SE ENCUENTRA EN LA RUTA WEB-INF/VIEWS/Inicio.JSP
	}

}
