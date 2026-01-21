package Telas;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroVeiculo extends JFrame {
    
    private JPanel contentPane;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    TelaCadastroVeiculo frame = new TelaCadastroVeiculo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public TelaCadastroVeiculo() {
        setTitle("UberLand - Cadastro de Veículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        criarInterface();
    }
    
    private void criarInterface() {
        // Cabeçalho
        JPanel panelCabecalho = criarCabecalho("🚘 Cadastro de Veículo", 
            "Selecione o tipo e preencha os dados do veículo");
        
        // Painel de seleção de tipo
        JPanel panelTipo = criarPainelTipo();
        
        // Painel de formulário (será atualizado conforme o tipo)
        JPanel panelFormulario = new JPanel();
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBorder(new EmptyBorder(20, 30, 20, 30));
        
        // Botões
        JPanel panelBotoes = criarBotoes();
        
        contentPane.add(panelCabecalho, BorderLayout.NORTH);
        contentPane.add(panelTipo, BorderLayout.WEST);
        contentPane.add(panelFormulario, BorderLayout.CENTER);
        contentPane.add(panelBotoes, BorderLayout.SOUTH);
    }
    
    private JPanel criarCabecalho(String titulo, String subtitulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(231, 76, 60)); // Vermelho
        panel.setPreferredSize(new Dimension(750, 100));
        panel.setBorder(new EmptyBorder(15, 30, 15, 30));
        
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setForeground(Color.WHITE);
        
        JLabel lblSubtitulo = new JLabel(subtitulo);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSubtitulo.setForeground(new Color(240, 240, 240));
        
        panel.add(lblTitulo, BorderLayout.CENTER);
        panel.add(lblSubtitulo, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel criarPainelTipo() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 0, 10));
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(new EmptyBorder(20, 15, 20, 15));
        panel.setPreferredSize(new Dimension(180, 0));
        
        String[] tipos = {"🚕 UberX", "🚙 UberComfort", "🚖 UberBlack"};
        String[] descricoes = {"Econômico", "Confortável", "Premium"};
        Color[] cores = {new Color(52, 152, 219), new Color(155, 89, 182), new Color(46, 204, 113)};
        
        ButtonGroup grupo = new ButtonGroup();
        
        for (int i = 0; i < tipos.length; i++) {
            JToggleButton btn = criarBotaoTipo(tipos[i], descricoes[i], cores[i]);
            grupo.add(btn);
            panel.add(btn);
            
            if (i == 0) {
                btn.setSelected(true);
            }
        }
        
        return panel;
    }
    
    private JToggleButton criarBotaoTipo(String texto, String descricao, Color cor) {
        JToggleButton btn = new JToggleButton("<html><center>" + texto + "<br><small>" + descricao + "</small></center></html>");
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(150, 80));
        
        btn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (btn.isSelected()) {
                    btn.setBackground(cor);
                    btn.setForeground(Color.WHITE);
                    btn.setBorder(BorderFactory.createLineBorder(cor.darker(), 2));
                } else {
                    btn.setBackground(Color.WHITE);
                    btn.setForeground(Color.BLACK);
                    btn.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
                }
            }
        });
        
        return btn;
    }
    
    private JPanel criarBotoes() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panel.setBackground(new Color(248, 249, 250));
        panel.setBorder(new MatteBorder(1, 0, 0, 0, new Color(222, 226, 230)));
        
        JButton btnSalvar = criarBotao("💾 Salvar", new Color(231, 76, 60));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TelaCadastroVeiculo.this,
                    "Veículo cadastrado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton btnLimpar = criarBotao("🗑️ Limpar", new Color(255, 193, 7));
        
        JButton btnCadMotorista = criarBotao("👤 Novo Motorista", new Color(52, 152, 219));
        btnCadMotorista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroMotorista();
            }
        });
        
        JButton btnVoltar = criarBotao("⬅️ Voltar", new Color(108, 117, 125));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial();
            }
        });
        
        panel.add(btnSalvar);
        panel.add(btnLimpar);
        panel.add(btnCadMotorista);
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
        botao.setPreferredSize(new Dimension(150, 40));
        
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
        dispose();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial frame = new TelaInicial();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void abrirTelaCadastroMotorista() {
        dispose();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCadastroMotorista frame = new TelaCadastroMotorista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}