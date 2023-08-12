package com.mx.proyecto.RepositoryImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.mx.proyecto.Entity.MisEmpleados;
import com.mx.proyecto.Entity.UsuariosAdmin;
import com.mx.proyecto.Repository.MisEmpleadosDAO;

@Repository
public class MisEmpleadosDAOImpl extends GenericDAO<MisEmpleados, Long> implements MisEmpleadosDAO{

	@Override
	@Transactional
	public MisEmpleados consultaPorRfc(String rfc) {

		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(MisEmpleados.class);//ESTO REPRESENTA EL SELECT * FROM TABLA
		
		criteria.add(Restrictions.eq("rfc", rfc));
		
		return (MisEmpleados)criteria.uniqueResult();//ESPERA UN UNICO RESULTADO
	}

	@Override
	@Transactional
	public List<MisEmpleados> obtieneEmpleadas(String sexo, int edad) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(MisEmpleados.class);//ESTO REPRESENTA EL SELECT * FROM TABLA
		
		criteria.add(Restrictions.eq("sexo", sexo));
		criteria.add(Restrictions.eq("edad", edad));

		
		return (List<MisEmpleados>) criteria.list();
	}


	@Override
	@Transactional
	public List<MisEmpleados> obtieneEmpleados(String sexo) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(MisEmpleados.class);
		
		criteria.add(Restrictions.eq("sexo", sexo));
		
		return (List<MisEmpleados>) criteria.list();
	}

	@Override
	@Transactional
	public List<MisEmpleados> obtieneEmpleados() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(MisEmpleados.class);
		
		return (List<MisEmpleados>) criteria.list();
	}

	/*@Override
	public MisEmpleados consultaBaja(int activo) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);//SELECT * FROM TABLA
		
		criteria.add(Restrictions.eq("activo", activo));//WHERE ESTADO
		
		return (MisEmpleados) criteria.uniqueResult();//ESPERA UN UNICO RESULTADO
	}*/
	
/*
	@Override
	public MisEmpleados consultaBaja(MisEmpleadosDTO idEmpleado) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);//SELECT * FROM TABLA
		
		//criteria.add(Restrictions.eq("activo", activo));//WHERE ESTADO
		
		return (MisEmpleados) criteria.uniqueResult();//ESPERA UN UNICO RESULTADO
	}*/

	@Override
	public List<MisEmpleados> obtieneEmpleados2() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
		
		return (List<MisEmpleados>) criteria.list();
	}

	@Override
	public MisEmpleados consultaBaja(long idEmpleado) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);//SELECT * FROM TABLA
		
		//criteria.add(Restrictions.eq("activo", activo));//WHERE ESTADO
		
		return (MisEmpleados) criteria.uniqueResult();//ESPERA UN UNICO RESULTADO
	}

	@Override
	@Transactional
	public MisEmpleados consultaExistencia(String rfc, String curp) {
		System.out.println("Informacion a buscar " + curp + rfc);
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(MisEmpleados.class);//ESTO REPRESENTA EL SELECT * FROM TABLA
		
		criteria.add(Restrictions.eq("rfc", rfc));
		criteria.add(Restrictions.eq("curp", curp));
				
		return (MisEmpleados)criteria.uniqueResult();//ESPERA UN UNICO RESULTADO
	}

	

	
	
	

}//FIN DE LA CLASE
