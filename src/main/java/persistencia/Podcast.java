package persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um podcast no sistema, com atributos relacionados ao produtor,
 * nome do episódio, número do episódio, duração e URL.
 */
@Entity
@Table(name = "podcast")
public class Podcast {

    /**
     * Identificador único do podcast. Gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nome do produtor responsável pelo podcast.
     */
    private String produtor;

    /**
     * Nome do episódio do podcast.
     */
    private String nomeEpisodio;

    /**
     * Número do episódio do podcast.
     */
    private int numeroEpisodio;

    /**
     * Duração do episódio, representada como uma string (por exemplo, "30:45").
     */
    private String duracao;

    /**
     * URL de acesso ao episódio do podcast.
     */
    private String url;

    /**
     * Obtém o identificador único do podcast.
     *
     * @return o identificador do podcast.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do podcast.
     *
     * @param id o identificador a ser atribuído.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produtor responsável pelo podcast.
     *
     * @return o nome do produtor.
     */
    public String getProdutor() {
        return produtor;
    }

    /**
     * Define o nome do produtor responsável pelo podcast.
     *
     * @param produtor o nome do produtor a ser atribuído.
     */
    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    /**
     * Obtém o nome do episódio do podcast.
     *
     * @return o nome do episódio.
     */
    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    /**
     * Define o nome do episódio do podcast.
     *
     * @param nomeEpisodio o nome do episódio a ser atribuído.
     */
    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    /**
     * Obtém o número do episódio do podcast.
     *
     * @return o número do episódio.
     */
    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    /**
     * Define o número do episódio do podcast.
     *
     * @param numeroEpisodio o número do episódio a ser atribuído.
     */
    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    /**
     * Obtém a duração do episódio do podcast.
     *
     * @return a duração do episódio.
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * Define a duração do episódio do podcast.
     *
     * @param duracao a duração a ser atribuída.
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    /**
     * Obtém a URL de acesso ao episódio do podcast.
     *
     * @return a URL do episódio.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define a URL de acesso ao episódio do podcast.
     *
     * @param url a URL a ser atribuída.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
