package Telas;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroMotorista extends JFrame {
    
    private TelaInicial telaAnterior;
    
    // CONSTRUTOR COM TELA ANTERIOR
    public TelaCadastroMotorista(TelaInicial anterior) {
        this.telaAnterior = anterior;
        initUI();
    }
    
    // CONSTRUTOR PADRÃO (para executar direto)
    public TelaCadastroMotorista() {
        initUI();
    }
    
    private void initUI() {
        setTitle("UberLand - Cadastro de Motorista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        criarInterface();
    }
    
    private void criarInterface() {
        // Cabeçalho
        JPanel panelCabecalho = criarCabecalho("🚗 Cadastro de Motorista", 
            "Preencha os dados do motorista e veículo");
        
        // Abas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabbedPane.setBackground(Color.WHITE);
        
        // Aba Dados Pessoais
        tabbedPane.addTab("📋 Dados Pessoais", criarAbaDadosPessoais());
        
        // Aba Veículo
        tabbedPane.addTab("🚘 Veículo", criarAbaVeiculo());
        
        // Aba Documentos
        tabbedPane.addTab("📄 Documentos", criarAbaDocumentos());
        
        // Botões
        JPanel panelBotoes = criarBotoes();
        
        getContentPane().add(panelCabecalho, BorderLayout.NORTH);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        getContentPane().add(panelBotoes, BorderLayout.SOUTH);
    }
    
    private JPanel criarCabecalho(String titulo, String subtitulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(155, 89, 182));
        panel.setPreferredSize(new Dimension(800, 120));
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        
        JLabel lblSubtitulo = new JLabel(subtitulo);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(240, 240, 240));
        
        panel.add(lblTitulo, BorderLayout.CENTER);
        panel.add(lblSubtitulo, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel criarAbaDadosPessoais() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        
        String[] labels = {
            "Nome Completo:", "CPF:", "Data Nascimento:",
            "Endereço:", "Telefone:", "E-mail:",
            "Nome Social:", "Data CNH:"
        };
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 0.3;
            
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            panel.add(label, gbc);
            
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            
            JTextField campo = new JTextField();
            campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            campo.setPreferredSize(new Dimension(250, 30));
            panel.add(campo, gbc);
        }
        
        return panel;
    }
    
    private JPanel criarAbaVeiculo() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel lblTipo = new JLabel("Tipo de Veículo:");
        lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblTipo, gbc);
        
        String[] tipos = {"UberX", "UberComfort", "UberBlack"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);
        comboTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(comboTipo, gbc);
        
        String[] labels = {"Placa:", "Marca:", "Modelo:", "Cor:", "Ano:", "Capacidade:"};
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            panel.add(label, gbc);
            
            gbc.gridx = 1;
            JTextField campo = new JTextField();
            campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            panel.add(campo, gbc);
        }
        
        return panel;
    }
    
    private JPanel criarAbaDocumentos() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 15, 15));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        String[] documentos = {
            "CNH Digital", "CRLV", 
            "Comprovante de Endereço", "Certidão Criminal",
            "Foto do Veículo", "Seguro Obrigatório"
        };
        
        for (String doc : documentos) {
            JPanel docPanel = new JPanel(new BorderLayout(0, 5));
            docPanel.setBackground(Color.WHITE);
            
            JCheckBox checkBox = new JCheckBox(doc);
            checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            checkBox.setBackground(Color.WHITE);
            
            JButton btnUpload = new JButton("📎 Anexar");
            btnUpload.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            btnUpload.setBackground(new Color(240, 240, 240));
            btnUpload.setFocusPainted(false);
            
            docPanel.add(checkBox, BorderLayout.CENTER);
            docPanel.add(btnUpload, BorderLayout.SOUTH);
            
            panel.add(docPanel);
        }
        
        return panel;
    }
    
    private JPanel criarBotoes() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panel.setBackground(new Color(248, 249, 250));
        panel.setBorder(new MatteBorder(1, 0, 0, 0, new Color(222, 226, 230)));
        
        JButton btnSalvar = criarBotao("💾 Salvar", new Color(155, 89, 182));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TelaCadastroMotorista.this,
                    "Motorista cadastrado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton btnLimpar = criarBotao("🗑️ Limpar", new Color(255, 193, 7));
        
        JButton btnVoltar = criarBotao("⬅️ Voltar", new Color(108, 117, 125));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial();
            }
        });
        
        panel.add(btnSalvar);
        panel.add(btnLimpar);
        panel.add(btnVoltar);
        
        return panel;
    }
    
    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botao.setPreferredSize(new Dimension(140, 40));
        
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(cor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(cor);
            }
        });
        
        return botao;
    }
    
    private void voltarTelaInicial() {
        this.dispose(); // Fecha esta tela
        if (telaAnterior != null) {
            telaAnterior.setVisible(true); // Mostra a tela inicial
        }
    }
    
    // Método main para testar individualmente
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    TelaCadastroMotorista frame = new TelaCadastroMotorista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}