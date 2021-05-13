package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.Controllers.ControladorMateria;
import model.entities.Controllers.ControladorProfesores;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class PanelList extends JPanel {
	
	private JButton btnTodosIzquierda;
	private JList jlistProvincias;
	
	
	List <Materia> materias = new ArrayList<Materia>();
	List <Profesor> profesores = new ArrayList<Profesor>();
	
	JComboBox <Materia>jcbMateria;
	JComboBox <Profesor>jcbProfesor;
	
	JComboBox jcbNota;
	
	Materia actual = new Materia();
	
	JPanel panel_1 = new JPanel();
	
	

	private DefaultListModel<Materia> listModelMateria = null;
	/**
	 * Create the panel.
	 */
	public PanelList() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelPrincipal = new JPanel();
		GridBagConstraints gbc_panelPrincipal = new GridBagConstraints();
		gbc_panelPrincipal.fill = GridBagConstraints.BOTH;
		gbc_panelPrincipal.gridx = 0;
		gbc_panelPrincipal.gridy = 0;
		add(panelPrincipal, gbc_panelPrincipal);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{0, 0, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 192, 193, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panelPrincipal.add(panel, gbc_panel);
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
		
		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizar = new JButton("Actualizar");
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.gridwidth = 2;
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.gridx = 0;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panelPrincipal.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{146, 102, 153, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNoSeleccionado = new JLabel("Alumnado no seleccionado:");
		GridBagConstraints gbc_lblNoSeleccionado = new GridBagConstraints();
		gbc_lblNoSeleccionado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoSeleccionado.gridx = 0;
		gbc_lblNoSeleccionado.gridy = 0;
		panel_1.add(lblNoSeleccionado, gbc_lblNoSeleccionado);
		
		JLabel lblSeleccionado = new JLabel("AlumnadoSeleccionado");
		GridBagConstraints gbc_lblSeleccionado = new GridBagConstraints();
		gbc_lblSeleccionado.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccionado.gridx = 2;
		gbc_lblSeleccionado.gridy = 0;
		panel_1.add(lblSeleccionado, gbc_lblSeleccionado);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnTodosIzquierda = new JButton("<<");
		GridBagConstraints gbc_btnTodosIzquierda = new GridBagConstraints();
		gbc_btnTodosIzquierda.insets = new Insets(0, 0, 5, 5);
		gbc_btnTodosIzquierda.gridx = 1;
		gbc_btnTodosIzquierda.gridy = 1;
		panel_2.add(btnTodosIzquierda, gbc_btnTodosIzquierda);
		
		JButton btnIzquierda = new JButton("<");
		GridBagConstraints gbc_btnIzquierda = new GridBagConstraints();
		gbc_btnIzquierda.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzquierda.gridx = 1;
		gbc_btnIzquierda.gridy = 2;
		panel_2.add(btnIzquierda, gbc_btnIzquierda);
		
		JButton btnDerecha = new JButton(">");
		GridBagConstraints gbc_btnDerecha = new GridBagConstraints();
		gbc_btnDerecha.insets = new Insets(0, 0, 5, 5);
		gbc_btnDerecha.gridx = 1;
		gbc_btnDerecha.gridy = 3;
		panel_2.add(btnDerecha, gbc_btnDerecha);
		
		JButton btnTodosDerecha = new JButton(">>");
		GridBagConstraints gbc_btnTodosDerecha = new GridBagConstraints();
		gbc_btnTodosDerecha.insets = new Insets(0, 0, 0, 5);
		gbc_btnTodosDerecha.gridx = 1;
		gbc_btnTodosDerecha.gridy = 4;
		panel_2.add(btnTodosDerecha, gbc_btnTodosDerecha);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JButton btnGuardar = new JButton("Guardar alumnos seleccionados");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 3;
		panelPrincipal.add(btnGuardar, gbc_btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		cargarDatosMateria();
		cargarDatosProfesor();
		cargarNotas();

	}
	
	private void cargarDatosMateria() {
		List <Materia> materias  = ControladorMateria.getInstance().findAll();
		for (Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
	}

	private void cargarDatosProfesor() {
		List <Profesor> profesores  = ControladorProfesores.getInstance().findAll();
		for (Profesor p : profesores) {
			this.jcbProfesor.addItem(p);
		}
	}
	
	private void cargarNotas() {
		for (int i = 0; i < 10; i++) {
			this.jcbNota.addItem(Integer.valueOf(i));
		}
		}
	
	
	
	
	
	private void guardar() {
		cargarActualDesdePantalla();
		boolean resultado = ControladorMateria.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}

	private void cargarActualDesdePantalla() {
		Materia m = (Materia) jcbMateria.getSelectedItem();
	}
	
	/**
	 * 
	 */
	private DefaultListModel getDefaultListModel () {
		this.listModelMateria = new DefaultListModel<Materia>();
		return this.listModelMateria;
	}

	/**
	 * Para agregar provincias se hace un recorrido circular de la lista de provincias
	 */
//	private void agregarProvincia () {
//		this.listModelMateria.addElement(this.materias.get(this.indiceProximaProvinciaParaAgregar));
//		this.indiceProximaProvinciaParaAgregar++;
//		if (this.indiceProximaProvinciaParaAgregar == this.materias.size()) {
//			this.indiceProximaProvinciaParaAgregar = 0;
//		}
//	}
	
	/**
	 * Para eliminar todas las provincias seleccionadas, deberíamos comenzar desde la última e ir haciendo el barrido hasta la primera.
	 */
	
//	private void eliminarProvinciasSeleccionadas () {
//		for (int i = this.jlistProvincias.getSelectedIndices().length - 1; i >= 0; i--) {
//			this.listModelProvincias.removeElementAt(this.jlistProvincias.getSelectedIndices()[i]);
//		}
//	}

}
