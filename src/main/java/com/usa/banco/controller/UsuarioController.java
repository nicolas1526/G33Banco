package com.usa.banco.controller;

import com.usa.banco.model.UsuarioModel;
import com.usa.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<UsuarioModel> obtenerUsuario(){
        return usuarioService.obtenerUsuario();
    }

    @DeleteMapping("/usuario/{id}")
    public String eliminarUsuario(@PathVariable int id){
        return usuarioService.eliminarUsuario(id);
    }

    @PostMapping("/usuario")
    public String crearUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.crearUsuario(usuarioModel);
    }



    @PutMapping("/usuario")
    public String actualizarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.actualizarUsuario(usuarioModel);
    }
}
