package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Reserva;
import cl.taller.serviexpress.domain.Servicio;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.services.impl.ReservaServicesImpl;
import cl.taller.serviexpress.services.impl.ServicioServicesImpl;
import cl.taller.serviexpress.services.impl.UsuarioServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.ReservaViewModel;
import cl.taller.serviexpress.web.frontend.viewmodel.UserViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nippo
 */
@Controller
@RequestMapping("/Reserva")
public class ReservaController {

	@Autowired
	ReservaServicesImpl reservaServices;
	
	@Autowired
	UsuarioServicesImpl userServices;

    private static final String INDEX_URL = "Reserva";
    private static final String RESERVA_URL = "CrearReserva";
    private static final String READ_URL = "LeerUsuario";
    private static final String EDIT_URL = "EditarServicio";

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("UserViewModel", new UserViewModel());
        return INDEX_URL;
    }

    @SuppressWarnings("deprecation")
	@RequestMapping(value = "/CrearReserva", method = RequestMethod.POST)
    public String createServicio(@Valid ReservaViewModel reservaViewModel, BindingResult result, Model model) {

        Reserva reserva = new Reserva();
        Usuario usuario = userServices.buscarPorID(reservaViewModel.getIdMecanico());
        reserva.setUsuario(usuario);
        reserva.setDescripcionReserva(reservaViewModel.getDescripcion());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        Date fecha;
		try {
			fecha = formatter.parse(reservaViewModel.getFecha());
	        String hora = reservaViewModel.getHora().substring(0, 2);
	        String minuto = reservaViewModel.getHora().substring(3, 5);
	        fecha.setHours(Integer.parseInt(hora));
	        fecha.setMinutes(Integer.parseInt(minuto));
	        reserva.setFechaReserva(fecha);
	        reservaServices.crearReseva(reserva);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("UserViewModel", new UserViewModel());
        return INDEX_URL;
    }

    @RequestMapping(value = {"/LeerUsuario"}, method = RequestMethod.GET)
    public String leerUsuario(@Valid UserViewModel userViewModel, BindingResult result, Model model) {
        Usuario usuario = userServices.buscarPorRut(userViewModel.getRut());
        List<Usuario> users = userServices.listarUsuarios();
        List<Usuario> mecanicos = new ArrayList<Usuario>();
        for(Usuario u : users) {
        	if(u.getPerfil().getId() == 3L)
        		mecanicos.add(u);
        }
        model.addAttribute("mecanicos" , mecanicos);
        model.addAttribute("usuario", usuario);
        model.addAttribute("reservaViewModel",new ReservaViewModel());
        
        return RESERVA_URL;
    }

}
