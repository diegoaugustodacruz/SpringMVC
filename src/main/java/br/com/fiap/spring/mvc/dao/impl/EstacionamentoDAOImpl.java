package br.com.fiap.spring.mvc.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.spring.mvc.dao.EstacionamentoDAO;
import br.com.fiap.spring.mvc.entity.Estacionamento;

@Repository
public class EstacionamentoDAOImpl extends GenericDAOImpl<Estacionamento, Integer> implements EstacionamentoDAO{


}
