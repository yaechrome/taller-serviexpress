
package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Recepcion;
import cl.taller.serviexpress.services.impl.RecepcionServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.RecepcionFormatedViewModel;
import cl.taller.serviexpress.web.frontend.viewmodel.RecepcionViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	RecepcionServicesImpl recepcionServices;
    
    private static final String INDEX_URL="Recepcion";
    private static final String RECEPTION_URL="CrearRecepcion";

    @RequestMapping
    public String index(Model model) {
    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		List<Recepcion> recepciones = recepcionServices.listarRecepciones();
        List<RecepcionFormatedViewModel> recepcionesFormateadas = new ArrayList<RecepcionFormatedViewModel>();
        for (Recepcion i : recepciones) {
        	RecepcionFormatedViewModel recepcion = new RecepcionFormatedViewModel();
        	recepcion.setId(i.getId());
        	recepcion.setOrdenCompra(i.getOrdenCompra());
        	recepcion.setIdUsuario(i.getIdUsuario());
        	recepcion.setFechaRecepcion(formatter.format(i.getFechaRecepcion()));
        	recepcion.setValorTotal(i.getValorTotal());
        	recepcion.setEstadoRecepcion(i.getEstadoRecepcion());
        	recepcion.setRecepcionProducto(i.getRecepcionProducto());
        	recepcionesFormateadas.add(recepcion);
        }
		model.addAttribute("recepciones", recepcionesFormateadas);
    	model.addAttribute("RecepcionViewModel", new RecepcionViewModel());
    	
        return INDEX_URL;
    }
    
    @RequestMapping(value="/CrearRecepcion",method=RequestMethod.GET)
    public String verCrearRecepcion(@Valid RecepcionViewModel recepcionViewModel, BindingResult result,Model model) {
		List<Recepcion> recepciones = recepcionServices.listarRecepciones();
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
    	
    	if(recepcionServices.crearRecepcion(recepcion)) {
    		List<Recepcion> recepciones = recepcionServices.listarRecepciones();
    		model.addAttribute("recepciones", recepciones);
    		model.addAttribute("RecepcionViewModel", new RecepcionViewModel());
    	}
        
    	return INDEX_URL;
    }
    
    @RequestMapping(value="/BuscarRecepcionPorOrden/{id}",method=RequestMethod.GET)
    public String buscarRecepcion(@Valid RecepcionViewModel recepcionViewModel, BindingResult result,Model model) {
		List<Recepcion> recepciones = recepcionServices.listarRecepcionPorOrden(recepcionViewModel.getOrdenCompra().getId());
		model.addAttribute("recepciones", recepciones);
                
    	model.addAttribute("RecepcionViewModel", new RecepcionViewModel());
    	return INDEX_URL;
    }
}
