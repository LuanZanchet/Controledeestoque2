import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Contato extends JFrame{
	private JLabel jlbImagem;
	Contato(){
	setTitle("Suporte");
	setLayout(null);
	jlbImagem=new JLabel(new ImageIcon("suporte.jpg"));
	jlbImagem.setBounds(0, 0, 794, 742);
	getContentPane().add(jlbImagem);
	
	setSize(794, 742);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setVisible(true);
	}
}
