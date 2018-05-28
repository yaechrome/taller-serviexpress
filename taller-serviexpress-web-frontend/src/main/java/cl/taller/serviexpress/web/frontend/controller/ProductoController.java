
package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cl.taller.serviexpress.services.impl.ProductoServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.ProductoViewModel;
import cl.taller.serviexpress.web.frontend.viewmodel.UserViewModel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/Producto")
public class ProductoController {
    @Autowired
    ProductoServicesImpl productoDao;
    
    private static final String INDEX_URL="Producto";
    private static final String PRODUCT_URL="CrearProducto";
    private static final String ASSING_TYPE_URL = "Producto/asignarTipo";
    private static final String CREATE_PRODUCT_URL = "Producto/CrearProducto";
    private static final String EDIT_PRODUCT = "Producto/editarProducto";
    
    @RequestMapping
    public String index(Model model) {
        
		List<Producto> productos = productoDao.listarProductos();
		model.addAttribute("productos", productos);
    	model.addAttribute("ProductosViewModel", new ProductoViewModel());
    	
        return INDEX_URL;
    }
    
    @RequestMapping(value="/CrearProducto",method=RequestMethod.GET)
    public String verCrearProducto(@Valid ProductoViewModel productoViewModel, BindingResult result,Model model) {
		List<Producto> users = productoDao.listarProductos();
		model.addAttribute("users", users);
    	model.addAttribute("UserViewModel", new UserViewModel());
    	
    	return PRODUCT_URL;
    }
    
    @RequestMapping(value="/CrearProducto",method=RequestMethod.POST)
    public String createProduct(@Valid ProductoViewModel productoViewModel, BindingResult result,Model model) {
		
    	Producto producto = new Producto();
    	
    	producto.setTipoProducto(productoViewModel.getTipoProducto());
    	producto.setNombreProducto(productoViewModel.getNombreProducto());
        producto.setPrecioVenta(productoViewModel.getPrecioVenta());
        producto.setStock(productoViewModel.getStock());
        producto.setStockCritico(productoViewModel.getStockCritico());
        
    	
    	if(productoDao.crearProducto(producto)) {
    		List<Producto> productos = productoDao.listarProductos();
    		model.addAttribute("productos", productos);
    		model.addAttribute("ProductosViewModel", new ProductoViewModel());
    	}
    	return INDEX_URL;
    }
    
    
    
}
