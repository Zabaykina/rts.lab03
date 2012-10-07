package rts.lab03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View {

	private JFrame frame;
	private Controller controller;
	private JButton btnStop;
	private JButton btnStart;
private JCheckBox chckbxDeadLock;
	
	
	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 650, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel controlPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) controlPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);

		btnStart = new JButton("Start");
		controlPanel.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setEnabled(false);
		controlPanel.add(btnStop);

		chckbxDeadLock = new JCheckBox("dead lock");
		controlPanel.add(chckbxDeadLock);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 50, 50, 50, 50, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel label_10 = new JLabel("Схема стола");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.gridwidth = 5;
		gbc_label_10.insets = new Insets(5, 5, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 0;
		panel.add(label_10, gbc_label_10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(5, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblFork1 = new JLabel("Вилка 1");
		GridBagConstraints gbc_lblFork1 = new GridBagConstraints();
		gbc_lblFork1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFork1.gridx = 1;
		gbc_lblFork1.gridy = 1;
		panel.add(lblFork1, gbc_lblFork1);

		JLabel lblPlate1 = new JLabel("Тарелка 1");
		GridBagConstraints gbc_lblPlate1 = new GridBagConstraints();
		gbc_lblPlate1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlate1.gridx = 2;
		gbc_lblPlate1.gridy = 1;
		panel.add(lblPlate1, gbc_lblPlate1);

		JLabel lblFork2 = new JLabel("Вилка 2");
		GridBagConstraints gbc_lblFork2 = new GridBagConstraints();
		gbc_lblFork2.insets = new Insets(0, 0, 5, 5);
		gbc_lblFork2.gridx = 3;
		gbc_lblFork2.gridy = 1;
		panel.add(lblFork2, gbc_lblFork2);

		JLabel lblPlate5 = new JLabel("Тарелка 5");
		GridBagConstraints gbc_lblPlate5 = new GridBagConstraints();
		gbc_lblPlate5.insets = new Insets(0, 5, 5, 5);
		gbc_lblPlate5.gridx = 0;
		gbc_lblPlate5.gridy = 2;
		panel.add(lblPlate5, gbc_lblPlate5);

		JLabel lblPlate2 = new JLabel("Тарелка 2");
		GridBagConstraints gbc_lblPlate2 = new GridBagConstraints();
		gbc_lblPlate2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlate2.gridx = 4;
		gbc_lblPlate2.gridy = 2;
		panel.add(lblPlate2, gbc_lblPlate2);

		JLabel lblFork5 = new JLabel("Вилка 5");
		GridBagConstraints gbc_lblFork5 = new GridBagConstraints();
		gbc_lblFork5.insets = new Insets(0, 0, 5, 5);
		gbc_lblFork5.gridx = 0;
		gbc_lblFork5.gridy = 3;
		panel.add(lblFork5, gbc_lblFork5);

		JLabel lblFork3 = new JLabel("Вилка 3");
		GridBagConstraints gbc_lblFork3 = new GridBagConstraints();
		gbc_lblFork3.insets = new Insets(0, 0, 5, 5);
		gbc_lblFork3.gridx = 4;
		gbc_lblFork3.gridy = 3;
		panel.add(lblFork3, gbc_lblFork3);

		JLabel lblPlate4 = new JLabel("Тарелка 4");
		GridBagConstraints gbc_lblPlate4 = new GridBagConstraints();
		gbc_lblPlate4.insets = new Insets(0, 0, 0, 5);
		gbc_lblPlate4.gridx = 1;
		gbc_lblPlate4.gridy = 4;
		panel.add(lblPlate4, gbc_lblPlate4);

		JLabel lblFork4 = new JLabel("Вилка 4");
		GridBagConstraints gbc_lblFork4 = new GridBagConstraints();
		gbc_lblFork4.insets = new Insets(0, 0, 0, 5);
		gbc_lblFork4.gridx = 2;
		gbc_lblFork4.gridy = 4;
		panel.add(lblFork4, gbc_lblFork4);

		JLabel lblPlate3 = new JLabel("Тарелка 3");
		GridBagConstraints gbc_lblPlate3 = new GridBagConstraints();
		gbc_lblPlate3.insets = new Insets(0, 0, 0, 5);
		gbc_lblPlate3.gridx = 3;
		gbc_lblPlate3.gridy = 4;
		panel.add(lblPlate3, gbc_lblPlate3);

		ArrayList<JLabel> lblPlates = new ArrayList<JLabel>();
		lblPlates.add(lblPlate1);
		lblPlates.add(lblPlate2);
		lblPlates.add(lblPlate3);
		lblPlates.add(lblPlate4);
		lblPlates.add(lblPlate5);

		ArrayList<JLabel> lblForks = new ArrayList<JLabel>();
		lblForks.add(lblFork1);
		lblForks.add(lblFork2);
		lblForks.add(lblFork3);
		lblForks.add(lblFork4);
		lblForks.add(lblFork5);

		controller = new Controller(chckbxDeadLock.isSelected(), textArea,
				lblPlates, lblForks);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.setDeadlock(chckbxDeadLock.isSelected());
				controller.start();
				btnStart.setEnabled(false);
				btnStop.setEnabled(true);
			}
		});

		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
				btnStop.setEnabled(false);
				btnStart.setEnabled(true);
			}
		});
	}
}
