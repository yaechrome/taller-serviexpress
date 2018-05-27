/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Perfil;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.services.impl.PerfilServicesImpl;
import cl.taller.serviexpress.services.impl.UsuarioServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.UserViewModel;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ochandia
 */
@Controller
@RequestMapping("/Usuario")
public class UserController {

	@Autowired
	UsuarioServicesImpl userDao;
	
	@Autowired
	PerfilServicesImpl perfilDao;
	
    private static final String INDEX_URL="Usuario";
    private static final String USER_URL="CrearUsuario";
    private static final String ASSING_PROFILE_URL = "user/assignProfile";
    private static final String CREATE_USER_URL = "Usuario/CrearUsuario";
    private static final String EDIT_USER = "user/editUser";
    
    @RequestMapping
    public String index(Model model) {
        
		List<Usuario> users = userDao.listarUsuarios();
		model.addAttribute("users", users);
    	model.addAttribute("UserViewModel", new UserViewModel());
    	
        return INDEX_URL;
    }
    
    @RequestMapping(value="/CrearUsuario",method=RequestMethod.GET)
    public String verCrearUsuario(@Valid UserViewModel userViewModel, BindingResult result,Model model) {
		List<Usuario> users = userDao.listarUsuarios();
		model.addAttribute("users", users);
    	model.addAttribute("UserViewModel", new UserViewModel());
    	
    	return USER_URL;
    }
    
    @RequestMapping(value="/CrearUsuario",method=RequestMethod.POST)
    public String createUser(@Valid UserViewModel userViewModel, BindingResult result,Model model) {
		List<Usuario> users = userDao.listarUsuarios();
		List<Perfil> perfiles = perfilDao.listarPerfiles();
    	
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("users", users);
    	model.addAttribute("UserViewModel", new UserViewModel());
    	return INDEX_URL;
    }
    
    @RequestMapping(value="/BuscarUsuario/{rut}",method=RequestMethod.GET)
    public String buscarUsuario(@Valid UserViewModel userViewModel, BindingResult result,Model model) {
		List<Usuario> users = userDao.listarUsuarios();
		List<Perfil> perfiles = perfilDao.listarPerfiles();
    	
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("users", users);
    	model.addAttribute("UserViewModel", new UserViewModel());
    	return INDEX_URL;
    }
    
}
