package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;
import model.entities.Controllers.ControladorEstudiantes;
import model.entities.Controllers.ControladorMateria;
import model.entities.Controllers.ControladorProfesores;
import model.entities.Controllers.ControladorValoracionMateria;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class PanelList extends JPanel {
	
	DefaultListModel<Estudiante> listAlumnosSeleccionados = new DefaultListModel<Estudiante>();
	JList<Estudiante> jlAlumnosSeleccionados = new JList<Estudiante>(listAlumnosSeleccionados);
	JScrollPane jspAS = new JScrollPane(jlAlumnosSeleccionados);
	
	DefaultListModel<Estudiante> listAlumnosNoSeleccionados = new DefaultListModel<Estudiante>();
	JList<Estudiante> jlAlumnosNoSeleccionados = new JList<Estudiante>(listAlumnosNoSeleccionados);
	JScrollPane	jspANS = new JScrollPane(jlAlumnosNoSeleccionados);
	
	JComboBox<Materia>jcbMateria;
	JComboBox<Profesor>jcbProfesor;
	JComboBox<Float>jcbNota;
	

	/**
	 * Create the panel.
	 */
	public PanelList() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 160, 0};
		gridBagLayout.rowHeights = new int[]{123, 27, 116, 36, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNota = new JLabel("Nota:");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel.add(lblNota, gbc_lblNota);
		
		jcbNota = new JComboBox<Float>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refrescar();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);
		
		JLabel lblANS = new JLabel("Alumnado no seleccionado:");
		GridBagConstraints gbc_lblANS = new GridBagConstraints();
		gbc_lblANS.insets = new Insets(0, 0, 5, 5);
		gbc_lblANS.gridx = 0;
		gbc_lblANS.gridy = 1;
		add(lblANS, gbc_lblANS);
		
		JLabel lblAS = new JLabel("Alumnado seleccionado:");
		GridBagConstraints gbc_lblAS = new GridBagConstraints();
		gbc_lblAS.insets = new Insets(0, 0, 5, 0);
		gbc_lblAS.gridx = 2;
		gbc_lblAS.gridy = 1;
		add(lblAS, gbc_lblAS);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{161, 0, 173, 0};
		gbl_panel_1.rowHeights = new int[]{105, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		GridBagConstraints gbc_jspANS = new GridBagConstraints();
		gbc_jspANS.insets = new Insets(0, 0, 0, 5);
		gbc_jspANS.fill = GridBagConstraints.BOTH;
		gbc_jspANS.gridx = 0;
		gbc_jspANS.gridy = 0;
		panel_1.add(jspANS, gbc_jspANS);
				
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnTodosIzq = new JButton("<<");
		btnTodosIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				todosIzq();
			}
		});
		GridBagConstraints gbc_btnTodosIzq = new GridBagConstraints();
		gbc_btnTodosIzq.anchor = GridBagConstraints.NORTH;
		gbc_btnTodosIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnTodosIzq.gridx = 0;
		gbc_btnTodosIzq.gridy = 0;
		panel_2.add(btnTodosIzq, gbc_btnTodosIzq);
		
		JButton btnUnoIzq = new JButton("<");
		GridBagConstraints gbc_btnUnoIzq = new GridBagConstraints();
		gbc_btnUnoIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnoIzq.gridx = 0;
		gbc_btnUnoIzq.gridy = 1;
		panel_2.add(btnUnoIzq, gbc_btnUnoIzq);
		
		btnUnoIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				unoIzq();
			}
		});
		
		JButton btnUnoDer = new JButton(">");
		GridBagConstraints gbc_btnUnoDer = new GridBagConstraints();
		gbc_btnUnoDer.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnoDer.gridx = 0;
		gbc_btnUnoDer.gridy = 2;
		panel_2.add(btnUnoDer, gbc_btnUnoDer);
		
		btnUnoDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				unoDerecha();
			}
		});
		
		JButton btnTodosDer = new JButton(">>");
		GridBagConstraints gbc_btnTodosDer = new GridBagConstraints();
		gbc_btnTodosDer.anchor = GridBagConstraints.SOUTH;
		gbc_btnTodosDer.gridx = 0;
		gbc_btnTodosDer.gridy = 3;
		panel_2.add(btnTodosDer, gbc_btnTodosDer);
		
		btnTodosDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				todosDerecha();
			}
		});
		
		GridBagConstraints gbc_jspAS = new GridBagConstraints();
		gbc_jspAS.fill = GridBagConstraints.BOTH;
		gbc_jspAS.gridx = 2;
		gbc_jspAS.gridy = 0;
		panel_1.add(jspAS, gbc_jspAS);
				
		JButton btnGuardar = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_jspAS.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 3;
		add(btnGuardar, gbc_btnGuardar);

		cargarMaterias();
		cargarProfesores();
		cargarNotas();
	}
	
	private void todosDerecha() {
		for (int i = 0; i < this.listAlumnosNoSeleccionados.size(); i++) {
			this.listAlumnosSeleccionados.addElement(this.listAlumnosNoSeleccionados.elementAt(i));
		}
		this.listAlumnosNoSeleccionados.clear();
	}
	
	private void todosIzq() {
		for (int i = 0; i < this.listAlumnosSeleccionados.size(); i++) {
			this.listAlumnosNoSeleccionados.addElement(this.listAlumnosSeleccionados.elementAt(i));
		}
		this.listAlumnosSeleccionados.clear();

	}
	
	private void unoDerecha() {
		for (int i = 0; i < this.jlAlumnosNoSeleccionados.getSelectedIndices().length; i++) {
			this.listAlumnosSeleccionados.addElement(this.listAlumnosNoSeleccionados
					.getElementAt(this.jlAlumnosNoSeleccionados.getSelectedIndices()[i]));

		}
		for (int i = this.jlAlumnosNoSeleccionados.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listAlumnosNoSeleccionados.removeElementAt(this.jlAlumnosNoSeleccionados.getSelectedIndices()[i]);
		}

	}
	
	private void unoIzq() {
		for (int i = 0; i < this.jlAlumnosSeleccionados.getSelectedIndices().length; i++) {
			this.listAlumnosNoSeleccionados.addElement(this.listAlumnosSeleccionados
					.getElementAt(this.jlAlumnosSeleccionados.getSelectedIndices()[i]));

		}
		for (int i = this.jlAlumnosSeleccionados.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listAlumnosSeleccionados.removeElementAt(this.jlAlumnosSeleccionados.getSelectedIndices()[i]);
		}
	}
	
	private void guardar() {
		Materia m = (Materia)jcbMateria.getSelectedItem();
		Profesor p = (Profesor)jcbProfesor.getSelectedItem();
		Float nota = (Float) jcbNota.getSelectedItem();
		
		ValoracionMateria vm = null;
		
		for (int i = 0; i < this.listAlumnosSeleccionados.size(); i++) {
			Estudiante e = this.listAlumnosSeleccionados.elementAt(i);
			
			vm = ControladorValoracionMateria.getInstancia().findEstudianteProfesorMateria(p, m, e);
			if (vm == null) {
				vm = new ValoracionMateria();
				vm.setEstudiante(e);
				vm.setMateria(m);
				vm.setProfesor(p);
				vm.setValoracion(nota);
			}
			else {
				vm.setValoracion((float) this.jcbNota.getSelectedItem());
				ControladorValoracionMateria.getInstancia().guardar(vm);
				
			}
		}
		boolean resultado = ControladorValoracionMateria.getInstancia().guardar(vm);
		if (resultado == true) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	
	private void refrescar() {
		listAlumnosSeleccionados.removeAllElements();
		listAlumnosNoSeleccionados.removeAllElements();

		
		Materia m = (Materia)jcbMateria.getSelectedItem();
		Profesor p = (Profesor)jcbProfesor.getSelectedItem();
		Float nota = (Float) jcbNota.getSelectedItem();
		
		
		
		List<Estudiante>estudiantes = ControladorEstudiantes.getInstance().findAll();

		
		for (Estudiante e : estudiantes) {
			ValoracionMateria vm = ControladorValoracionMateria.getInstancia().findEstudianteProfesorValoracionMateria(p, m, e, Float.valueOf(nota));
			if (vm == null) {
				this.listAlumnosNoSeleccionados.addElement(e);
			}
			else {
				this.listAlumnosSeleccionados.addElement(e);
			}
		}
	}
	
	
	private void cargarMaterias() {
		List<Materia> materias = ControladorMateria.getInstance().findAll();
		for (Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void cargarProfesores() {
		List<Profesor> profesores = ControladorProfesores.getInstance().findAll();
		for (Profesor p : profesores) {
			this.jcbProfesor.addItem(p);
		}
	}
	
	private void cargarNotas() {
		for (int i = 0; i <= 10; i++) {
			this.jcbNota.addItem(Float.valueOf(i));
		}
	}
}
