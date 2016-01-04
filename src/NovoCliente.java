import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NovoCliente extends JFrame {
	
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
	private JButton jbtCadastrar=new JButton("Cadastrar");
	private JButton jbtFechar=new JButton("Fechar");
	private File clientes=new File("clientes.txt");
	private File MostrarCliente=new File("MostrarCliente.txt");
	int opcao = 0;
	
private void posicionaObjeto(JComponent obj, int x, int y, int w, int h){
	obj.setBounds(x, y, w,h);
	getContentPane().add(obj);
}
NovoCliente(){
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
posicionaObjeto(jbtCadastrar, 220, 	290, 100, 25);
posicionaObjeto(jbtFechar, 420, 290, 100, 25);


jbtCadastrar.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileWriter fw= new FileWriter("clientes.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			boolean tem=clientes.exists();
			if(tem){
				bw.write(jtfCodigo.getText());
				bw.newLine();
				bw.write(jtfNome.getText());
				bw.newLine();
				bw.write(jtfTelefone.getText());
				bw.newLine();
			}
			else{
				clientes.createNewFile();
			}
			
			bw.close();
			fw.close();
		
			FileWriter fwm= new FileWriter("MostrarCliente.txt",true);
			BufferedWriter bwm=new BufferedWriter(fwm);
			boolean tem1=clientes.exists();
			if(tem1){
				bwm.write(jtfCodigo.getText());
				bwm.newLine();
				bwm.write(jtfNome.getText());
				bwm.newLine();
				bwm.write(jtfCpf.getText());
				bwm.newLine();
				bwm.write(jtfRg.getText());
				bwm.newLine();
				bwm.write(jtfEndereco.getText());
				bwm.newLine();
				bwm.write(jtfNumero.getText());
				bwm.newLine();
				bwm.write(jtfCidade.getText());
				bwm.newLine();
				bwm.write(jtfEstado.getText());
				bwm.newLine();
				bwm.write(jtfTelefone.getText());
				bwm.newLine();
				bwm.write(jtfEmail.getText());
				bwm.newLine();
				bwm.write(jtfObs.getText());
				bwm.newLine();
			}
			else{
				MostrarCliente.createNewFile();
			}
			
			bwm.close();
			fwm.close();
			
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado Com Sucesso!");
			dispose();
			new CadastrarCliente();
		} catch (IOException e1) {
	 		 
		}
		
		
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
