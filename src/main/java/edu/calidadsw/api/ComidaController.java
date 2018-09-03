package edu.calidadsw.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import edu.calidadsw.entity.Comida;
import edu.calidadsw.model.json.AddComida;
import edu.calidadsw.model.json.MenuSemanal;
import edu.calidadsw.service.IComidaService;

@RestController
@RequestMapping("/comida")
public class ComidaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IComidaService comidaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comida>> getAllComidas() {
		logger.info("> getAllComidas [Comida]");

		List<Comida> list = null;
		try {
			list = comidaService.getAllComidas();

			if (list != null) {
				
			}else {
				list = new ArrayList<Comida>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Comida>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllComidas [Comida]");
		return new ResponseEntity<List<Comida>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/hoy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comida>> getComida() {
		logger.info("> getAllComidas [Comida]");

		List<Comida> list = null;
		try {
			list = comidaService.getComida();

			if (list != null) {
				
			}else {
				list = new ArrayList<Comida>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Comida>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllComidas [Comida]");
		return new ResponseEntity<List<Comida>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listar/semanal/{fechaFiltro}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MenuSemanal> getComidaIdByWeek(@PathVariable("fechaFiltro") String fechaFiltro) {
		logger.info("> getComidaIdByWeek [fecha]");

		List<Comida> list = null;
		MenuSemanal menuSemanal = null;
		
		Date fecha;
		DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			fecha = formateador.parse(fechaFiltro);
			
			list = comidaService.getComidaIdByWeek(fecha);

			if (list != null) {
				menuSemanal = new MenuSemanal();
				menuSemanal.setLunes(list.subList(0, 3));
				menuSemanal.setMartes(list.subList(3, 6));
				menuSemanal.setMiercoles(list.subList(6, 9));
				menuSemanal.setJueves(list.subList(9, 12));
				menuSemanal.setViernes(list.subList(12, 15));
				menuSemanal.setSabado(list.subList(15, 18));
				menuSemanal.setDomingo(list.subList(18, 21));
			}else {
				list = new ArrayList<Comida>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<MenuSemanal>(menuSemanal, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getComidaIdByWeek [fecha]");
		return new ResponseEntity<MenuSemanal>(menuSemanal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listar/semanal/android", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MenuSemanal> getComidaIdByWeek() {
		logger.info("> getComidaIdByWeek [fecha]");

		List<Comida> list = null;
		MenuSemanal menuSemanal = null;
				
		try {
						
			list = comidaService.getComidaIdByWeek();

			if (list != null) {
				menuSemanal = new MenuSemanal();
				menuSemanal.setLunes(list.subList(0, 3));
				menuSemanal.setMartes(list.subList(3, 6));
				menuSemanal.setMiercoles(list.subList(6, 9));
				menuSemanal.setJueves(list.subList(9, 12));
				menuSemanal.setViernes(list.subList(12, 15));
				menuSemanal.setSabado(list.subList(15, 18));
				menuSemanal.setDomingo(list.subList(18, 21));
			}else {
				list = new ArrayList<Comida>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<MenuSemanal>(menuSemanal, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getComidaIdByWeek [fecha]");
		return new ResponseEntity<MenuSemanal>(menuSemanal, HttpStatus.OK);
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateComida(@RequestBody Comida comida) {

		Integer update = null;
		try {
			update = comidaService.updateComida(comida);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(update, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> addComida(@RequestBody AddComida addComida) {

		Integer add = null;
		try {
			add = comidaService.addComida(addComida);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(add, HttpStatus.OK);
	}
	
	@RequestMapping(value = "list/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateComida(@RequestBody List<Comida> comidaList) {

		logger.info("1. "+ comidaList);
		Integer update = null;
		try {
			logger.info("2. "+ comidaList);
			update = comidaService.addListComida(comidaList);
			logger.info("3. "+ comidaList);
		} catch (Exception e) {
			logger.info("4. "+ comidaList);
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("5. "+ comidaList);
		return new ResponseEntity<Integer>(update, HttpStatus.OK);
	}

}