package com.gabensoft.awsintegration2.model.service;



import com.gabensoft.awsintegration2.model.persistence.TipoIDDTO;

import java.util.ArrayList;

public interface TipoIDService {
    ArrayList<TipoIDDTO> listTipos();
    void save(TipoIDDTO tipoID);
    void delete(TipoIDDTO tipoID);
    TipoIDDTO findTipo (TipoIDDTO tipoID);
}
