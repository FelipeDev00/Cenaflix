package DAO;

import jakarta.persistence.*;
import java.util.List;
import persistencia.JPAUtil;
import persistencia.Podcast;

/**
 * Classe DAO (Data Access Object) para gerenciar operações relacionadas à entidade {@link Podcast}.
 * Esta classe fornece métodos para salvar, listar e excluir registros no banco de dados.
 */
public class PodcastDAO {

    /** Instância de {@link EntityManager} obtida através do {@link JPAUtil}. */
    private EntityManager em = JPAUtil.getEntityManager();

    /**
     * Salva ou atualiza um podcast no banco de dados.
     * <p>
     * Se o ID do podcast for 0, um novo registro é criado. Caso contrário, o registro existente é atualizado.
     * </p>
     *
     * @param podcast Objeto {@link Podcast} a ser salvo ou atualizado.
     */
    public void salvar(Podcast podcast) {
        try {
            em.getTransaction().begin();
            if (podcast.getId() == 0) {
                em.persist(podcast); // Cria um novo registro
            } else {
                em.merge(podcast); // Atualiza um registro existente
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // Reverte a transação em caso de erro
            e.printStackTrace();
        }
    }

    /**
     * Lista todos os podcasts registrados no banco de dados.
     *
     * @return Uma lista de objetos {@link Podcast}.
     */
    public List<Podcast> listarPodcasts() {
        TypedQuery<Podcast> query = em.createQuery("SELECT p FROM Podcast p", Podcast.class);
        return query.getResultList();
    }

    /**
     * Exclui um podcast do banco de dados com base no ID fornecido.
     *
     * @param id ID do podcast a ser excluído.
     */
    public void excluir(int id) {
        try {
            Podcast podcast = em.find(Podcast.class, id); // Busca o podcast pelo ID
            if (podcast != null) {
                em.getTransaction().begin();
                em.remove(podcast); // Remove o podcast encontrado
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fecha o {@link EntityManager} associado a esta instância.
     */
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
