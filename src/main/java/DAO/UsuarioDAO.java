package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import persistencia.JPAUtil;
import persistencia.Usuario;

/**
 * Classe DAO (Data Access Object) responsável por operações relacionadas à entidade {@link Usuario}.
 * Esta classe realiza interações com o banco de dados, como autenticação de usuários.
 */
public class UsuarioDAO {

    /**
     * Autentica um usuário com base no nome e senha fornecidos.
     * <p>
     * Este método verifica no banco de dados se existe um registro correspondente ao nome e senha fornecidos.
     * </p>
     *
     * @param nome O nome do usuário a ser autenticado.
     * @param senha A senha do usuário a ser autenticado.
     * @return Um objeto {@link Usuario} se a autenticação for bem-sucedida, ou {@code null} caso contrário.
     */
    public Usuario autenticar(String nome, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Cria uma consulta para buscar o usuário com nome e senha correspondentes
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha", 
                Usuario.class);
            
            query.setParameter("nome", nome); // Define o parâmetro 'nome'
            query.setParameter("senha", senha); // Define o parâmetro 'senha'
            
            List<Usuario> usuarios = query.getResultList();

            // Retorna o primeiro usuário encontrado ou null se a lista estiver vazia
            return usuarios.isEmpty() ? null : usuarios.get(0);
        } finally {
            // Fecha o EntityManager para liberar recursos
            em.close();
        }
    }
}
