package com.mx.proyecto.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mx.proyecto.Entity.EstatusCuentaEntity;
import com.mx.proyecto.Repository.CataEstatusCuentaDAO;

@Repository
public class CataEstatusCuentaDAOImpl extends GenericDAO<EstatusCuentaEntity, Long> implements CataEstatusCuentaDAO{

	@Override
	@Transactional()
	public List<EstatusCuentaEntity> obtieneEstatusInd() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EstatusCuentaEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<EstatusCuentaEntity>) criteria.list();
	}

}
