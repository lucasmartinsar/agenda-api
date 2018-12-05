package br.com.agenda.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.api.model.Cliente;
import br.com.agenda.api.repository.ClienteRepository;

/**
 * 
 * @author Lucas
 *
 */

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository rep;
	
	@Transactional
	public void save(Cliente cliente) {
		this.rep.save(cliente);
	}
	
	@Transactional (readOnly=true)
	public List<Cliente> listaClientes(){
		return this.rep.findAll();
	}


	public void deletaCliente(Cliente cliente) {
		this.rep.delete(cliente);
	}

	@Transactional
	public void deletarPorId (Long id) {
		this.rep.deleteById(id);
	}
	
	@Transactional
	public void atualizar (Cliente cliente) {
		this.rep.saveAndFlush(cliente);
	}
	
	@Transactional(readOnly=true)
	public Cliente buscarPorNome (String nome) {
		return this.rep.findByNome(nome);
	}
	
	public Cliente buscarPorEmail (String email) {
		return this.rep.findByEmail(email);
	}
	
}
	