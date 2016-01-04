import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DigiteSenha extends JFrame implements ActionListener {
	private JLabel jlbSenha,jlbConfirmar;
	private JTextField jtfSenha,jtfConfirmar;
	private JButton jbtOk;
	
	public DigiteSenha() {
		setLayout(null);
		
		jlbSenha=new JLabel("Senha:");
		jlbSenha.setBounds(15, 150, 100, 25);
		getContentPane().add(jlbSenha);
		
		jtfSenha=new JTextField();
		jtfSenha.setBounds(125, 150, 150, 25);
		getContentPane().add(jtfSenha);
		
		jlbConfirmar=new JLabel("Confirmar Senha:");
		jlbConfirmar.setBounds(15, 180, 120, 25);
		getContentPane().add(jlbConfirmar);
		
		jtfConfirmar=new JTextField();
		jtfConfirmar.setBounds(125, 180, 150, 25);
		getContentPane().add(jtfConfirmar);
		
		jbtOk=new JButton("Ok");
		jbtOk.setBounds(100, 210, 50, 25);
		jbtOk.addActionListener(this);
		getContentPane().add(jbtOk);
		
		setTitle("Recuperação de Senha");
		setSize(320,310);
		setVisible(true);
		this.getContentPane().setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if(jtfConfirmar.getText().equals(jtfSenha.getText())){
			try {
				File arquivo=new File("RecuperacaoSenha.txt"); 
				FileWriter fw= new FileWriter("RecuperacaoSenha.txt",true);
				BufferedWriter bw= new BufferedWriter(fw);
				boolean existe=arquivo.exists();
				if(existe){
					
					bw.write(jtfSenha.getText());
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
			JOptionPane.showMessageDialog(this, "Senha Recuperada Com Sucesso,entre em contato com o Admnistrador para Recuperar sua Senha Original");
			new Login_t1();
		}
		else{
			JOptionPane.showMessageDialog(this, "As Senhas não Conferem, Digite Novamente!");
		}
	}
	
}
