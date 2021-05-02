package gui;

import javax.swing.JPanel;


import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.entities.Tipologiasexo;
import model.entities.Controllers.ControladorTipologiaSexo;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {

	public JComboBox<Tipologiasexo> jcbSexo;

	public JTextField jtfNombre;
	public JTextField jtfPrimerApellido;
	public JTextField jtfSegundoApellido;
	public JTextField jtfDNI;
	public JTextField jtfDireccion;
	public JTextField jtfEmail;
	public JTextField jtfTelefono;
	public JLabel lblNewLabel;
	private JButton btnColorFondo;
	JColorChooser jcc;
	Color color;
	private JScrollPane jspImagen;
	private byte imagen[] = new byte[] {};
	private JButton btnCambiarImagen;
	private JFileChooser jFileChooser;
	private JPopupMenu popupMenu;
	private JLabel lblDimensiones;

	private JLabel jtaContenidoFichero;
	private JScrollPane scrollPane;


	/**
	 * Create the application.
	 */
	public Panel() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 7;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 0;
        add(scrollPane, gbc_scrollPane);
		
		jspImagen = new JScrollPane();
		scrollPane.setViewportView(jspImagen);
		
		popupMenu = new JPopupMenu();
		addPopup(jspImagen, popupMenu);
		
		lblDimensiones = new JLabel("New label");
		popupMenu.add(lblDimensiones);
		popupMenu.addSeparator();
        popupMenu.add(crearNuevoMenuItem("Cambiar imagen"));
        addPopup(scrollPane, popupMenu);

	


		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 3;
		add(lblPrimerApellido, gbc_lblPrimerApellido);

		jtfPrimerApellido = new JTextField();
		GridBagConstraints gbc_jtfPrimerApellido = new GridBagConstraints();
		gbc_jtfPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPrimerApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrimerApellido.gridx = 1;
		gbc_jtfPrimerApellido.gridy = 3;
		add(jtfPrimerApellido, gbc_jtfPrimerApellido);
		jtfPrimerApellido.setColumns(10);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 4;
		add(lblSegundoApellido, gbc_lblSegundoApellido);

		jtfSegundoApellido = new JTextField();
		GridBagConstraints gbc_jtfSegundoApellido = new GridBagConstraints();
		gbc_jtfSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSegundoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundoApellido.gridx = 1;
		gbc_jtfSegundoApellido.gridy = 4;
		add(jtfSegundoApellido, gbc_jtfSegundoApellido);
		jtfSegundoApellido.setColumns(10);

		lblNewLabel = new JLabel("Sexo");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbSexo = new JComboBox();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 5;
		add(jcbSexo, gbc_jcbSexo);

		JLabel lblDNI = new JLabel("DNI:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 6;
		add(lblDNI, gbc_lblDNI);

		jtfDNI = new JTextField();
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 6;
		add(jtfDNI, gbc_jtfDNI);
		jtfDNI.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 7;
		add(lblDireccion, gbc_lblDireccion);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		add(lblEmail, gbc_lblEmail);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 8;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		btnCambiarImagen = new JButton("Cambiar Imagen");
		btnCambiarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnCambiarImagen = new GridBagConstraints();
		gbc_btnCambiarImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiarImagen.gridx = 2;
		gbc_btnCambiarImagen.gridy = 8;
		add(btnCambiarImagen, gbc_btnCambiarImagen);

		JLabel lblTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 9;
		add(lblTelefono, gbc_lblTelefono);

		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 9;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);

		btnColorFondo = new JButton("Color Favorito");
		btnColorFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(jcc, "Elige un color", color.black);
				setBackground(color);
			}
		});
		GridBagConstraints gbc_btnColorFondo = new GridBagConstraints();
		gbc_btnColorFondo.gridx = 2;
		gbc_btnColorFondo.gridy = 9;
		add(btnColorFondo, gbc_btnColorFondo);
		cargarDatos();
	}

	private JMenuItem crearNuevoMenuItem (String titulo) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (titulo == "Cambiar imagen") {
                    seleccionaImagen();
                }
            }
        });

        return item;
    }

	public String getNombre() {
		return jtfNombre.getText();
	}

	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}

	public String getPrimerApellido() {
		return jtfPrimerApellido.getText();
	}

	public void setPrimerApellido(String primerApellido) {
		this.jtfPrimerApellido.setText(primerApellido);
	}

	public String getSegundoApellido() {
		return jtfSegundoApellido.getText();
	}

	public void setSegundoApellido(String segundoApellido) {
		this.jtfSegundoApellido.setText(segundoApellido);
	}
	
	public void setImagen(byte imagen[]) {
        ImageIcon icon = new ImageIcon(imagen);
        JLabel lbl = new JLabel(icon);
        this.scrollPane.setViewportView(lbl);
        this.scrollPane.revalidate();
        this.scrollPane.repaint();
    }

    public byte[] getImagen() {
        return this.imagen;
    }

	public JComboBox<Tipologiasexo> getJcbSexo() {
		return jcbSexo;
	}

	public void setJcbSexo(JComboBox<Tipologiasexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}

	public String getDni() {
		return jtfDNI.getText();
	}

	public void setDni(String dni) {
		this.jtfDNI.setText(dni);
	}

	private void seleccionaImagen() {
		this.jFileChooser = new JFileChooser();

		// Configurando el componente

		// Establecimiento de la carpeta de inicio
		this.jFileChooser.setCurrentDirectory(new File("C:\\"));

		// Tipo de selecci�n que se hace en el di�logo
		this.jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros
		// this.jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //
		// S�lo selecciona ficheros
		// this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		// // Selecciona ficheros y carpetas

		// Filtro del tipo de ficheros que puede abrir
		this.jFileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Imágenes *.png, *.jpg";
			}

			@Override
			public boolean accept(File f) {
				if (f.isFile() && f.getAbsolutePath().endsWith(".png") || f.getAbsolutePath().endsWith(".jpg"))
					return true;
				return false;
			}
		});

		// Abro el di�logo para la elecci�n del usuario
		int seleccionUsuario = jFileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = this.jFileChooser.getSelectedFile();

			// Vuelco el nombre del fichero sobre el JTextField
			this.jtfNombre.setText(fichero.getAbsolutePath());

			// Volcamos el contenido del fichero al JTextArea
			((JLabel) this.jtaContenidoFichero).setText(leerContenidoFicheroTexto(fichero));
		}
	}

	/**
	 * 
	 * @param f
	 * @return
	 */
	private byte[] leerContenidoFicheroBinario(File f) {
		try {
			return Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[] {};
	}
	
	private String leerContenidoFicheroTexto (File f) {
        if (f.isFile()) {
            try {
                FileReader fileReader = new FileReader(f);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                StringBuffer sb = new StringBuffer();
                String lineaDelFichero;

                // Lectura del fichero l�nea a l�nea
                while ((lineaDelFichero = bufferedReader.readLine()) != null) {
                    sb.append(lineaDelFichero + "\n");
                }

                return sb.toString();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "Imposible obtener el contenido del fichero";
    }

	private void cargarDatos() {
		List<Tipologiasexo> sexo = ControladorTipologiaSexo.getInstance().findAll();

		for (Tipologiasexo t : sexo) {
			this.jcbSexo.addItem(t);
		}
	}

	public JLabel getlblDimensiones() {
		return lblDimensiones;
	}

	public void setlabelDimensiones(String lblDimensiones) {
		this.lblDimensiones.setText(lblDimensiones);
	}

	public String getDireccion() {
		return jtfDireccion.getText();
	}

	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);
	}

	public String getEmail() {
		return jtfEmail.getText();
	}

	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}

	public String getTelefono() {
		return jtfTelefono.getText();
	}

	public void setTelefono(String telefono) {
		this.jtfTelefono.setText(telefono);
		;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}
