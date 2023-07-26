package reto.fullstack.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reto.fullstack.backend.domain.entities.DetalleVenta;

import java.util.List;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {
    @Query(value = "select * from detalle_venta dv INNER JOIN venta v ON v.id = dv.id_venta  WHERE v.fecha = (?1)", nativeQuery = true)
    @Transactional(readOnly = true)
    public List<DetalleVenta> getVentasByFecha(String fecha);

    @Query(value = "select * from detalle_venta dv INNER JOIN venta v ON dv.id_venta= v.id  WHERE v.id = (?1)", nativeQuery = true)
    @Transactional(readOnly = true)
    public List<DetalleVenta> getVentasById(Long idVenta);
}
