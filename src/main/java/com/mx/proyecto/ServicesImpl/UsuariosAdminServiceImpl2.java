package com.mx.proyecto.ServicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Entity.UsuariosAdmin;
import com.mx.proyecto.Repository.UsuariosAdminDAO2;
import com.mx.proyecto.Services.UsuariosAdminService2;

@Service
public class UsuariosAdminServiceImpl2 implements UsuariosAdminService2{//CAPA DEL NEGOCIO
	
	@Autowired
	private UsuariosAdminDAO2 usuariosAdminDAO2;

	//CODIGOS HTTP
	//404 - NO ENCONTRADO
	//500 - ERROR INTERNO EN EL SERVIDOR
	//401 - FALTA DE PERMISOS (FALTA DE ROLES)
	//200 - OK
	//
	
	@Override
	public ResponseDto getUsuarios() {
		ResponseDto responde = new ResponseDto();
		
		try {
		List<UsuariosAdmin> listaUsuarios = usuariosAdminDAO2.obtieneUsuarios();
		
		System.out.println("Imprimir resultado --> " + listaUsuarios);
		
		if(listaUsuarios !=null) {//ES DIFERENTE DE NULO, ESTO QUIERE DECIR QUE SI TIENE UNA LISTA DE USUARIOS
			responde.setCode(200);//OK
			responde.setMessage("Lista de usuarios");
			responde.setList(listaUsuarios);
		}else {
			responde.setCode(100);//OK
		}
		
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: getUsuarios");
			
		}
		
		return responde;
	}
	
	// ESTE SERVICIO DE GET USUARIOS SI ESTA FUNCIONANDO
	/*
	 * 	@Override
	public ResponseDto getUsuarios() {
		
		ResponseDto responde = new ResponseDto();
		
		try {
		List<UsuariosAdmin> listaUsuarios = usuariosAdminDAO2.obtieneUsuarios();
		responde.setContent(200);//OK
		responde.setMessage("Lista de usuarios");
		responde.setList(listaUsuarios);
		
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: getUsuarios");
			
		}
		
		return responde;
	}
	 * 
	 * */

	
	/*1.- SI TODOS LOS DATOS DEBEN SER OBLIGATORIOS
		1.1.- CAMPOS OBLIGATORIOS: NOMBRE COMPLETO, EDAD Y DIRECCION
	  2.- LOS CAMPOS NO VENGAN EN NULL, QUE CONTENGA INFORMACION
	*/
	
	@Override
	public ResponseDto insertUsuariosAdmin(UsuariosAdminDTO nuevoUsuario) {
		ResponseDto responde = new ResponseDto();

		try {
			
			
			if(nuevoUsuario != null) {//SI ES DIFERENTE DE NULL, QUE NO VENGA VACIO. SE CUMPLE LA 2DA REGLA
				//OPERADORES
				//&& --> AND,  LA CONDICION ES UNO Y LA OTRA
				//|| --> OR, LA CONDICION ES UNO O LA OTRA
				
				if(nuevoUsuario.getNombreCompleto() !=null && !nuevoUsuario.getNombreCompleto().isEmpty() 
						&& nuevoUsuario.getEdad() !=0 && nuevoUsuario.getDireccion() !=null 
						&& !nuevoUsuario.getDireccion().isEmpty()) {
				
				UsuariosAdmin datos = new UsuariosAdmin();
				datos.setIdUser(nuevoUsuario.getIdUser());
				datos.setNombreCompleto(nuevoUsuario.getNombreCompleto());
				datos.setEdad(nuevoUsuario.getEdad());
				datos.setDireccion(nuevoUsuario.getDireccion());
				datos.setEstado(nuevoUsuario.getEstado());
				datos.setRol(nuevoUsuario.getRol());
				
				usuariosAdminDAO2.create(datos);//INSERTANDO REGISTROS EN LA TABLA
				
				responde.setCode(200);//OK
				responde.setMessage("Los datos se guardaron correctamente");
				}else {
					responde.setCode(300);//
					responde.setMessage("Los datos obligatorios vienen vacios (Nombre Completo, Edad y Direccion");
				}
				
			}else {
				responde.setCode(400);//
				responde.setMessage("Los datos vienen vacios");
			}
			
						
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: insertUsuariosAdmin");
		}
		return responde;
	}
	
	//ESTE SERVICIO DE INSERT USUARIOS SI FUNCIONA
	/*
	 * 	@Override
	public ResponseDto insertUsuariosAdmin(UsuariosAdminDTO nuevoUsuario) {
		ResponseDto responde = new ResponseDto();

		try {
			
			UsuariosAdmin datos = new UsuariosAdmin();
			datos.setIdUser(nuevoUsuario.getIdUser());
			datos.setNombreCompleto(nuevoUsuario.getNombreCompleto());
			datos.setEdad(nuevoUsuario.getEdad());
			datos.setDireccion(nuevoUsuario.getDireccion());
			datos.setEstado(nuevoUsuario.getEstado());
			datos.setRol(nuevoUsuario.getRol());
			
			usuariosAdminDAO2.create(datos);//INSERTANDO REGISTROS EN LA TABLA
			
			responde.setCode(200);//OK
			responde.setMessage("Los datos se guardaron correctamente");
			
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: insertUsuariosAdmin");
		}
		return null;
	}
	 * */
	
	//SERVICIO PARA ELIMINAR UN USUARIO
	@Override
	public ResponseDto eliminarUsuario(UsuariosAdminDTO idUser) {
		ResponseDto responde = new ResponseDto();
		
		try {
			
			usuariosAdminDAO2.delete(idUser.getIdUser());//ELIMINAR UN REGISTRO DE LA TABLA
			
			responde.setCode(200);//OK
			responde.setMessage("Los datos se eliminaron correctamente");
			
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: eliminarUsuario");
		}
		return responde;
	}

	
	//SERVICIO PARA ACTUALIZAR UN REGISTRO
	@Override
	public ResponseDto actualizarUsuario(UsuariosAdmin datos) {
		ResponseDto responde = new ResponseDto();
		
		try {
			
			usuariosAdminDAO2.update(datos);//ACTUALIZAR UN REGISTRO DE LA TABLA
			
			responde.setCode(200);//OK
			responde.setMessage("Los datos se actualizaron correctamente");
			
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: actualizarUsuario");
		}		return responde;
	}

	
	//CONSULTAR POR EL CAMPO ESTADO
	@Override
	public ResponseDto getUsuariosPorEstado(UsuariosAdminDTO datos) {
		ResponseDto responde = new ResponseDto();

		try {
			
			UsuariosAdmin resultado = usuariosAdminDAO2.consultaPorEstado(datos.getEstado());
			
			responde.setCode(200);//OK
			responde.setMessage("Consulta por estado");
			responde.setContent(resultado);
			
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: getUsuariosPorEstado");
		}
		return responde;
	}

	//SERVICIO PARA CONSULTAR LA INFORMACION POR ID
	//SELECT * FROM TABLA WHERE ID = 5
	@Override
	public ResponseDto getUsuariosPorId(UsuariosAdminDTO datos) {
		ResponseDto responde = new ResponseDto();

		try {
			
			UsuariosAdmin resulConsult = usuariosAdminDAO2.read(datos.getIdUser());
			
			responde.setCode(200);//OK
			responde.setMessage("Consulta por id");
			responde.setContent(resulConsult);
			
		}catch(Exception e) {
			responde.setCode(500);//ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: UsuariosAdminServiceImpl2 y en el metodo: getUsuariosPorEstado");
		}
		return responde;
	}

	
	
}//FIN DE LA CLASE
