import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Admin_tela2 extends JFrame implements ActionListener {
 private JMenuBar jmbBarra;
 private JMenu jmnArquivo,jmnMovimentacao,jmnFinanceiro,jmnSuporte, jmnSair;
 private JMenuItem jmiProduto,jmiCadastrarUsuario,jmiContasReceber, jmiContasPagar,jmiSair,jmiOutro,jmiCadastrarCliente;
 private JMenuItem jmiVisualizarEstoque, jmiExcluirProduto, jmiContato,jmiCadastrarFornecedor;
 private JButton jbtCliente, jbtFornecedor, jbtProduto, jbtEstoque,jbtContas1, jbtContas, jbtSair;
 private JLabel jlbCliente, jlbFornecedor, jlbProduto, jlbProduto1, jlbEstoque;
 private JLabel jlbContas, jlbContas1, jlbContas2, jlbContas3, jlbSair, jlbLayout; 
 private JSeparator jspSeparador, jspSeparador1, jspSeparador2, jspSeparador3, jspSeparador4, jspSeparador5, jspSeparador6,jspSeparador7;
 public void setValor(int Usuario){
	 if(Usuario!=0){
		 jmiCadastrarUsuario.setEnabled(false);;
	 }
 }
 Admin_tela2(){
	  setLayout(null);
	  jmbBarra=new JMenuBar();
	  jmnArquivo=new JMenu("Arquivo");
	  jmnMovimentacao=new JMenu("Movimentação de Estoque");
	  jmnFinanceiro=new JMenu("Financeiro");
	  jmnSuporte=new JMenu("Suporte");
	  jmnSair=new JMenu("Sair");
	  jmiProduto=new JMenuItem("Cadastrar Produto");
	  jmiCadastrarUsuario=new JMenuItem("Usuários");
	  jmiCadastrarCliente= new JMenuItem("Clientes");
	  jmiCadastrarFornecedor= new JMenuItem("Fornecedores");
	  jmiVisualizarEstoque= new JMenuItem("Visualizar Estoque");
	  jmiExcluirProduto= new JMenuItem("ExcluirProduto");
	  jmiContasReceber=new JMenuItem("Contas à Receber"); 
	  jmiContasPagar=new JMenuItem("Contas à Pagar");
	  jmiContato=new JMenuItem("Contato");
	  jmiSair=new JMenuItem("Sair");
	  jmiOutro=new JMenuItem("Entrar Com Outro Usuário");
	  
	  jmbBarra.add(jmnArquivo);
	  jmbBarra.add(jmnMovimentacao);
	  jmbBarra.add(jmnFinanceiro);
	  jmbBarra.add(jmnSuporte);
	  jmbBarra.add(jmnSair);
	  jmnArquivo.add(jmiCadastrarUsuario);
	  jmnArquivo.add(jmiCadastrarCliente);
	  jmnArquivo.add(jmiCadastrarFornecedor);
	  jmnMovimentacao.add(jmiProduto);
	  jmnMovimentacao.add(jmiExcluirProduto);
	  jmnMovimentacao.add(jmiVisualizarEstoque);
	  jmnFinanceiro.add(jmiContasReceber);
	  jmnFinanceiro.add(jmiContasPagar);
	  jmnSuporte.add(jmiContato);
	  jmnSair.add(jmiOutro);
	  jmnSair.addSeparator();
	  jmnSair.add(jmiSair);
	  jmiExcluirProduto.setEnabled(false);
	  
	  jmiCadastrarUsuario.addActionListener(this);
	  jmiCadastrarCliente.addActionListener(this);
	  jmiCadastrarFornecedor.addActionListener(this);
	  jmiProduto.addActionListener(this);
	  jmiVisualizarEstoque.addActionListener(this);
	  jmiExcluirProduto.addActionListener(this);
	  jmiContasReceber.addActionListener(this);
	  jmiContasPagar.addActionListener(this);
	  jmiContato.addActionListener(this);
	  jmiSair.addActionListener(this);
	  jmiOutro.addActionListener(this);
	 
	    jlbCliente=new JLabel("Cliente");
		jlbCliente.setBounds(45, 52, 51, 51);
		jlbCliente.setBackground(Color.white);
		getContentPane().add(jlbCliente);
		
	    jlbLayout=new JLabel(new ImageIcon("layout.jpg"));
		jlbLayout.setBounds(55, 206, 962, 377);
		jlbLayout.setBackground(Color.white);
		getContentPane().add(jlbLayout);

		jspSeparador=new JSeparator();
		jspSeparador.setBounds(0, 94, 915, 20);
		getContentPane().add(jspSeparador);
		
		jspSeparador1=new JSeparator(SwingConstants.VERTICAL);
		jspSeparador1.setBounds(130, 0, 10 , 94 );
		getContentPane().add(jspSeparador1);
		
	  	jbtCliente=new JButton(new ImageIcon("botao_cliente.jpg"));
		jbtCliente.setBounds(40, 5, 51, 51);
		jbtCliente.setBackground(Color.white);
		jbtCliente.setBorder(null);
		getContentPane().add(jbtCliente);
		
		jlbFornecedor=new JLabel("Fornecedor");
		jlbFornecedor.setBounds(165, 52, 71, 51);
		jlbFornecedor.setBackground(Color.white);
		getContentPane().add(jlbFornecedor);

		
		jspSeparador2=new JSeparator(SwingConstants.VERTICAL);
		jspSeparador2.setBounds(260, 0, 10 , 94 );
		getContentPane().add(jspSeparador2);
		
	  	jbtFornecedor=new JButton(new ImageIcon("botao_fornecedor1.jpg"));
		jbtFornecedor.setBounds(170, 10, 51, 51);
		jbtFornecedor.setBackground(Color.white);
		jbtFornecedor.setBorder(null);
		getContentPane().add(jbtFornecedor);
		

		jlbProduto=new JLabel("Cadastrar");
		jlbProduto.setBounds(295, 60, 71, 25);
		jlbProduto.setBackground(Color.white);
		getContentPane().add(jlbProduto);
		jlbProduto1=new JLabel("Produto");
		jlbProduto1.setBounds(298, 75, 71, 25);
		jlbProduto1.setBackground(Color.white);
		getContentPane().add(jlbProduto1);

		
		jspSeparador3=new JSeparator(SwingConstants.VERTICAL);
		jspSeparador3.setBounds(391, 0, 10 , 94 );
		getContentPane().add(jspSeparador3);
		
	  	jbtProduto=new JButton(new ImageIcon("botao_Produto.jpg"));
		jbtProduto.setBounds(300, 10, 51, 51);
		jbtProduto.setBackground(Color.white);
		jbtProduto.setBorder(null);
		getContentPane().add(jbtProduto);
	
		jlbEstoque=new JLabel("Estoque");
		jlbEstoque.setBounds(431, 52, 71, 51);
		jlbEstoque.setBackground(Color.white);
		getContentPane().add(jlbEstoque);
		
		jspSeparador4=new JSeparator(SwingConstants.VERTICAL);
		jspSeparador4.setBounds(522, 0, 10 , 94 );
		getContentPane().add(jspSeparador4);
		
	  	jbtEstoque=new JButton(new ImageIcon("botao_Estoque.jpg"));
		jbtEstoque.setBounds(431, 10, 51, 51);
		jbtEstoque.setBackground(Color.white);
		jbtEstoque.setBorder(null);
		getContentPane().add(jbtEstoque);
		
		jlbContas=new JLabel("Contas");
		jlbContas.setBounds(562, 45, 71, 51);
		jlbContas.setBackground(Color.white);
		getContentPane().add(jlbContas);
		
		jlbContas1=new JLabel("a Pagar");
		jlbContas1.setBounds(562, 60, 71, 51);
		jlbContas1.setBackground(Color.white);
		getContentPane().add(jlbContas1);
		
		jspSeparador5=new JSeparator(SwingConstants.VERTICAL);
		jspSeparador5.setBounds(653, 0, 10 , 94 );
		getContentPane().add(jspSeparador5);
		
	  	jbtContas=new JButton(new ImageIcon("icone_contas.jpg"));
		jbtContas.setBounds(562, 10, 51, 51);
		jbtContas.setBackground(Color.white);
		jbtContas.setBorder(null);
		getContentPane().add(jbtContas);
		
		jlbContas2=new JLabel("Contas");
		jlbContas2.setBounds(693, 45, 71, 51);
		jlbContas2.setBackground(Color.white);
		getContentPane().add(jlbContas2);
		
		jlbContas3=new JLabel("a Receber");
		jlbContas3.setBounds(693, 60, 71, 51);
		jlbContas3.setBackground(Color.white);
		getContentPane().add(jlbContas3);
		
		jspSeparador6=new JSeparator(SwingConstants.VERTICAL);
		jspSeparador6.setBounds(784, 0, 10 , 94 );
		getContentPane().add(jspSeparador6);
		
		jbtContas1=new JButton(new ImageIcon("icone_contas1.jpg"));
		jbtContas1.setBounds(693, 10, 51, 51);
		jbtContas1.setBackground(Color.white);
		jbtContas1.setBorder(null);
		getContentPane().add(jbtContas1);
		
		jlbSair=new JLabel("Sair");
		jlbSair.setBounds(830, 52, 71, 51);
		jlbSair.setBackground(Color.white);
		getContentPane().add(jlbSair);
		
		jspSeparador7=new JSeparator(SwingConstants.VERTICAL);
		jspSeparador7.setBounds(915, 0, 10 , 94 );
		getContentPane().add(jspSeparador7);
		
	  	jbtSair=new JButton(new ImageIcon("icone_sair.jpg"));
		jbtSair.setBounds(824, 10, 51, 51);
		jbtSair.setBackground(Color.white);
		jbtSair.setBorder(null);
		getContentPane().add(jbtSair);
		
		jbtCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new CadastrarCliente();
			}
		});
		jbtFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new CadastrarFornecedor();
			}
		});
		jbtProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new CadastrarProdutos();
			}
		});
		jbtContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ContasPagar();
			}
		});
		jbtContas1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ContasReceber();
			}
		});
		jbtSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		jbtEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					new VisualizarEstoque();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
	  
	  
	  
	  setJMenuBar(jmbBarra);
	  setTitle("Refigeração São Roque");
	  setExtendedState( MAXIMIZED_BOTH );  
	  setVisible(true);
	  this.setResizable(false);
	  this.getContentPane().setBackground(Color.white);
	  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	  
			
	 }
 
 	public void actionPerformed(ActionEvent arg0) {
 		if(arg0.getSource()==jmiCadastrarUsuario){
 			new CadastrarUsuario();
 		}
 		if(arg0.getSource()==jmiCadastrarCliente){
 			new CadastrarCliente();
 		}
 		if(arg0.getSource()==jmiCadastrarFornecedor){
 			new CadastrarFornecedor();
 		}
 		if(arg0.getSource()==jmiVisualizarEstoque){
 			try {
				new VisualizarEstoque();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 		if(arg0.getSource()==jmiExcluirProduto){
 			new ExcluirProduto();
 		}
 		if(arg0.getSource()==jmiProduto){
 			new CadastrarProdutos();
 		}
 		
 		if(arg0.getSource()==jmiContasReceber){
 			new ContasReceber();
 		}
 		if(arg0.getSource()==jmiContasPagar){
 			new ContasPagar();
 		}
 		if(arg0.getSource()==jmiContato){
 			new Suporte();
 		}
 				
 		if(arg0.getSource()==jmiSair){
 			int resultado=JOptionPane.showConfirmDialog(this, "Deseja Realmente Sair?");
			if(resultado==0){
				dispose();
				JOptionPane.showMessageDialog(this, "Refrigeração São Roque Consertando seus Eletros!");
			}
 		}
 		if(arg0.getSource()==jmiOutro){
 			int resultado=JOptionPane.showConfirmDialog(this, "Deseja Trocar de Usuário?");
			if(resultado==0){
				dispose();
				new Login_t1();
			}
			
 		}
 	}
}
