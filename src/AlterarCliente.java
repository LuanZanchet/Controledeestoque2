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

public class AlterarCliente extends JFrame {
	
	private JLabel jlbCodigo = new JLabel("Codigo");       
	private JLabel jlbNome = new JLabel("Nome");		
	private JLabel jlbCpf = new JLabel("Cpf");			
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
	private JButton jbtAlterar=new JButton("Alterar");
	private JButton jbtFechar=new JButton("Fechar");
	private File MostrarCliente=new File("MostrarCliente.txt");
	private File Clientes=new File("clientes.txt");
	private Vector<String>vcrCliente=new Vector<>();
	private Vector<String>vcrCliente1=new Vector<>();
	int opcao = 0, aux=1, posicao=0;
	
private void posicionaObjeto(JComponent obj, int x, int y, int w, int h){
	obj.setBounds(x, y, w,h);
	getContentPane().add(obj);
}

public void setValor1(int a){
	FileReader fr = null;
	try {
		fr = new FileReader("MostrarCliente.txt");
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	BufferedReader br = new BufferedReader(fr); 
	try {
		vcrCliente.clear();
		while (br.ready()) {
			
			String linha = br.readLine();
			vcrCliente.add(linha);
		
			
			
		}
		br.close();
		fr.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	FileReader frs = null;
	try {
		frs = new FileReader("clientes.txt");
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	BufferedReader brs = new BufferedReader(frs); 
	try {
		vcrCliente1.clear();
		while (brs.ready()) {
			
			String linha = brs.readLine();
			vcrCliente1.add(linha);
		
			
			
		}
		brs.close();
		frs.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	aux=11*(a-1);
	 jtfCodigo.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	
	 jtfNome.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	 
	 jtfCpf.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	
	 jtfRg.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	 
	 jtfEndereco.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);

	 jtfNumero.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);

	 jtfCidade.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	
	 jtfEstado.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	
	 jtfTelefone.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	 
	 jtfEmail.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	 
	 jtfObs.setText(vcrCliente.elementAt(aux));
	 vcrCliente.remove(aux);
	 int aux2=3*(a-1);
	 vcrCliente1.remove(aux2);
	 vcrCliente1.remove(aux2);
	 vcrCliente1.remove(aux2);
	 
	
		
	 
}


AlterarCliente(){
	setTitle("Financeiro");
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
posicionaObjeto(jbtAlterar, 220, 290, 100, 25);
posicionaObjeto(jbtFechar, 420, 290, 100, 25);

jbtAlterar.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileWriter out1 = new FileWriter("MostrarCliente.txt");
			out1.write("");
			out1.flush();   
			out1.close();  
			FileWriter f=new FileWriter("MostrarCliente.txt",true);
			BufferedWriter b=new BufferedWriter(f);
				boolean tem=MostrarCliente.exists();
								if(tem){
								
									for(int a=0; a<vcrCliente.size(); a++){
										b.write(vcrCliente.get(a));
										b.newLine();	
										
									}
									b.write(jtfCodigo.getText());
									b.newLine();
									b.write(jtfNome.getText());
									b.newLine();
									b.write(jtfCpf.getText());
									b.newLine();
									b.write(jtfRg.getText());
									b.newLine();
									b.write(jtfEndereco.getText());
									b.newLine();
									b.write(jtfNumero.getText());
									b.newLine();
									b.write(jtfCidade.getText());
									b.newLine();
									b.write(jtfEstado.getText());
									b.newLine();
									b.write(jtfTelefone.getText());
									b.newLine();
									b.write(jtfEmail.getText());
									b.newLine();
									b.write(jtfObs.getText());
									b.newLine();
									}
								
								else{
									MostrarCliente.createNewFile(); 
								}
								
								
								b.close();
								f.close();
								
								
								
								
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 try {
			  FileWriter out = new FileWriter("clientes.txt");
				out.write("");
				out.flush();   
				out.close();  
				FileWriter fws= new FileWriter("clientes.txt",true);
				BufferedWriter bws=new BufferedWriter(fws);
				boolean tem=Clientes.exists();
				if(tem){
					for(int a=0; a<vcrCliente1.size(); a++){
						bws.write(vcrCliente1.get(a));
						bws.newLine();	
						
					}
					bws.write(jtfCodigo.getText());
					bws.newLine();
					bws.write(jtfNome.getText());
					bws.newLine();
					bws.write(jtfTelefone.getText());
					bws.newLine();
				}
				else{
					Clientes.createNewFile();
				}
				
				bws.close();
				fws.close();
		 } catch (IOException e) {
				e.printStackTrace();
			}
		JOptionPane.showMessageDialog(null, "alterado com sucesso");
		dispose();
		new CadastrarCliente();
	}
});
jbtFechar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		dispose();
		new CadastrarCliente();
		
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
