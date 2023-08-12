
$(document).ready(function(){
	
	//alert("Yo aparezco al momento de cargar la pagina ***");
	//console.log("Yo soy un mensaje desde el navegador**");	
	
	// CON ESTA LINEA SE ESTA CONSULTANDO EL SERVICIO DE CONSULTAR LA TABLA DE AFORE
	llenarTablaAfiliado();
	
	// CON ESTO SE ESTA DANDO LA FUNCION AL BOTON DE AGREGAR USUARIO
	$('#btn_AbrirModal').click(function() {
		
		llenar_combo_de_anio('#listaDeAnio'); // llama la function que hace la peticion de los AÑOS
		llenar_combo_de_mes('#listaDeMes'); // llama la function que hace la peticion de los MESES
		llenar_combo_de_estatusActividad('#listaEstatusActividad'); // llama la function que hace la peticion de los MESES
		llenar_combo_de_tipoTrabajador('#listaTipoTrabajador'); // llama la function que hace la peticion de los MESES
		llenar_combo_cuenta_ind('#listaCuentaIndividual'); // llama la function que hace la peticion de los MESES
		llenar_combo_codigoOrigen('#listaCodigoOrigen'); // llama la function que hace la peticion de los MESES
		llenar_combo_regimenAfiliacion('#listaRegimenAfiliacion'); // llama la function que hace la peticion de los MESES
		llenar_combo_indicadorSaldo('#listaIndicadorSaldo'); // llama la function que hace la peticion de los MESES
		
		
		$('#muestraModal').modal('show'); // muestra el modal
	});
});


///////////////////////////   PARA CONSULTAR LA TABLA////////////////////////////////////////////////////////////////////

// 01.- Se va a consumir el servicios de -> getUsuariosAdmin del controlador
function llenarTablaAfiliado() {

	console.log("Estoy dentro de la function llenar tabla");

	debugger;//ESTO LO QUE HACE ES IR SALTANDO EN EL CODIGO LINEA POR LINEA

	var table = $('#id_tablaAfiliados').DataTable();
	table.destroy(); // Destruir la informacion que ya contiene la tabla, IMPORTANTE AGREGARLA PARA REALIZAR LA CONSULTA

	$.ajax({// Ajax = nos ayuda a realizar el consumo de nuestros servicios que se encuentran en el controlador / Hacer el enlace del FrontEnd - BackEnd
		type: "get",
		url: '/Capacitacion/guardarAfore/getMostrarTabla',
		dataType: "json",
		success: function(response) {  // response =  listUsuarios que vienen desde la DB, code=200 y mensaje="......."

			console.log(response);
			console.log(response.list);//CON ESTA LINEA SE TRAE LA CONSULTA SIEMPRE QUE SEA CON LISTAS

			$("#id_tablaAfiliados").DataTable({
				data: response.list, //CON ESTA LINEA SE TRAE LA CONSULTA SIEMPRE QUE SEA CON LISTAS
				resposive: true,
				columns: [
					{
						data: "idTrabajador",
						"searchable": false, // no se puede filtrar por el ide xq esta en false
						"visible": false,	// Este columna no es visible					
					},
					{
						data: "anio",
					},
					{
						data: "mes",
					},
					{
						data: "nss",
					},
					{
						data: "curp",
					},
					{
						data: "estatusActividad",
					},
					{
						data: "tipoTrabajador",
					},
					{
						data: "estatusCuenta",
					},
					{
						data: "codigoOrigen",
					},
					{
						data: "regimenAfiliacion",
					},
					{
						data: "indicadorSaldo",
					},

					{
						className: "text-center", // centrar
						"orderable": false, // no se puedan ordenas por los botones
						data: function(row, type, set) {
							var a;
							a = `<a href="#" id="eliminar_usuario" class="btn btn-danger btn-remove" value="${row.idTrabajador}"><i class="fas fa-trash-alt"></i></a>`;

							return a;
						}
					},
					{
						className: "text-center",
						"orderable": false,
						data: function(row, type, set) {
							var a;
							a = `<a href="#" id="editar_usuario" class="btn btn-success" value="${row.idTrabajador}"><i class="fa fa-edit"></i></a>`;

							return a;
						}
					}
				],
				"language": configuracionLenguaje_es
			});
		},
	});
}


///////////////////////////   PARA CAMBIAR EL IDIOMA  //////////////////////////////////////////////////////////////////


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


///////////////////////////   INSERTAR REGISTRO  //////////////////////////////////////////////////////////////////


//Function para registrar informacion del usuario cuando se de clic en el boton de guardar
$(document).on("click", "#btn_guardar", function(e) {
	e.preventDefault();

	alert("Soy el botont guardar");

	debugger; // mostrarte como se ejecuta el codigo linea x linea

	
	var datoAfiliado = {	
		idTrabajador: 1,
		anio: $('#año_view').val(),// <-- se recoje la informacion ingresada en el campo de texto
		mes: $('#mes_view').val(),
		nss: $('#nss_view').val(),
		curp: $('#curp_view').val(),
		estatusActividad: $('#estatus_actividad_view').val(),
		tipoTrabajador: $('#tipo_trabajador_view').val(),
		estatusCuenta: $('#estatus_cuenta_view').val(),
		codigoOrigen: $('#codigo_origen_view').val(),
		regimenAfiliacion: $('#regimen_afiliacion_view').val(),
		indicadorSaldo: $('#indicador_saldo_view').val(),
				
	}

	console.log(datoAfiliado);

	// Ajax: Conexion del frontEnd conectarlo con el BackEnd

	$.ajax({												 // Todo esto contiene el valor del id desde la tabla -> $(this).attr("value");
		type: "post",
		url: "/Capacitacion/guardarAfore/insertAfiliado2",
		data: JSON.stringify(datoAfiliado), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {

			console.log(response);

			alert(response.message);
			llenarTablaAfiliado(); // Esta es la function que hace el llenado de la tabla SE ACTUALICE entonces hay
			 // que llamarlo una vez eliminado el registro de la peticion sea correcta

			//			Hacer el codigo para que el modal se oculte

		}
	});
});


///////////////////////////   PARA ELIMINAR EL REGISTRO A TRAVES DEL BOTON ELIMINAR  ///////////////////////////////////


//Al momento de dar click sobre el icono se ejecuta esta funcion para ejecitar la peticion y se elimne el registro.
$(document).on("click", "#eliminar_usuario", function(e) {
	e.preventDefault();

	alert("Estoy desde la function eliminar");

	debugger; // mostrarte como se ejecuta el codigo linea x linea

	var idAfil = {
		//						: -> id=1	 // -> $(this).attr("value") -> Es el valor que recojemos de la tabla o sea es el id de cada registro
		idTrabajador: $(this).attr("value")// Asignado el id a la variable -> idTrabajador que viene de la clase DTO. ESTA ES LA FORMA DE RECOGER INFO
	}

	console.log(idAfil);

	// Ajax: Conexion del frontEnd conectarlo con el BackEnd

	$.ajax({												 // Todo esto contiene el valor del id desde la tabla -> $(this).attr("value");
		type: "POST",
		url: "/Capacitacion/guardarAfore/eliminarAfiliado",
		data: JSON.stringify(idAfil), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {

			console.log(response);
			alert(response.message);
			llenarTablaAfiliado(); // Esta es la function que hace el llenado de la tabla entonces hay que llamarlo una vez eliminado el registro de la peticion ->eliminarUsuario

		}
	});
});


///////////////////////////   PARA BUSQUEDA DE REGISTRO POR ID  //////////////////////////////////////////////////////////////////


// 1.- Consultar la informacion a la DB por el Id -> select * from tabla where id=1
// 2.- es mostrar la informacion en un formulario
// 3.- Boton de actualizar -> UPDATE SET TABLA WHERE


//Esta parte es para consultar la informacion del usuario por su ID, de la fila que se selecciona dentro del dataTable esto para llenar los campos del modal presentar la inf.
$(document).on("click", "#editar_usuario", function(e) {
	e.preventDefault();

	debugger;
	var idAfil = {
		//			: -> id=1	 // -> $(this).attr("value") -> Es el valor que recojemos de la tabla o sea es el id de cada registro
		idTrabajador: $(this).attr("value")// Asignado el id a la variable -> idUser que viene de la clase DTO
	}

	$.ajax({
		type: "POST",
		url: "/Capacitacion/guardarAfore/getAfiliadoPorId",
		data: JSON.stringify(idAfil), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {

			console.log(response);
			//			console.log(data.content.nombreCompleto);

			$('#modalActualizarAfiliado').modal('show');// mostrar/presen tar en la vista el modal

			//			-->content: 
			//			direccion: "CDMX"
			//			edad: 28
			//			estado: 4
			//			idUser: 2
			//			nombreCompleto: "Diego Hernandez Sanchez"
			//			rol: 3

		// CON LO SIGUIENTE SE MUESTRA LA INFORMACION EN EL MODAL DE ACTUALIZAR REGISTRO
		// LA INFORMACION VIENE EN RESPONSE.CONTENT POR LO TANTO SE AGREGA AL CODIGO ESPECIFICANDO QUE DATO SE REQUIERE
			
			$('#idAfiliado_actualizar').val(response.content.idTrabajador);  //  
			$('#año_actualizar').val(response.content.anio);
			$('#mes_actualizar').val(response.content.mes);
			$('#nss_actualizar').val(response.content.nss);
			$('#curp_actualizar').val(response.content.curp);
			$('#estatus_actividad_actualizar').val(response.content.estatusActividad);
			$('#tipo_trabajador_actualizar').val(response.content.tipoTrabajador);
			$('#estatus_cuenta_actualizar').val(response.content.estatusCuenta);
			$('#codigo_origen_actualizar').val(response.content.codigoOrigen);
			$('#regimen_afiliacion_actualizar').val(response.content.regimenAfiliacion);
			$('#indicador_saldo_actualizar').val(response.content.indicadorSaldo);

		}
	});

});


///////////////////////////   PARA ACTUALIZAR EL REGISTRO  //////////////////////////////////////////////////////////////////


//Function para actualizar informacion del usuario
$(document).on("click", "#btn_actualizarAfiliado", function(e) {
	e.preventDefault();

	debugger; // mostrarte como se ejecuta el codigo linea x linea
	
	// CON EL .VAL PARA RECOGER LA INFORMACION QUE TIENEN LOS CAMPOS, EN FORMATO JSON

	var datoAfiliado = {				// VIENE DESDE EL SERVICIO DE INSERTAR REGISTRO EN ESTE ARCHIVO "datoAfiliado"
		idTrabajador: $('#idAfiliado_actualizar').val(),
		anio: $('#año_actualizar').val(),
		mes: $('#mes_actualizar').val(),
		nss: $('#nss_actualizar').val(),
		curp: $('#curp_actualizar').val(),
		estatusActividad: $('#estatus_actividad_actualizar').val(),
		tipoTrabajador: $('#tipo_trabajador_actualizar').val(),
		estatusCuenta: $('#estatus_cuenta_actualizar').val(),
		codigoOrigen: $('#codigo_origen_actualizar').val(),
		regimenAfiliacion: $('#regimen_afiliacion_actualizar').val(),
		indicadorSaldo: $('#indicador_saldo_actualizar').val()
		
	}

	console.log(datoAfiliado);

	// Ajax: Conexion del frontEnd conectarlo con el BackEnd

	$.ajax({												 // Todo esto contiene el valor del id desde la tabla -> $(this).attr("value");
		type: "POST",
		url: "/Capacitacion/guardarAfore/actualizarAfiliado",
		data: JSON.stringify(datoAfiliado), //-> es la informacion que se le manda al controller por ser una peticion de tipo POST	
		contentType: "application/json",
		dataType: "json",
		success: function(response) {
			console.log(response);
			alert(response.message);

			$('#modalActualizarUsuario').hide(); // ocultar el modal una vez que se actualize correctamente
												// AUNQUE NO FUNCIONA CORRECTAMENTE

			llenarTablaAfiliado(); // Esta es la function que hace el llenado de la tabla entonces hay que llamarlo una vez eliminado el registro de la peticion ->eliminarUsuario


		}
	});

});


///////////////////////////   COMBO BOX DE AÑO  //////////////////////////////////////////////////////////////////


//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO AÑO

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_de_anio(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getAnio",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idAnio + '>' + registro.nombreAnio + '</option>');
	             });
	        },
	    });
	}
	
	
	///////////////////////////   COMBO BOX DE MES  //////////////////////////////////////////////////////////////////


//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO MES

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_de_mes(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getMes",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idMes + '>' + registro.nombreMes + '</option>');
	             });
	        },
	    });
	}


	///////////////////////////   COMBO BOX DE ESTATUS ACTIVIDAD   //////////////////////////////////////////////////////////////////


//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO ESTATUS ACTIVIDAD   

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_de_estatusActividad(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getEstatusAct",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idActividad + '>' + registro.nombreActividad + '</option>');
	             });
	        },
	    });
	}

	
		///////////////////////////   COMBO BOX DE TIPO_TRABAJADOR  //////////////////////////////////////////////////////////////////


//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO TIPO_TRABAJADOR

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_de_tipoTrabajador(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getTipoTrabajador",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idTipo + '>' + registro.tipoTrabajador + '</option>');
	             });
	        },
	    });
	}

			///////////////////////////   COMBO BOX DE ESTATUS_CUENTA  //////////////////////////////////////////////////////////////////


//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO ESTATUS_CUENTA

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_cuenta_ind(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getCuentaIndividual",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idCuentaInd + '>' + registro.estatusCuenta + '</option>');
	             });
	        },
	    });
	}


			///////////////////////////   COMBO BOX DE CODIGO ORIGEN  //////////////////////////////////////////////////////////////////
	
	
	//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO CODIGO ORIGEN

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_codigoOrigen(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getCodigoOrigen",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idCodigo + '>' + registro.codigoOrigen + '</option>');
	             });
	        },
	    });
	}
	
	
				///////////////////////////   COMBO BOX DE REGIMEN DE AFILIACION  //////////////////////////////////////////////////////////////////

				
	//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO REGIMEN DE AFILIACION

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_regimenAfiliacion(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getRegimenAfil",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idRegimen + '>' + registro.regimen + '</option>');
	             });
	        },
	    });
	}
	
			
	
	
					///////////////////////////   COMBO BOX DE INDICADOR DE SALDO  //////////////////////////////////////////////////////////////////

				
	//-- FUNCTIONES PARA LLENAR LOS COMBOS CON EL CATALOGO INDICADOR DE SALDO 

// $.each -> esto equivalente a un for()  en JAVA

//hace el llenado de la lista de estados
function llenar_combo_indicadorSaldo(combo) {
	debugger
	$(combo).empty();
	    $.ajax({
	        type: "get",
	        url: "/Capacitacion/catalogosAfore/getIndicadorSaldo",
	        dataType: "json",
	        success: function (response) {
	            console.log(response);
	            $.each(response, function (key, registro) {
	                $(combo).append('<option value=' + registro.idIndicador + '>' + registro.indicador + '</option>');
	             });
	        },
	    });
	}
		