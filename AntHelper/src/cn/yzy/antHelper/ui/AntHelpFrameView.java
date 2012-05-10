package cn.yzy.antHelper.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AntHelpFrameView extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField tfAntHome;
	protected JTextField tfBuildFileName;
	protected JTextField tfTarget;
	protected JTextField tfLoation;
	protected JTable locationsTable;
	protected JButton btnDeleteLocation;
	protected JButton btnAddLocation;
	protected JButton btnLocation;
	protected Component btnAntHome;
	protected JButton btnRun;
	protected JButton btnCancel;
	protected JTextArea taOutput;
	public AntHelpFrameView() {
		
		setPreferredSize(new Dimension(1024,600));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(SwingUtil.createEtchedBorder());
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnRun = new JButton("Run");
		buttonPanel.add(btnRun);
		
		btnCancel = new JButton("Cancel");
		buttonPanel.add(btnCancel);
		
		JSplitPane contentPanel = new JSplitPane();
		contentPanel.setOneTouchExpandable(true);
		contentPanel.setContinuousLayout(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(SwingUtil.createEtchedBorder());
		contentPanel.setLeftComponent(leftPanel);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{0, 157, 0, 0, 0, 0};
		gbl_leftPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_leftPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		JLabel lbAntHome = new JLabel("Ant Home:");
		GridBagConstraints gbc_lbAntHome = new GridBagConstraints();
		gbc_lbAntHome.insets = new Insets(0, 5, 5, 5);
		gbc_lbAntHome.anchor = GridBagConstraints.WEST;
		gbc_lbAntHome.gridx = 0;
		gbc_lbAntHome.gridy = 0;
		leftPanel.add(lbAntHome, gbc_lbAntHome);
		
		tfAntHome = new JTextField();
		GridBagConstraints gbc_tfAntHome = new GridBagConstraints();
		gbc_tfAntHome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAntHome.gridwidth = 3;
		gbc_tfAntHome.insets = new Insets(5, 0, 5, 5);
		gbc_tfAntHome.gridx = 1;
		gbc_tfAntHome.gridy = 0;
		leftPanel.add(tfAntHome, gbc_tfAntHome);
		tfAntHome.setColumns(10);
		
		btnAntHome = new JButton("Browse");
		GridBagConstraints gbc_btnAntHome = new GridBagConstraints();
		gbc_btnAntHome.anchor = GridBagConstraints.WEST;
		gbc_btnAntHome.insets = new Insets(5, 0, 5, 5);
		gbc_btnAntHome.gridx = 4;
		gbc_btnAntHome.gridy = 0;
		leftPanel.add(btnAntHome, gbc_btnAntHome);
		
		JLabel lbBuildFileName = new JLabel("Build File Name:");
		GridBagConstraints gbc_lbBuildFileName = new GridBagConstraints();
		gbc_lbBuildFileName.anchor = GridBagConstraints.WEST;
		gbc_lbBuildFileName.insets = new Insets(0, 5, 5, 5);
		gbc_lbBuildFileName.gridx = 0;
		gbc_lbBuildFileName.gridy = 1;
		leftPanel.add(lbBuildFileName, gbc_lbBuildFileName);
		
		tfBuildFileName = new JTextField();
		GridBagConstraints gbc_tfBuildFileName = new GridBagConstraints();
		gbc_tfBuildFileName.gridwidth = 4;
		gbc_tfBuildFileName.insets = new Insets(0, 0, 5, 5);
		gbc_tfBuildFileName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBuildFileName.gridx = 1;
		gbc_tfBuildFileName.gridy = 1;
		leftPanel.add(tfBuildFileName, gbc_tfBuildFileName);
		tfBuildFileName.setColumns(10);
		
		JLabel lbTarget = new JLabel("Target:");
		GridBagConstraints gbc_lbTarget = new GridBagConstraints();
		gbc_lbTarget.anchor = GridBagConstraints.WEST;
		gbc_lbTarget.insets = new Insets(0, 5, 5, 5);
		gbc_lbTarget.gridx = 0;
		gbc_lbTarget.gridy = 2;
		leftPanel.add(lbTarget, gbc_lbTarget);
		
		tfTarget = new JTextField();
		GridBagConstraints gbc_tfTarget = new GridBagConstraints();
		gbc_tfTarget.gridwidth = 4;
		gbc_tfTarget.insets = new Insets(0, 0, 5, 5);
		gbc_tfTarget.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTarget.gridx = 1;
		gbc_tfTarget.gridy = 2;
		leftPanel.add(tfTarget, gbc_tfTarget);
		tfTarget.setColumns(10);
		
		JLabel lbLocation = new JLabel("Location:");
		GridBagConstraints gbc_lbLocation = new GridBagConstraints();
		gbc_lbLocation.anchor = GridBagConstraints.WEST;
		gbc_lbLocation.insets = new Insets(0, 5, 5, 5);
		gbc_lbLocation.gridx = 0;
		gbc_lbLocation.gridy = 3;
		leftPanel.add(lbLocation, gbc_lbLocation);
		
		tfLoation = new JTextField();
		GridBagConstraints gbc_tfLoation = new GridBagConstraints();
		gbc_tfLoation.insets = new Insets(0, 0, 5, 5);
		gbc_tfLoation.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfLoation.gridx = 1;
		gbc_tfLoation.gridy = 3;
		leftPanel.add(tfLoation, gbc_tfLoation);
		tfLoation.setColumns(10);
		
		btnLocation = new JButton("Browse");
		GridBagConstraints gbc_btnLocation = new GridBagConstraints();
		gbc_btnLocation.anchor = GridBagConstraints.WEST;
		gbc_btnLocation.insets = new Insets(0, 0, 5, 5);
		gbc_btnLocation.gridx = 2;
		gbc_btnLocation.gridy = 3;
		leftPanel.add(btnLocation, gbc_btnLocation);
		
		btnAddLocation = new JButton("Add");
		GridBagConstraints gbc_btnAddLocation = new GridBagConstraints();
		gbc_btnAddLocation.anchor = GridBagConstraints.WEST;
		gbc_btnAddLocation.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLocation.gridx = 3;
		gbc_btnAddLocation.gridy = 3;
		leftPanel.add(btnAddLocation, gbc_btnAddLocation);
		
		btnDeleteLocation = new JButton("Delete");
		GridBagConstraints gbc_btnDeleteLocation = new GridBagConstraints();
		gbc_btnDeleteLocation.anchor = GridBagConstraints.WEST;
		gbc_btnDeleteLocation.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteLocation.gridx = 4;
		gbc_btnDeleteLocation.gridy = 3;
		leftPanel.add(btnDeleteLocation, gbc_btnDeleteLocation);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		leftPanel.add(scrollPane, gbc_scrollPane);
		
		locationsTable = new JTable();
		scrollPane.setViewportView(locationsTable);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(SwingUtil.createEtchedBorder());
		contentPanel.setRightComponent(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		taOutput = new JTextArea();
		taOutput.setWrapStyleWord(true);
		taOutput.setLineWrap(true);
		JScrollPane scroller=new JScrollPane();
		scroller.setViewportView(taOutput);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		rightPanel.add(scroller);
		
		pack();
	}

}
