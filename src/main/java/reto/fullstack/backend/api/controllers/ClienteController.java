package reto.fullstack.backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reto.fullstack.backend.domain.entities.Cliente;
import reto.fullstack.backend.infraestructure.services.ClienteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<?> obtenerClientes() {
        List<Cliente> clientes = null;
        Map<String, Object> response = new HashMap<>();
        try {
            clientes = clienteService.listaClientes();
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta 'SELECT' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            clienteNuevo = clienteService.create(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el 'INSERT' a la BD.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente '" + clienteNuevo.getNombres() + "' se creo con exito.");
        response.put("cliente", clienteNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
