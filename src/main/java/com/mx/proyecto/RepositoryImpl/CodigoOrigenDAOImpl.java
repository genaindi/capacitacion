package com.mx.proyecto.RepositoryImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.proyecto.Entity.CodigoOrigenEntity;
import com.mx.proyecto.Repository.CodigoOrigenDAO;

@Repository
public class CodigoOrigenDAOImpl extends GenericDAO<CodigoOrigenEntity, Long> implements CodigoOrigenDAO{

	@Override
	@Transactional()
	public List<CodigoOrigenEntity> obtieneCodigoOrigen() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(CodigoOrigenEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<CodigoOrigenEntity>) criteria.list();
	}

}
