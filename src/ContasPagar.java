import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class ContasPagar extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	private JLabel jlbFornecedor = new JLabel("Fornecedor:"),jlbValor = new JLabel("Valor:"); 
	private JLabel jlbEmissao = new JLabel("Data de Emissão :"),jlbVencimento = new JLabel("data de Vencimento :");
	private JTextField jtfCliente = new JTextField(), jtfValor = new JTextField();
	private JTextField jtfEmissao = new JTextField(),jtfVencimento = new JTextField();
	private JTable jtbTabela =new JTable();
	private ScrollPane scpRolagem=new ScrollPane();
	private DefaultTableModel dtmTabela = new DefaultTableModel() ;
	private JButton jbtCadastrar = new JButton("Cadastrar");
	private JButton jbtLimpar =new JButton("Limpar");
	private JButton jbtAtualizar=new JButton("Atualizar Contas");
	private File pagar=new File("ContasPagar.txt");
	private int atualiza=0;
	int Linha=1;
	private void posicionaObjeto(JComponent obj, int x, int y, int w, int h){
		obj.setBounds(x, y, w,h);
		getContentPane().add(obj);
	}
	ContasPagar() {
		setTitle("Financeiro");
		setLayout(null);
		posicionaObjeto(jlbFornecedor, 10, 10, 100, 25);
		posicionaObjeto(jtfCliente, 130, 10, 100, 25);
		posicionaObjeto(jlbValor, 10, 40, 100, 25);
		posicionaObjeto(jtfValor, 130, 40, 100, 25);
		posicionaObjeto(jlbEmissao, 10, 80, 140, 25);
		posicionaObjeto(jtfEmissao, 130, 80, 100, 25);
		posicionaObjeto(jlbVencimento, 10, 120, 140, 25);
		posicionaObjeto(jtfVencimento, 130, 120, 100, 25);
		scpRolagem.setBounds(350,10,500,300);
		scpRolagem.add(jtbTabela);
		getContentPane().add(scpRolagem);
		posicionaObjeto(jbtCadastrar, 40, 290, 100, 25);
		posicionaObjeto(jbtLimpar, 150, 290, 100, 25);
		posicionaObjeto(jbtAtualizar, 350, 310, 150, 25);
		jtbTabela.setModel(dtmTabela);  
		
		dtmTabela.setColumnCount(4);
		dtmTabela.setRowCount(Linha);
		dtmTabela.setValueAt("Cliente", 0, 0);
		dtmTabela.setValueAt("Valor", 0, 1);
		dtmTabela.setValueAt("Emissão", 0, 2);
		dtmTabela.setValueAt("Vencimento ", 0, 3);
		atualiza=1;
		FileReader fr = null;
		try {
			fr = new FileReader("ContasPagar.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		int linhaa=1,coluna=0;
		try {
			while (br.ready()) {
				dtmTabela.setRowCount(linhaa+1);
				
				
				String linha = br.readLine();
				dtmTabela.setValueAt(linha, linhaa,coluna);
				coluna++;
				if(coluna==4){
				linhaa++;
				coluna=0;
				
				}
				Linha=linhaa;
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		jbtCadastrar.addActionListener(new ActionListener() {
			private double aux, aux2, aux3,aux4;
			
			public void actionPerformed(ActionEvent e) {
				
				dtmTabela.setRowCount(Linha+1);
				dtmTabela.setValueAt(jtfCliente.getText(), Linha, 0);
				dtmTabela.setValueAt(jtfValor.getText(), Linha, 1);
				dtmTabela.setValueAt(jtfEmissao.getText(), Linha, 2);
				dtmTabela.setValueAt(jtfVencimento.getText(), Linha, 3);
				
				try {
					FileWriter fw= new FileWriter("ContasPagar.txt",true);
					BufferedWriter bw= new BufferedWriter(fw);
					boolean existente=pagar.exists();
					if(existente){
						bw.write(jtfCliente.getText());
						bw.newLine();
						bw.write(jtfValor.getText());
						bw.newLine();
						bw.write(jtfEmissao.getText());
						bw.newLine();
						bw.write(jtfVencimento.getText());
						bw.newLine();
					}
					else{
						pagar.createNewFile();
					}
					
					bw.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Linha++;
				}
			
		});	
		jbtLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha=jtbTabela.getSelectedRow();
				dtmTabela.removeRow(linha);
				Linha--;
				Writer out;
				try {
					out = new FileWriter("ContasPagar.txt");
					out.write("");
					out.flush();    
					out.close();  
					FileWriter fe= new FileWriter("ContasPagar.txt",true);
					BufferedWriter be= new BufferedWriter(fe);
						boolean existe=pagar.exists();
						if(existe){
									for(int i=1;i<Linha;i++){
										for(int j=0;j<4;j++){
											be.write(String.valueOf((dtmTabela.getValueAt(i, j))));
											be.newLine();
										}
									}
									}
										else{
											pagar.createNewFile(); 
										}
										
										be.close();
										fe.close();
				}
				catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		});
		
		jbtAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ContasPagar();
			}
		});
		
		setSize(900, 600);
		this.getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
}	
}
