/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.domain.Perfil;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.services.impl.OrdenServicesImpl;
import cl.taller.serviexpress.services.impl.PerfilServicesImpl;
import cl.taller.serviexpress.services.impl.UsuarioServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Inicio")
public class HomeController {
	
    @Autowired
    OrdenServicesImpl ordenServices;

	@Autowired
	UsuarioServicesImpl userServices;
	
	@Autowired
	PerfilServicesImpl perfilServices; 

    private static final String INDEX_URL = "Inicio";

    @RequestMapping
    public String index(Model model) {
        List<Usuario> users = userServices.listarUsuarios();
        List<Usuario> mecanicos = new ArrayList<Usuario>();
        List<Usuario> ejecutivos = new ArrayList<Usuario>();
        List<Usuario> clientes = new ArrayList<Usuario>();
        List<Usuario> proveedores = new ArrayList<Usuario>();
        List<Usuario> administradores = new ArrayList<Usuario>();
        List<OrdenCompra> ordenes = ordenServices.listarOrdenCompra();
        List<Perfil> perfiles = perfilServices.listarPerfiles();
        for(Usuario u : users) {
        	if (u.getPerfil().getId() == 1L)
        		administradores.add(u);
        	if (u.getPerfil().getId() == 2L)
        		ejecutivos.add(u);
        	if(u.getPerfil().getId() == 3L)
        		mecanicos.add(u);
        	if(u.getPerfil().getId() == 4L)
        		clientes.add(u);
        	if(u.getPerfil().getId() == 5L)
        		proveedores.add(u);
        }
        model.addAttribute("ordenes", ordenes.size());
        model.addAttribute("clientes", clientes.size());
        model.addAttribute("mecanicos" , mecanicos.size());
        model.addAttribute("ejecutivos" , ejecutivos.size());
        model.addAttribute("proveedores", proveedores.size());
        model.addAttribute("administradores", administradores.size());
        model.addAttribute("perfiles", perfiles);
        model.addAttribute("UserViewModel", new UserViewModel());

        return INDEX_URL;
    }
}
