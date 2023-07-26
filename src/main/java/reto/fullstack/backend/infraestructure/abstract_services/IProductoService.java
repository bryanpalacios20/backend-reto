package reto.fullstack.backend.infraestructure.abstract_services;

import reto.fullstack.backend.domain.entities.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> listaProductos();

    Producto create(Producto request);

    Producto update(Producto request, Long id);

    void delete(Long id);
}
