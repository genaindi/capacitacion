package com.mx.proyecto.Repository;

import java.util.List;
import com.mx.proyecto.Entity.EstatusCuentaEntity;

public interface CataEstatusCuentaDAO extends DAO<EstatusCuentaEntity, Long>{

	List<EstatusCuentaEntity> obtieneEstatusInd();

}
