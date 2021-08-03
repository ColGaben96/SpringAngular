package com.gabensoft.awsintegration2.model.dao;

import com.gabensoft.awsintegration2.model.persistence.UsuarioDTO;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<UsuarioDTO, Integer> {
}
