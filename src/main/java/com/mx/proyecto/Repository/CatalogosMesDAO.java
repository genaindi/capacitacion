package com.mx.proyecto.Repository;

import java.util.List;

import com.mx.proyecto.Entity.AnioEntity;
import com.mx.proyecto.Entity.MesEntity;

public interface CatalogosMesDAO extends DAO<MesEntity, Long>{

	List<MesEntity> obtieneMes();
	
}
