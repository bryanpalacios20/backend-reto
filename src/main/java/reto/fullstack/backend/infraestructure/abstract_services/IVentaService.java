package reto.fullstack.backend.infraestructure.abstract_services;

import reto.fullstack.backend.domain.entities.DetalleVenta;
import reto.fullstack.backend.domain.entities.Venta;

import java.util.List;
public interface IVentaService {
    Venta create (Venta request);

}
