package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Factura;
import cl.taller.serviexpress.services.impl.FacturaServicesImpl;
//import cl.taller.serviexpress.services.impl.ProductoServicesImpl;
import cl.taller.serviexpress.services.impl.UsuarioServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.IdViewModel;
import cl.taller.serviexpress.web.frontend.viewmodel.FacturaViewModel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Factura")
public class FacturaController {

    @Autowired
    FacturaServicesImpl facturaServices;

    @Autowired
    UsuarioServicesImpl userServices;

    private static final String INDEX_URL = "Factura";
    private static final String ORDER_URL = "CrearFactura";
    private static final String ORDEN_FILTER_URL = "FiltroFacturas";

    @RequestMapping
    public String index(Model model) {

        List<Factura> facturas = facturaServices.listarFactura();
        model.addAttribute("facturas", facturas);
        model.addAttribute("FacturaViewModel", new FacturaViewModel());

        return INDEX_URL;
    }

    @RequestMapping(value = "/CrearFactura", method = RequestMethod.GET)
    public String verCrearFactura(@Valid FacturaViewModel facturaViewModel, BindingResult result, Model model) {
        List<Factura> facturas = facturaServices.listarFactura();
        model.addAttribute("facturas", facturas);
        model.addAttribute("FacturaViewModel", new FacturaViewModel());
        return ORDER_URL;
    }

    @RequestMapping(value = "/CrearFactura", method = RequestMethod.POST)
    public String crearFactura(@Valid FacturaViewModel facturaViewModel, BindingResult result, Model model) {

        Factura factura = new Factura();

        factura.setRutCliente(facturaViewModel.getRutCliente());
        factura.setUsuario(facturaViewModel.getUsuario());
        factura.setPatenteVehiculo(facturaViewModel.getPatenteVehiculo());
        factura.setValorNeto(facturaViewModel.getValorNeto());
        factura.setIva(facturaViewModel.getIva());
        factura.setTotalFactura(facturaViewModel.getTotalFactura());
        factura.setEstadoFactura(facturaViewModel.getEstadoFactura());
        factura.setEstadoPago(facturaViewModel.getEstadoPago());
        factura.setFacturaProducto(facturaViewModel.getFacturaProducto());
        factura.setFacturaServicio(facturaViewModel.getFacturaServicio());

        if (facturaServices.crearFactura(factura)) {

            List<Factura> facturas = facturaServices.listarFactura();
            model.addAttribute("facturas", facturas);
            model.addAttribute("FacturaViewModel", new FacturaViewModel());
        }
        return INDEX_URL;
    }

    @RequestMapping(value = "/BuscarFactura/{id}", method = RequestMethod.GET)
    public String buscarFactura(@Valid IdViewModel idViewModel, BindingResult result, Model model) {
        Factura factura = facturaServices.buscarFacturaPorId(idViewModel.getId());

        model.addAttribute("factura", factura);
        model.addAttribute("FacturaViewModel", new FacturaViewModel());
        return INDEX_URL;
    }

    @RequestMapping(value = "/FiltroFacturas", method = RequestMethod.GET)
    public String filtroOrdenCompra(@Valid FacturaViewModel facturaViewModel, BindingResult result, Model model) {
        List<Factura> facturas = facturaServices.listarFactura();
        model.addAttribute("facturas", facturas);
        model.addAttribute("FacturaViewModel", new FacturaViewModel());
        return ORDEN_FILTER_URL;
    }
}
