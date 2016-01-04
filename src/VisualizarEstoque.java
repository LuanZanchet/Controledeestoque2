import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class VisualizarEstoque extends JFrame implements ActionListener {
	private JTable jtbProdutos=new JTable();
	private DefaultTableModel dtmProdutos=new DefaultTableModel();
	private ScrollPane rolagem=new ScrollPane();
	private JButton jbtSair, jbtAtualizar;
	
	VisualizarEstoque() throws IOException{
		setLayout(null);
		
		rolagem.setBounds(0, 0, 860, 600);
		dtmProdutos.setColumnCount(6);
		dtmProdutos.setRowCount(1);
		dtmProdutos.setValueAt("Cód. Produto", 0, 0);
		dtmProdutos.setValueAt("Nome", 0, 1);
		dtmProdutos.setValueAt("Descrição do Produto", 0, 2);
		dtmProdutos.setValueAt("Valor Compra", 0, 3);
		dtmProdutos.setValueAt("Valor Venda", 0, 4);
		dtmProdutos.setValueAt("Quantidade", 0, 5);
		
		jtbProdutos.setModel(dtmProdutos);
		rolagem.add(jtbProdutos);
		getContentPane().add(rolagem);
		
		
		jbtAtualizar=new JButton("Atualizar");
		jbtAtualizar.setBounds(10, 600, 110, 25);
		jbtAtualizar.addActionListener(this);
		getContentPane().add(jbtAtualizar);
		jbtSair=new JButton("Fechar");
		jbtSair.setBounds(780, 600, 80, 25);
		jbtSair.addActionListener(this);
		getContentPane().add(jbtSair);
		FileReader fr = null;
		try {
			fr = new FileReader("Produtos.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		int Coluna=0,Linha=1;
		try {
			while (br.ready()) {
				
				dtmProdutos.setRowCount(Linha+1);
				
				
				String linha = br.readLine();
				dtmProdutos.setValueAt(linha, Linha,Coluna);
				Coluna++;
				if(Coluna==6){
				Linha++;
				Coluna=0;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		setTitle("Estoque");
		setSize(880,680);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		this.getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jbtAtualizar){
				dispose();
				try {
					new VisualizarEstoque();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		if(arg0.getSource()==jbtSair){
			dispose();
		}
	}
}