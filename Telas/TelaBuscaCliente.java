package Telas ;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class TelaBuscaCliente extends JFrame {
    
    private JPanel contentPane;
    private JTable tabelaClientes;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    TelaBuscaCliente frame = new TelaBuscaCliente();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public TelaBuscaCliente() {
        setTitle("UberLand - Busca e Remoção de Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        criarInterface();
        carregarDadosExemplo();
    }
    
    private void criarInterface() {
        // Cabeçalho
        JPanel panelCabecalho = criarCabecalho("🔍 Busca de Clientes", 
            "Encontre, visualize ou remova clientes cadastrados");
        
        // Painel de busca
        JPanel panelBusca = criarPainelBusca();
        
        // Painel de resultados
        JPanel panelResultados = criarPainelResultados();
        
        // Painel de detalhes
        JPanel panelDetalhes = criarPainelDetalhes();
        
        // Botões
        JPanel panelBotoes = criarBotoes();
        
        contentPane.add(panelCabecalho, BorderLayout.NORTH);
        contentPane.add(panelBusca, BorderLayout.WEST);
        contentPane.add(panelResultados, BorderLayout.CENTER);
        contentPane.add(panelDetalhes, BorderLayout.SOUTH);
        contentPane.add(panelBotoes, BorderLayout.EAST);
    }
    
    private JPanel criarCabecalho(String titulo, String subtitulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(46, 204, 113)); // Verde
        panel.setPreferredSize(new Dimension(900, 100));
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
    
    private JPanel criarPainelBusca() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(new EmptyBorder(20, 15, 20, 15));
        panel.setPreferredSize(new Dimension(200, 0));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 15, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel lblFiltro = new JLabel("Filtrar por:");
        lblFiltro.setFont(new Font("Segoe UI", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblFiltro, gbc);
        
        String[] filtros = {"Todos", "Nome", "CPF", "E-mail", "VIP", "Corridas > 50"};
        for (int i = 0; i < filtros.length; i++) {
            JCheckBox check = new JCheckBox(filtros[i]);
            check.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            check.setBackground(new Color(240, 240, 240));
            gbc.gridy = i + 1;
            panel.add(check, gbc);
        }
        
        // Campo de busca
        gbc.gridy = filtros.length + 2;
        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel.add(lblBuscar, gbc);
        
        gbc.gridy = filtros.length + 3;
        JTextField txtBusca = new JTextField();
        txtBusca.setPreferredSize(new Dimension(150, 25));
        panel.add(txtBusca, gbc);
        
        gbc.gridy = filtros.length + 4;
        JButton btnBuscar = new JButton("🔍 Buscar");
        btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnBuscar.setBackground(new Color(52, 152, 219));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(btnBuscar, gbc);
        
        return panel;
    }
    
    private JPanel criarPainelResultados() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Cabeçalho da tabela
        String[] colunas = {"ID", "Nome", "CPF", "E-mail", "Corridas", "VIP", "Ações"};
        Object[][] dados = {}; // Inicialmente vazio
        
        DefaultTableModel model = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Apenas coluna de ações
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) {
                    return JButton.class;
                }
                return String.class;
            }
        };
        
        tabelaClientes = new JTable(model);
        tabelaClientes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tabelaClientes.setRowHeight(30);
        tabelaClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelaClientes.getTableHeader().setBackground(new Color(240, 240, 240));
        tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Centralizar conteúdo
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < colunas.length; i++) {
            tabelaClientes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel criarPainelDetalhes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220)),
            "Detalhes do Cliente",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 12),
            new Color(70, 70, 70)
        ));
        panel.setPreferredSize(new Dimension(900, 120));
        
        String[] campos = {"Nome:", "CPF:", "Data Nasc:", "Celular:", 
                          "E-mail:", "Corridas:", "VIP:", "Desconto:"};
        String[] valores = {"Nenhum selecionado", "-", "-", "-", 
                           "-", "0", "Não", "0%"};
        
        for (int i = 0; i < campos.length; i++) {
            JPanel campoPanel = new JPanel();
            campoPanel.setLayout(new BorderLayout());
            campoPanel.setBackground(Color.WHITE);
            
            JLabel lblCampo = new JLabel(campos[i]);
            lblCampo.setFont(new Font("Segoe UI", Font.BOLD, 11));
            lblCampo.setForeground(new Color(100, 100, 100));
            
            JLabel lblValor = new JLabel(valores[i]);
            lblValor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lblValor.setForeground(Color.BLACK);
            
            campoPanel.add(lblCampo, BorderLayout.NORTH);
            campoPanel.add(lblValor, BorderLayout.CENTER);
            
            panel.add(campoPanel);
        }
        
        return panel;
    }
    
    private JPanel criarBotoes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 0, 10));
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(new EmptyBorder(20, 15, 20, 15));
        panel.setPreferredSize(new Dimension(150, 0));
        
        // Botão Visualizar
        JButton btnVisualizar = criarBotaoAcao("👁️ Visualizar", new Color(52, 152, 219));
        btnVisualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TelaBuscaCliente.this,
                    "Visualizando detalhes do cliente...",
                    "Visualizar",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Botão Editar
        JButton btnEditar = criarBotaoAcao("✏️ Editar", new Color(241, 196, 15));
        
        // Botão Remover
        JButton btnRemover = criarBotaoAcao("🗑️ Remover", new Color(231, 76, 60));
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(TelaBuscaCliente.this,
                    "Tem certeza que deseja remover este cliente?\nEsta ação não pode ser desfeita.",
                    "Confirmar Remoção",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(TelaBuscaCliente.this,
                        "Cliente removido com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        // Botão Promover VIP
        JButton btnPromover = criarBotaoAcao("⭐ Promover VIP", new Color(155, 89, 182));
        btnPromover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TelaBuscaCliente.this,
                    "Cliente promovido a VIP com sucesso!",
                    "Promoção",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Botão Voltar
        JButton btnVoltar = criarBotaoAcao("⬅️ Voltar", new Color(108, 117, 125));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial();
            }
        });
        
        panel.add(btnVisualizar);
        panel.add(btnEditar);
        panel.add(btnRemover);
        panel.add(btnPromover);
        panel.add(btnVoltar);
        
        return panel;
    }
    
    private JButton criarBotaoAcao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 12));
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
    
    private void carregarDadosExemplo() {
        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        
        // Adiciona dados de exemplo
        Object[][] dadosExemplo = {
            {"001", "João Silva", "123.456.789-00", "joao@email.com", "45", "Não", "🔍"},
            {"002", "Maria Santos", "987.654.321-00", "maria@email.com", "120", "Sim", "🔍"},
            {"003", "Pedro Costa", "456.789.123-00", "pedro@email.com", "80", "Sim", "🔍"},
            {"004", "Ana Oliveira", "789.123.456-00", "ana@email.com", "25", "Não", "🔍"},
            {"005", "Carlos Souza", "321.654.987-00", "carlos@email.com", "150", "Sim", "🔍"}
        };
        
        for (Object[] linha : dadosExemplo) {
            model.addRow(linha);
        }
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
}