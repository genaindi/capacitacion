package com.mx.proyecto.RepositoryImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mx.proyecto.Entity.RegimenAfilEntity;
import com.mx.proyecto.Repository.RegimenAfilDAO;

@Repository
public class RegimenAfilDAOImpl extends GenericDAO<RegimenAfilEntity, Long> implements RegimenAfilDAO{

	@Override
	@Transactional()
	public List<RegimenAfilEntity> obtieneRegimenAfil() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(RegimenAfilEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<RegimenAfilEntity>) criteria.list();
	}

}
