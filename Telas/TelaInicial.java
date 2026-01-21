package Telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    
    private JPanel contentPane;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    TelaInicial frame = new TelaInicial();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public TelaInicial() {
        setTitle("UberLand - Sistema de Transporte");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        criarInterface();
    }
    
    private void criarInterface() {
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 90, 180);
                Color color2 = new Color(0, 140, 255);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());
        
        JPanel card = criarCardCentral();
        mainPanel.add(card, BorderLayout.CENTER);
        
        contentPane.add(mainPanel, BorderLayout.CENTER);
    }
    
    private JPanel criarCardCentral() {
        JPanel card = new JPanel();
        card.setLayout(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(40, 40, 40, 40)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 15, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Logo
        JLabel lblIcone = new JLabel("🚖", SwingConstants.CENTER);
        lblIcone.setFont(new Font("Segoe UI", Font.PLAIN, 48));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(lblIcone, gbc);
        
        // Título
        JLabel lblTitulo = new JLabel("UberLand", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(new Color(0, 90, 180));
        gbc.gridy = 1;
        card.add(lblTitulo, gbc);
        
        // Subtítulo
        JLabel lblSubtitulo = new JLabel("Escolha o tipo de cadastro", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(100, 100, 100));
        gbc.gridy = 2;
        card.add(lblSubtitulo, gbc);
        
        // Painel de opções
        JPanel painelOpcoes = new JPanel(new GridLayout(1, 2, 15, 0));
        painelOpcoes.setBackground(Color.WHITE);
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        
        ButtonGroup grupo = new ButtonGroup();
        
        // Opção Cliente
        JPanel panelCliente = criarPanelOpcao("👤", "Cliente", "Solicitar corridas");
        JRadioButton rbCliente = (JRadioButton) ((BorderLayout) panelCliente.getLayout()).getLayoutComponent(BorderLayout.CENTER);
        grupo.add(rbCliente);
        painelOpcoes.add(panelCliente);
        
        // Opção Motorista
        JPanel panelMotorista = criarPanelOpcao("🚗", "Motorista", "Oferecer corridas");
        JRadioButton rbMotorista = (JRadioButton) ((BorderLayout) panelMotorista.getLayout()).getLayoutComponent(BorderLayout.CENTER);
        grupo.add(rbMotorista);
        painelOpcoes.add(panelMotorista);
        
        gbc.gridy = 3;
        card.add(painelOpcoes, gbc);
        
        // Botão Continuar
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnContinuar.setBackground(new Color(0, 123, 255));
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorderPainted(false);
        btnContinuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnContinuar.setPreferredSize(new Dimension(140, 40));
        
        // Efeito hover
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContinuar.setBackground(new Color(0, 105, 217));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContinuar.setBackground(new Color(0, 123, 255));
            }
        });
        
        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!rbCliente.isSelected() && !rbMotorista.isSelected()) {
                    JOptionPane.showMessageDialog(TelaInicial.this,
                        "Por favor, selecione uma opção",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (rbCliente.isSelected()) {
                    abrirTelaCadastroCliente();
                } else {
                    abrirTelaCadastroMotorista();
                }
            }
        });
        
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 0, 0, 0);
        card.add(btnContinuar, gbc);
        
        return card;
    }
    
    private JPanel criarPanelOpcao(String icone, String titulo, String descricao) {
        JPanel panel = new JPanel(new BorderLayout(0, 8));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(20, 15, 20, 15)
        ));
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Ícone
        JLabel lblIcone = new JLabel(icone, SwingConstants.CENTER);
        lblIcone.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        
        // Radio button
        JRadioButton radio = new JRadioButton(titulo);
        radio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        radio.setBackground(Color.WHITE);
        radio.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Descrição
        JLabel lblDesc = new JLabel(descricao, SwingConstants.CENTER);
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblDesc.setForeground(new Color(150, 150, 150));
        
        panel.add(lblIcone, BorderLayout.NORTH);
        panel.add(radio, BorderLayout.CENTER);
        panel.add(lblDesc, BorderLayout.SOUTH);
        
        // Tornar todo o painel clicável
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio.setSelected(true);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 123, 255), 1),
                    BorderFactory.createEmptyBorder(20, 15, 20, 15)
                ));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
                    BorderFactory.createEmptyBorder(20, 15, 20, 15)
                ));
            }
        });
        
        return panel;
    }
    
    // ========== MÉTODOS DE NAVEGAÇÃO ==========
    private void abrirTelaCadastroCliente() {
        // Fecha completamente a tela inicial
        this.dispose();
        
        // Cria thread separada para a nova tela
        new Thread(() -> {
            try {
                Thread.sleep(100); // Pequena pausa
                
                SwingUtilities.invokeLater(() -> {
                    TelaCadastroCliente tela = new TelaCadastroCliente();
                    tela.setLocationRelativeTo(null);
                    tela.setVisible(true);
                    
                    // Opcional: Fechar completamente ao sair
                    tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void abrirTelaCadastroMotorista() {
        this.setVisible(false);
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCadastroMotorista tela = new TelaCadastroMotorista(TelaInicial.this);
                    tela.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    TelaInicial.this.setVisible(true);
                }
            }
        });
    }
}