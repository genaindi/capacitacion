package com.mx.proyecto.Repository;

import java.util.List;

import com.mx.proyecto.Entity.EstatusActividadEntity;

public interface CataEstatusActividadDAO extends DAO<EstatusActividadEntity, Long>{


	List<EstatusActividadEntity> obtieneEstatus();
	
	

}
