import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login_t1 extends JFrame implements ActionListener {
	
	private JLabel jlbUsuario,jlbSenha, jlbImg;
	private JTextField jtfUsuario;
	private JPasswordField jpfSenha;
	private JButton jbtEsqueceuSenha,jbtLogar,jbtSair;
	private Vector<String> vcrUsuarios=new Vector<String>();
	private Vector<String> vcrSenhas=new Vector<String>();
	private int i,contador=0,j;
	private Vector<String> vcrSenhasR=new Vector<String>();
	private Vector<String> vcrUsuariosR=new Vector<String>();
	Login_t1(){
		setLayout(null);
		
		jlbImg=new JLabel(new ImageIcon("teste.jpg"));
		jlbImg.setBounds(10, 10, 300, 120);
		getContentPane().add(jlbImg);
		
		jlbUsuario=new JLabel("Usuário:");
		jlbUsuario.setBounds(15, 150, 100, 25);
		jlbUsuario.setForeground(Color.blue);
		getContentPane().add(jlbUsuario);
		
		jtfUsuario=new JTextField();
		jtfUsuario.setBounds(85, 150, 150, 25);
		getContentPane().add(jtfUsuario);
		
		jlbSenha=new JLabel("Senha:");
		jlbSenha.setBounds(15, 180, 100, 25);
		jlbSenha.setForeground(Color.blue);
		getContentPane().add(jlbSenha);
		
		jpfSenha=new JPasswordField();
		jpfSenha.setBounds(85, 180, 150, 25);
		getContentPane().add(jpfSenha);
		
		jbtLogar=new JButton(new ImageIcon("botao_login.jpg"));
		jbtLogar.setBounds(100, 210, 80, 25);
		jbtLogar.setBorder(null);
		jbtLogar.addActionListener(this);
		getContentPane().add(jbtLogar);
		
		jbtSair=new JButton(new ImageIcon("botao_sair.gif"));
		jbtSair.setBounds(260, 230, 40, 40);
		jbtSair.setBorder(null);
		jbtSair.addActionListener(this);
		getContentPane().add(jbtSair);
		
		jbtEsqueceuSenha=new JButton("Esqueci Minha Senha");
		jbtEsqueceuSenha.setFont(new Font("Serif", Font.BOLD, 10));
		jbtEsqueceuSenha.setForeground(Color.black);
		jbtEsqueceuSenha.setBounds(90, 240, 130, 15);
		jbtEsqueceuSenha.addActionListener(this);
		getContentPane().add(jbtEsqueceuSenha);
		
		setTitle("Seja Bem-Vindo");
		setSize(320,310);
		setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Login_t1();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jbtLogar){
			FileReader fr = null;
			FileReader fr1=null;
			FileReader fr2=null;
			FileReader fr3=null;
			try {
				fr = new FileReader("Usuários.txt");
				BufferedReader br = new BufferedReader(fr); 
					while (br.ready()) {
						
						String linha = br.readLine();
						vcrUsuarios.add(linha);
					}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fr1 = new FileReader("Senhas.txt");
				BufferedReader br1 = new BufferedReader(fr1); 
				try {
					while (br1.ready()) {
						
						String linha = br1.readLine();
						vcrSenhas.add(linha);
					}
				} catch (IOException e) {
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				fr2 = new FileReader("UsuariosRecuperacao.txt");
				BufferedReader br2 = new BufferedReader(fr2); 
				try {
					while (br2.ready()) {
						
						String linha = br2.readLine();
						vcrUsuariosR.add(linha);
					}
				} catch (IOException e) {
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				fr3 = new FileReader("RecuperacaoSenha.txt");
				BufferedReader br3 = new BufferedReader(fr3); 
				try {
					while (br3.ready()) {
						
						String linha = br3.readLine();
						vcrSenhasR.add(linha);
					}
				} catch (IOException e) {
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			int posicao1=-1,auxiliar=0;
			for(j=0;j<vcrUsuariosR.size();j++){
				if(vcrUsuariosR.elementAt(j).equals(jtfUsuario.getText())){
					posicao1=j;
				}
			}
			int posicao=-1,aux=0,aux1=0;
			for(i=0;i<vcrUsuarios.size();i++){
				if(jtfUsuario.getText().equals(vcrUsuarios.elementAt(i))){
					posicao=i;
					aux1=1;
				}
			}
			if(aux1==0){
				JOptionPane.showMessageDialog(this, "Usuário Inválido");
				dispose();
				new Login_t1();
			}
			else{
			if(aux1==1||posicao1==j){
				 if(jpfSenha.getText().equals(vcrSenhas.elementAt(posicao))||jpfSenha.getText().equals(vcrSenhasR.elementAt(posicao1))){
			dispose();
			Admin_tela2 tela=new Admin_tela2();
			tela.setValor(posicao);
			}
		
		else{
			posicao=0;
			JOptionPane.showMessageDialog(this, "Senha Inválida");
			contador++;
			if(contador==3){
				JOptionPane.showMessageDialog(this,"Esqueceu a senha? Experiemente a função Esqueci Minha senha");
				contador=0;
			}
			}
		}
		}
		}
		if(arg0.getSource()==jbtSair){
			int resultado=JOptionPane.showConfirmDialog(this, "Deseja Realmente Sair?");
			if(resultado==0){
				dispose();
				JOptionPane.showMessageDialog(this, "Refrigeração São Roque Consertando seus Eletros!");
			}
		}
		if(arg0.getSource()==jbtEsqueceuSenha){
			dispose();
		    new EsqueceuSenha();
		}
	}
}
	