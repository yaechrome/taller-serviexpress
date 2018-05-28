
package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Recepcion;
import cl.taller.serviexpress.domain.RecepcionProducto;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.services.impl.RecepcionServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.RecepcionViewModel;
import cl.taller.serviexpress.web.frontend.viewmodel.UserViewModel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Recepcion")
public class RecepcionController {
    @Autowired
	RecepcionServicesImpl recepcionDao;
    
    private static final String INDEX_URL="Recepcion";
    private static final String RECEPTION_URL="CrearRecepcion";
    private static final String CREATE_RECEPTION_URL = "Recepcion/CrearRecepcion";
    private static final String CREATE_RECEPTIONPRODUCT_URL = "RecepcionProducto/CrearRecepcionProducto";
    private static final String EDIT_RECEPTION = "user/editUser";

    @RequestMapping
    public String index(Model model) {
		List<Recepcion> recepciones = recepcionDao.listarRecepciones();
		model.addAttribute("recepciones", recepciones);
    	model.addAttribute("RecepcionViewModel", new RecepcionViewModel());
    	
        return INDEX_URL;
    }
    
    @RequestMapping(value="/CrearRecepcion",method=RequestMethod.GET)
    public String verCrearRecepcion(@Valid RecepcionViewModel recepcionViewModel, BindingResult result,Model model) {
		List<Recepcion> recepciones = recepcionDao.listarRecepciones();
		model.addAttribute("recepciones", recepciones);
    	model.addAttribute("RecepcionViewModel", new RecepcionViewModel());
    	
    	return RECEPTION_URL;
    }
    
    @RequestMapping(value="/CrearRecepcion",method=RequestMethod.POST)
    public String createReception(@Valid RecepcionViewModel recepcionViewModel, BindingResult result,Model model) {
		
    	Recepcion recepcion = new Recepcion();
        
        recepcion.setIdUsuario(recepcionViewModel.getIdUsuario());
        recepcion.setOrdenCompra(recepcionViewModel.getOrdenCompra());
        recepcion.setEstadoRecepcion(recepcionViewModel.getEstadoRecepcion());
        recepcion.setFechaRecepcion(recepcionViewModel.getFechaRecepcion());
        recepcion.setValorTotal(recepcionViewModel.getValorTotal());
        recepcion.setRecepcionProducto(recepcionViewModel.getRecepcionProducto());
    	
    	if(recepcionDao.crearRecepcion(recepcion)) {
    		List<Recepcion> recepciones = recepcionDao.listarRecepciones();
    		model.addAttribute("recepciones", recepciones);
    		model.addAttribute("RecepcionViewModel", new RecepcionViewModel());
    	}
        
    	return INDEX_URL;
    }
    
    @RequestMapping(value="/BuscarRecepcionPorOrden/{id}",method=RequestMethod.GET)
    public String buscarRecepcion(@Valid RecepcionViewModel recepcionViewModel, BindingResult result,Model model) {
		List<Recepcion> recepciones = recepcionDao.listarRecepcionPorOrden(recepcionViewModel.getOrdenCompra().getId());
		model.addAttribute("recepciones", recepciones);
                
    	model.addAttribute("RecepcionViewModel", new RecepcionViewModel());
    	return INDEX_URL;
    }
}
