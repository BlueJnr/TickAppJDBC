package edu.calidadsw.api;


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

import edu.calidadsw.entity.UsuarioJOINTicketJOINNivelTurno;
import edu.calidadsw.service.IUsuarioJOINTicketJOINNivelTurnoService;

@RestController
@RequestMapping("/usuario/ticket/nivelturno")
public class UsuarioJOINTicketJOINNivelTurnoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUsuarioJOINTicketJOINNivelTurnoService service;

	@RequestMapping(value = "/leer/{codigo}/{comidaTipo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioJOINTicketJOINNivelTurno> getId(@PathVariable("codigo") String codigo,@PathVariable("comidaTipo") String comidaTipo){
		logger.info("> getId [Persona]");
		
		UsuarioJOINTicketJOINNivelTurno per = null;
		try {
			per = service.getUsuarioJOINTicketJOINNivelTurnoById(codigo, comidaTipo);

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			per = new UsuarioJOINTicketJOINNivelTurno();
			return new ResponseEntity<UsuarioJOINTicketJOINNivelTurno>(per, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< get [Persona]");
		return new ResponseEntity<UsuarioJOINTicketJOINNivelTurno>(per, HttpStatus.OK);
	}
}

