package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Servicio;
import cl.taller.serviexpress.services.impl.ServicioServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.ServicioViewModel;
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
@RequestMapping("/Servicio")
public class ServicioController {
    @Autowired
    ServicioServicesImpl servicioDao;
    
    
    private static final String INDEX_URL="Servicio";
    private static final String SERVICE_URL="CrearServicio";
    private static final String CREATE_SERVICE_URL = "Servicio/CrearServicio";
    
    @RequestMapping
    public String index(Model model) {
        
        List<Servicio> servicios = servicioDao.listarServicios();
        model.addAttribute("servicios", servicios);
    	model.addAttribute("ServicioViewModel", new ServicioViewModel());
    	
        return INDEX_URL;
    }
    
    @RequestMapping(value="/CrearServicio",method=RequestMethod.GET)
    public String verCrearServicio(@Valid ServicioViewModel serviceViewModel, BindingResult result,Model model) {
        List<Servicio> servicios = servicioDao.listarServicios();
        model.addAttribute("servicios", servicios);
    	model.addAttribute("ServicioViewModel", new ServicioViewModel());
    	
    	return SERVICE_URL;
    }
    
    @RequestMapping(value="/CrearServicio",method=RequestMethod.POST)
    public String createServicio(@Valid ServicioViewModel serviceViewModel, BindingResult result,Model model) {
		
    	Servicio servicio = new Servicio();
    	

    	servicio.setDescripcionServicio(serviceViewModel.getDescripcionServicio());
    	servicio.setEstadoServicio(serviceViewModel.getEstadoServicio());
    	servicio.setValor(serviceViewModel.getValor());
    	
    	
    	if(servicioDao.crearServicio(servicio)) {
    	
    		List<Servicio> servicios = servicioDao.listarServicios();
    		model.addAttribute("servicios", servicios);
    		model.addAttribute("ServicioViewModel", new ServicioViewModel());
    	}
    	return INDEX_URL;
    }
}
