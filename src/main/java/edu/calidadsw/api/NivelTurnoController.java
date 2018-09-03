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
import org.springframework.web.bind.annotation.RestController;

import edu.calidadsw.entity.NivelTurno;
import edu.calidadsw.model.json.Respuesta;
import edu.calidadsw.service.INivelTurnoService;

@RestController
@RequestMapping("/nivelturno")
public class NivelTurnoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private INivelTurnoService nivelTurnoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NivelTurno>> getAllNivelTurnos() {
		logger.info("> getAllNivelTurnos [NivelTurno]");

		List<NivelTurno> list = null;
		try {
			list = nivelTurnoService.getAllNivelTurnos();

			if (list != null) {
				
			}else {
				list = new ArrayList<NivelTurno>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<NivelTurno>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllNivelTurnos [NivelTurno]");
		return new ResponseEntity<List<NivelTurno>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listar/{idComida}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NivelTurno>> getAllNivelTurnosByIdComida(@PathVariable("idComida") Integer idComida) {
		logger.info("> getAllNivelTurnosByIdComida [fecha]");

		List<NivelTurno> list = null;
			
		try {
			
			list = nivelTurnoService.getAllNivelTurnosByIdComida(idComida);

			if (list == null) {
				list = new ArrayList<NivelTurno>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<NivelTurno>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllNivelTurnosByIdComida [fecha]");
		return new ResponseEntity<List<NivelTurno>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listar/{idComida}/{nivel}/{turno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> getIdNivelTurnoByIdComidaNivelTurno(@PathVariable("idComida") int idComida,@PathVariable("nivel") int nivel,@PathVariable("turno") int turno) {
		logger.info("> getAllNivelTurnosByIdComida [fecha]");

		Respuesta respuesta;
		Integer estado ;
		String mensaje;
			
		try {
			
			estado = nivelTurnoService.getIdNivelTurnoByIdComidaNivelTurno(idComida, nivel, turno);
			mensaje = estado != 0 ? "SE OBTUVO EL ID CON EXITO":"NO SE OBTUVO EL ID";
			respuesta = new Respuesta(estado, mensaje );

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			respuesta = new Respuesta();
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllNivelTurnosByIdComida [fecha]");
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateComida(@RequestBody NivelTurno nivelTurno) {

		Integer update = null;
		try {
			update = nivelTurnoService.updateNivelTurno(nivelTurno);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(update, HttpStatus.OK);
	}
	
	@RequestMapping(value = "list/actualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateComida(@RequestBody List<NivelTurno> nivelTurnoList) {

		Integer update = null;
		try {
			update = nivelTurnoService.updateNivelTurno(nivelTurnoList);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(update, HttpStatus.OK);
	}
}