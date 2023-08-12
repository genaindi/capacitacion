package com.mx.proyecto.RepositoryImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mx.proyecto.Entity.IndicadorSaldoEntity;
import com.mx.proyecto.Repository.CataIndicadorSaldoDAO;

@Repository
public class CataIndicadorSaldoDAOImpl extends GenericDAO<IndicadorSaldoEntity, Long> implements CataIndicadorSaldoDAO{

	@Override
	@Transactional()
	public List<IndicadorSaldoEntity> obtieneRegimenAfil() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(IndicadorSaldoEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<IndicadorSaldoEntity>) criteria.list();
	}

}
