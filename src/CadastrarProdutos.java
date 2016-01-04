
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class CadastrarProdutos extends JFrame {
	private JLabel jlbCodigo =new JLabel("Código de Barra:"), jlbNome=new JLabel("Nome do Produto:");
	private JLabel jlbDescricao=new JLabel("Descrição"),jlbFator=new JLabel("Quantidade :");
	private JLabel jlbUn=new JLabel("Un. Venda:"),jlbCompra=new JLabel("Valor Compra:");
	private JLabel jlbVenda=new JLabel("Valor Venda:"),jlbPorcentagem=new JLabel("%"),jlbLucro=new JLabel("Lucro:");
	private JTextField jtfCodigo= new JTextField(), jtfNome= new JTextField();
	private JTextField jtfDescicao= new JTextField(),jtfFator= new JTextField();
	private JTextField jtfCompra= new JTextField(),jtfLucro= new JTextField(),jtfVenda= new JTextField();
	private JComboBox jcbUn;
	private JButton jbtCadastrar,jbtVisualizar;
	private void posicionaObjeto(JComponent obj, int x, int y, int w, int h){
		obj.setBounds(x, y, w,h);
		getContentPane().add(obj);
	}
	public CadastrarProdutos() {
		setLayout(null);
		posicionaObjeto(jlbCodigo, 10, 10, 100, 25);
		posicionaObjeto(jtfCodigo, 110, 10, 100, 25);
		posicionaObjeto(jlbNome, 220, 10, 120, 25);
		posicionaObjeto(jtfNome, 340, 10, 100, 25);
		posicionaObjeto(jlbDescricao, 10, 40, 100, 25);
		posicionaObjeto(jtfDescicao, 110, 40, 330, 25);
		posicionaObjeto(jlbCompra, 10, 70, 100, 25);
		posicionaObjeto(jtfCompra, 110, 70, 50, 25);
		posicionaObjeto(jlbLucro, 170, 70, 60, 25);
		posicionaObjeto(jtfLucro, 220, 70, 50, 25);
		posicionaObjeto(jlbPorcentagem, 270, 70, 50, 25);
		posicionaObjeto(jlbVenda, 300, 70, 100, 25);
		posicionaObjeto(jtfVenda, 390, 70, 50, 25);
		posicionaObjeto(jlbFator, 10, 110, 100, 25);
		posicionaObjeto(jtfFator, 110, 110, 100, 25);
		posicionaObjeto(jlbUn, 210, 110, 100, 25);
		
		
		
		jcbUn=new JComboBox<String>();
		jcbUn.setBounds(280, 110, 100, 25);
		jcbUn.addItem(null);
		jcbUn.addItem("1");
		jcbUn.addItem("2");
		jcbUn.addItem("3");
		jcbUn.addItem("4");
		jcbUn.addItem("5");
		jcbUn.addItem("6");
		jcbUn.addItem("7");
		jcbUn.addItem("8");
		jcbUn.addItem("9");
		jcbUn.addItem("10");
		jcbUn.addItem("11");
		jcbUn.addItem("12");
		jcbUn.addItem("13");
		jcbUn.addItem("14");
		jcbUn.addItem("15");
		jcbUn.addItem("16");
		jcbUn.addItem("17");
		jcbUn.addItem("18");
		jcbUn.addItem("19");
		jcbUn.addItem("20");
		getContentPane().add(jcbUn);
		
		jbtCadastrar=new JButton("Cadastrar");
		jbtCadastrar.setBounds(100, 170, 100, 25);
		getContentPane().add(jbtCadastrar);
		
		jbtVisualizar=new JButton("Visualizar Estoque");
		jbtVisualizar.setBounds(200, 170, 150, 25);
		getContentPane().add(jbtVisualizar);
		jbtCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File arquivo=new File("Produtos.txt"); 
					FileWriter fw= new FileWriter("Produtos.txt",true);
					BufferedWriter bw= new BufferedWriter(fw);
					boolean existe=arquivo.exists();
					if(existe){
						bw.write(jtfCodigo.getText()); 
						bw.newLine(); 
						bw.write(jtfNome.getText()); 
						bw.newLine();
						bw.write(jtfDescicao.getText()); 
						bw.newLine();
						bw.write(jtfCompra.getText()); 
						bw.newLine();
						bw.write(jtfVenda.getText()); 
						bw.newLine();
						bw.write(jtfFator.getText()); 
						bw.newLine();
						JOptionPane.showInputDialog(this, "Produto Cadastrado Com Sucesso!");
						
						
					}
					else{
						arquivo.createNewFile(); 
					}
					
					bw.close();
					fw.close();
				} catch (IOException e1) {
					 
				
				} 
				
			}
		});
		jbtVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new VisualizarEstoque();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		setTitle("Cadastro de Produtos");
		setSize(500, 300);
		this.getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
}