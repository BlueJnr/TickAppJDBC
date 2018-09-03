package edu.calidadsw.api;

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

import edu.calidadsw.entity.TicketJOINNivelTurnoJOINComida;
import edu.calidadsw.service.ITicketJOINNivelTurnoJOINComidaService;

@RestController
@RequestMapping("/ticket/nivelturno/comida")
public class TicketJOINNivelTurnoJOINComidaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ITicketJOINNivelTurnoJOINComidaService service;
	

	@RequestMapping(value = "/listar/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketJOINNivelTurnoJOINComida> getAllTicketJOINNivelTurnoJOINComidas(@PathVariable("idUsuario") Integer idUsuario) {
		logger.info("> getAllTicketJOINNivelTurnoJOINComidas [TicketJOINNivelTurnoJOINComida]");

		List<TicketJOINNivelTurnoJOINComida> list;
		TicketJOINNivelTurnoJOINComida ticketJOINNivelTurnoJOINComida = null;

		try {
			list = service.getAllTicketJOINNivelTurnoJOINComidas(idUsuario);
			ticketJOINNivelTurnoJOINComida = list.get(0);
			if(list != null) {
				ticketJOINNivelTurnoJOINComida = list.get(0);
			}

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<TicketJOINNivelTurnoJOINComida>(ticketJOINNivelTurnoJOINComida, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllTicketJOINNivelTurnoJOINComidas [TicketJOINNivelTurnoJOINComida]");
		return new ResponseEntity<TicketJOINNivelTurnoJOINComida>(ticketJOINNivelTurnoJOINComida, HttpStatus.OK);
	}
}
