package Telas;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroCliente extends JFrame {
    
    private TelaInicial telaAnterior;
    
    // CONSTRUTOR COM TELA ANTERIOR
    public TelaCadastroCliente(TelaInicial anterior) {
        this.telaAnterior = anterior;
        initUI();
    }
    
    // CONSTRUTOR PADRÃO (para executar direto)
    public TelaCadastroCliente() {
        initUI(); ////
    }
    
    private void initUI() {
        setTitle("UberLand - Cadastro de Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 650);
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
        JPanel panelCabecalho = criarCabecalho("👤 Cadastro de Cliente", "Preencha os dados do cliente");
        
        // Formulário
        JPanel panelFormulario = criarFormulario();
        
        // Botões
        JPanel panelBotoes = criarBotoes();
        
        getContentPane().add(panelCabecalho, BorderLayout.NORTH);
        getContentPane().add(panelFormulario, BorderLayout.CENTER);
        getContentPane().add(panelBotoes, BorderLayout.SOUTH);
    }
    
    private JPanel criarCabecalho(String titulo, String subtitulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(52, 152, 219));
        panel.setPreferredSize(new Dimension(700, 120));
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
    
    private JPanel criarFormulario() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(30, 40, 30, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        
        String[] labels = {
            "Nome Completo:", "CPF:", "Data de Nascimento:",
            "E-mail:", "Celular:", "Gênero:", "Forma de Pagamento:"
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
            
            if (i == 5) { // Gênero
                String[] generos = {"Selecione...", "Masculino", "Feminino", "Outro", "Prefiro não informar"};
                JComboBox<String> combo = new JComboBox<>(generos);
                combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                combo.setPreferredSize(new Dimension(200, 30));
                panel.add(combo, gbc);
            } else if (i == 6) { // Forma de Pagamento
                String[] pagamentos = {"Selecione...", "Cartão de Crédito", "Cartão de Débito", "PIX", "Dinheiro"};
                JComboBox<String> combo = new JComboBox<>(pagamentos);
                combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                combo.setPreferredSize(new Dimension(200, 30));
                panel.add(combo, gbc);
            } else {
                JTextField campo = new JTextField();
                campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                campo.setPreferredSize(new Dimension(200, 30));
                panel.add(campo, gbc);
            }
        }
        
        return panel;
    }
    
    private JPanel criarBotoes() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panel.setBackground(new Color(248, 249, 250));
        panel.setBorder(new MatteBorder(1, 0, 0, 0, new Color(222, 226, 230)));
        
        // Botão Salvar
        JButton btnSalvar = criarBotao("💾 Salvar", new Color(40, 167, 69));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TelaCadastroCliente.this,
                    "Cliente cadastrado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Botão Limpar
        JButton btnLimpar = criarBotao("🗑️ Limpar", new Color(255, 193, 7));
        
        // Botão Buscar Clientes
        JButton btnBuscar = criarBotao("🔍 Buscar", new Color(52, 152, 219));
        
        // Botão Voltar
        JButton btnVoltar = criarBotao("⬅️ Voltar", new Color(108, 117, 125));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial();
            }
        });
        
        panel.add(btnSalvar);
        panel.add(btnLimpar);
        panel.add(btnBuscar);
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
        botao.setPreferredSize(new Dimension(120, 40));
        
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
                    TelaCadastroCliente frame = new TelaCadastroCliente();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}