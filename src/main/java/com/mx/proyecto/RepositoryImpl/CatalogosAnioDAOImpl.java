package com.mx.proyecto.RepositoryImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mx.proyecto.Entity.AnioEntity;
import com.mx.proyecto.Repository.CatalogosAnioDAO;

@Repository
public class CatalogosAnioDAOImpl extends GenericDAO<AnioEntity, Long> implements CatalogosAnioDAO{

	@Override
	@Transactional()
	public List<AnioEntity> obtieneAnio() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(AnioEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<AnioEntity>) criteria.list();
	}
	
	

}
