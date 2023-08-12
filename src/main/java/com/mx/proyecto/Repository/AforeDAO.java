package com.mx.proyecto.Repository;

import java.util.List;
import com.mx.proyecto.Entity.Afore;

public interface AforeDAO extends DAO<Afore, Long>{

	List<Afore> obtieneTabla();

	Long obtenValorSecuencia();

}
