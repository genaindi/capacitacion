package com.mx.proyecto.Services;

import java.util.List;

import com.mx.proyecto.Entity.AnioEntity;
import com.mx.proyecto.Entity.CodigoOrigenEntity;
import com.mx.proyecto.Entity.EstatusActividadEntity;
import com.mx.proyecto.Entity.EstatusCuentaEntity;
import com.mx.proyecto.Entity.IndicadorSaldoEntity;
import com.mx.proyecto.Entity.MesEntity;
import com.mx.proyecto.Entity.RegimenAfilEntity;
import com.mx.proyecto.Entity.TipoTrabajadorEntity;

public interface CatalogosAforeService {

	List<AnioEntity> getAnio();

	List<MesEntity> getMes();

	List<EstatusActividadEntity> getEstatusAct();

	List<TipoTrabajadorEntity> getTipoTrabajador();

	List<EstatusCuentaEntity> getCuentaIndividual();

	List<CodigoOrigenEntity> getCodigoOrigen();

	List<RegimenAfilEntity> getRegimenAfil();

	List<IndicadorSaldoEntity> getIndicadorSaldo();

}//FIN DE LA CLASE
