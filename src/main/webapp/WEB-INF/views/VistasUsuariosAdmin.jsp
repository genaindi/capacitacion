<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- INTEGRAMOS JQUERY PARA QUE FUNCIONE EL JAVASCRIPT -->
<script type="text/javascript" lenguaje="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>

<!--  INTEGRAMOS PLUGIN DE dataTable -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<script type="text/javascript" lenguaje="javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>


<!--  INTEGRACION DE BOOSTRAP -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!--  ASI SE MANDA A LLAMAR MI ARCHIVO JAVASCRIPT  -->
<script lenguaje="javascript" type="text/javascript" src="<c:url value="/resources/javascript/usuariosAdmin.js"/>"></script>

<!-- ESTO ES PARA UTILIZAR ICONOS EN EL PROYECTO  -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

</head>
<body>

<!-- PARA ABRIR MODAL EL BOTON SE LE AGREGO UN IDE, VAMOS A ABRIR EL MODAL POR MEDIO DE JAVASCRIPT EN EL ARCHIVO .JS -->
<button type = "button" class = "btn btn-primary" id = "btn_AbrirModal">
		Agregar nuevo registro
</button>

<!--  ESTE ES EL MODAL PARA AGREGAR UN NUEVO REGISTRO -->
<div class="modal fade" id=muestraModal data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar nuevo registro</h5>
        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
        
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Nombre completo *:</label>
            <input type="text" class="form-control" id="nombre_completo_view">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Edad *:</label>
            <input type="text" class="form-control" id="edad_view">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Direccion *:</label>
            <input type="text" class="form-control" id="direccion_view">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Estado *:</label>
            <!--input type="text" class="form-control" id="estado_view">  -->
            
            <select id="listaDeEstados" class="form-select" aria-label="Default select example"><!-- ESTE ES EL COMBO BOX DE ESTADO -->
   	  	 	</select>
   
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Rol *:</label>
            <!--input type="text" class="form-control" id="rol_view">-->
            
            <select id="listaDeRoles" class="form-select" aria-label="Default select example"><!-- ESTE ES EL COMBO BOX DE ROL -->
                                                
	  	 	</select>
            
          </div>
          
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-primary" id="btn_guardar" >Guardar registro</button>
      </div>
    </div>
  </div>
</div>

<center>
<h2>SOY LA VISTA DE USUARIOS ADMIN</h2>
</center>

<br><br><br>

<table class="table" id="id_tablaUsuariosAdmin">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">NOMBRE COMPLETO</th>
      <th scope="col">EDAD</th>
      <th scope="col">DIRECCION</th>
      <th scope="col">ESTADO</th>
      <th scope="col">ROL</th>
      <th scope="col">ELIMINAR</th>
      <th scope="col">ACTUALIZAR</th>
    </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>


<!-- Modal 2 ESTE MODAL ES PARA ACTUALIZAR INFORMACION DEL USUARIO-->
		<div class="modal fade" id="modalActualizarUsuario" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Actualizar registro</h5>
					</div>
					<input type="hidden" id="idUser_actualizar">
					
					<div class="modal-body">
						<label for="">Nombre completo: </label> 
						<input type="text" class="form-control" id="nombre_completo_actualizar">
						
						<label for="">edad: </label> 
						<input type="text" class="form-control" id="edad_actualizar">

						<label for="">direccion: </label> 
						<input type="text" class="form-control" id="direccion_actualizar">

						<label for="">Estado: </label> 
						<input type="text" class="form-control" id="estado_actualizar">

						<label for="">Rol: </label> 
						<input type="text" class="form-control" id="rol_actualizar">
						
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
						<button type="button" class="btn btn-primary" id="BotonActualizarUsuario" onclick="click">Actualizar</button>
					</div>
				</div>
			</div>
		</div>

<!-- javascript -->

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>


</body>
</html>