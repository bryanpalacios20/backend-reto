package reto.fullstack.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reto.fullstack.backend.domain.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
