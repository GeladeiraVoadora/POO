package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.exceptions.UsuarioExistenteException;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuario cadastraUsuario(Usuario usuario) throws UsuarioExistenteException;
    public Usuario atualizarUsuario(Usuario usuario);
    public void removerUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorId(Integer id);
    public Usuario buscarUsuarioPorEmail(String email);
    public Usuario buscarUsuarioPorEmailAndSenha(String email, String senha);
    public Optional<Usuario> buscarUsuarioPorLoginESenha(String login, String senha);
}
