// Objetivo JavaScript = js = Es para movimiento, funcion=(clic boton, llenar de informacion una tabla, mostrar/ocultar componente boton, una tabla)
// Un metodo en java = en js se llaman => function

$(document).ready(function() { // Esta parte  es para realizar la carga de la pagina *DESDE EL INICIO*

	//alert("Yo aparezco al cargar a pagina desde el inicio"); // mensaje emergenete -> Es visible --- esto aveces se utitliza para mensajes para el usuario
	//console.log("Yo soy un mensaje desde la consola del navegador"); // Es para el programador imprimir mensajes de ayuda


	llenarTablaUsuariosAdmin();

	// click = Accion de dar clic a un componente
	// onChage = Aplica en los comboBox
	//...

	$('#btn_AbrirModal').click(function() {
		
		llenar_combo_lista_de_roles('#listaDeRoles'); // llama la function que hace la peticion de los roles
		llenar_combo_lista_de_estados('#listaDeEstados')// llama la function que hace la peticion de los estados
		
		$('#muestraModal').modal('show'); // muestra el modal
	});

});

//EN JAVASCRIPT
//function() => Lo correspondiente a clases java es un Metodo
//en ves de usar System.out.prin --> alert("mensaje"); --> ventana emergente / console.log("Mensaje")--> consola del navegador


// ---------------    FUNCTION DE EJEMPLO BASICO  ----------------
//function llenarTablaUsuariosAdmin(){
//	 //var e = 0; //<- la forma de declarar variables en javascript
//	
//	var table = $('#id_tablaUsuariosAdmin').DataTable(); // esta linea lo convierte en dataTable()	
//}







// 01.- Se va a consumir el servicios de -> getUsuariosAdmin del controlador
function llenarTablaUsuariosAdmin() {

	console.log("Estoy dentro de la function llenar tabla");

	debugger;//ESTO LO QUE HACE ES IR SALTANDO EN EL CODIGO LINEA POR LINEA

	var table = $('#id_tablaUsuariosAdmin').DataTable();
	table.destroy(); // Destruir la informacion que ya contiene la tabla

	$.ajax({// Ajax = nos ayuda a realizar el consumo de nuestros servicios que se encuentran en el controlador / Hacer el enlace del FrontEnd - BackEnd
		type: "get",
		url: '/Capacitacion/usuariosHibernate2/getUsuariosAdmin',
		dataType: "json",
		success: function(response) {  // response =  listUsuarios que vienen desde la DB, code=200 y mensaje="......."

			console.log(response);
			console.log(response.list);

			$("#id_tablaUsuariosAdmin").DataTable({
				data: response.list,
				resposive: true,
				columns: [
					{
						data: "idUser",
						"searchable": false, // no se puede filtrar por el ide xq esta en false
						"visible": false,	// Este columna no es visible					
					},
					{
						data: "nombreCompleto",
					},
					{
						data: "edad",
					},
					{
						data: "direccion",
					},
					{
						data: "estado",
					},
					{
						data: "rol",
					},

					{
						className: "text-center", // centrar
						"orderable": false, // no se puedan ordenas por los botones
						data: function(row, type, set) {
							var a;
							a = `<a href="#" id="eliminar_usuario" class="btn btn-danger btn-remove" value="${row.idUser}"><i class="fas fa-trash-alt"></i></a>`;

							return a;
						}
					},
					{
						className: "text-center",
						"orderable": false,
						data: function(row, type, set) {
							var a;
							a = `<a href="#" id="editar_usuario" class="btn btn-success" value="${row.idUser}"><i class="fa fa-edit"></i></a>`;

							return a;
						}
					}
				],
				"language": configuracionLenguaje_es

			});
		},
	});
}

//cambiar de idiom ingles - españo el datatble
var configuracionLenguaje_es = {
	sLoadingRecords: "Cargando...",
	sProcessing: "Procesando...",
	sInfoEmpty: "Registros: 0",
	sZeroRecords: "Ningún dato disponible en esta tabla",
	sEmptyTable: "Ningún dato disponible en esta tabla",
	sInfo: " Registros: _TOTAL_ ",
	sSearch: "Filtrar por: ",
	sInfoFiltered: "filtrados",
	sUrl: "",
	sInfoThousands: ",",
	oPaginate: {
		sFirst: "Primero",
		sLast: "Último",
		sNext: "Siguiente",
		sPrevious: "Anterior"
	}
};

//Function para registrar informacion del usuario cuando se de clic en el boton de guardar
$(document).on("click", "#btn_guardar", function(e) {
	e.preventDefault();

	alert("Soy el botont guardar");

	debugger; // mostrarte como se ejecuta el codigo linea x linea

	var datosUsuario = {
		idUser: 1,
		nombreCompleto: $('#nombre_completo_view').val(), // <-- se recoje la informacion ingresada en el campo de texto
		edad: $('#edad_view').val(),
		direccion: $('#direccion_view').val(),
		//estado: $('#estado_view').val(),
		estado: $('#listaDeEstados').val(),
		//rol: $('#rol_view').val()
		rol: $('#listaDeRoles').val()
	}

	console.log(datosUsuario);

	// Ajax: Conexion del frontEnd conectarlo con el BackEnd

	$.ajax({												 // Todo esto contiene el valor del id desde la tabla -> $(this).attr("value");
		type: "post",
		url: "/Capacitacion/usuariosHibernate2/insertUsuarios",
		data: JSON.stringify(datosUsuario), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {

			console.log(response);

			alert(response.message);
			llenarTablaUsuariosAdmin(); // Esta es la function que hace el llenado de la tabla entonces hay que llamarlo una vez eliminado el registro de la peticion sea correcta

			//			Hacer el codigo para que el modal se oculte

		}
	});


});









//Al momento de dar click sobre el icono se ejecuta esta funcion para ejecitar la peticion y se elimne el registro.
$(document).on("click", "#eliminar_usuario", function(e) {
	e.preventDefault();

	alert("Estoy desde la function eliminar");

	debugger; // mostrarte como se ejecuta el codigo linea x linea


	var idUsuario = {
		//						: -> id=1	 // -> $(this).attr("value") -> Es el valor que recojemos de la tabla o sea es el id de cada registro
		idUser: $(this).attr("value")// Asignado el id a la variable -> idUser que viene de la clase DTO
	}

	console.log(idUsuario);

	// Ajax: Conexion del frontEnd conectarlo con el BackEnd

	$.ajax({												 // Todo esto contiene el valor del id desde la tabla -> $(this).attr("value");
		type: "POST",
		url: "/Capacitacion/usuariosHibernate2/eliminarUsuario",
		data: JSON.stringify(idUsuario), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {

			console.log(response);
			alert(response.message);
			llenarTablaUsuariosAdmin(); // Esta es la function que hace el llenado de la tabla entonces hay que llamarlo una vez eliminado el registro de la peticion ->eliminarUsuario

		}
	});

});




// 1.- Consultar la informacion a la DB por el Id -> select * from tabla where id=1
// 2.- es mostrar la informacion en un formulario
// 3.- Boton de actualizar -> UPDATE SET TABLA WHERE


//Esta parte es para consultar la informacion del usuario por su ID, de la fila que se selecciona dentro del dataTable esto para llenar los campos del modal presentar la inf.
$(document).on("click", "#editar_usuario", function(e) {
	e.preventDefault();

	debugger;
	var idUsuario = {
		//			: -> id=1	 // -> $(this).attr("value") -> Es el valor que recojemos de la tabla o sea es el id de cada registro
		idUser: $(this).attr("value")// Asignado el id a la variable -> idUser que viene de la clase DTO
	}

	$.ajax({
		type: "POST",
		url: "/Capacitacion/usuariosHibernate2/getUsuariosPorId",
		data: JSON.stringify(idUsuario), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {

			console.log(response);
			//			console.log(data.content.nombreCompleto);

			$('#modalActualizarUsuario').modal('show');// mostrar/presen tar en la vista el modal

			//			-->content: 
			//			direccion: "CDMX"
			//			edad: 28
			//			estado: 4
			//			idUser: 2
			//			nombreCompleto: "Diego Hernandez Sanchez"
			//			rol: 3

			$('#idUser_actualizar').val(response.content.idUser);  //  
			$('#nombre_completo_actualizar').val(response.content.nombreCompleto);
			$('#edad_actualizar').val(response.content.edad);
			$('#direccion_actualizar').val(response.content.direccion);
			$('#estado_actualizar').val(response.content.estado);
			$('#rol_actualizar').val(response.content.rol);

		}
	});

});


//Function para actualizar informacion del usuario
$(document).on("click", "#BotonActualizarUsuario", function(e) {
	e.preventDefault();

	debugger; // mostrarte como se ejecuta el codigo linea x linea

	var datosUsuario = {
		idUser: $('#idUser_actualizar').val(),
		nombreCompleto: $('#nombre_completo_actualizar').val(),
		edad: $('#edad_actualizar').val(),
		direccion: $('#direccion_actualizar').val(),
		estado: $('#estado_actualizar').val(),
		rol: $('#rol_actualizar').val()
	}

	console.log(datosUsuario);

	// Ajax: Conexion del frontEnd conectarlo con el BackEnd

	$.ajax({												 // Todo esto contiene el valor del id desde la tabla -> $(this).attr("value");
		type: "POST",
		url: "/Capacitacion/usuariosHibernate2/actualizarDatos",
		data: JSON.stringify(datosUsuario), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {
			console.log(response);
			alert(response.message);

			$('#modalActualizarUsuario').hide(); // ocultar el modal una vez que se actualize correctamente

			llenarTablaUsuariosAdmin(); // Esta es la function que hace el llenado de la tabla entonces hay que llamarlo una vez eliminado el registro de la peticion ->eliminarUsuario


		}
	});

});


//-- FUNCTIONES PARA LLENAR LOS COMBOS CON LOS CATALOGOS DE ESTADOS Y ROLES

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_lista_de_estados(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogos/getEstados",
	        dataType: "json",
	        success: function (respose) {
	            console.log(respose);
	            $.each(respose, function (key, registro) {
	                $(combo).append('<option value=' + registro.idEstado + '>' + registro.nombre + '</option>');
	             });
	        },
	    });
	}




//Function para llenar el coboBox de la lista de roles

function llenar_combo_lista_de_roles(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogos/getRoles",
	        dataType: "json",
	        success: function (respose) {
	            console.log(respose);
	            $.each(respose, function (key, registro) {
	                $(combo).append('<option value=' + registro.idRol + '>' + registro.descripcion + '</option>');
	             });
	        },
	    });
	}
	
	