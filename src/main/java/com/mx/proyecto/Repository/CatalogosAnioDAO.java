package com.mx.proyecto.Repository;

import java.util.List;

import com.mx.proyecto.Entity.AnioEntity;

public interface CatalogosAnioDAO extends DAO<AnioEntity, Long>{

	List<AnioEntity> obtieneAnio();

}//FIN DE LA CLASE

