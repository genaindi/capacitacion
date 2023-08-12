package com.mx.proyecto.Repository;

import java.util.List;
import com.mx.proyecto.Entity.RegimenAfilEntity;

public interface RegimenAfilDAO extends DAO<RegimenAfilEntity, Long>{

	List<RegimenAfilEntity> obtieneRegimenAfil();

}
