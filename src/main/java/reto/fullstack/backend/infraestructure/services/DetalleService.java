package reto.fullstack.backend.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.fullstack.backend.domain.entities.DetalleVenta;
import reto.fullstack.backend.domain.repositories.DetalleVentaRepository;
import reto.fullstack.backend.infraestructure.abstract_services.IDetalleVentaService;

import java.util.List;

@Service
public class DetalleService implements IDetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> ventaById(Long id) {
        return detalleVentaRepository.getVentasById(id);
    }

    @Override
    public List<DetalleVenta> ventasByDate(String fecha) {
        return detalleVentaRepository.getVentasByFecha(fecha);
    }
}
