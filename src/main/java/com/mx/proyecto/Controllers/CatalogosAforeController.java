package com.mx.proyecto.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mx.proyecto.Entity.AnioEntity;
import com.mx.proyecto.Entity.CodigoOrigenEntity;
import com.mx.proyecto.Entity.EstatusActividadEntity;
import com.mx.proyecto.Entity.MesEntity;
import com.mx.proyecto.Entity.RegimenAfilEntity;
import com.mx.proyecto.Entity.EstatusCuentaEntity;
import com.mx.proyecto.Entity.IndicadorSaldoEntity;
import com.mx.proyecto.Entity.TipoTrabajadorEntity;
import com.mx.proyecto.Services.CatalogosAforeService;

@Controller
@RequestMapping(value="catalogosAfore")
public class CatalogosAforeController {
	
	@Autowired
	private CatalogosAforeService catalogosAforeService;
	
	// UNA CONSULTA PARA OBTENER TODOS LOS AÑOS EXISTENTES PRESENTARLOS EN UN COMBO
		// BOX PARA QUE EL USUARIO ELIJA EL AÑO
		@ResponseBody
		@RequestMapping(value = "/getAnio", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity<List<AnioEntity>> obtenerAnio() {
			final HttpHeaders httpHeaders = new HttpHeaders();

			List<AnioEntity> respuesta = catalogosAforeService.getAnio();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity<List<AnioEntity>>(respuesta, httpHeaders, HttpStatus.OK);
		}
		
		
		// UNA CONSULTA PARA OBTENER TODOS LOS MESES EXISTENTES PRESENTARLOS EN UN COMBO
				// BOX PARA QUE EL USUARIO ELIJA EL MES
				@ResponseBody
				@RequestMapping(value = "/getMes", method = RequestMethod.GET, produces = "application/json")
				public ResponseEntity<List<MesEntity>> obtenerMes() {
					final HttpHeaders httpHeaders = new HttpHeaders();

					List<MesEntity> respuesta = catalogosAforeService.getMes();

					httpHeaders.setContentType(MediaType.APPLICATION_JSON);

					return new ResponseEntity<List<MesEntity>>(respuesta, httpHeaders, HttpStatus.OK);
				}
				
				
				// UNA CONSULTA PARA OBTENER TODOS LOS ESTATUS EXISTENTES PRESENTARLOS EN UN COMBO
				// BOX PARA QUE EL USUARIO ELIJA EL ESTATUS
				@ResponseBody
				@RequestMapping(value = "/getEstatusAct", method = RequestMethod.GET, produces = "application/json")
				public ResponseEntity<List<EstatusActividadEntity>> obtenerEstatusAct() {
					final HttpHeaders httpHeaders = new HttpHeaders();

					List<EstatusActividadEntity> respuesta = catalogosAforeService.getEstatusAct();

					httpHeaders.setContentType(MediaType.APPLICATION_JSON);

					return new ResponseEntity<List<EstatusActividadEntity>>(respuesta, httpHeaders, HttpStatus.OK);
				}
				
				
				// UNA CONSULTA PARA OBTENER TODOS LOS ESTATUS EXISTENTES PRESENTARLOS EN UN COMBO
				// BOX PARA QUE EL USUARIO ELIJA EL ESTATUS
				@ResponseBody
				@RequestMapping(value = "/getTipoTrabajador", method = RequestMethod.GET, produces = "application/json")
				public ResponseEntity<List<TipoTrabajadorEntity>> obtenerTipoTrabajador() {
					final HttpHeaders httpHeaders = new HttpHeaders();

					List<TipoTrabajadorEntity> respuesta = catalogosAforeService.getTipoTrabajador();

					httpHeaders.setContentType(MediaType.APPLICATION_JSON);

					return new ResponseEntity<List<TipoTrabajadorEntity>>(respuesta, httpHeaders, HttpStatus.OK);
				}
				
				
				// UNA CONSULTA PARA OBTENER TODOS LOS ESTATUS EXISTENTES PRESENTARLOS EN UN COMBO
				// BOX PARA QUE EL USUARIO ELIJA EL ESTATUS INDIVIDUAL
				@ResponseBody
				@RequestMapping(value = "/getCuentaIndividual", method = RequestMethod.GET, produces = "application/json")
				public ResponseEntity<List<EstatusCuentaEntity>> obtenerCuentaInd() {
					final HttpHeaders httpHeaders = new HttpHeaders();

					List<EstatusCuentaEntity> respuesta = catalogosAforeService.getCuentaIndividual();

					httpHeaders.setContentType(MediaType.APPLICATION_JSON);

					return new ResponseEntity<List<EstatusCuentaEntity>>(respuesta, httpHeaders, HttpStatus.OK);
				}
				
				
				// UNA CONSULTA PARA OBTENER TODOS LOS ESTATUS EXISTENTES PRESENTARLOS EN UN COMBO
				// BOX PARA QUE EL USUARIO ELIJA EL CODIGO ORIGEN
				@ResponseBody
				@RequestMapping(value = "/getCodigoOrigen", method = RequestMethod.GET, produces = "application/json")
				public ResponseEntity<List<CodigoOrigenEntity>> obtenerCodigoOrigen() {
					final HttpHeaders httpHeaders = new HttpHeaders();

					List<CodigoOrigenEntity> respuesta = catalogosAforeService.getCodigoOrigen();

					httpHeaders.setContentType(MediaType.APPLICATION_JSON);

					return new ResponseEntity<List<CodigoOrigenEntity>>(respuesta, httpHeaders, HttpStatus.OK);
				}
				
				
				// UNA CONSULTA PARA OBTENER TODOS LOS ESTATUS EXISTENTES PRESENTARLOS EN UN COMBO
				// BOX PARA QUE EL USUARIO ELIJA EL REGIMEN DE AFILIACION
				@ResponseBody
				@RequestMapping(value = "/getRegimenAfil", method = RequestMethod.GET, produces = "application/json")
				public ResponseEntity<List<RegimenAfilEntity>> obtenerRegimenAfil() {
					final HttpHeaders httpHeaders = new HttpHeaders();

					List<RegimenAfilEntity> respuesta = catalogosAforeService.getRegimenAfil();

					httpHeaders.setContentType(MediaType.APPLICATION_JSON);

					return new ResponseEntity<List<RegimenAfilEntity>>(respuesta, httpHeaders, HttpStatus.OK);
				}
				
				
				// UNA CONSULTA PARA OBTENER TODOS LOS ESTATUS EXISTENTES PRESENTARLOS EN UN COMBO
				// BOX PARA QUE EL USUARIO ELIJA EL INDICADOR DE SALDO
				@ResponseBody
				@RequestMapping(value = "/getIndicadorSaldo", method = RequestMethod.GET, produces = "application/json")
				public ResponseEntity<List<IndicadorSaldoEntity>> obtenerIndicador() {
					final HttpHeaders httpHeaders = new HttpHeaders();

					List<IndicadorSaldoEntity> respuesta = catalogosAforeService.getIndicadorSaldo();

					httpHeaders.setContentType(MediaType.APPLICATION_JSON);

					return new ResponseEntity<List<IndicadorSaldoEntity>>(respuesta, httpHeaders, HttpStatus.OK);
				}


}//FIN DE LA CLASE
