/**
 * 
 */
package cl.taller.serviexpress.web.frontend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.services.impl.UsuarioServicesImpl;
import cl.taller.serviexpress.web.frontend.viewmodel.LoginViewModel;

/**
 * @author ochandia
 *
 */

@Controller
@RequestMapping("login")
public class WebAuthController {
	
	private static final String HOME_URL = "Inicio";
	private static final String LOGIN_URL = "login";

	@Autowired
	private UsuarioServicesImpl userServices;
	
	
	@RequestMapping
	public String login(Model model) {
		model.addAttribute("loginViewModel", new LoginViewModel());
		return LOGIN_URL;
	}
	
	protected boolean isAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication().getClass()
				.equals(UsernamePasswordAuthenticationToken.class) ? true : false;
	}
	
	@RequestMapping (value="authenticate", method = RequestMethod.POST)
	public String loginAuth(@Valid LoginViewModel loginViewModel, BindingResult result, Model model,  RedirectAttributes redirectAttributes) {
		
		if(result.hasFieldErrors()) {
			if((loginViewModel.getUsername()== null || loginViewModel.getUsername().trim().isEmpty())&(loginViewModel.getPassword()== null || loginViewModel.getPassword().trim().isEmpty())){
				
				redirectAttributes.addFlashAttribute("error", result.hasFieldErrors());
				
				return "redirect:/"+LOGIN_URL;
				
			}
			
			if(loginViewModel.getUsername()== null || loginViewModel.getUsername().trim().isEmpty()) {
				
				redirectAttributes.addFlashAttribute("errorUsername", result.hasFieldErrors());
				
				return "redirect:/"+LOGIN_URL;
				
			}else {
				
				if(loginViewModel.getPassword()== null || loginViewModel.getPassword().trim().isEmpty()) {
					
					redirectAttributes.addFlashAttribute("errorPassword", result.hasFieldErrors());
					
					return "redirect:/"+LOGIN_URL;
					
				}else {
					
				redirectAttributes.addFlashAttribute("errorPasswordField", result.hasFieldErrors());
			
				return "redirect:/"+LOGIN_URL;
				}
			}
		}
		
			
			try {
				
				final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginViewModel.getUsername(), loginViewModel.getPassword(), null);
				
				
				Usuario usuario = userServices.authentication(loginViewModel.getUsername(), token.getCredentials().toString());
			
				if(usuario == null) {
					redirectAttributes.addFlashAttribute("errorBD", true);
					
					return "redirect:/"+LOGIN_URL;
				}
				
				/**
				
				final Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			
				authorities.add(new SimpleGrantedAuthority(usuario.getPerfil().getDetallePerfil()));
			
				*/

				SecurityContextHolder.getContext().setAuthentication(token);		
			
				return "redirect:/"+HOME_URL;
			
			}catch(AuthenticationException e){
				redirectAttributes.addFlashAttribute("errorBD", true);
				
				return "redirect:/"+LOGIN_URL;
			}
	}
}
