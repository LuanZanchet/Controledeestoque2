import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ExcluirFornecedor extends JFrame {
	
	private JLabel jlbCodigo = new JLabel("Codigo");       
	private JLabel jlbNome = new JLabel("Nome");		
	private JLabel jlbCpf = new JLabel("Cnpj");			
	private JLabel jlbRg = new JLabel("Rg");		
	private JLabel jlbEndereco = new JLabel("Endereco");		
	private JLabel jlbNumero = new JLabel("Numero");		
	private JLabel jlbCidade = new JLabel("Cidade");		
	private JLabel JlbEstado = new JLabel("Estado");		
	private JLabel jlbTelefone = new JLabel("Telefone");		
	private JLabel jlbEmail = new JLabel("Email");		
	private JLabel jlbObs = new JLabel("Obs:");			
	private JTextField jtfCodigo = new JTextField();      
	private JTextField jtfNome =  new JTextField();
	private JTextField jtfCpf =   new JTextField();		
	private JTextField jtfRg =   new JTextField();
	private JTextField jtfEndereco = new JTextField();
	private JTextField jtfNumero =  new JTextField();
	private JTextField jtfCidade = new JTextField();
	private JTextField jtfEstado  = new JTextField();
	private JTextField jtfTelefone  = new JTextField();
	private JTextField jtfEmail  = new JTextField();
	private JTextField jtfObs  = new JTextField();
	private JButton jbtExcluir=new JButton("Excluir");
	private JButton jbtFechar=new JButton("Fechar");
	private File MostrarFornecedor=new File("MostrarFornecedor.txt");
	private File Fornecedores=new File("fornecedores.txt");
	private Vector<String>vcrFornecedor=new Vector<>();
	private Vector<String>vcrFornecedor1=new Vector<>();
	int opcao = 0, aux=1, posicao=0;
	
private void posicionaObjeto(JComponent obj, int x, int y, int w, int h){
	obj.setBounds(x, y, w,h);
	getContentPane().add(obj);
}

public void setValor1(int a){
	FileReader fr = null;
	try {
		fr = new FileReader("MostrarFornecedor.txt");
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	BufferedReader br = new BufferedReader(fr); 
	try {
		vcrFornecedor.clear();
		while (br.ready()) {
			
			String linha = br.readLine();
			vcrFornecedor.add(linha);
		
			
			
		}
		br.close();
		fr.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	FileReader frs = null;
	try {
		frs = new FileReader("fornecedores.txt");
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	BufferedReader brs = new BufferedReader(frs); 
	try {
		vcrFornecedor1.clear();
		while (brs.ready()) {
			
			String linha = brs.readLine();
			vcrFornecedor1.add(linha);
		
			
			
		}
		brs.close();
		frs.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	aux=11*(a-1);
	 jtfCodigo.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	
	 jtfNome.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	 
	 jtfCpf.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	
	 jtfRg.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	 
	 jtfEndereco.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);

	 jtfNumero.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);

	 jtfCidade.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	
	 jtfEstado.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	
	 jtfTelefone.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	 
	 jtfEmail.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	 
	 jtfObs.setText(vcrFornecedor.elementAt(aux));
	 vcrFornecedor.remove(aux);
	 int aux2=3*(a-1);
	 vcrFornecedor1.remove(aux2);
	 vcrFornecedor1.remove(aux2);
	 vcrFornecedor1.remove(aux2);
	
	 jtfCodigo.setEditable(false);
	 jtfNome.setEditable(false);
	 jtfCpf.setEditable(false);
	 jtfRg.setEditable(false);
	 jtfEndereco.setEditable(false);
	 jtfNumero.setEditable(false);
	 jtfCidade.setEditable(false);
	 jtfEstado.setEditable(false);
	 jtfTelefone.setEditable(false);
	 jtfEmail.setEditable(false);
	 jtfObs.setEditable(false);
		
	 
}


ExcluirFornecedor(){
	setTitle("Fornecedor");
	setLayout(null);

posicionaObjeto(jlbCodigo, 10, 10, 100, 25);
posicionaObjeto(jtfCodigo, 60, 10, 40, 25);
posicionaObjeto(jlbNome, 110, 10, 80, 25);
posicionaObjeto(jtfNome, 150, 10, 390, 25);
posicionaObjeto(jlbCpf, 10, 70, 100, 25);
posicionaObjeto(jtfCpf, 40, 70, 110, 25);
posicionaObjeto(jlbRg, 160, 70, 100, 25);
posicionaObjeto(jtfRg, 180, 70, 100, 25);
posicionaObjeto(jlbEndereco, 10, 40, 100, 25);
posicionaObjeto(jtfEndereco, 70, 40, 370, 25);
posicionaObjeto(jlbNumero, 450, 40, 100, 25);
posicionaObjeto(jtfNumero, 500, 40, 40, 25);
posicionaObjeto(jlbCidade, 290, 70, 100, 25);
posicionaObjeto(jtfCidade, 340, 70, 100, 25);
posicionaObjeto(JlbEstado, 450, 70, 40, 25);
posicionaObjeto(jtfEstado, 500, 70, 40, 25);
posicionaObjeto(jlbTelefone, 360, 100, 100, 25);
posicionaObjeto(jtfTelefone, 420, 100, 120, 25);
posicionaObjeto(jlbEmail, 10, 100, 100, 25);
posicionaObjeto(jtfEmail, 50, 100, 300, 25);
posicionaObjeto(jlbObs, 10, 130, 100, 25);
posicionaObjeto(jtfObs, 10, 150, 530, 120);
posicionaObjeto(jbtExcluir, 220, 290, 100, 25);
posicionaObjeto(jbtFechar, 420, 290, 100, 25);

jbtExcluir.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileWriter out1 = new FileWriter("MostrarFornecedor.txt");
			out1.write("");
			out1.flush();   
			out1.close();  
			FileWriter f=new FileWriter("MostrarFornecedor.txt",true);
			BufferedWriter b=new BufferedWriter(f);
				boolean tem=MostrarFornecedor.exists();
								if(tem){
								
									for(int a=0; a<vcrFornecedor.size(); a++){
										b.write(vcrFornecedor.get(a));
										b.newLine();	
										
									}
									}
								
								else{
									MostrarFornecedor.createNewFile(); 
								}
								
								
								b.close();
								f.close();
								
								
								
								
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 try {
			  FileWriter out = new FileWriter("fornecedores.txt");
				out.write("");
				out.flush();   
				out.close();  
				FileWriter fws= new FileWriter("fornecedores.txt",true);
				BufferedWriter bws=new BufferedWriter(fws);
				boolean tem=Fornecedores.exists();
				if(tem){
					for(int a=0; a<vcrFornecedor1.size(); a++){
						bws.write(vcrFornecedor1.get(a));
						bws.newLine();	
						
					}
				}
				else{
					Fornecedores.createNewFile();
				}
				
				bws.close();
				fws.close();
		 } catch (IOException e) {
				e.printStackTrace();
			}
		JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
		dispose();
		new CadastrarFornecedor();
	}
});
jbtFechar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		dispose();
		new CadastrarFornecedor();
		
	}
});
	setSize(580, 370);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setResizable(false);
	this.getContentPane().setBackground(Color.white);
	setVisible(true);
	
}

}
