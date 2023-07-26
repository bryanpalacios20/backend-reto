package reto.fullstack.backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto.fullstack.backend.domain.entities.Producto;
import reto.fullstack.backend.infraestructure.services.ProductoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<?> obtenerProducto() {
        List<Producto> productos = null;
        Map<String, Object> response = new HashMap<>();
        try {
            productos = productoService.listaProductos();
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta 'SELECT' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        Producto productoNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            productoNuevo = productoService.create(producto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el 'INSERT' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El producto '" + producto.getNombre() + "' se creo con exito.");
        response.put("producto", productoNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long idProducto, @RequestBody Producto producto){
        Producto productoActualizado = null;
        Map<String, Object> response = new HashMap<>();
        try {
            productoActualizado = productoService.update(producto, idProducto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el 'UPDATE' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		response.put("mensaje", "El producto '" + producto.getNombre() + "' se actualizo exitosamente.");
		response.put("producto", productoActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")//ruta: DELETE -- localhost:8080/best_travel/ticket/1
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
