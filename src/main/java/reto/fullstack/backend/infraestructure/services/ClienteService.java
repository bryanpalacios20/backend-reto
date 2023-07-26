package reto.fullstack.backend.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.fullstack.backend.domain.entities.Cliente;
import reto.fullstack.backend.domain.repositories.ClienteRepository;
import reto.fullstack.backend.infraestructure.abstract_services.IClienteService;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente create(Cliente request) {
        return clienteRepository.save(request);
    }
}
