package com.mx.proyecto.ServicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.proyecto.Dto.MisEmpleadosDTO;
import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Entity.MisEmpleados;
import com.mx.proyecto.Repository.MisEmpleadosDAO;
import com.mx.proyecto.Services.MisEmpleadosService;

@Service
public class MisEmpleadosServiceImpl implements MisEmpleadosService{
	
	@Autowired
	private MisEmpleadosDAO misEmpleadosDAO;

	// CONSULTAR POR RFC
	@Override
	public ResponseDto getEmpleadosPorRfc(MisEmpleadosDTO rfc) {
		ResponseDto responde = new ResponseDto();

		try {
			MisEmpleados resultado = misEmpleadosDAO.consultaPorRfc(rfc.getRfc());
			System.out.println("rfc" + resultado);

			responde.setCode(200);// OK
			responde.setMessage("El registro se busco correctamente");
			responde.setContent(resultado);

		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage(
					"Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: getEmpleadosPorRfc");
		}

		return responde;
	}

	@Override
	public ResponseDto getEmpleadasFemeninas(MisEmpleadosDTO datos) {
		ResponseDto responde = new ResponseDto();

		try {

			List<MisEmpleados> listaEmpleados = misEmpleadosDAO.obtieneEmpleadas(datos.getSexo(), datos.getEdad());

			responde.setCode(200);// OK
			responde.setMessage("Lista de usuarios");
			responde.setList(listaEmpleados);

		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage(
					"Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: getEmpleadasFemeninas");

		}

		return responde;
	}

	@Override
	public ResponseDto getEmpleados(MisEmpleadosDTO datos) {
		ResponseDto responde = new ResponseDto();

		try {

			List<MisEmpleados> listaEmpleados = misEmpleadosDAO.obtieneEmpleados(datos.getSexo());

			responde.setCode(200);// OK
			responde.setMessage("Lista de usuarios");
			responde.setList(listaEmpleados);

		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage("Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: getEmpleados");

		}

		return responde;
	}

	@Override
	public ResponseDto eliminarEmpleado3(MisEmpleadosDTO idEmpleado) {
		ResponseDto responde = new ResponseDto();

		try {

			MisEmpleados resulConsultBaja = misEmpleadosDAO.read(idEmpleado.getIdEmpleado());

			if (resulConsultBaja.getActivo() == 0) {

				misEmpleadosDAO.delete(idEmpleado.getIdEmpleado());// ELIMINAR UN REGISTRO DE LA TABLA

				responde.setCode(200);// OK
				responde.setMessage("Empleado eliminado correctamente");
			} else {
				responde.setCode(300);// OK
				responde.setMessage("Imposible eliminar Empleado, Sigue Laborando (Activo)...! ");

			}
		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage(
					"Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: eliminarEmpleado");
		}
		return responde;
	}

	@Override
	public ResponseDto actualizarActivos(MisEmpleadosDTO idEmpleado) {
		ResponseDto responde = new ResponseDto();

		try {

			MisEmpleados resulActualActivo = misEmpleadosDAO.read(idEmpleado.getIdEmpleado());

			if (resulActualActivo.getActivo() == 1) {

				MisEmpleados datos = new MisEmpleados();
				datos.setIdEmpleado(idEmpleado.getIdEmpleado());
				datos.setNombreCompleto(idEmpleado.getNombreCompleto());
				datos.setRfc(idEmpleado.getRfc());
				datos.setCurp(idEmpleado.getCurp());
				datos.setEdad(idEmpleado.getEdad());
				datos.setSexo(idEmpleado.getSexo());
				datos.setDireccion(idEmpleado.getDireccion());
				datos.setNss(idEmpleado.getNss());
				datos.setTelefono(idEmpleado.getTelefono());
				datos.setActivo(idEmpleado.getActivo());

				misEmpleadosDAO.update(datos);// ACTUALIZAR UN REGISTRO DE LA TABLA

				responde.setCode(200);// OK
				responde.setMessage("Empleado se actualizo correctamente");
			} else {
				responde.setCode(300);// OK
				responde.setMessage("El empleado esta dado de baja, No puede actualizar su informacion.!");

			}
		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage(
					"Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: actualizarActivos");
		}
		return responde;
	}

	@Override
	public ResponseDto insertMisEmpleados(MisEmpleadosDTO datos) {
		ResponseDto responde = new ResponseDto();

		try {

			MisEmpleados consultaNombre = misEmpleadosDAO.read(datos.getIdEmpleado());

			if (consultaNombre.getNombreCompleto() != consultaNombre.getNombreCompleto()) {

				MisEmpleados insertar = new MisEmpleados();
				insertar.setIdEmpleado(datos.getIdEmpleado());
				insertar.setNombreCompleto(datos.getNombreCompleto());
				insertar.setRfc(datos.getRfc());
				insertar.setCurp(datos.getCurp());
				insertar.setEdad(datos.getEdad());
				insertar.setSexo(datos.getSexo());
				insertar.setDireccion(datos.getDireccion());
				insertar.setNss(datos.getNss());
				insertar.setTelefono(datos.getTelefono());
				insertar.setActivo(datos.getActivo());

				misEmpleadosDAO.create(insertar);// INSERTANDO REGISTROS EN LA TABLA

				responde.setCode(200);// OK
				responde.setMessage("Empleado se inserto correctamente");
			} else {
				responde.setCode(300);// OK
				responde.setMessage("El empleado ya existe en la base de datos. No puede insertar su informacion.!");

			}
		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage(
					"Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: insertMisEmpleados");
		}
		return responde;
	}

	@Override
	public ResponseDto insertMisEmpleados2(MisEmpleadosDTO nuevoUsuario) {
		ResponseDto responde = new ResponseDto();
		
		try {

			MisEmpleados consultaNombre = misEmpleadosDAO.read(nuevoUsuario.getIdEmpleado());

			if (consultaNombre.getNombreCompleto() != nuevoUsuario.getNombreCompleto()) {

				MisEmpleados insertar = new MisEmpleados();
				insertar.setIdEmpleado(nuevoUsuario.getIdEmpleado());
				insertar.setNombreCompleto(nuevoUsuario.getNombreCompleto());
				insertar.setRfc(nuevoUsuario.getRfc());
				insertar.setCurp(nuevoUsuario.getCurp());
				insertar.setEdad(nuevoUsuario.getEdad());
				insertar.setSexo(nuevoUsuario.getSexo());
				insertar.setDireccion(nuevoUsuario.getDireccion());
				insertar.setNss(nuevoUsuario.getNss());
				insertar.setTelefono(nuevoUsuario.getTelefono());
				insertar.setActivo(nuevoUsuario.getActivo());

				misEmpleadosDAO.create(insertar);// INSERTANDO REGISTROS EN LA TABLA

				responde.setCode(200);// OK
				responde.setMessage("Empleado se inserto correctamente");
			} else {
				responde.setCode(300);// OK
				responde.setMessage("El empleado ya existe en la base de datos. No puede insertar su informacion.!");

			}
		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage(
					"Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: insertMisEmpleados");
		}
		return responde;
	}

	@Override
	public ResponseDto insertMisEmpleados3(MisEmpleadosDTO nuevoUsuario) {
ResponseDto responde = new ResponseDto();
		
		try {

			MisEmpleados consultaNombre = misEmpleadosDAO.consultaExistencia(nuevoUsuario.getRfc(), nuevoUsuario.getCurp());

			if (consultaNombre.getRfc() == null && consultaNombre.getCurp() == null) {

				MisEmpleados insertar = new MisEmpleados();
				insertar.setIdEmpleado(nuevoUsuario.getIdEmpleado());
				insertar.setNombreCompleto(nuevoUsuario.getNombreCompleto());
				insertar.setRfc(nuevoUsuario.getRfc());
				insertar.setCurp(nuevoUsuario.getCurp());
				insertar.setEdad(nuevoUsuario.getEdad());
				insertar.setSexo(nuevoUsuario.getSexo());
				insertar.setDireccion(nuevoUsuario.getDireccion());
				insertar.setNss(nuevoUsuario.getNss());
				insertar.setTelefono(nuevoUsuario.getTelefono());
				insertar.setActivo(nuevoUsuario.getActivo());

				misEmpleadosDAO.create(insertar);// INSERTANDO REGISTROS EN LA TABLA

				responde.setCode(200);// OK
				responde.setMessage("Empleado se inserto correctamente");
			} else {
				responde.setCode(300);// OK
				responde.setMessage("El empleado ya existe en la base de datos. No puede insertar su informacion.!");

			}
		} catch (Exception e) {
			responde.setCode(500);// ERROR INTERNO
			responde.setMessage(
					"Ocurrio un error en la clase: MisEmpleadosServiceImpl y en el metodo: insertMisEmpleados");
		}
		return responde;
	}
	

	
	
}//FIN DE LA CLASE
