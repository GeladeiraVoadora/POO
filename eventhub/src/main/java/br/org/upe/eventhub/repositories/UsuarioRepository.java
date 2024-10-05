package br.org.upe.eventhub.repositories;

import br.org.upe.eventhub.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
    @Query("select u from Usuario u where (u.email =:login OR u.cpf =:login)"
    + "and u.senha =:senha")
    Optional<Usuario> findByLoginAndSenha(String login, String senha);

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByCpf(String cpf);
}
