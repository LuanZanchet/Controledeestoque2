import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CadastrarUsuario extends JFrame implements ActionListener {
	private JLabel jlbFrase,jlbUsuarios,jlbAtual,jlbNova,jlbConfirmar,jlbNovo;
	private JTextField jtfAtual,jtfNova,jtfConfirmar,jtfNovo;
	private JButton jbtInserir,jbtExcluir,jbtAlterar,jbtFechar;
	private JList<String> jltUsuarios=new JList<>();
	private Vector<String>vcrUsuarios=new Vector<>();
	private ScrollPane rolagem=new ScrollPane();
	private Vector<String> vcrSenhas=new Vector<String>();
	private Vector<String> vcrPalavras=new Vector<String>();
	private File arquivo=new File("Usuários.txt"); 
	private File senhas= new File("Senhas.txt");
	private File palavras=new File("Palavras.txt");
	private JLabel jlbPalavra;
	private JTextField jtfPalavra;
	CadastrarUsuario(){
		setLayout(null);
		
		rolagem.setBounds(20,70, 250, 200);
		jltUsuarios.setListData(vcrUsuarios);
		rolagem.add(jltUsuarios);
		getContentPane().add(rolagem);
		
		jlbFrase=new JLabel(">>>Para excluir um usuário, selecione-o na lista 'Usuários' depois clique em 'Excluir'.");
		jlbFrase.setBounds(30, 0, 500, 25);
		getContentPane().add(jlbFrase);
		
		jlbUsuarios=new JLabel("Usuários:");
		jlbUsuarios.setBounds(20, 40, 100, 25);
		getContentPane().add(jlbUsuarios);
		
		jlbAtual=new JLabel("Senha Atual:");
		jlbAtual.setBounds(290, 40, 100, 25);
		getContentPane().add(jlbAtual);
		
		jtfAtual=new JTextField();
		jtfAtual.setBounds(290, 70, 150, 25);
		getContentPane().add(jtfAtual);
		
		jlbNova=new JLabel("Nova Senha:");
		jlbNova.setBounds(290, 110, 100, 25);
		getContentPane().add(jlbNova);
		
		jtfNova=new JTextField();
		jtfNova.setBounds(290, 140, 150, 25);
		getContentPane().add(jtfNova);
		
		jlbConfirmar=new JLabel("Confirmar Senha:");
		jlbConfirmar.setBounds(290, 180, 100, 25);
		getContentPane().add(jlbConfirmar);
		
		jtfConfirmar=new JTextField();
		jtfConfirmar.setBounds(290, 210, 150, 25);
		getContentPane().add(jtfConfirmar);
		
		jlbPalavra=new JLabel("Palavra Secreta");
		jlbPalavra.setBounds(290, 250, 150, 25);
		getContentPane().add(jlbPalavra);
		
		jtfPalavra=new JTextField();
		jtfPalavra.setBounds(290, 270, 150, 25);
		getContentPane().add(jtfPalavra);
		
		jlbNovo=new JLabel("Novo Usuário:");
		jlbNovo.setBounds(10, 290, 100, 25);
		getContentPane().add(jlbNovo);
		
		jtfNovo=new JTextField();
		jtfNovo.setBounds(10, 320, 150, 25);
		getContentPane().add(jtfNovo);
		
		jbtInserir=new JButton("Inserir");
		jbtInserir.setBounds(170, 320, 80, 25);
		jbtInserir.addActionListener(this);
		getContentPane().add(jbtInserir);
		
		jbtExcluir=new JButton("Excluir");
		jbtExcluir.setBounds(260, 320, 80, 25);
		jbtExcluir.addActionListener(this);
		getContentPane().add(jbtExcluir);
		
		jbtAlterar=new JButton("Alterar");
		jbtAlterar.setBounds(350, 320, 80, 25);
		jbtAlterar.addActionListener(this);
		getContentPane().add(jbtAlterar);
		
		jbtFechar=new JButton("Fechar");
		jbtFechar.setBounds(440, 320, 80, 25);
		jbtFechar.addActionListener(this);
		getContentPane().add(jbtFechar);
		
		
		FileReader fr = null;
		try {
			fr = new FileReader("Usuários.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr); 
		try {
			vcrUsuarios.clear();
			while (br.ready()) {
				
				String linha = br.readLine();
				vcrUsuarios.add(linha);
				jltUsuarios.setListData(vcrUsuarios);
				
				
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileReader f = null;
		try {
			f = new FileReader("Senhas.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader b = new BufferedReader(f);
		try { 
			while (b.ready()) {
				
				String linha = b.readLine();
				vcrSenhas.add(linha);
			}
			f.close();
			b.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileReader fp = null;
		try {
			fp = new FileReader("Palavras.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader bp = new BufferedReader(fp);
		try { 
			while (bp.ready()) {
				
				String palavra = bp.readLine();
				vcrPalavras.add(palavra);
			
			}
			fp.close();
			bp.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	
		
		jltUsuarios.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 1||e.getClickCount() == 2){

					FileReader fs = null, fp = null;
					try {
						fs = new FileReader("Senhas.txt");
						fp = new FileReader("Palavras.txt");
					BufferedReader bs = new BufferedReader(fs);
					BufferedReader bp = new BufferedReader(fp);
					
						while (bs.ready()) {
							
							String linha = bs.readLine();
							vcrSenhas.add(linha);
						}
						while (bp.ready()) {
							
							String palavra = bp.readLine();
							vcrPalavras.add(palavra);
						}
						bs.close();
						fs.close();
						bp.close();
						fp.close();
						
						
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
					  int indice = jltUsuarios.locationToIndex(e.getPoint());
					  jtfAtual.setText(vcrSenhas.elementAt(indice));
					  
					  int indice1 = jltUsuarios.locationToIndex(e.getPoint());
					  jtfPalavra.setText(vcrPalavras.elementAt(indice1));
				}
			}
		});
		
		
		setTitle("Cadastro de Usuário");
		setSize(550,400);
		setVisible(true);
		this.getContentPane().setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	

	
	public void actionPerformed(ActionEvent arg0) {
		int aux=0, aux2=0;
		if(arg0.getSource()==jbtAlterar){
			if(jltUsuarios.getSelectedIndex()==-1){
				JOptionPane.showMessageDialog(this, "Selecione o Usuário!");
			}
			else{
				if(jtfNova.getText().equals(jtfConfirmar.getText())){
				 aux2 = jltUsuarios.getSelectedIndex();
				 vcrSenhas.set(aux2, jtfNova.getText() );
				 vcrPalavras.set(aux2, jtfPalavra.getText());
				 jtfAtual.setText(vcrSenhas.get(aux2));
				  			
					try {
						FileWriter out1 = new FileWriter("Senhas.txt");
						out1.write("");
						out1.flush();   
						out1.close();  
						FileWriter f=new FileWriter("Senhas.txt",true);
						BufferedWriter b=new BufferedWriter(f);
							boolean tem=senhas.exists();
											if(tem){
												for(int i=0; i<vcrUsuarios.size(); i++ ){
												b.write(vcrSenhas.get(i));
												b.newLine();
												}
											}
											else{
												senhas.createNewFile(); 
											}
											jtfNova.setText(null);
											jtfConfirmar.setText(null);
											
											b.close();
											f.close();
											
											
											
											
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					try {
						FileWriter out2 = new FileWriter("Palavras.txt");
						out2.write("");
						out2.flush();   
						out2.close();  
						FileWriter fp=new FileWriter("Palavras.txt",true);
						BufferedWriter bp=new BufferedWriter(fp);
							boolean tem1=palavras.exists();
											if(tem1){
												for(int i=0; i<vcrUsuarios.size(); i++ ){
												bp.write(vcrPalavras.get(i));
												bp.newLine();
												}
											}
											else{
												palavras.createNewFile(); 
											}
											jtfNova.setText(null);
											jtfConfirmar.setText(null);
											
											bp.close();
											fp.close();

					} catch (IOException e) {
					
						e.printStackTrace();
					}
					}else{
						JOptionPane.showMessageDialog(this, "As Senhas não Conferem, Digite Novamente!");
					}
			}
			
			
		}
		if(arg0.getSource()==jbtInserir){
		if(vcrUsuarios.size()==0){
			JOptionPane.showMessageDialog(this, "Atualize a Lista de Usuários Antes de Cadastrar!");
		}
		else{
			if(jtfNovo.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Insira o Nome do Usuário ");
			}
			else if(jtfNova.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Insira a Senha do Usuário!");
			}
			else if(jtfNova.getText().equals(jtfConfirmar.getText())){
				aux=1;
			}
			else if(aux==0){
				JOptionPane.showMessageDialog(this, "As Senhas não Conferem, Digite Novamente!");
			}
			if(jtfPalavra.getText().isEmpty()){
				aux=2;
			}
			if(aux==2){
				JOptionPane.showMessageDialog(this, "Digite a Palavra Secreta!");
			}
			if(aux==1){
				boolean mesmonome=vcrUsuarios.contains(jtfNovo.getText());
				if(mesmonome){ 
					JOptionPane.showMessageDialog(this, "Não pode Cadastrar Usuários com o Mesmo Nome!");
				}
				else{
				vcrUsuarios.add(jtfNovo.getText());
				jltUsuarios.setListData(vcrUsuarios);
				
				JOptionPane.showMessageDialog(this, "Usuário Cadastrado Com Sucesso!");
				try {
					FileWriter fw= new FileWriter("Usuários.txt",true);
					FileWriter f=new FileWriter("Senhas.txt",true);
					FileWriter fe=new FileWriter("Palavras.txt",true);
					BufferedWriter bw= new BufferedWriter(fw);
					BufferedWriter b=new BufferedWriter(f);
					BufferedWriter be=new BufferedWriter(fe);
					boolean existe=arquivo.exists();
					boolean tem=senhas.exists();
					boolean possui=palavras.exists();
					
					if(tem){
						b.write(jtfNova.getText());
						b.newLine();
					}
					else{
						senhas.createNewFile();
					}
					
					b.close();
					f.close();
					
					if(existe){
						bw.write(jtfNovo.getText());
						bw.newLine();
					}
					else{
						arquivo.createNewFile(); 
					}
					
					bw.close();
					fw.close();
					
					if(possui){
						be.write(jtfPalavra.getText());
						be.newLine();
					}
					
					be.close();
					fe.close();
				} catch (IOException e1) {
			 		 
			 
				} 
					dispose();
					new CadastrarUsuario();
				}
				jtfNovo.setText(null);
				jtfNova.setText(null);
				jtfConfirmar.setText(null);
				jtfPalavra.setText(null);
			}
		}
		
		}
		if(arg0.getSource()==jbtExcluir){
			if(jltUsuarios.getSelectedIndex()==-1){
				JOptionPane.showMessageDialog(this, "selecione um usuário para excluir");
				
			}else{
				if(jltUsuarios.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(this, "Não pode Excluir o Administrador");
				}else{
				int selecionado;
				selecionado=jltUsuarios.getSelectedIndex();
				vcrUsuarios.remove(selecionado);
				jltUsuarios.setListData(vcrUsuarios);
				vcrSenhas.remove(selecionado);
				vcrPalavras.remove(selecionado);
				JOptionPane.showMessageDialog(this, "Exclusão Realizada Com Sucesso!");
				Writer out,out1,out2;
				try {
					out = new FileWriter("Usuários.txt");
					out.write("");
					out.flush();    
					out.close();  
					FileWriter fw= new FileWriter("Usuários.txt",true);
					BufferedWriter bw= new BufferedWriter(fw);
						boolean existe=arquivo.exists();
						if(existe){
									for(int i=0; i<vcrUsuarios.size(); i++){		
									bw.write(vcrUsuarios.get(i));
											bw.newLine();
									}
									}
										else{
											arquivo.createNewFile(); 
										}
										
										bw.close();
										fw.close();
					out1 = new FileWriter("Senhas.txt");
					out1.write("");
					out1.flush();   
					out1.close();  
					FileWriter f=new FileWriter("Senhas.txt",true);
					BufferedWriter b=new BufferedWriter(f);
						boolean tem=senhas.exists();
										if(tem){
											for(int i=0; i<vcrUsuarios.size(); i++ ){
											b.write(vcrSenhas.get(i));
											b.newLine();
											}
										}
										else{
											senhas.createNewFile();
										}
										jtfAtual.setText(null);
										b.close();
										f.close();
										out2 = new FileWriter("Palavras.txt");
										out2.write("");
										out2.flush();   
										out2.close();  
										FileWriter fp=new FileWriter("Palavras.txt",true);
										BufferedWriter bp=new BufferedWriter(fp);
											boolean tem1=palavras.exists();
															if(tem1){
																for(int i=0; i<vcrUsuarios.size(); i++ ){
																bp.write(vcrPalavras.get(i));
																bp.newLine();
																}
															}
															else{
																palavras.createNewFile();
															}
															jtfPalavra.setText(null);
															bp.close();
															fp.close();
															

					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				  
		 
				
				
			}
		}
		}
		
		if(arg0.getSource()==jbtFechar){
			dispose();
		}
	}
}