package view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DAO.PodcastDAO;
import persistencia.Podcast;


public class TelaListagemGeral extends JFrame {
    private JTextField txtFiltroProdutor;
    private JTable tabelaPodcasts;
    private PodcastDAO podcastDAO;


    

    public TelaListagemGeral() {
        podcastDAO = new PodcastDAO();
        initComponents();
    }

    private void initComponents() {
        setTitle("Listagem de Podcasts");
        setSize(600, 400);
        setLayout(new BorderLayout());

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

        // Adicionando componentes
        add(filtroPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        listarPodcasts(""); // Carrega todos os podcasts ao abrir a tela
    }

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
}
