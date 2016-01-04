import java.awt.Color;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class ExcluirProduto extends JFrame {
	private JLabel jlbCodigo,jlbBarras,jlbDescricao;
	private JTextField jtfCodigo,jtfBarras,jtfDescricao;
	private JButton jbtLupa,jbtProcurar,jbtExcluir,jbtFechar;
	private JTable jtbProdutos=new JTable();
	private DefaultTableModel dtmProdutos=new DefaultTableModel();
	private ScrollPane rolagem=new ScrollPane();
	private JSeparator jspLinha;
	private int linha=1;
	
	ExcluirProduto() {
		setLayout(null);
		
		jlbCodigo=new JLabel("Código do Produto");
		jlbCodigo.setBounds(20, 10, 150, 25);
		getContentPane().add(jlbCodigo);
		
		jtfCodigo=new JTextField();
		jtfCodigo.setBounds(20, 30, 150, 25);
		getContentPane().add(jtfCodigo);
		
		jlbBarras=new JLabel("Código de Barras");
		jlbBarras.setBounds(190, 10, 150, 25);
		getContentPane().add(jlbBarras);
		
		jtfBarras=new JTextField();
		jtfBarras.setBounds(190, 30, 150, 25);
		getContentPane().add(jtfBarras);
		
		jlbDescricao=new JLabel("Descrição do Produto");
		jlbDescricao.setBounds(360, 10, 150, 25);
		getContentPane().add(jlbDescricao);
		
		jtfDescricao=new JTextField();
		jtfDescricao.setBounds(360, 30, 300, 25);
		getContentPane().add(jtfDescricao);
		
		jbtLupa=new JButton();
		jbtLupa.setBounds(680, 30, 25, 25);
		getContentPane().add(jbtLupa);
		
		jbtProcurar=new JButton("Procurar");
		jbtProcurar.setBounds(730, 30, 100, 25);
		getContentPane().add(jbtProcurar);
		
		rolagem.setBounds(10, 70, 820, 500);
		dtmProdutos.setColumnCount(6);
		dtmProdutos.setRowCount(1);
		dtmProdutos.setValueAt("Data", 0, 0);
		dtmProdutos.setValueAt("Cód. Produto", 0, 1);
		dtmProdutos.setValueAt("Descrição do Produto", 0, 2);
		dtmProdutos.setValueAt("Operação", 0, 3);
		dtmProdutos.setValueAt("Quantidade", 0, 4);
		dtmProdutos.setValueAt("Valor", 0, 5);
		
		
		jtbProdutos.setModel(dtmProdutos);
		rolagem.add(jtbProdutos);
		getContentPane().add(rolagem);
		
		jspLinha=new JSeparator();
		jspLinha.setBounds(10, 580, 820, 30);
		getContentPane().add(jspLinha);
		
		jbtExcluir=new JButton("Excluir e Reverter");
		jbtExcluir.setBounds(200,600,140,25);
		getContentPane().add(jbtExcluir);
		
		jbtFechar=new JButton("Fechar");
		jbtFechar.setBounds(520, 600, 100, 25);
		getContentPane().add(jbtFechar);
		
		setTitle("Excluir/Reverter Produto");
		setSize(880,680);
		this.setLocationRelativeTo(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}