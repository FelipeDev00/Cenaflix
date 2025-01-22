package br.com.main.cenaflixone;

import view.TelaLogin;

/**
 * Classe principal da aplicação CenaflixOne.
 * Esta classe é responsável por inicializar e exibir a tela de login do sistema.
 */
public class CenaflixOne {

    /**
     * Método principal da aplicação.
     * Configura o *Look and Feel* da interface gráfica para "Nimbus" e inicia a tela de login.
     *
     * @param args argumentos da linha de comando (não utilizados).
     */
    public static void main(String args[]) {
        try {
            // Configura o Look and Feel para "Nimbus", caso disponível.
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Cria e exibe a tela de login da aplicação. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }
}
