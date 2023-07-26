package reto.fullstack.backend.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.fullstack.backend.domain.entities.DetalleVenta;
import reto.fullstack.backend.domain.entities.Venta;
import reto.fullstack.backend.domain.repositories.VentaRepository;
import reto.fullstack.backend.infraestructure.abstract_services.IVentaService;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta create(Venta request) {
        return null;
    }

}
