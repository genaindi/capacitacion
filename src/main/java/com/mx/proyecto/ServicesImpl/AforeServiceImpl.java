package com.mx.proyecto.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.proyecto.Dto.AforeDTO;
import com.mx.proyecto.Dto.MisEmpleadosDTO;
import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Entity.Afore;
import com.mx.proyecto.Entity.MisEmpleados;
import com.mx.proyecto.Entity.UsuariosAdmin;
import com.mx.proyecto.Repository.AforeDAO;
import com.mx.proyecto.Services.AforeService;

@Service
public class AforeServiceImpl implements AforeService{
	
	@Autowired
	private AforeDAO aforeDAO;

	@Override
	public ResponseDto insertAfiliado(AforeDTO nuevoTrabajador) {
		ResponseDto response = new ResponseDto();
		
		try {

		//	if (consultaNombre == null) {

				Afore insertar = new Afore();
				insertar.setIdTrabajador(nuevoTrabajador.getIdTrabajador());
				insertar.setAnio(nuevoTrabajador.getAnio());
				insertar.setMes(nuevoTrabajador.getMes());
				insertar.setNss(nuevoTrabajador.getNss());
				insertar.setCurp(nuevoTrabajador.getCurp());
				insertar.setEstatusActividad(nuevoTrabajador.getEstatusActividad());
				insertar.setTipoTrabajador(nuevoTrabajador.getTipoTrabajador());
				insertar.setEstatusCuenta(nuevoTrabajador.getEstatusCuenta());
				insertar.setCodigoOrigen(nuevoTrabajador.getCodigoOrigen());
				insertar.setRegimenAfiliacion(nuevoTrabajador.getRegimenAfiliacion());
				insertar.setIndicadorSaldo(nuevoTrabajador.getIndicadorSaldo());
				
				aforeDAO.create(insertar);// INSERTANDO REGISTROS EN LA TABLA

				response.setCode(200);// OK
				response.setMessage("Trabajador se inserto correctamente");
		//	} else {
		//		response.setCode(300);// OK
		//		response.setMessage("El empleado ya existe en la base de datos. No puede insertar su informacion.!");

		//	}
		} catch (Exception e) {
			response.setCode(500);// ERROR INTERNO
			response.setMessage(
					"Ocurrio un error en la clase: AforeServiceImpl y en el metodo: insertAfiliado");
		}
		return response;
	}


	@Override
	public ResponseDto getMostrarTabla() {
		ResponseDto response = new ResponseDto();

		try {
			List<Afore> listaTabla = aforeDAO.obtieneTabla();

			response.setCode(200);// OK
			response.setMessage("La tabla se encontro correctamente");
			response.setList(listaTabla);

		} catch (Exception e) {
			response.setCode(500);// ERROR INTERNO
			response.setMessage(
					"Ocurrio un error en la clase: AforeServiceImpl y en el metodo: getMostraTabla");
		}

		return response;
	}


	@Override
	public ResponseDto insertAfiliado2(AforeDTO nuevoAfiliado) {
		ResponseDto response = new ResponseDto();

		try {
			
			
			if(nuevoAfiliado != null) {//SI ES DIFERENTE DE NULL, QUE NO VENGA VACIO. SE CUMPLE LA 2DA REGLA
				//OPERADORES
				//&& --> AND,  LA CONDICION ES UNO Y LA OTRA
				//|| --> OR, LA CONDICION ES UNO O LA OTRA
				
				if( nuevoAfiliado.getNss() !=0 && nuevoAfiliado.getCurp() !=null 
						&& !nuevoAfiliado.getCurp().isEmpty()) {
					
					Afore insertar = new Afore();
					
					insertar.setIdTrabajador(nuevoAfiliado.getIdTrabajador());
					insertar.setIdTrabajador(aforeDAO.obtenValorSecuencia());							
					insertar.setAnio(nuevoAfiliado.getAnio());
					insertar.setMes(nuevoAfiliado.getMes());
					insertar.setNss(nuevoAfiliado.getNss());
					insertar.setCurp(nuevoAfiliado.getCurp());
					insertar.setEstatusActividad(nuevoAfiliado.getEstatusActividad());
					insertar.setTipoTrabajador(nuevoAfiliado.getTipoTrabajador());
					insertar.setEstatusCuenta(nuevoAfiliado.getEstatusCuenta());
					insertar.setCodigoOrigen(nuevoAfiliado.getCodigoOrigen());
					insertar.setRegimenAfiliacion(nuevoAfiliado.getRegimenAfiliacion());
					insertar.setIndicadorSaldo(nuevoAfiliado.getIndicadorSaldo());
				
					aforeDAO.create(insertar);//INSERTANDO REGISTROS EN LA TABLA
				
					response.setCode(200);//OK
					response.setMessage("Los datos se guardaron correctamente");
				}else {
					response.setCode(300);//
					response.setMessage("Los datos obligatorios vienen vacios (NSS y CURP");
				}
				
			}else {
				response.setCode(400);//
				response.setMessage("Los datos vienen vacios");
			}
			
						
		}catch(Exception e) {
			response.setCode(500);//ERROR INTERNO
			response.setMessage("Ocurrio un error en la clase: AforeServiceImpl y en el metodo: insertAfiliado2");
		}
		return response;
	}


	@Override
	public ResponseDto getAfiliadoPorId(AforeDTO datoId) {
		ResponseDto response = new ResponseDto();

		try {
			
			Afore resulConsult = aforeDAO.read(datoId.getIdTrabajador());
			
			response.setCode(200);//OK
			response.setMessage("Consulta por id");
			response.setContent(resulConsult);
			
		}catch(Exception e) {
			response.setCode(500);//ERROR INTERNO
			response.setMessage("Ocurrio un error en la clase: AforeServiceImpl y en el metodo: getAfiliadoPorId");
		}
		return response;
	}


	@Override
	public ResponseDto eliminarAfiliado(AforeDTO idAfiliado) {
		ResponseDto response = new ResponseDto();
		
		try {
			
			aforeDAO.delete(idAfiliado.getIdTrabajador());//ELIMINAR UN REGISTRO DE LA TABLA
			
			response.setCode(200);//OK
			response.setMessage("Los datos se eliminaron correctamente");
			
		}catch(Exception e) {
			response.setCode(500);//ERROR INTERNO
			response.setMessage("Ocurrio un error en la clase: AforeServiceImpl y en el metodo: eliminarAfiliado");
		}
		return response;
	}


	@Override
	public ResponseDto actualizarAfiliado(Afore datos) {
		ResponseDto response = new ResponseDto();
		
		try {
			
			aforeDAO.update(datos);//ACTUALIZAR UN REGISTRO DE LA TABLA
			
			response.setCode(200);//OK
			response.setMessage("Los datos se actualizaron correctamente");
			
		}catch(Exception e) {
			response.setCode(500);//ERROR INTERNO
			response.setMessage("Ocurrio un error en la clase: AforeServiceImpl y en el metodo: actualizarAfiliado");
		}		return response;
	}

}//FIN DE LA CLASE
