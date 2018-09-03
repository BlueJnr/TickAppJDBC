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

import edu.calidadsw.entity.Ticket;
import edu.calidadsw.entity.TicketJOINNivelTurnoJOINComida;
import edu.calidadsw.model.json.Respuesta;
import edu.calidadsw.service.ITicketJOINNivelTurnoJOINComidaService;
import edu.calidadsw.service.ITicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ITicketService ticketService;
	
	@Autowired
	private ITicketJOINNivelTurnoJOINComidaService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> getAllTickets() {
		logger.info("> getAllTickets [Ticket]");

		List<Ticket> list = null;
		try {
			list = ticketService.getAllTickets();

			if (list != null) {
				
			}else {
				list = new ArrayList<Ticket>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Ticket>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllTickets [Ticket]");
		return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateTicket(@RequestBody Ticket ticket) {

		Integer update = null;
		try {
			update = ticketService.updateTicket(ticket);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(update, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cancelar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> cancelarTicket(@RequestBody Ticket ticket) {

		Respuesta respuesta;
		Integer estado ;
		String mensaje;

		try {
			estado = ticketService.cancelarTicket(ticket);
			if(estado !=0) {
				mensaje = "SE LOGRO CANCELAR EL TICKET";
				ticketService.addTicket(ticketService.removeTicketCola(ticket));
			}else {
				mensaje = "NO SE PUDO CANCELAR EL TICKET";
			}
			respuesta = new Respuesta(estado, mensaje);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/validar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> validarTicket(@RequestBody Ticket ticket) {

		Respuesta respuesta;
		Integer estado ;
		String mensaje;

		try {
			estado = ticketService.validarTicket(ticket);
			mensaje = estado != 0 ? "SE LOGRO VALIDAR EL TICKET":"NO SE PUDO VALIDAR EL TICKET";
			respuesta = new Respuesta(estado, mensaje);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add/cola", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> addTicketCola(@RequestBody Ticket ticket) {
		
		Respuesta respuesta;
		Integer estado ;
		String mensaje;

		try {
			estado = ticketService.addTicketCola(ticket);
			mensaje = estado != 0 ? "LOGRO ENTRAR A LA COLA":"NO LOGRO ENTRAR A LA COLA";
			respuesta = new Respuesta(estado, mensaje);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketJOINNivelTurnoJOINComida> addTicket(@RequestBody Ticket ticket) {

		List<TicketJOINNivelTurnoJOINComida> ticketJOINNivelTurnoJOINComidaList=null;
		TicketJOINNivelTurnoJOINComida ticketJOINNivelTurnoJOINComida = null;
		Integer add = null;
		try {
			add = ticketService.addTicket(ticket);
			if(add!=0) {
				ticketJOINNivelTurnoJOINComidaList = service.getAllTicketJOINNivelTurnoJOINComidas(ticket.getIdUsuario());
				ticketJOINNivelTurnoJOINComida = ticketJOINNivelTurnoJOINComidaList.get(0);
			}else {
				ticketJOINNivelTurnoJOINComidaList = new ArrayList<TicketJOINNivelTurnoJOINComida>();
				ticketJOINNivelTurnoJOINComida = new TicketJOINNivelTurnoJOINComida();
			}
		} catch (Exception e) {
			return new ResponseEntity<TicketJOINNivelTurnoJOINComida>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<TicketJOINNivelTurnoJOINComida>(ticketJOINNivelTurnoJOINComida, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/validar/hora/reserva/{idComida}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> validarHoraReserva(@PathVariable("idComida") Integer idComida) {
		logger.info("> validarReserva [Ticket]");
		logger.info("idComida -> "+idComida);

		Respuesta respuesta;
		Integer estado ;
		String mensaje;
		
		try {
			
			estado = ticketService.validarHoraReserva(idComida);
			logger.info("ESTADOOOOOO"+estado);
			mensaje = estado != 0 ? "HORA VALIDA PARA RESERVAR":"HORA NO VALIDA PARA RESERVAR";
			respuesta = new Respuesta(estado, mensaje);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/validar/reserva/{idUsuario}/{idComida}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> validarReserva(@PathVariable("idUsuario") Integer idUsuario,
			@PathVariable("idComida") Integer idComida) {
		logger.info("> validarReserva [Ticket]");
		logger.info("idUsuario -> "+idUsuario);
		logger.info("idComida -> "+idComida);

		Respuesta respuesta;
		Integer estado ;
		String mensaje;
		
		try {
			
			estado = ticketService.validarReserva(idUsuario,idComida);
			logger.info("ESTADOOOOOO"+estado);
			mensaje = estado != 0 ? "HABILITADO PARA RESERVAR":"INHABILITADO PARA RESERVAR";
			respuesta = new Respuesta(estado, mensaje);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/validar/cantidad/{idComida}/{idNivelTurno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> validarCantidadNivelTurno(@PathVariable("idComida") Integer idComida,
			@PathVariable("idNivelTurno") Integer idNivelTurno) {
		logger.info("> validarCantidadNivelTurno [Ticket]");

		Respuesta respuesta;
		Integer estado ;
		String mensaje;
		try {
			estado = ticketService.validarCantidadNivelTurno(idComida,idNivelTurno);
			mensaje = estado != 0 ? "CANTIDAD DISPONIBLE DE TICKETS":"NO HAY TICKETS DISPONIBLES";
			respuesta = new Respuesta(estado, mensaje );
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
}
