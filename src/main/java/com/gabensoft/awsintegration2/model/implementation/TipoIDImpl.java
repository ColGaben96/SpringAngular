package com.gabensoft.awsintegration2.model.implementation;


import com.gabensoft.awsintegration2.model.dao.TipoIDDAO;
import com.gabensoft.awsintegration2.model.persistence.TipoIDDTO;
import com.gabensoft.awsintegration2.model.service.TipoIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoIDImpl implements TipoIDService {
    @Autowired
    private TipoIDDAO tipoID;
    @Override
    public ArrayList<TipoIDDTO> listTipos() {
        return (ArrayList<TipoIDDTO>) this.tipoID.findAll();
    }

    @Override
    public void save(TipoIDDTO tipoID) {
        this.tipoID.save(tipoID);
    }

    @Override
    public void delete(TipoIDDTO tipoID) {
        this.tipoID.delete(tipoID);
    }

    @Override
    public TipoIDDTO findTipo(TipoIDDTO tipoID) {
        return this.tipoID.findById(tipoID.getId()).orElse(null);
    }
}
