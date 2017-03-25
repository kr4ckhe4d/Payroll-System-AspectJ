package com.mtit.payrollsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mtit.dataaccess.Employee;
import com.mtit.service.ServiceManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtDesignation;
	private JTextField txtBasicSal;
	private JTextField txtEPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEmployee frame = new CreateEmployee();
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
	public CreateEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				GroupLayout gl_contentPane = new GroupLayout(contentPane);

		JLabel lblCreateEmployee = new JLabel("Create Employee");
		lblCreateEmployee.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JLabel lblFullName = new JLabel("Full Name : ");
		
		JLabel lblDesignation = new JLabel("Designation :");
		
		JLabel lblBasicSalary = new JLabel("Basic Salary : ");
		
		JLabel lblEpf = new JLabel("EPF : ");
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
		
		txtDesignation = new JTextField();
		txtDesignation.setColumns(10);
		
		txtBasicSal = new JTextField();
		txtBasicSal.setColumns(10);
		
		txtEPF = new JTextField();
		txtEPF.setColumns(10);
		
		JButton btnCreateEmployee = new JButton("Create Employee");
		btnCreateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFname.getText().isEmpty() ||
						txtDesignation.getText().isEmpty() ||
						txtBasicSal.getText().isEmpty() ||
						txtEPF.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "One or more fields are empty.", "Validation Fail", JOptionPane.INFORMATION_MESSAGE);
				}else{
					Employee emp = new Employee(0,txtFname.getText(),txtDesignation.getText(),Double.parseDouble(txtBasicSal.getText()),Double.parseDouble(txtEPF.getText()));
					ServiceManager.getEmployeeService().addEmployee(emp);
					JOptionPane.showMessageDialog(null, "Added employee successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBasicSal.setText("");
				txtDesignation.setText("");
				txtEPF.setText("");
				txtFname.setText("");
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDesignation)
								.addComponent(lblFullName)
								.addComponent(lblBasicSalary)
								.addComponent(lblEpf))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFname, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
								.addComponent(txtDesignation, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtBasicSal, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(txtEPF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCreateEmployee, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCreateEmployee, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCreateEmployee, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFullName)
						.addComponent(txtFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesignation)
						.addComponent(txtDesignation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBasicSalary)
						.addComponent(txtBasicSal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEpf)
						.addComponent(txtEPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateEmployee)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
