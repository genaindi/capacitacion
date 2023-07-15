package com.mx.proyecto.Repository;

import java.util.List;
import com.mx.proyecto.Entity.MisEmpleados;

public interface MisEmpleadosDAO extends DAO<MisEmpleados, Long>{

	MisEmpleados consultaPorRfc(String rfc);

	List<MisEmpleados> obtieneEmpleadas(String sexo, int Edad);

	List<MisEmpleados> obtieneEmpleados(String sexo);
	
	List<MisEmpleados> obtieneEmpleados();

	List<MisEmpleados> obtieneEmpleados2();

	MisEmpleados consultaBaja(long idEmpleado);

	MisEmpleados consultaExistencia(String rfc, String curp);




}//FIN DE LA CLASE
