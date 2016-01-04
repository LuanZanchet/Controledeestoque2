import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class CadastrarCliente extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	private JLabel jlbPesquisar = new JLabel("Pesquisar por:"),jlbValor = new JLabel("Valor:"); 
	private JLabel jlbEmissao = new JLabel("Data de Emissão :"),jlbVencimento = new JLabel("data de Vencimento :");
	private ButtonGroup btgEscolha = new ButtonGroup();
	private JRadioButton jrbCodigo = new JRadioButton("Código");
	private JRadioButton jrbNome = new JRadioButton("Nome/Empresa");
	private JTextField jtfPesquisar = new JTextField(), jtfValor = new JTextField();
	private JTextField jtfEmissao = new JTextField(),jtfVencimento = new JTextField();
	private JTable jtbTabela =new JTable();
	private ScrollPane scpRolagem=new ScrollPane();
	private DefaultTableModel dtmTabela = new DefaultTableModel() ;
	private JButton jbtPesquisar = new JButton("Pesquisar");
	private JButton jbtNovo =new JButton("Novo");
	private JButton jbtAlterar =new JButton("Alterar"), jbtExcluir=new JButton("Excluir");
	private JButton jbtConsultar =new JButton("Consultar"),jbtSair=new JButton("Sair"),jbtMostrar=new JButton("Mostrar Todos");
	private int n=1,l=0, posicao=0, selecionado,procurar=0, aux=0;
	private DefaultTableModel dtmTodos=new DefaultTableModel();
	private void posicionaObjeto(JComponent obj, int x, int y, int w, int h){
		obj.setBounds(x, y, w,h);
		getContentPane().add(obj);
	}
	CadastrarCliente() {
		setTitle("Cadastrar Clientes");
		setLayout(null);
		posicionaObjeto(jlbPesquisar, 10, 10, 100, 25);
		posicionaObjeto(jrbCodigo, 10, 30, 100, 25);
		posicionaObjeto(jrbNome, 10, 50, 150, 25);
		posicionaObjeto(jtfPesquisar, 160, 30, 300, 25);
		scpRolagem.setBounds(10,80,550,300);
		scpRolagem.add(jtbTabela);
		getContentPane().add(scpRolagem);
		posicionaObjeto(jbtPesquisar, 470, 20, 100, 25);
		posicionaObjeto(jbtMostrar, 460, 50, 120, 25);
		posicionaObjeto(jbtNovo, 20, 400, 70, 25);
		posicionaObjeto(jbtConsultar, 110, 400, 100, 25);
		posicionaObjeto(jbtAlterar , 230, 400, 100, 25);
		posicionaObjeto(jbtExcluir, 350, 400, 100, 25);
		posicionaObjeto(jbtSair, 460, 400, 90, 25);
		
		jrbCodigo.setBackground(Color.white);
		jrbNome.setBackground(Color.white);
		
		btgEscolha.add(jrbCodigo);
		btgEscolha.add(jrbNome);
		
		jtbTabela.setModel(dtmTabela);  
		
		dtmTabela.setColumnCount(3);
		dtmTabela.setRowCount(n);
		dtmTabela.setValueAt("Código", 0, 0);
		dtmTabela.setValueAt("Cliente", 0, 1);
		dtmTabela.setValueAt("Telefone", 0, 2);
		
		dtmTodos.setColumnCount(3);
		dtmTodos.setRowCount(1);
		
		FileReader fr = null;
		try {
			fr = new FileReader("clientes.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr); 
		try {
			int Coluna=0, n=1;
			while (br.ready()) {
				
				dtmTabela.setRowCount(n+1);
				String linha = br.readLine();
				dtmTabela.setValueAt(linha, n, Coluna);
				Coluna++;
				if(Coluna==3){
					Coluna=0;
					n++;
				}
			}
			br.close();
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		jbtPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader f = null;
				try {
					f = new FileReader("clientes.txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader b = new BufferedReader(f); 
				try {
					int Coluna1=0;
					while (b.ready()) {
						dtmTodos.setRowCount(l+1);
						String linha = b.readLine();
						dtmTodos.setValueAt(linha, l, Coluna1);
						Coluna1++;
						if(Coluna1==3){
							Coluna1=0;
							l++;
						}
					}
					b.close();
					f.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				int i,j,linha=-1;
				if(jrbCodigo.isSelected()){
					for(i=0;i<dtmTodos.getRowCount();i++){
						for(j=0;j<3;j++){
							if(jtfPesquisar.getText().equals(dtmTodos.getValueAt(i, j))){
								procurar=i+1;
								aux=1;
								linha=i;
								break;
							}
						}
					}
					if(aux==0){
						JOptionPane.showMessageDialog(null, "Não Encontrado!");
					}
					if(aux==1){
						n=1;
						dtmTabela.setRowCount(n);
						dtmTabela.setRowCount(n+1);
						dtmTabela.setValueAt(dtmTodos.getValueAt(linha, 0), 1, 0);
						dtmTabela.setValueAt(dtmTodos.getValueAt(linha, 1), 1, 1);
						dtmTabela.setValueAt(dtmTodos.getValueAt(linha, 2), 1, 2);
					}
				}
				if(jrbNome.isSelected()){
					for(i=0;i<dtmTodos.getRowCount();i++){
						for(j=0;j<3;j++){
							if(jtfPesquisar.getText().equals(dtmTodos.getValueAt(i, j))){
								procurar=i+1;
								aux=1;
								linha=i;
								break;
							}
						}
					}
					if(aux==0){
						JOptionPane.showMessageDialog(null, "Não Encontrado!");
					}
					if(aux==1){
						n=1;
						dtmTabela.setRowCount(n);
						dtmTabela.setRowCount(n+1);
						dtmTabela.setValueAt(dtmTodos.getValueAt(linha, 0), 1, 0);
						dtmTabela.setValueAt(dtmTodos.getValueAt(linha, 1), 1, 1);
						dtmTabela.setValueAt(dtmTodos.getValueAt(linha, 2), 1, 2);
					}
				}
			}
				
		});	
		jbtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NovoCliente();
				
				
			}
		});
		jbtConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionado=jtbTabela.getSelectedRow();
				
				if(selecionado==0){
					JOptionPane.showMessageDialog(null, "Não pode Visualizar essa linha");
				}
				else if(selecionado==-1){
					JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja Visualizar");
				}
				else{
					if(aux==1)
						selecionado=procurar;
					
				VisualizarCliente tela=new VisualizarCliente();
				tela.setValor1(selecionado);
				dispose();
					
				}
				
				}
		});
		jbtAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionado=jtbTabela.getSelectedRow();
				if(selecionado==0){
					JOptionPane.showMessageDialog(null, "Não pode alterar essa linha");
				}
				else if(selecionado==-1){
					JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja alterar");
				}
				else{
					if(aux==1)
						selecionado=procurar;
				AlterarCliente tela=new AlterarCliente();
				tela.setValor1(selecionado);
				dispose();
				}
							}
		});
		jbtMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose(); 
			new CadastrarCliente();
			}
			
		});
		jbtExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				selecionado=jtbTabela.getSelectedRow();
				if(selecionado==0){
					JOptionPane.showMessageDialog(null, "Não pode excluir essa linha");
				}
				else if(selecionado==-1){
					JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja excluir");
				}
				else{
					if(aux==1)
						selecionado=procurar;
				ExcluirCliente tela=new ExcluirCliente();
				tela.setValor1(selecionado);
				dispose();
				}
				
			}
		});
		jbtSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
}	
	
}