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

import edu.calidadsw.entity.Usuario;
import edu.calidadsw.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUsuarioService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		logger.info("> getAllUsuarios [Usuario]");

		List<Usuario> list = null;
		try {
			list = service.getAllUsuarios();

			if (list != null) {
				
			}else {
				list = new ArrayList<Usuario>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Usuario>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllUsuarios [Usuario]");
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/leer/{user}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUsuario(@PathVariable("user") String user,
			@PathVariable("password") String password) {
		logger.info("> getUsuario [Usuario]");

		Usuario usuario = null;
		try {
			usuario = service.getUsuarioByUusuarioPassword(user, password);

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (usuario == null) {
			logger.error("Unexpected NullPointerException caught.");
			return new ResponseEntity<Usuario>(usuario, HttpStatus.UNAUTHORIZED);
		} else {
			logger.info("< getUsuario [Usuario]");
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}

	}
}
