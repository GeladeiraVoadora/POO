package br.org.upe.eventhub.controllers;

import br.org.upe.eventhub.entities.DTO.UsuarioDTO;
import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.entities.enums.PerfilEnum;
import br.org.upe.eventhub.exceptions.UsuarioExistenteException;
import br.org.upe.eventhub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> registerUser(@RequestBody UsuarioDTO usuarioDTO) throws UsuarioExistenteException {
        Usuario usuario = new Usuario(usuarioDTO.nome(),
                usuarioDTO.cpf(),
                usuarioDTO.email(),
                usuarioDTO.senha(),
                usuarioDTO.telefone());

        usuario.setPerfil(PerfilEnum.PARTICIPANTE);

        usuario = usuarioService.cadastraUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }
}
