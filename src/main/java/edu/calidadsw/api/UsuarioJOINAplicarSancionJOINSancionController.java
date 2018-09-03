package edu.calidadsw.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.calidadsw.entity.AplicarSancionJOINSancion;
import edu.calidadsw.entity.UsuarioJOINAplicarSancionJOINSancion;
import edu.calidadsw.service.IUsuarioJOINAplicarSancionJOINSancionService;

@RestController
@RequestMapping("/usuario/aplicarsancion/sancion")
public class UsuarioJOINAplicarSancionJOINSancionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUsuarioJOINAplicarSancionJOINSancionService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioJOINAplicarSancionJOINSancion>> getAllUsuarioJOINAplicarSancionJOINSancions() {
		logger.info("> getAllUsuarioJOINAplicarSancionJOINSancions [UsuarioJOINAplicarSancionJOINSancion]");

		List<UsuarioJOINAplicarSancionJOINSancion> list = null;
		try {
			list = service.getAllUsuarioJOINAplicarSancionJOINSancions();

			if (list != null) {
				
			}else {
				list = new ArrayList<UsuarioJOINAplicarSancionJOINSancion>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<UsuarioJOINAplicarSancionJOINSancion>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllUsuarioJOINAplicarSancionJOINSancions [UsuarioJOINAplicarSancionJOINSancion]");
		return new ResponseEntity<List<UsuarioJOINAplicarSancionJOINSancion>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AplicarSancionJOINSancion>> getAllUsuarioJOINAplicarSancionJOINSancions(@PathVariable("idUsuario") Integer idUsuario) {
		logger.info("> getAllUsuarioJOINAplicarSancionJOINSancions [UsuarioJOINAplicarSancionJOINSancion]");

		List<AplicarSancionJOINSancion> list = null;
		try {
			list = service.getAllUsuarioJOINAplicarSancionJOINSancions(idUsuario);

			if (list != null) {
				
			}else {
				list = new ArrayList<AplicarSancionJOINSancion>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<AplicarSancionJOINSancion>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllUsuarioJOINAplicarSancionJOINSancions [UsuarioJOINAplicarSancionJOINSancion]");
		return new ResponseEntity<List<AplicarSancionJOINSancion>>(list, HttpStatus.OK);
	}
}

