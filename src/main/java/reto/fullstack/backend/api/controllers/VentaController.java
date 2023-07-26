package reto.fullstack.backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto.fullstack.backend.domain.entities.DetalleVenta;
import reto.fullstack.backend.domain.entities.Venta;
import reto.fullstack.backend.infraestructure.abstract_services.IDetalleVentaService;
import reto.fullstack.backend.infraestructure.services.VentaService;
import reto.fullstack.backend.util.Fecha;

import java.text.ParseException;
import java.util.*;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @Autowired
    private IDetalleVentaService detalleVentaService;

    @PostMapping("/")
    public ResponseEntity<?> crearVenta(@RequestBody Venta venta) {
        Venta ventaNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            venta.setFecha(Fecha.obtenerFecha());
            ventaNuevo = ventaService.create(venta);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el 'INSERT' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El venta de id '" + venta.getId() + "' se creo con exito.");
        response.put("venta", ventaNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{idVenta}")
    public ResponseEntity<?> obtenerVentaPorId(@PathVariable Long idVenta) {
        List<DetalleVenta> venta ;
        Map<String, Object> response = new HashMap<>();
        try {
            venta = detalleVentaService.ventaById(idVenta);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta 'SELECT' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (venta == null) {
            response.put("mensaje", "La venta con el codigo '" + idVenta + "' no existe en la BD.");
        }

        return new ResponseEntity<List<DetalleVenta>>(venta, HttpStatus.OK);
    }

    @GetMapping("/fecha/{fechaStr}")
    public ResponseEntity<?> buscarVentaPorFecha( @PathVariable String fechaStr) throws ParseException {
        List<DetalleVenta> ventas;
        Map<String, Object> response = new HashMap<>();
        try {
            ventas = detalleVentaService.ventasByDate(fechaStr);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta 'SELECT' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<DetalleVenta>>(ventas, HttpStatus.OK);
    }

}
