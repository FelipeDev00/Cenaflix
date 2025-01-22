package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.PodcastDAO;
import persistencia.Podcast;

/**
 * Classe que representa a tela de listagem de podcasts.
 * Permite listar, filtrar e excluir podcasts cadastrados.
 */
public class TelaListagemPodcast extends JFrame {
    private JTextField txtFiltroProdutor;
    private JTable tabelaPodcasts;
    private PodcastDAO podcastDAO;
    private JButton btnExcluir;

    /**
     * Construtor da classe TelaListagemPodcast.
     * Inicializa os componentes da interface e carrega os podcasts ao abrir a tela.
     */
    public TelaListagemPodcast() {
        podcastDAO = new PodcastDAO();
        initComponents();
    }

    /**
     * Inicializa os componentes da interface gráfica.
     */
    private void initComponents() {
        setTitle("Listagem de Podcasts");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Painel de Filtro
        JPanel filtroPanel = new JPanel();
        txtFiltroProdutor = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> listarPodcasts(txtFiltroProdutor.getText()));
        filtroPanel.add(new JLabel("Filtrar por Produtor:"));
        filtroPanel.add(txtFiltroProdutor);
        filtroPanel.add(btnBuscar);

        // Tabela de Podcasts
        tabelaPodcasts = new JTable(new DefaultTableModel(
            new Object[]{"ID", "Produtor", "Nome Episódio", "Número Episódio", "Duração", "URL"}, 0));
        JScrollPane scrollPane = new JScrollPane(tabelaPodcasts);

        // Botão Excluir
        btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(this::excluirPodcast);

        JPanel southPanel = new JPanel();
        southPanel.add(btnExcluir);

        // Adicionando componentes
        add(filtroPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        listarPodcasts(""); // Carrega todos os podcasts ao abrir a tela
    }

    /**
     * Lista os podcasts na tabela com base no filtro informado.
     *
     * @param produtor Nome do produtor para filtrar os resultados (opcional).
     */
    private void listarPodcasts(String produtor) {
        DefaultTableModel model = (DefaultTableModel) tabelaPodcasts.getModel();
        model.setRowCount(0); // Limpa a tabela antes de carregar os dados

        List<Podcast> podcasts = podcastDAO.listarPodcasts();
        for (Podcast podcast : podcasts) {
            if (produtor.isEmpty() || podcast.getProdutor().contains(produtor)) {
                model.addRow(new Object[]{
                    podcast.getId(), podcast.getProdutor(), podcast.getNomeEpisodio(),
                    podcast.getNumeroEpisodio(), podcast.getDuracao(), podcast.getUrl()
                });
            }
        }
    }

    /**
     * Exclui o podcast selecionado na tabela.
     *
     * @param e Evento acionado pelo botão de exclusão.
     */
    private void excluirPodcast(ActionEvent e) {
        int selectedRow = tabelaPodcasts.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um podcast para excluir.");
            return;
        }

        int id = (int) tabelaPodcasts.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(
            this, "Tem certeza que deseja excluir o podcast?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            podcastDAO.excluir(id);
            listarPodcasts(""); // Atualiza a tabela
            JOptionPane.showMessageDialog(this, "Podcast excluído com sucesso.");
        }
    }
}
