package laguna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.CardLayout;

import javax.swing.JTextArea;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class LagunaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNazivKnjige;
	private JTextField textFieldNaziv;
	private JLabel lblPisac;
	private JTextField textFieldPisac;
	private JLabel lblIzdavac;
	private JTextField textFieldIzdavac;
	private JLabel lblZanr;
	private JComboBox comboBox;
	private JButton btnIspisi;
	private JTextArea textAreaString;
	private JTextArea textAreaJSON;
	
	private LinkedList<Laguna> knjige = new LinkedList<Laguna>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LagunaGUI frame = new LagunaGUI();
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
	public LagunaGUI() {
		setTitle("Knjiga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow]"));
		contentPane.add(getPanel(), "cell 0 0,grow");
		contentPane.add(getPanel_1(), "cell 1 0,alignx center,growy");
		contentPane.add(getPanel_2(), "cell 2 0,grow");
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new CardLayout(0, 0));
			panel.add(getTextAreaString(), "name_1013042097943");
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{108, 0};
			gbl_panel_1.rowHeights = new int[]{43, 40, 39, 42, 23, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			GridBagConstraints gbc_lblNazivKnjige = new GridBagConstraints();
			gbc_lblNazivKnjige.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNazivKnjige.insets = new Insets(0, 0, 5, 0);
			gbc_lblNazivKnjige.gridx = 0;
			gbc_lblNazivKnjige.gridy = 0;
			panel_1.add(getLblNazivKnjige(), gbc_lblNazivKnjige);
			GridBagConstraints gbc_textFieldNaziv = new GridBagConstraints();
			gbc_textFieldNaziv.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldNaziv.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNaziv.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldNaziv.gridx = 0;
			gbc_textFieldNaziv.gridy = 0;
			panel_1.add(getTextFieldNaziv(), gbc_textFieldNaziv);
			GridBagConstraints gbc_lblPisac = new GridBagConstraints();
			gbc_lblPisac.anchor = GridBagConstraints.NORTH;
			gbc_lblPisac.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPisac.insets = new Insets(0, 0, 5, 0);
			gbc_lblPisac.gridx = 0;
			gbc_lblPisac.gridy = 1;
			panel_1.add(getLblPisac(), gbc_lblPisac);
			GridBagConstraints gbc_textFieldPisac = new GridBagConstraints();
			gbc_textFieldPisac.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldPisac.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPisac.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPisac.gridx = 0;
			gbc_textFieldPisac.gridy = 1;
			panel_1.add(getTextFieldPisac(), gbc_textFieldPisac);
			GridBagConstraints gbc_textFieldIzdavac = new GridBagConstraints();
			gbc_textFieldIzdavac.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldIzdavac.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIzdavac.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldIzdavac.gridx = 0;
			gbc_textFieldIzdavac.gridy = 2;
			panel_1.add(getTextFieldIzdavac(), gbc_textFieldIzdavac);
			GridBagConstraints gbc_lblIzdavac = new GridBagConstraints();
			gbc_lblIzdavac.anchor = GridBagConstraints.NORTH;
			gbc_lblIzdavac.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblIzdavac.insets = new Insets(0, 0, 5, 0);
			gbc_lblIzdavac.gridx = 0;
			gbc_lblIzdavac.gridy = 2;
			panel_1.add(getLblIzdavac(), gbc_lblIzdavac);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.anchor = GridBagConstraints.SOUTH;
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.gridx = 0;
			gbc_comboBox.gridy = 3;
			panel_1.add(getComboBox(), gbc_comboBox);
			GridBagConstraints gbc_lblZanr = new GridBagConstraints();
			gbc_lblZanr.anchor = GridBagConstraints.NORTH;
			gbc_lblZanr.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblZanr.insets = new Insets(0, 0, 5, 0);
			gbc_lblZanr.gridx = 0;
			gbc_lblZanr.gridy = 3;
			panel_1.add(getLblZanr(), gbc_lblZanr);
			GridBagConstraints gbc_btnIspisi = new GridBagConstraints();
			gbc_btnIspisi.anchor = GridBagConstraints.NORTH;
			gbc_btnIspisi.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnIspisi.gridx = 0;
			gbc_btnIspisi.gridy = 5;
			panel_1.add(getBtnIspisi(), gbc_btnIspisi);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new CardLayout(0, 0));
			panel_2.add(getTextAreaJSON(), "name_1023120441989");
		}
		return panel_2;
	}
	private JLabel getLblNazivKnjige() {
		if (lblNazivKnjige == null) {
			lblNazivKnjige = new JLabel("Naziv knjige:");
		}
		return lblNazivKnjige;
	}
	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}
	private JLabel getLblPisac() {
		if (lblPisac == null) {
			lblPisac = new JLabel("Pisac:");
		}
		return lblPisac;
	}
	private JTextField getTextFieldPisac() {
		if (textFieldPisac == null) {
			textFieldPisac = new JTextField();
			textFieldPisac.setColumns(10);
		}
		return textFieldPisac;
	}
	private JLabel getLblIzdavac() {
		if (lblIzdavac == null) {
			lblIzdavac = new JLabel("Izdavac:");
		}
		return lblIzdavac;
	}
	private JTextField getTextFieldIzdavac() {
		if (textFieldIzdavac == null) {
			textFieldIzdavac = new JTextField();
			textFieldIzdavac.setColumns(10);
		}
		return textFieldIzdavac;
	}
	private JLabel getLblZanr() {
		if (lblZanr == null) {
			lblZanr = new JLabel("Zanr:");
		}
		return lblZanr;
	}
	
	
	@SuppressWarnings("unchecked")
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Drama", "Romansa", "Akcija", "Horor", "Komedija"}));
		}
		return comboBox;
	}
	private JButton getBtnIspisi() {
		if (btnIspisi == null) {
			btnIspisi = new JButton("Ispisi");
			btnIspisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent o) {
					try {
						PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("biblioteka.out")));
						Laguna m = new Laguna();
						
						if(textFieldIzdavac.getText().isEmpty()) {
							m.setIzdavac("Nepoznat");
						}
						else {
							m.setIzdavac(textFieldIzdavac.getText());
						}
						if(textFieldNaziv.getText().isEmpty()) {
							m.setNazivKnjige("Nepoznat");
						}
						else {
							m.setNazivKnjige(textFieldNaziv.getText());
						}
						if(textFieldPisac.getText().isEmpty()) {
							m.setPisac("Nepoznat");
						}
						else {
							m.setPisac(textFieldPisac.getText());
						}
					
						String z = String.valueOf(comboBox.getSelectedItem());
						m.setZanr(z);
						
						pw.println(m);
						pw.close();
						
						if(!(knjige.contains(m))) {
							knjige.add(m);
						}
						textAreaString.setText(m.toString());
						
					} catch (IOException e1) {
						System.out.println("Greska!");
					}
					
					
					
					
					JSONObject ob = new JSONObject();
					try {
						String n = "nepoznato";
						
						if(textFieldNaziv.getText().isEmpty()) {
							ob.put("nazivKnjige", n);
						} else {
							ob.put("nazivKnjige", textFieldNaziv.getText());
						}
						if(textFieldPisac.getText().isEmpty()) {
							ob.put("pisac", n);
						} else {
							ob.put("pisac", textFieldPisac.getText());
						}
						if(textFieldIzdavac.getText().isEmpty()) {
							ob.put("izdavac", n);
						} else {
							ob.put("izdavac", textFieldIzdavac.getText());
						}
						
						ob.put("zanr", comboBox.getSelectedItem());
						
						textAreaJSON.setText(ob.toString(4));
					} catch (JSONException e) {
						System.out.println("Greska!");
					}
					
					
					
					
				}
			});
		}
		return btnIspisi;
	}
	private JTextArea getTextAreaString() {
		if (textAreaString == null) {
			textAreaString = new JTextArea();
		}
		return textAreaString;
	}
	private JTextArea getTextAreaJSON() {
		if (textAreaJSON == null) {
			textAreaJSON = new JTextArea();
		}
		return textAreaJSON;
	}
	
	
	
	
	
}
