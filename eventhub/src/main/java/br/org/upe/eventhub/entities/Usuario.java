package br.org.upe.eventhub.entities;

import br.org.upe.eventhub.entities.enums.PerfilEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;
    @OneToMany(mappedBy = "usuario")
    private List<Inscricao> inscricoes;

    public Usuario(String nome, String cpf, String email, String senha, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

}
