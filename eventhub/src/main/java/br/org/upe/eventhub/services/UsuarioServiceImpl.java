package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.exceptions.UsuarioExistenteException;
import br.org.upe.eventhub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario cadastraUsuario(Usuario usuario) throws UsuarioExistenteException{

        Optional<Usuario> usuariobanco = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuariobanco.isPresent()) {
            throw new UsuarioExistenteException();
        }

        Optional<Usuario> usuariobanco2 = usuarioRepository.findByCpf(usuario.getCpf());
        if (usuariobanco2.isPresent()) {
            throw new UsuarioExistenteException();
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void removerUsuario(Usuario usuario) {

    }

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorEmailAndSenha(String email, String senha) {
        return null;
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorLoginESenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }
}
