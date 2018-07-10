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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Usuario")
public class UserController {

	@Autowired
	UsuarioServicesImpl userServices;
	
	@Autowired
	PerfilServicesImpl perfilServices; 

    private static final String INDEX_URL = "Usuario";
    private static final String USER_URL = "CrearUsuario";
    private static final String EDIT_URL = "EditarUsuario";
    private static final String READ_URL = "LeerUsuario";

    @RequestMapping
    public String index(Model model) {
        List<Usuario> users = userServices.listarUsuarios();
        List<Perfil> perfiles = perfilServices.listarPerfiles();
        model.addAttribute("users", users);
        model.addAttribute("perfiles", perfiles);
        model.addAttribute("UserViewModel", new UserViewModel());

        return INDEX_URL;
    }

    @RequestMapping(value = "/CrearUsuario", method = RequestMethod.GET)
    public String verCrearUsuario(@Valid UserViewModel userViewModel, BindingResult result, Model model) {
        List<Usuario> users = userServices.listarUsuarios();
        model.addAttribute("users", users);
        model.addAttribute("UserViewModel", new UserViewModel());

        return USER_URL;
    }

    @RequestMapping(value = "/CrearUsuario", method = RequestMethod.POST)
    public String createUser(@Valid UserViewModel userViewModel, BindingResult result, Model model) {

        Usuario user = new Usuario();

        Perfil perfilCliente = perfilServices.buscarPorPerfil(4L);
        user.setNombre(userViewModel.getNombre());
        user.setRut(userViewModel.getRut());
        user.setDireccion(userViewModel.getDireccion());
        user.setContactoTelefonico(userViewModel.getTelefono());
        user.setPerfil(perfilCliente);
        user.setUsername(userViewModel.getUsername());

        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userViewModel.getUsername(),userViewModel.getPassword(),null);
        user.setPassword(token.toString());

        if (userServices.crearUsuario(user)) {

            List<Usuario> users = userServices.listarUsuarios();
            model.addAttribute("users", users);
            model.addAttribute("UserViewModel", new UserViewModel());
        }
        return INDEX_URL;
    }
    
    @RequestMapping(value = "/BuscarUsuario/{rut}", method = RequestMethod.GET)
    public String buscarUsuario(@Valid UserViewModel userViewModel, BindingResult result, Model model) {
        List<Usuario> users = userServices.listarUsuarios();
        List<Perfil> perfiles = perfilServices.listarPerfiles();

        model.addAttribute("perfiles", perfiles);
        model.addAttribute("users", users);
        model.addAttribute("UserViewModel", new UserViewModel());
        return INDEX_URL;
    }

    @RequestMapping(value = {"/EditarUsuario"}, method = RequestMethod.GET)
    public String editarUsuario(@Valid UserViewModel userViewModel, @RequestParam("id") Long id, BindingResult result, Model model) {
        Usuario usuario = userServices.buscarPorID(id);
        List<Perfil> perfiles = perfilServices.listarPerfiles();
        UserViewModel userViewModel2 = new UserViewModel();
        userViewModel2.setNombre(usuario.getNombre());
        userViewModel2.setRut(usuario.getRut());
        model.addAttribute("perfiles", perfiles);
        model.addAttribute("usuario", usuario);
        model.addAttribute("UserViewModel", userViewModel2);
        return EDIT_URL;
    }

    @RequestMapping(value = {"/ActualizarUsuario"}, method = RequestMethod.POST)
    public String ActualizarUsuario(@Valid UserViewModel userViewModel, @RequestParam("rut") String rut, BindingResult result, Model model) {
        Usuario usuario = userServices.buscarPorRut(rut);
        Perfil perfil = perfilServices.buscarPorPerfil(userViewModel.getIdPerfil());
        usuario.setPerfil(perfil);
        if (userServices.modificarUsuario(usuario)) {
            List<Usuario> users = userServices.listarUsuarios();
            model.addAttribute("users", users);
            model.addAttribute("UserViewModel", new UserViewModel());
        }
        return INDEX_URL;
    }

    @RequestMapping(value = {"/LeerUsuario"}, method = RequestMethod.GET)
    public String leerUsuario(@Valid UserViewModel userViewModel, BindingResult result, Model model) {
        Usuario usuario = userServices.buscarPorRut(userViewModel.getRut());
        model.addAttribute("usuario", usuario);
        return READ_URL;
    }

    
    
}
