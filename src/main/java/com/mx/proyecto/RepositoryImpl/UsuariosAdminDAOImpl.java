package com.mx.proyecto.RepositoryImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mx.proyecto.Entity.UsuariosAdmin;
import com.mx.proyecto.Repository.UsuariosAdminDAO;

@Repository
public class UsuariosAdminDAOImpl implements UsuariosAdminDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//----------------------Contructor---------------
	public UsuariosAdminDAOImpl() {//Es un contructot vacio		
	}
	
	public UsuariosAdminDAOImpl(SessionFactory sessionFactory) {//Es un contructot con un parametro	
		this.sessionFactory = sessionFactory;
	}

	//Primer servicio para realizar la consulta select * from tabla
	@Override
	@SuppressWarnings("unchecked")//Quita las advertencias de lineas amarillas, asi evita contaminacion visual
	@Transactional() // Es lo equivalente a un commit en oracle (Confirma los cambios)
	public List<UsuariosAdmin> obtenerTodosUsuarios() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);// select * from Usuarios_Admin
		
		//criteria.add(Restrictions.eq("rol", 3));//--> equivale al where rol = 3
		//criteria.add(Restrictions.eq("edad", 37));//--> equivale al where edad = 37
		
		return (List<UsuariosAdmin>) criteria.list();
	}

	@Override
	@Transactional() // Es lo equivalente a un commit en oracle (Confirma los cambios)
	public Integer insertarUsuario(UsuariosAdmin datos) {

		sessionFactory.getCurrentSession().save(datos);//Esto es insert a la tabla
		
		return 1;
	}

	@Override
	@Transactional() // Es lo equivalente a un commit en oracle (Confirma los cambios)	
	public Integer eliminarUsuarioPorID(UsuariosAdmin datos) {

		sessionFactory.getCurrentSession().delete(datos);// ELIMINAR POR HIBERNATE
		
		return 1;
	}

	@Override
	@Transactional() // Es lo equivalente a un commit en oracle (Confirma los cambios)	
	public Integer actualizarUsuario(UsuariosAdmin datos) {

		sessionFactory.getCurrentSession().update(datos);//ACTUALIZAR POR HIBERNATE
		
		return 1;
	}
	
	/******** IMPORTANTE ********
	*Para consulta por hibernate importante 2 cosas
	*1. La session actual -> final Session session = sessionFactory.getCurrentSession();
	*2. Usar la entity/entidad -> (es la tabla de oracle DB) -> final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
	
	*/

}//Fin de la clase
