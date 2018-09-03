package edu.calidadsw.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.calidadsw.entity.Sancion;
import edu.calidadsw.model.json.Respuesta;
import edu.calidadsw.service.ISancionService;

@RestController
@RequestMapping("/sancion")
public class SancionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ISancionService sancionService;
	

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sancion>> getAllSancions() {
		logger.info("> getAllSancions [Sancion]");

		List<Sancion> list = null;
		try {
			list = sancionService.getAllSancions();

			if (list != null) {
				
			}else {
				list = new ArrayList<Sancion>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Sancion>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllSancions [Sancion]");
		return new ResponseEntity<List<Sancion>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/aplicar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> aplicarSancion() {

		Respuesta respuesta;
		Integer estado ;
		String mensaje;

		try {
			estado = sancionService.aplicarSancion();
			mensaje = estado != 0 ? "SE LOGRO SANCIONAR":"NO HAY SANCIONADOS";
			respuesta = new Respuesta(estado, mensaje);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/quitar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> quitarSancion() {

		Respuesta respuesta;
		Integer estado ;
		String mensaje;

		try {
			estado = sancionService.quitarSancion();
			mensaje = estado != 0 ? "SE LOGRO QUITAR SANCIONES":"NO SE QUITO NIGUNA SANCION";
			respuesta = new Respuesta(estado, mensaje);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
		
}
