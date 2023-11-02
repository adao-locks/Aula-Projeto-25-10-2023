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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class App extends JFrame implements TableModel, ActionBarListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfDescription;
	private TaskController controller = new TaskController();
	private JTable table;
	private String[] Colums = new String[] {"Código", "Descrição"};

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
		controller.setActionBarListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 290);
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
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "2, 9, fill, fill");
		
		table = createTable(this);
		scrollPane.setViewportView(table);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.save();
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
				controller.changeDescription(tfDescription.getText());
//				System.out.println("[tfDescription] Digitando a Letra "+e.getKeyChar());
//				System.out.println("[tfDescription] O texto é "+tfDescription.getText());
			}
		}); //tfCode e tfDescription; Duas maneiras diferentes de escrever com o mesmo objetivo.
		
	}
	
	private JTable createTable() {
		JTable table = new JTable(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				controller.selectTask(index);
				tfCode.setText(controller.getCode());
				tfDescription.setText(controller.getDescription());
			}
		});
	}

	@Override
	public int getRowCount() {
		return controller.getTotalTask();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return Colums[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return controller.getValueAt(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		
	}

	@Override
	public void onSave() {
		table = new JTable(this);
		tfDescription.setText(controller.getDescription());
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

}
