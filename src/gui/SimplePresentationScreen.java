package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.Color;
import javax.swing.UIManager;

public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textFieldLU;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldMail;
	private JTextField textFieldGitURL;
	private JLabel JLabelFecha;
	private JLabel JLabelFotoAlumno;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 255));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 197);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel JLabelLU = new JLabel("LU");
		JLabelLU.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel JLabelApellido = new JLabel("Apellido");
		JLabelApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel JLabelNombre = new JLabel("Nombre");
		JLabelNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel JLabelMail = new JLabel("E-mail");
		JLabelMail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel = new JLabel("Github URL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textFieldLU = new JTextField();
		textFieldLU.setBackground(Color.WHITE);
		textFieldLU.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldLU.setEditable(false);
		textFieldLU.setColumns(10);
		textFieldLU.setText(Integer.toString(studentData.getId()));
		
		textFieldApellido = new JTextField();	
		textFieldApellido.setBackground(Color.WHITE);
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setText(studentData.getFirstName());
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBackground(Color.WHITE);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNombre.setEditable(false);
		textFieldNombre.setText(studentData.getLastName());
		textFieldNombre.setColumns(10);
		
		textFieldMail = new JTextField();
		textFieldMail.setBackground(Color.WHITE);
		textFieldMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldMail.setEditable(false);
		textFieldMail.setColumns(10);
		textFieldMail.setText(studentData.getMail());
		
		textFieldGitURL = new JTextField();
		textFieldGitURL.setBackground(Color.WHITE);
		textFieldGitURL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldGitURL.setEditable(false);
		textFieldGitURL.setColumns(10);
		textFieldGitURL.setText(studentData.getGithubURL());
			
		JLabelFotoAlumno =new JLabel();
		JLabelFotoAlumno.setBorder(UIManager.getBorder("Tree.editorBorder"));
		JLabelFotoAlumno.setBounds(445, 37, 150, 150);
		ImageIcon imagen= new ImageIcon(studentData.getPathPhoto());
		Icon icon= new ImageIcon(imagen.getImage().getScaledInstance(JLabelFotoAlumno.getWidth(), JLabelFotoAlumno.getHeight(), Image.SCALE_SMOOTH));
		JLabelFotoAlumno.setIcon(icon);
		contentPane.add(JLabelFotoAlumno);
		
		String fecha= LocalDate.now().toString();
		String hora= LocalTime.now().toString().substring(0,8);
		JLabelFecha= new JLabel("Esta ventana fue generada el "+fecha+" a las: "+ hora);
		JLabelFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JLabelFecha.setBounds(6, 198, 420, 20);
		contentPane.add(JLabelFecha);
		
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(JLabelApellido)
						.addComponent(JLabelNombre)
						.addComponent(JLabelMail)
						.addComponent(JLabelLU, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
							.addComponent(textFieldApellido, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
							.addComponent(textFieldLU, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
							.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
							.addComponent(textFieldMail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
						.addComponent(textFieldGitURL, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
					.addContainerGap(26, GroupLayout.PREFERRED_SIZE))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(JLabelLU)
						.addComponent(textFieldLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(JLabelApellido)
						.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(JLabelNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(JLabelMail)
						.addComponent(textFieldMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldGitURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
				
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane);
	}
}
