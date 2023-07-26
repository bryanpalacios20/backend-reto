package reto.fullstack.backend.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.fullstack.backend.domain.entities.Producto;
import reto.fullstack.backend.domain.repositories.ProductoRepository;
import reto.fullstack.backend.infraestructure.abstract_services.IProductoService;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto create(Producto request) {
        return productoRepository.save(request);
    }

    @Override
    public Producto update(Producto request, Long id) {
        var productoToUpdate = productoRepository.findById(id).orElseThrow();
        productoToUpdate.setNombre(request.getNombre());
        productoToUpdate.setPrecio(request.getPrecio());
        var productoUpdated = productoRepository.save(productoToUpdate);
        return productoUpdated;
    }

    @Override
    public void delete(Long id) {
        var productoDelete =productoRepository.findById(id).orElseThrow();
        productoRepository.delete(productoDelete);
    }
}
