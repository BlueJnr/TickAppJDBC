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

import edu.calidadsw.entity.Accede;
import edu.calidadsw.model.json.UpdateAccesoComida;
import edu.calidadsw.service.IAccedeService;

@RestController
@RequestMapping("/accede")
public class AccedeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAccedeService accedeService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Accede>> getAllAccedes() {
		logger.info("> getAllAccedes [Accede]");

		List<Accede> list = null;
		try {
			list = accedeService.getAllAccedes();

			if (list != null) {

			} else {
				list = new ArrayList<Accede>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Accede>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllAccedes [Accede]");
		return new ResponseEntity<List<Accede>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar/{idComida}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Accede>> getAllAccedesByIdComida(@PathVariable("idComida") Integer idComida) {
		logger.info("> getAllAccedesByIdComida [fecha]");

		List<Accede> list = null;

		try {

			list = accedeService.getAllAccedesByIdComida(idComida);

			if (list == null) {
				list = new ArrayList<Accede>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Accede>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllAccedesByIdComida [fecha]");
		return new ResponseEntity<List<Accede>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateAccede(@RequestBody Accede accede) {

		Integer update = null;
		try {
			update = accedeService.updateAccede(accede);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(update, HttpStatus.OK);
	}

	@RequestMapping(value = "/comida/actualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateAccesoComida(@RequestBody UpdateAccesoComida updateAccesoComida) {

		logger.info("1 . " + updateAccesoComida);

		Integer update = null;
		try {
			logger.info("2 . " + updateAccesoComida);
			update = accedeService.updateAccesoComida(updateAccesoComida);
			logger.info("3 ." + updateAccesoComida);
		} catch (Exception e) {
			logger.info("4 ." + updateAccesoComida);
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("5 ." + updateAccesoComida);
		return new ResponseEntity<Integer>(update, HttpStatus.OK);
	}

}