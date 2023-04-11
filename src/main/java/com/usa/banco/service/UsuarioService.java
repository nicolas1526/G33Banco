package com.usa.banco.service;

import com.usa.banco.model.UsuarioModel;
import com.usa.banco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModel> obtenerUsuario(){
        return usuarioRepository.findAll();
    }
    public String eliminarUsuario(int id){
        usuarioRepository.deleteById(id);
        return "El usuario se elimino";
    }
    public String crearUsuario(UsuarioModel usuarioModel){
        if (usuarioRepository.existsById(usuarioModel.getId())){
            return "El usuario con id "+ (String.valueOf(usuarioModel.getId()))+" ya existe";
        }else{
            usuarioRepository.save(usuarioModel);
            return "EL usuario se creo";
        }
    }
    public String actualizarUsuario(UsuarioModel usuarioModel){
        if (usuarioRepository.existsById(usuarioModel.getId())){
            usuarioRepository.save(usuarioModel);
            return "EL usuario se actualizo";
        }else{
            return "El usuario con id "+ (String.valueOf(usuarioModel.getId()))+" no existe";
        }
    }
}
