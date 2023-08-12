package com.mx.proyecto.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.proyecto.Entity.AnioEntity;
import com.mx.proyecto.Entity.MesEntity;
import com.mx.proyecto.Repository.CatalogosAnioDAO;
import com.mx.proyecto.Repository.CatalogosMesDAO;

@Repository
public class CatalogosMesDAOImpl extends GenericDAO<MesEntity, Long> implements CatalogosMesDAO{

	@Override
	@Transactional()
	public List<MesEntity> obtieneMes() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(MesEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<MesEntity>) criteria.list();
	}
	
	

}//FIN DE LA CLASE
