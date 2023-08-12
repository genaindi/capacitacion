package com.mx.proyecto.Repository;

import java.util.List;

import com.mx.proyecto.Entity.TipoTrabajadorEntity;

public interface CataTipoTrabajadorDAO extends DAO<TipoTrabajadorEntity, Long>{

	List<TipoTrabajadorEntity> obtieneTipoTrabajador();
	
	

}
