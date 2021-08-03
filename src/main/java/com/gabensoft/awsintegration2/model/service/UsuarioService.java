package com.gabensoft.awsintegration2.model.service;



import com.gabensoft.awsintegration2.model.persistence.UsuarioDTO;

import java.util.ArrayList;

public interface UsuarioService {
    ArrayList<UsuarioDTO> listUsuarios();
    void save(UsuarioDTO usuario);
    void delete(UsuarioDTO usuario);
    UsuarioDTO findUsuario (UsuarioDTO usuario);
}
