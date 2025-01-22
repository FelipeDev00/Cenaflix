package persistencia;

import jakarta.persistence.*;

/**
 * Classe que representa a entidade Usuario no banco de dados.
 * Esta classe utiliza a API JPA para mapeamento objeto-relacional.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    /**
     * Identificador único do usuário, gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nome do usuário.
     */
    private String nome;

    /**
     * Senha do usuário.
     */
    private String senha;

    /**
     * Tipo do usuário, representado pelo enum {@link TipoUsuario}.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;

    /**
     * Enumeração que define os diferentes tipos de usuário.
     */
    public enum TipoUsuario {
        Administrador,
        Operador,
        Usuario
    }

    /**
     * Obtém o identificador único do usuário.
     * 
     * @return o ID do usuário.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do usuário.
     * 
     * @param id o ID do usuário.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     * 
     * @return o nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * 
     * @param nome o nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a senha do usuário.
     * 
     * @return a senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * 
     * @param senha a senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o tipo do usuário.
     * 
     * @return o tipo do usuário.
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Define o tipo do usuário.
     * 
     * @param tipoUsuario o tipo do usuário.
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}