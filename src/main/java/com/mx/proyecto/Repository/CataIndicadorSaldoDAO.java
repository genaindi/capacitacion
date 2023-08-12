package com.mx.proyecto.Repository;

import java.util.List;

import com.mx.proyecto.Entity.IndicadorSaldoEntity;

public interface CataIndicadorSaldoDAO extends DAO<IndicadorSaldoEntity, Long>{

	List<IndicadorSaldoEntity> obtieneRegimenAfil();

}
