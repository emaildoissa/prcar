package com.br.app.prcar.service;

import com.br.app.prcar.data.ClienteEntity;
import com.br.app.prcar.data.ClienteRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository; 
    
    public ClienteEntity criarCliente( @Valid  ClienteEntity cliente){
        clienteRepository.save(cliente);
        return cliente;
    }
    
    public List<ClienteEntity> listarTodosClientes() {
        return clienteRepository.findAll();
    }
    
    public List<ClienteEntity> listarUltimos10Clientes() {
        return clienteRepository.findFirst10ByOrderByDataDesc();
    }
    
    public ClienteEntity getClienteId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
    public ClienteEntity atualizarCliente(Integer clienteId, ClienteEntity clienteRequest) {
        ClienteEntity cliente = getClienteId(clienteId);
        cliente.setNome(clienteRequest.getNome());
        cliente.setTelefone(clienteRequest.getTelefone());
        cliente.setData(clienteRequest.getData());
        cliente.setMarca(clienteRequest.getMarca());   
        cliente.setPlaca(clienteRequest.getPlaca());
        cliente.setKm(clienteRequest.getKm());
        cliente.setServiço1(clienteRequest.getServiço1());
        cliente.setServiço2(clienteRequest.getServiço2());
        clienteRepository.save(cliente);
        return cliente;
    }
    
    public void deletarFilme(Integer clienteId) {
        ClienteEntity cliente = getClienteId(clienteId);
        clienteRepository.deleteById(cliente.getId());
    }
}
