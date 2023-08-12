package com.mx.proyecto.ServicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.proyecto.Entity.AnioEntity;
import com.mx.proyecto.Entity.CodigoOrigenEntity;
import com.mx.proyecto.Entity.EstatusActividadEntity;
import com.mx.proyecto.Entity.EstatusCuentaEntity;
import com.mx.proyecto.Entity.IndicadorSaldoEntity;
import com.mx.proyecto.Entity.MesEntity;
import com.mx.proyecto.Entity.RegimenAfilEntity;
import com.mx.proyecto.Entity.TipoTrabajadorEntity;
import com.mx.proyecto.Repository.CataEstatusActividadDAO;
import com.mx.proyecto.Repository.CataEstatusCuentaDAO;
import com.mx.proyecto.Repository.CataIndicadorSaldoDAO;
import com.mx.proyecto.Repository.CataTipoTrabajadorDAO;
import com.mx.proyecto.Repository.CatalogosAnioDAO;
import com.mx.proyecto.Repository.CatalogosMesDAO;
import com.mx.proyecto.Repository.CodigoOrigenDAO;
import com.mx.proyecto.Repository.RegimenAfilDAO;
import com.mx.proyecto.Services.CatalogosAforeService;

@Service
public class CatalogosAforeServiceImpl implements CatalogosAforeService{
	
	@Autowired
	private CatalogosAnioDAO catalogosAnioDAO;
	
	@Autowired
	private CatalogosMesDAO catalogosMesDAO;
	
	@Autowired
	private CataEstatusActividadDAO cataEstatusActividadDAO;
	
	@Autowired
	private CataTipoTrabajadorDAO cataTipoTrabajadorDAO;
	
	@Autowired
	private CataEstatusCuentaDAO cataEstatusCuentaDAO;
	
	@Autowired
	private CodigoOrigenDAO codigoOrigenDAO;
	
	@Autowired
	private RegimenAfilDAO regimenAfilDAO;
	
	@Autowired
	private CataIndicadorSaldoDAO cataIndicadorSaldoDAO;

	@Override
	public List<AnioEntity> getAnio() {
		List<AnioEntity> listAnio = catalogosAnioDAO.obtieneAnio();
		
		return listAnio;
	}

	@Override
	public List<MesEntity> getMes() {
		List<MesEntity> listMes = catalogosMesDAO.obtieneMes();
		
		return listMes;
	}

	@Override
	public List<EstatusActividadEntity> getEstatusAct() {
		List<EstatusActividadEntity> listEstatusActividad = cataEstatusActividadDAO.obtieneEstatus();
		
		return listEstatusActividad;
	}

	@Override
	public List<TipoTrabajadorEntity> getTipoTrabajador() {
		List<TipoTrabajadorEntity> listTipoTrabajador = cataTipoTrabajadorDAO.obtieneTipoTrabajador();
		
		return listTipoTrabajador;
	}

	@Override
	public List<EstatusCuentaEntity> getCuentaIndividual() {
		List<EstatusCuentaEntity> listCuentaInd = cataEstatusCuentaDAO.obtieneEstatusInd();
		
		return listCuentaInd;
	}

	@Override
	public List<CodigoOrigenEntity> getCodigoOrigen() {
		List<CodigoOrigenEntity> listCodigoOrigen = codigoOrigenDAO.obtieneCodigoOrigen();
		
		return listCodigoOrigen;
	}

	@Override
	public List<RegimenAfilEntity> getRegimenAfil() {
		List<RegimenAfilEntity> listRegimenAfiliacion = regimenAfilDAO.obtieneRegimenAfil();
		
		return listRegimenAfiliacion;
	}

	@Override
	public List<IndicadorSaldoEntity> getIndicadorSaldo() {
		List<IndicadorSaldoEntity> listIndicadorSaldo = cataIndicadorSaldoDAO.obtieneRegimenAfil();
		
		return listIndicadorSaldo;
	}

}//FIN DE LA CLASE
