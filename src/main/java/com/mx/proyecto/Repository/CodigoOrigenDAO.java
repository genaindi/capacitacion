package com.mx.proyecto.Repository;

import java.util.List;

import com.mx.proyecto.Entity.CodigoOrigenEntity;

public interface CodigoOrigenDAO extends DAO<CodigoOrigenEntity, Long>{

	List<CodigoOrigenEntity> obtieneCodigoOrigen();
	
	

}
