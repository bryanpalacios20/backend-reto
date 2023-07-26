package reto.fullstack.backend.infraestructure.abstract_services;

import reto.fullstack.backend.domain.entities.DetalleVenta;

import java.util.List;

public interface IDetalleVentaService {

    List<DetalleVenta> ventaById(Long id);
    List<DetalleVenta> ventasByDate(String fecha);
}
