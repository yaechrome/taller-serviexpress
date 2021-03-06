package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.FamiliaProducto;
import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.services.impl.ProductoServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.IdViewModel;
import cl.taller.serviexpress.web.frontend.viewmodel.ProductoViewModel;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    ProductoServicesImpl productoServices;   

    private static final String INDEX_URL = "Producto";
    private static final String PRODUCT_URL = "CrearProducto";
    private static final String EDIT_URL = "EditarProducto";
    private static final String READ_URL = "LeerProducto";
    
    @RequestMapping
    public String index(Model model) {

        List<Producto> productos = productoServices.listarProductos();
        List<TipoProducto> tipos = productoServices.listarTiposProductos();
        List<FamiliaProducto> familias = productoServices.listarFamiliasProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("tipos", tipos);
        model.addAttribute("familias", familias);
        model.addAttribute("ProductoViewModel", new ProductoViewModel());

        return INDEX_URL;
    }

    @RequestMapping(value = "/CrearProducto", method = RequestMethod.GET)
    public String verCrearProducto(@Valid ProductoViewModel productoViewModel, BindingResult result, Model model) {
        List<Producto> productos = productoServices.listarProductos();
        List<TipoProducto> tipos = productoServices.listarTiposProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("tipos", tipos);
        model.addAttribute("ProductoViewModel", new ProductoViewModel());

        return PRODUCT_URL;
    }

    @RequestMapping(value = "/CrearProducto", method = RequestMethod.POST)
    public String createProduct(@Valid ProductoViewModel productoViewModel, BindingResult result, Model model) {

        Producto producto = new Producto();
        TipoProducto tipo = productoServices.buscarTipoProductoPorId(productoViewModel.getIdTipo());
        producto.setTipoProducto(tipo);
        producto.setNombreProducto(productoViewModel.getNombreProducto());
        producto.setPrecioVenta(productoViewModel.getPrecioVenta());
        producto.setStock(productoViewModel.getStock());
        producto.setStockCritico(productoViewModel.getStockCritico());

        if (productoServices.crearProducto(producto)) {
            List<Producto> productos = productoServices.listarProductos();
            List<TipoProducto> tipos = productoServices.listarTiposProductos();
            List<FamiliaProducto> familias = productoServices.listarFamiliasProductos();
            model.addAttribute("productos", productos);
            model.addAttribute("tipos", tipos);
            model.addAttribute("familias", familias);
            model.addAttribute("ProductoViewModel", new ProductoViewModel());
        }
        return INDEX_URL;
    }

    @RequestMapping(value = {"/LeerProducto"}, method = RequestMethod.GET)
    public String leerProducto(@Valid IdViewModel idViewModel, BindingResult result, Model model) {
        Producto producto = productoServices.buscarProductoPorId(idViewModel.getId());
        model.addAttribute("producto", producto);
        model.addAttribute("ProductoViewModel", new ProductoViewModel());
        return READ_URL;
    }
    
    @RequestMapping(value = {"/ActualizarProducto"}, method = RequestMethod.POST)
    public String ActualizarProducto(@Valid ProductoViewModel productoViewModel, @RequestParam("id") Long id, BindingResult result, Model model) {
        Producto producto = productoServices.buscarProductoPorId(id);
        TipoProducto tipo = producto.getTipoProducto();
        FamiliaProducto familia = producto.getTipoProducto().getFamiliaProducto();
        Producto productoGuardar = producto;        
        tipo.setFamiliaProducto(familia);
        productoGuardar.setTipoProducto(tipo);
        productoGuardar.setPrecioVenta(productoViewModel.getPrecioVenta());
        productoGuardar.setStockCritico(productoViewModel.getStockCritico());
        if (productoServices.modificarProducto(productoGuardar)) {
            List<Producto> productos = productoServices.listarProductos();
            model.addAttribute("productos", productos);
            model.addAttribute("ProductoViewModel", new ProductoViewModel());
        }
        return INDEX_URL;
    }
    
    @RequestMapping(value = {"/EditarProducto"}, method = RequestMethod.GET)
    public String editarProducto(@Valid ProductoViewModel productoViewModel, @RequestParam("id") Long id, BindingResult result, Model model) {
        Producto producto = productoServices.buscarProductoPorId(id);
        ProductoViewModel productoViewModel2 = new ProductoViewModel();
        productoViewModel2.setNombreProducto(producto.getNombreProducto());
        productoViewModel2.setStock(producto.getStock());
        productoViewModel2.setPrecioVenta(producto.getPrecioVenta());
        model.addAttribute("producto", producto);
        model.addAttribute("ProductoViewModel", new ProductoViewModel());
        return EDIT_URL;
    }
    
    
}
