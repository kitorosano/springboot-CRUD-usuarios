package co.sofka.springboot.ApiRest.repositories;

import co.sofka.springboot.ApiRest.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(int prioridad);

    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);

    public abstract ArrayList<UsuarioModel> findByEmail(String email);
}
