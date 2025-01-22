package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe utilitária para gerenciar as operações relacionadas ao JPA.
 * Fornece métodos para criar, obter e fechar instâncias de {@link EntityManager}
 * e {@link EntityManagerFactory}.
 */
public class JPAUtil {

    /**
     * Nome da unidade de persistência definido no arquivo `persistence.xml`.
     * Centraliza o nome da unidade para facilitar alterações futuras.
     */
    private static final String PERSISTENCE_UNIT = "cenaflix-PU";

    /** Instância única de {@link EntityManager} para gerenciar as transações com o banco de dados. */
    private static EntityManager em;

    /** Instância única de {@link EntityManagerFactory} para criar os objetos {@link EntityManager}. */
    private static EntityManagerFactory fabrica;

    /**
     * Obtém a instância de {@link EntityManager}.
     * Se a fábrica ou o gerenciador de entidade estiverem fechados ou nulos, são criados novamente.
     *
     * @return Instância única de {@link EntityManager}.
     */
    public static EntityManager getEntityManager() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (em == null || !em.isOpen()) { // Cria se em for nulo ou se o EntityManager foi fechado
            em = fabrica.createEntityManager();
        }

        return em;
    }

    /**
     * Fecha o {@link EntityManager} e o {@link EntityManagerFactory}, caso estejam abertos.
     * Libera os recursos associados ao JPA.
     */
    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }

        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}
