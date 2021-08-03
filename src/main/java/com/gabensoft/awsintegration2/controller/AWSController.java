package com.gabensoft.awsintegration2.controller;


import com.gabensoft.awsintegration2.model.persistence.TipoIDDTO;
import com.gabensoft.awsintegration2.model.persistence.UsuarioDTO;
import com.gabensoft.awsintegration2.model.service.TipoIDService;
import com.gabensoft.awsintegration2.model.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AWSController {
    @Autowired
    private TipoIDService tipoID;
    @Autowired
    private UsuarioService usuario;

    @GetMapping("/")
    public String home(Model model) {
        log.info("Ingresó al home");
        return "index";
    }
    @GetMapping("/usuarios")
    public String getUsuarios(Model model) {
        var usuarios = usuario.listUsuarios();
        log.info("Descargando usuarios");
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
    @GetMapping("/agregarTipo")
    public String agregarTipoID(TipoIDDTO tipoID) {
        return "tipoIdNuevo";
    }
    @GetMapping("/agregarUsuario")
    public String agregarUsuario(UsuarioDTO usuario, Model model) {
        var tiposID = tipoID.listTipos();
        model.addAttribute("tiposID", tiposID);
        return "clienteNuevo";
    }

    @PostMapping("/nuevoID")
    public String nuevoTipoID(TipoIDDTO tipoID) {
        log.info("Ingresando nuevo tipo de identificación\n" +
                "Tipo de ID: "+tipoID.getNombre());
        this.tipoID.save(tipoID);
        return "redirect:/";
    }

    @PostMapping("/nuevoUsuario")
    public String nuevoUsuario(UsuarioDTO usuario) {
        log.info("Ingresando nuevo usuario\n" +
                "Nombre: "+usuario.getNombres()+" "+usuario.getApellidos()+"\n" +
                "Tipo ID:"+usuario.getTipoID_FK().getNombre()+"\n" +
                "ID: "+usuario.getIdentificacion());
        this.usuario.save(usuario);
        return "redirect:/usuarios";
    }
}
