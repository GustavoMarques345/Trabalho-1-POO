package Telas;

import javax.swing.*;
import java.awt.*;

public class Main {
    
    public static void main(String[] args) {
        // Configurar o Look and Feel do sistema para aparência nativa
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Configurações visuais opcionais para melhor aparência
            UIManager.put("Button.foreground", new Color(255, 255, 255));
            UIManager.put("Button.background", new Color(0, 123, 255));
            UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 12));
            UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 12));
            UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 12));
            
        } catch (Exception e) {
            System.err.println("Erro ao configurar aparência: " + e.getMessage());
        }
        
        // Iniciar a aplicação na Thread do Event Dispatch (requisito do Swing)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                iniciarAplicacao();
            }
        });
    }
    
    private static void iniciarAplicacao() {
        System.out.println("==========================================");
        System.out.println("   UBERLAND - SISTEMA DE GERENCIAMENTO   ");
        System.out.println("==========================================");
        System.out.println("Iniciando aplicação...");
        
        try {
            // Criar e exibir a tela inicial
            TelaInicial telaInicial = new TelaInicial();
            
            // Centralizar na tela
            telaInicial.setLocationRelativeTo(null);
            
            // Tornar visível
            telaInicial.setVisible(true);
            
            System.out.println("✓ Tela inicial carregada com sucesso!");
            System.out.println("✍️  Desenvolvedor: Gustavo Marques Oliveira");
            System.out.println("📅  Versão: 1.0.0");
            System.out.println("==========================================");
            
        } catch (Exception e) {
            System.err.println("❌ ERRO ao iniciar aplicação: " + e.getMessage());
            e.printStackTrace();
            
            // Mostrar mensagem de erro para o usuário
            JOptionPane.showMessageDialog(null,
                "Erro ao iniciar o sistema UberLand:\n" + e.getMessage(),
                "Erro de Inicialização",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método utilitário para abrir outras telas (opcional)
    public static void abrirTela(JFrame novaTela) {
        if (novaTela != null) {
            novaTela.setLocationRelativeTo(null);
            novaTela.setVisible(true);
        }
    }
    
    // Método para mostrar mensagens padrão do sistema
    public static void mostrarMensagem(String titulo, String mensagem, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }
    
    // Método para confirmar ações
    public static boolean confirmarAcao(String titulo, String mensagem) {
        int resposta = JOptionPane.showConfirmDialog(null,
            mensagem,
            titulo,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        return resposta == JOptionPane.YES_OPTION;
    }
}