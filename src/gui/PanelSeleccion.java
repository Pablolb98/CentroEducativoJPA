package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.entities.Materia;
import model.entities.Profesor;
import model.entities.Controllers.ControladorMateria;
import model.entities.Controllers.ControladorProfesores;


public class PanelSeleccion extends JPanel {
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	PanelNotas p = new PanelNotas();
	private JScrollPane scrollPane;
	
	
	public PanelSeleccion() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{75, 268, 100, 0};
		gridBagLayout.rowHeights = new int[]{61, 23, 130, 41, 59, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{80, 183, 200, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel_1);
		
		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel.add(jcbMateria, gbc_comboBox);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.insets = new Insets(0, 0, 0, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		panel.add(jcbProfesor, gbc_comboBox_1);
		
		JButton btnRefrescar = new JButton("Botón refrescar alumnado");
		GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
		gbc_btnRefrescar.anchor = GridBagConstraints.EAST;
		gbc_btnRefrescar.gridx = 2;
		gbc_btnRefrescar.gridy = 1;
		panel.add(btnRefrescar, gbc_btnRefrescar);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollAlumnos = new GridBagConstraints();
		gbc_scrollAlumnos.insets = new Insets(0, 0, 5, 0);
		gbc_scrollAlumnos.gridwidth = 3;
		gbc_scrollAlumnos.fill = GridBagConstraints.BOTH;
		gbc_scrollAlumnos.gridx = 0;
		gbc_scrollAlumnos.gridy = 2;
		add(scrollPane, gbc_scrollAlumnos);
		
		
		// se inserta un panel de un estudiante
		this.scrollPane.setViewportView(p);
		
		JButton btnNotas = new JButton("Guardar las notas de todos los alumnos");
		GridBagConstraints gbc_btnNotas = new GridBagConstraints();
		gbc_btnNotas.gridwidth = 2;
		gbc_btnNotas.insets = new Insets(0, 0, 5, 5);
		gbc_btnNotas.gridx = 1;
		gbc_btnNotas.gridy = 3;
		add(btnNotas, gbc_btnNotas);
		cargarDatos();	

	}
	
	private void cargarDatos() {
		List<Materia> materia = ControladorMateria.getInstance().findAll();

		for (Materia t : materia) {
			this.jcbMateria.addItem(t);
		}
		
		List<Profesor> profesor = ControladorProfesores.getInstance().findAll();

		for (Profesor t : profesor) {
			this.jcbProfesor.addItem(t);
		}
		
	}
	/**
	 * 
	 */
	private void cargarEnPantalla() {
		
	}

}
