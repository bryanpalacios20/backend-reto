package reto.fullstack.backend.infraestructure.abstract_services;

import reto.fullstack.backend.domain.entities.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> listaClientes();
    Cliente create(Cliente request);
}
