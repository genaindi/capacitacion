package com.mx.proyecto.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mx.proyecto.Entity.EstatusActividadEntity;
import com.mx.proyecto.Repository.CataEstatusActividadDAO;

@Repository
public class CataEstatusActividadDAOImpl extends GenericDAO<EstatusActividadEntity, Long> implements CataEstatusActividadDAO{

	@Override
	@Transactional()
	public List<EstatusActividadEntity> obtieneEstatus() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EstatusActividadEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<EstatusActividadEntity>) criteria.list();
	}

}
