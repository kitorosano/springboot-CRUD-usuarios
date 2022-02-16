package co.sofka.springboot.ApiRest.controllers;

import co.sofka.springboot.ApiRest.models.UsuarioModel;
import co.sofka.springboot.ApiRest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

//    obtenerusuariopornombre

//    obtenerusuarioporemail

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") int prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable("id") long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok) return "Se elimino el usuario con id " + id;
        return "No pudo eliminar el usuario con id " + id;
    }
}
