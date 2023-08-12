package com.mx.proyecto.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.proyecto.Entity.AnioEntity;
import com.mx.proyecto.Entity.TipoTrabajadorEntity;
import com.mx.proyecto.Repository.CataTipoTrabajadorDAO;

@Repository
public class CataTipoTrabajadorDAOImpl extends GenericDAO<TipoTrabajadorEntity, Long> implements CataTipoTrabajadorDAO{

	@Override
	@Transactional()
	public List<TipoTrabajadorEntity> obtieneTipoTrabajador() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(TipoTrabajadorEntity.class); // -> SELECT * FROM ESQUEMA.TABLA_ESTADOS
		
		return (List<TipoTrabajadorEntity>) criteria.list();
	}

}//FIN DE LA CLASE
