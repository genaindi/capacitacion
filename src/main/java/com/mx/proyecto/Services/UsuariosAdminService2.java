package com.mx.proyecto.Services;

import com.mx.proyecto.Dto.ResponseDto;
import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Entity.UsuariosAdmin;

public interface UsuariosAdminService2 {

	ResponseDto getUsuarios();

	ResponseDto insertUsuariosAdmin(UsuariosAdminDTO nuevoUsuario);

	ResponseDto eliminarUsuario(UsuariosAdminDTO idUser);

	ResponseDto actualizarUsuario(UsuariosAdmin datos);

	ResponseDto getUsuariosPorEstado(UsuariosAdminDTO datos);

	ResponseDto getUsuariosPorId(UsuariosAdminDTO datos);

		
	
}//FIN DE LA CLASE
