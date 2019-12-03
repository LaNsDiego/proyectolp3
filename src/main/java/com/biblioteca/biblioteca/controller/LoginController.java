package com.biblioteca.biblioteca.controller;


import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(LoginController.BASE_URL)
public class LoginController {
    public static final String BASE_URL = "/";

    @Autowired
    private UsuarioService daoUsuario ;

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @GetMapping("")
    public String login(){
        return "/view/login";
    }

    @PostMapping("login")
    public String login(Usuario usuario , HttpServletRequest request){

            Usuario objUsuario = daoUsuario.findByCorreoAndClave(usuario.getCorreo(),usuario.getClave());
            if(objUsuario != null){
                HttpSession session = request.getSession();

                session.setAttribute("usuarioid",objUsuario.getId());
                session.setAttribute("correo",objUsuario.getCorreo());
                session.setAttribute("usuarioid",objUsuario.getId());
                session.setAttribute("apellido",objUsuario.getApellidos());
                session.setAttribute("rol",objUsuario.rol.getNombre());
                session.setAttribute("nombre",objUsuario.getNombres());
                int rolid = objUsuario.rol.getId();
                if(rolid == 2){
                    session.setAttribute("biblioteca",objUsuario.biblioteca.getNumero() + " de " + objUsuario.biblioteca.facultad.getAcronimo());
                    session.setAttribute("bibliotecaid",objUsuario.biblioteca.getId());
                    return "redirect:/bibliotecaria/principal";
                }else{
                    return "redirect:/estudiante/principal";
                }

            }else{
                return "redirect:/";
            }

    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
}
