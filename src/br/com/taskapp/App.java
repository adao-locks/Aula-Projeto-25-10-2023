package br.com.taskapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "2, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("50dlu"),
				ColumnSpec.decode("50dlu"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnSave = new JButton("Salvar");
		panel.add(btnSave, "1, 1");
		
		JButton btnDelete = new JButton("Deletar");
		panel.add(btnDelete, "2, 1");
		
		JLabel lblCode = new JLabel("Código");
		contentPane.add(lblCode, "2, 3");
		
		tfCode = new JTextField();
		contentPane.add(tfCode, "2, 4, fill, default");
		tfCode.setColumns(10);
		
		JLabel lbDescription = new JLabel("Descrição");
		contentPane.add(lbDescription, "2, 6");
		
		tfDescription = new JTextField();
		contentPane.add(tfDescription, "2, 7, fill, default");
		tfDescription.setColumns(10);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "cliquei no botão Salvar");
			}
		});
		
		btnDelete.addActionListener((event)->{
			JOptionPane.showMessageDialog(null, "Cliquei no remover");
		});
		
		tfCode.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
		
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("[tfCode] Digitando a letra "+e.getKeyChar());
				System.out.println("[tfCode] O texto agora é "+tfCode.getText());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		tfDescription.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("[tfDescription] Digitando a Letra "+e.getKeyChar());
				System.out.println("[tfDescription] O texto é "+tfDescription.getText());
			}
		}); //tfCode e tfDescription; Duas maneiras diferentes de escrever com o mesmo objetivo.
		
	}

}
