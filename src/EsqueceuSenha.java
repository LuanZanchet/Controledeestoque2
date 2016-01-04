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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class EsqueceuSenha extends JFrame implements ActionListener {
	private JLabel jlbUsuario,jlbPalavra;
	private JTextField jtfUsuario,jtfPalavra;
	private JButton jbtRequisitar;
	private Vector<String> vcrUsuarios=new Vector();
	private Vector<String> vcrPalavras=new Vector();
	
	EsqueceuSenha(){
		setLayout(null);
		
		jlbUsuario=new JLabel("Usuário:");
		jlbUsuario.setBounds(15, 150, 100, 25);
		getContentPane().add(jlbUsuario);
		
		jtfUsuario=new JTextField();
		jtfUsuario.setBounds(115, 150, 150, 25);
		getContentPane().add(jtfUsuario);
		
		jlbPalavra=new JLabel("Palavra Secreta:");
		jlbPalavra.setBounds(15, 180, 150, 25);
		getContentPane().add(jlbPalavra);
		
		jtfPalavra=new JTextField();
		jtfPalavra.setBounds(115, 180, 150, 25);
		getContentPane().add(jtfPalavra);
		
		jbtRequisitar=new JButton("Requisitar Senha");
		jbtRequisitar.setBounds(100, 210, 150, 25);
		jbtRequisitar.addActionListener(this);
		getContentPane().add(jbtRequisitar);
		
		setTitle("Recuperação de Senha");
		setSize(320,310);
		setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent arg0) {
		FileReader fr = null;
		try {
			fr = new FileReader("Usuários.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr); 
		try {
			while (br.ready()) {
				
				String linha = br.readLine();
				vcrUsuarios.add(linha);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileReader f = null;
		try {
			f = new FileReader("Palavras.txt");
		
		BufferedReader b = new BufferedReader(f);
		
			while (b.ready()) {
				
				String linha = b.readLine();
				vcrPalavras.add(linha);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int i,posicao=-1;
		for(i=0;i<vcrUsuarios.size();i++){
			if(vcrUsuarios.elementAt(i).equals(jtfUsuario.getText())){
				posicao=i;
			}
		}
		if(posicao==-1){
			JOptionPane.showMessageDialog(this, "Usuário Inválido!");
		}
		else{
			if(vcrPalavras.elementAt(posicao).equals(jtfPalavra.getText())){
				try {
					File arquivo=new File("UsuariosRecuperacao.txt"); 
					FileWriter fw= new FileWriter("UsuariosRecuperacao.txt",true);
					BufferedWriter bw= new BufferedWriter(fw);
					boolean existe=arquivo.exists();
					if(existe){
						bw.write(jtfUsuario.getText()); 
						bw.newLine();
					}
					else{
						arquivo.createNewFile(); 
					}
					
					bw.close();
					fw.close();
				} catch (IOException e1) {
					 
				
				} 
				dispose();
				new DigiteSenha();
			}
			else{
				JOptionPane.showMessageDialog(this, "Palavra Secreta Inválida");
			}
		}
	}
}