package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.domain.OrdenProducto;
import cl.taller.serviexpress.services.impl.OrdenServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.IdViewModel;
import cl.taller.serviexpress.web.frontend.viewmodel.OrdenCompraViewModel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/OrdenCompra")
public class OrdenCompraController {
    
	@Autowired
    OrdenServicesImpl ordenCompraDao;
    
    private static final String INDEX_URL="OrdenCompra";
    private static final String ORDER_URL="CrearOrdenCompra";
    private static final String CREATE_ORDER_URL = "OrdenCompra/CrearOrdenCompra";

    @RequestMapping
    public String index(Model model) {
        
        List<OrdenCompra> orden = ordenCompraDao.listarOrdenCompra();
        model.addAttribute("orden", orden);
    	model.addAttribute("OrdenCompraViewModel", new OrdenCompraViewModel());
    	
        return INDEX_URL;
    }

    @RequestMapping(value="/CrearOrdenCompra",method=RequestMethod.GET)
    public String verCrearOrdenCompra(@Valid OrdenCompraViewModel ordenCompraViewModel, BindingResult result,Model model) {
		List<OrdenCompra> ordenes = ordenCompraDao.listarOrdenCompra();
		model.addAttribute("ordenes", ordenes);
    	model.addAttribute("OrdenCompraViewModel", new OrdenCompraViewModel());
    	
    	return ORDER_URL;
    }
    
    @RequestMapping(value="/CrearOrdenCompra",method=RequestMethod.POST)
    public String crearOrdenCompra(@Valid OrdenCompraViewModel ordenCompraViewModel, BindingResult result,Model model) {
		
    	OrdenCompra orden = new OrdenCompra();
    	
    	orden.setIdProveedor(ordenCompraViewModel.getIdProveedor());
    	orden.setUsuario(ordenCompraViewModel.getUsuario());
    	orden.setFechaEmision(ordenCompraViewModel.getFechaEmision());
    	orden.setEstadoOrden(ordenCompraViewModel.getEstadoOrden());
        orden.setObservacionOrden(ordenCompraViewModel.getObservacionOrden());
    	orden.setOrdenProducto(ordenCompraViewModel.getOrdenProducto());

    	
    	if(ordenCompraDao.crearOrdenCompra(orden)) {
    	
            List<OrdenCompra> ordenes = ordenCompraDao.listarOrdenCompra();
            model.addAttribute("ordenes", ordenes);
            model.addAttribute("OrdenCompraViewModel", new OrdenCompraViewModel());
    	}
    	return INDEX_URL;
    }
    
    @RequestMapping(value="/BuscarOrdenCompra/{id}",method=RequestMethod.GET)
    public String buscarOrdenCompra(@Valid IdViewModel idViewModel, BindingResult result,Model model) {
        OrdenCompra orden = ordenCompraDao.buscarOrdenCompraPorId(idViewModel.getId());

        model.addAttribute("orden", orden);
    	model.addAttribute("OrdenCompraViewModel", new OrdenCompraViewModel());
    	return INDEX_URL;
    }
}

