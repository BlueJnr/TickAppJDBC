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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.calidadsw.entity.TipoUsuario;
import edu.calidadsw.service.ITipoUsuarioService;

@RestController
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ITipoUsuarioService tipoUsuarioService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoUsuario>> getAllTipoUsuarios() {
		logger.info("> getAllTipoUsuarios [TipoUsuario]");

		List<TipoUsuario> list = null;
		try {
			list = tipoUsuarioService.getAllTipoUsuarios();

			if (list != null) {
				
			}else {
				list = new ArrayList<TipoUsuario>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<TipoUsuario>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllTipoUsuarios [TipoUsuario]");
		return new ResponseEntity<List<TipoUsuario>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listar/{idTipoUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoUsuario> getTipoUsuarioById(@PathVariable("idTipoUsuario") Integer idTipoUsuario) {
		logger.info("> getAllTipoUsuariosByIdComida [fecha]");

		TipoUsuario list = null;
			
		try {
			
			list = tipoUsuarioService.getTipoUsuarioById(idTipoUsuario);
			

			if (list == null) {
				list = new TipoUsuario();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<TipoUsuario>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllTipoUsuariosByIdComida [fecha]");
		return new ResponseEntity<TipoUsuario>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registrar(@RequestBody TipoUsuario tipoUsuario) {
		
		return tipoUsuarioService.updateTipoUsuario(tipoUsuario) != null ? "1" : "0";
	}
	

}