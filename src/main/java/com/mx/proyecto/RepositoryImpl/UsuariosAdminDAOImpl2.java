package com.mx.proyecto.RepositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.proyecto.Entity.UsuariosAdmin;
import com.mx.proyecto.Repository.UsuariosAdminDAO2;

@Repository												//GenericDAO<T, PK>
public class UsuariosAdminDAOImpl2 extends GenericDAO<UsuariosAdmin, Long> implements UsuariosAdminDAO2{
	
	//ES LA CONSULTA PARA TENER "SELECT * FROM TABLA"
	@Override
	@Transactional
	public List<UsuariosAdmin> obtieneUsuarios() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
		
		return (List<UsuariosAdmin>) criteria.list();//RETORNA UNA LISTA DE EMPLEADOS
	}

	//SELECT * FROM  TABLA WHERE CURP/RFC/STATUS = "SDFASDFA"
	@Override
	@Transactional
	public UsuariosAdmin consultaPorEstado(int estado) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);//SELECT * FROM TABLA
		
		criteria.add(Restrictions.eq("estado", estado));//WHERE ESTADO
		
		return (UsuariosAdmin) criteria.uniqueResult();//ESPERA UN UNICO RESULTADO
	}

	
	
}//FIN DE LA CLASE
