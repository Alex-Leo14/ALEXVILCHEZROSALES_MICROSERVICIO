package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;
import com.example.demo.modelo.Cliente;
import com.example.demo.servicio.ClienteService;

@Controller
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
    private ClienteService service;

    @GetMapping(path= "/listar")
    public @ResponseBody
    List<ClienteResponseDTO> listar(){
        return service.listar();
    }
    @PostMapping(path = "guardar")
    public ResponseEntity<Void> guardar(@RequestBody ClienteRequestDTO cliente){
        service.guardarCliente(cliente);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @GetMapping(path = "/listar/{id}")
    public @ResponseBody ResponseEntity<ClienteResponseDTO> ClientebyId(@PathVariable Integer id){
        Cliente cliente = service.clienteById(id);
        if(cliente != null) {
            return new ResponseEntity<ClienteResponseDTO>(HttpStatus.OK);

        }
        return new ResponseEntity<ClienteResponseDTO>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Cliente cliente = service.clienteById(id);
        if(cliente != null) {
            service.eliminarCliente(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
    @PutMapping(path = "/editar")
    public ResponseEntity<Void> editar(@RequestBody ClienteRequestDTO cliente){
        Cliente profe = service.clienteById(cliente.getIdClienteReq());
        if(profe != null) {
            service.editarCliente(cliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
