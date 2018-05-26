/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.web.frontend.controller;

import cl.taller.serviexpress.domain.Usuario;
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
@RequestMapping("/CrearUsuario")
public class UserController {

    
    private static final String USER_URL="CrearUsuario";
    private static final String INDEX_URL = "user/managementUsers";
    private static final String ASSING_PROFILE_URL = "user/assignProfile";
    private static final String CREATE_USER_URL = "user/createUser";
    private static final String EDIT_USER = "user/editUser";
    
    @RequestMapping
    public String index(Model model) {
	
        List<Usuario> users = null;//userServices.findAll();

	model.addAttribute("users", users);
        
        return USER_URL;
    }
    
}
