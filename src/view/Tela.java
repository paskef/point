/* 
 *  Para a realização desse projeto foram utilizados como objeto de pesquisa o
 * Stackoverflow e o Phind.
 */


package view;

// Importar bibliotecas

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Tela {
    private JFrame frame;
    private JPanel painel_principal;
    private Color cor_atual = Color.BLACK;
    private ArrayList<ArrayList<Point>> linhas = new ArrayList<>();
    private ArrayList<Color> cores = new ArrayList<>();
    private ArrayList<Point> linha_atual;
    private int pincel_tamanho = 2; // Tamanho do pincel em pixels

    
 // Criação de enum que contém todas as cores utilizadas nos botões
    
    public enum Cores {
        PRETO(Color.BLACK),
        CINZA_ESCURO(Color.DARK_GRAY),
        CINZA_CLARO(Color.LIGHT_GRAY),
        BRANCO(new Color(255, 255, 255)),
        AZUL(Color.BLUE),
        CIANO(Color.CYAN),
        VERDE(Color.GREEN),
        VERMELHO(Color.RED),
        LARANJA(new Color(255, 128, 0)),
        AMARELO(Color.YELLOW),
        ROSA(new Color(255, 0, 128)),
        MAGENTA(Color.MAGENTA),
    	VERDE_CLARO(new Color(128, 255, 128)),
    	AMARELO_CLARO(new Color(255, 255, 128)),
    	ROSA_CLARO(new Color(255, 128, 192)),
    	AZUL_ROYAL(new Color(128, 128, 255)),
    	MARROM(new Color(128, 64, 0)),
    	VINHO(new Color(128, 0, 64)),
    	SALMAO(new Color(255, 128, 128)),
    	BEGE(new Color(255, 238, 206)),
    	VERDE_ESCURO(new Color(0, 96, 0));
    	
    	

        private final Color cor;

        Cores(Color cor) {
            this.cor = cor;
        }

        public Color getCor() {
            return cor;
        }
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Tela window = new Tela();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    public Tela() {
        initialize();
    }
    
    /**
	 * @wbp.parser.entryPoint
	 */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Point!");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setResizable(false);

        painel_principal = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenhar_linhas(g);
                
            }
            
        };
        painel_principal.setBackground(Color.WHITE);
        painel_principal.addMouseListener(new MouseAdapter() {
        	// Captura os pontos iniciais quando o mouse é pressionado
            public void mousePressed(MouseEvent e) {
            	 // Cria uma nova linha para armazenar os pontos.
                linha_atual = new ArrayList<>();
                // Adiciona o ponto inicial à linha.
                linha_atual.add(new Point(e.getX(), e.getY()));
                linhas.add(linha_atual);
                cores.add(cor_atual);
            }
        });

        painel_principal.addMouseMotionListener(new MouseMotionAdapter() {
        	// Adiciona pontos à linha atual durante o arraste do mouse, atuando como ouvinte de movimento do mouse.
            public void mouseDragged(MouseEvent e) {
                linha_atual.add(new Point(e.getX(), e.getY()));
                painel_principal.repaint();
            }
        });

        frame.getContentPane().add(painel_principal, BorderLayout.CENTER);
        painel_principal.setLayout(null);
        		
        		// Criar painel lateral
                JPanel painel_lateral = new JPanel();
                painel_lateral.setBackground(new Color(225, 237, 253));
                painel_lateral.setBounds(0, -11, 140, 517);
                painel_principal.add(painel_lateral);
                painel_lateral.setLayout(null);
                
                // Criar botões da palheta de cores
                
                JButton corVerdeClaro = new JButton("");
                JButton corPreta = new JButton("");
                JButton corCinzaEscuro = new JButton("");
                JButton corCinzaClaro = new JButton("");
                JButton corBranca = new JButton("");                
                JButton corAzul= new JButton("");
                JButton corCiano= new JButton("");
                JButton corVerde= new JButton("");
                JButton corVermelha= new JButton("");
                JButton corLaranja= new JButton("");
                JButton corAmarela= new JButton("");
                JButton corRosa= new JButton("");
                JButton corMagenta= new JButton("");  
                JButton corAmareloClaro = new JButton("");
                JButton corRosaClaro = new JButton("");
                JButton corAzulRoyal = new JButton("");
                JButton corMarrom = new JButton("");
                JButton corVinho = new JButton("");
                JButton corSalmao = new JButton("");
                JButton corBege = new JButton("");
                JButton corVerdeEscuro = new JButton("");
                
                // Adicionar botões ao painel lateral
                
                painel_lateral.add(corPreta);
                painel_lateral.add(corCinzaEscuro);
                painel_lateral.add(corCinzaClaro);
                painel_lateral.add(corBranca);
                painel_lateral.add(corAzul);
                painel_lateral.add(corCiano);
                painel_lateral.add(corVerde);
                painel_lateral.add(corVermelha);
                painel_lateral.add(corLaranja);
                painel_lateral.add(corAmarela);
                painel_lateral.add(corRosa);
                painel_lateral.add(corMagenta);
                painel_lateral.add(corVerdeClaro);
                painel_lateral.add(corAmareloClaro);
                painel_lateral.add(corRosaClaro);
                painel_lateral.add(corAzulRoyal);
                painel_lateral.add(corMarrom);
                painel_lateral.add(corVinho);
                painel_lateral.add(corSalmao);
                painel_lateral.add(corBege);
                painel_lateral.add(corVerdeEscuro);
                
                // Alterar cor e posição de cada botão
                
                configurar_botao(corPreta, Cores.PRETO, 10, 20);
                configurar_botao(corCinzaEscuro, Cores.CINZA_ESCURO, 44, 20);
                configurar_botao(corCinzaClaro, Cores.CINZA_CLARO, 78, 20);
                configurar_botao(corBranca, Cores.BRANCO, 10, 173);
                configurar_botao(corAzul, Cores.AZUL, 112, 82);
                configurar_botao(corCiano, Cores.CIANO,44, 113);
                configurar_botao(corVerde, Cores.VERDE, 112, 113);
                configurar_botao(corVermelha, Cores.VERMELHO,  44, 51);
                configurar_botao(corLaranja, Cores.LARANJA, 112, 51);
                configurar_botao(corAmarela, Cores.AMARELO, 44, 142);
                configurar_botao(corRosa, Cores.ROSA, 78, 51);
                configurar_botao(corMagenta, Cores.MAGENTA, 10, 82);
                configurar_botao(corVerdeClaro, Cores.VERDE_CLARO,  10, 142);
                configurar_botao(corAmareloClaro, Cores.AMARELO_CLARO, 78, 142);
                configurar_botao(corRosaClaro, Cores.ROSA_CLARO, 78, 82);
                configurar_botao(corAzulRoyal, Cores.AZUL_ROYAL, 10, 113);
                configurar_botao(corMarrom, Cores.MARROM, 112, 20);
                configurar_botao(corVinho, Cores.VINHO, 10, 51);
                configurar_botao(corSalmao, Cores.SALMAO, 44, 82);
                configurar_botao(corBege, Cores.BEGE, 112, 142);
                configurar_botao(corVerdeEscuro, Cores.VERDE_ESCURO, 78, 113);

   
        menu();
        rodape();
    }
    
    /**
     * Configura os botões da paleta de cores.
     * button Botão a ser configurado.
     *  cor Cor associada ao botão.
     * x Posição horizontal do botão.
     * y Posição vertical do botão.
     */
    
    private void configurar_botao(JButton button, Cores cor, int x, int y) {
        button.setBounds(x, y, 20, 20);
        button.setBackground(cor.getCor());
        button.addActionListener(e -> cor_atual = cor.getCor());
    }
    
    /**
     * Desenha as linhas no painel de desenho.
     * @param g Objeto de gráficos para desenhar as linhas.
     */
    
    private void desenhar_linhas(Graphics g) {
        // Converte o objeto Graphics para Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Percorre todas as linhas armazenadas
        for (int i = 0; i < linhas.size(); i++) {
            // Obtém a lista de pontos representando a linha atual.
            ArrayList<Point> line = linhas.get(i);

            // Obtém a cor associada à linha atual.
            Color color = cores.get(i);

            // Configura a cor do objeto gráfico para a cor da linha atual.
            g2d.setColor(color);

            // Define a espessura da linha
            g2d.setStroke(new BasicStroke(pincel_tamanho, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            // Percorre todos os pontos da linha e desenha segmentos de linha entre pontos consecutivos.
            for (int j = 1; j < line.size(); j++) {
                Point currentPoint = line.get(j);
                Point previousPoint = line.get(j - 1);

                // Desenha uma linha entre o ponto anterior e o ponto atual.
                g2d.drawLine(previousPoint.x, previousPoint.y, currentPoint.x, currentPoint.y);
            }
        }
    }

    
    /**
     * Configura a barra de menu.
     */
    
    private void menu() {
        JMenuBar barra_menu = new JMenuBar();
        barra_menu.setBackground(new Color(243, 243, 243));
        JMenu botao_arquivo = new JMenu("Arquivo");
        botao_arquivo.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
        JMenuItem botao_salvar = new JMenuItem("Salvar como");
        botao_salvar.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
        botao_salvar.setHorizontalAlignment(SwingConstants.CENTER);
        botao_salvar.addActionListener(e -> salvar_arquivo());
        botao_arquivo.add(botao_salvar);
        barra_menu.add(botao_arquivo);
        frame.setJMenuBar(barra_menu);
        
    }
    
    /**
     * Configura os botões no rodapé.
     */
    
    private void rodape() {
    	JPanel barra_rodape = new JPanel();
    	barra_rodape.setBackground(new Color(243, 243, 243));
        frame.getContentPane().add(barra_rodape, BorderLayout.SOUTH);
        barra_rodape.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton botao_sair = new JButton("Sair");
        botao_sair.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
        botao_sair.setBackground(new Color(255, 255, 255));
        botao_sair.addActionListener(e -> System.exit(0));
        barra_rodape.add(botao_sair);

        JButton botao_limpar = new JButton("Limpar");
        botao_limpar.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
        botao_limpar.setBackground(new Color(255, 255, 255));
        botao_limpar.addActionListener(e -> {
            linhas.clear();
            cores.clear();
            painel_principal.repaint();
        });
        barra_rodape.add(botao_limpar);
    }
    
    /**
     * Salva o desenho como uma imagem.
     */
    
    private void salvar_arquivo() {
        try {
            // Cria um seletor de arquivos.
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvando arquivo...");
            
            // Exibe o seletor de arquivos e aguarda a escolha do usuário.
            int userSelection = fileChooser.showSaveDialog(frame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Obtém o arquivo selecionado pelo usuário.
                File file = fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();

                // Garante que o arquivo tenha a extensão .png.
                if (!filePath.toLowerCase().endsWith(".png")) {
                    file = new File(filePath + ".png");
                }

                // Cria uma imagem a partir do painel principal.
                BufferedImage image = new BufferedImage(painel_principal.getWidth(), painel_principal.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = image.getGraphics();

                // Preenche a imagem com a cor de fundo do painel principal.
                g.setColor(painel_principal.getBackground());
                g.fillRect(0, 0, image.getWidth(), image.getHeight());

                // Desenha as linhas no painel principal na imagem.
                desenhar_linhas(g);
                g.dispose();

                // Salva a imagem no arquivo PNG.
                ImageIO.write(image, "png", file);

                // Exibe uma mensagem de sucesso.
                JOptionPane.showMessageDialog(frame, "Imagem salva com sucesso!");
            }
        } catch (IOException ex) {
            // Em caso de erro durante o salvamento, exibe uma mensagem de erro.
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro durante o salvamento", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
}