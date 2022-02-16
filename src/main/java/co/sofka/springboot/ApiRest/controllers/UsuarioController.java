package co.sofka.springboot.ApiRest.controllers;

import co.sofka.springboot.ApiRest.models.UsuarioModel;
import co.sofka.springboot.ApiRest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    /**
     * Metodo para buscar todos los usuarios de la base de datos
     * @return Lista de los usuarios con toda su informacion
     */
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    /**
     *  Metodo para guardar un usuario en la base de datos, o modificarlo si en la request se menciona un ID
     * @param usuario
     * @return Toda la informacion del nuevo usuario agregado
     */
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    /**
     *  Metodo para obtener un usuario buscando por su ID en la base de datos
     * @param id
     * @return Toda la informacion del primer usuario encontrado cuyo ID coincida
     */
    @GetMapping("/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    /**
     * Metodo para obtener un usuario buscando por su nombre en la base de datos
     * @param nombre
     * @return Toda la informacion del primer usuario encontrado cuyo nombre coincida
     */
    @GetMapping(value = "/query", params = "nombre")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }

    /**
     * Metodo para obtener un usuario buscando por su prioridad en la base de datos
     * @param prioridad
     * @return Toda la informacion del primer usuario encontrado cuya prioridad coincida
     */
    @GetMapping(value = "/query", params = "prioridad")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") int prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    /**
     * Metodo para obtener un usuario buscando por su email en la base de datos
     * @param email
     * @return Toda la informacion del primer usuario encontrado cuyo email coincida
     */
    @GetMapping(value = "/query", params = "email")
    public ArrayList<UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("email") String email){
        return this.usuarioService.obtenerPorEmail(email);
    }

    /**
     * Metodo para eliminar un usuario mediante id de la tabla Usuarios
     * @param id
     * @return String mencionando si se ha eliminado exitosamente o no
     */
    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable("id") long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok) return "Se elimino el usuario con id " + id;
        return "No pudo eliminar el usuario con id " + id;
    }
}
