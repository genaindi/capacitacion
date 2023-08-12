package com.mx.proyecto.RepositoryImpl;

import java.math.BigDecimal;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.mx.proyecto.Entity.Afore;
import com.mx.proyecto.Repository.AforeDAO;

@Repository
public class AforeDAOImpl extends GenericDAO<Afore, Long> implements AforeDAO{

	
	@Override
	@Transactional
	public List<Afore> obtieneTabla() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(Afore.class);//ESTO REPRESENTA EL SELECT * FROM TABLA
		
		
		return (List<Afore>) criteria.list();
	}

	@Override
	@Transactional
	public Long obtenValorSecuencia() {
		String sqlSequence = "SELECT SEQ_AFORE.NEXTVAL AS SECUENCIAUSER FROM DUAL";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sqlSequence);
		List result = query.list();
		return ((BigDecimal) result.get(0)).longValue();
	}



}//FIN DE LA CLASE
