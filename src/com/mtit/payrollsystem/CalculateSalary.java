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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CalculateSalary extends JFrame {

	private JPanel contentPane;
	private JTextField txtEID;
	private JTextField txtOTHrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateSalary frame = new CalculateSalary();
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
	public CalculateSalary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCalculateSalary = new JLabel("Calculate Salary");
		lblCalculateSalary.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JLabel lblEmployeeId = new JLabel("Employee ID : ");
		
		txtEID = new JTextField();
		txtEID.setColumns(10);
		JLabel lblOtHours = new JLabel("OT Hours : ");
		
		txtOTHrs = new JTextField();
		txtOTHrs.setText("0");
		txtOTHrs.setColumns(10);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary : ");
		
		JLabel lblBasicSal = new JLabel("");
		
		JLabel lblNetSalary_ = new JLabel("Net Salary : ");
		
		JLabel lblNetSal = new JLabel("");
		
		JButton btnCalculateSalary = new JButton("Calculate Salary");
		
		JLabel lblEpfAmount = new JLabel("EPF Amount :");
		
		JLabel lblEPFAmt = new JLabel("");		
		
		btnCalculateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEID.getText().isEmpty() || txtOTHrs.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please fill required fields!!", "Validation Failed", JOptionPane.INFORMATION_MESSAGE);
				}else{
					Employee emp = ServiceManager.getEmployeeService().getEmployee(Integer.parseInt(txtEID.getText()));
					if(emp != null){
						JOptionPane.showMessageDialog(null, "Employee Found!!", "Found", JOptionPane.INFORMATION_MESSAGE);
						lblBasicSal.setText(Double.toString(emp.getSalary()));
						lblNetSal.setText(Double.toString(emp.getNetSalary(Integer.parseInt(txtOTHrs.getText()))));
						lblEPFAmt.setText(Double.toString(emp.getEPFAmt()));
					}else{
						JOptionPane.showMessageDialog(null, "No record found for entered ID!!", "Not Found", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		

		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack)
							.addGap(18)
							.addComponent(lblCalculateSalary, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEmployeeId)
								.addComponent(lblOtHours))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtEID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCalculateSalary))
								.addComponent(txtOTHrs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEpfAmount)
								.addComponent(lblNetSalary_)
								.addComponent(lblBasicSalary))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBasicSal, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
								.addComponent(lblNetSal, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
								.addComponent(lblEPFAmt, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))))
					.addGap(23))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCalculateSalary, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeId)
						.addComponent(txtEID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculateSalary))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOtHours)
						.addComponent(txtOTHrs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBasicSalary)
						.addComponent(lblBasicSal, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEpfAmount)
						.addComponent(lblEPFAmt, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNetSalary_)
						.addComponent(lblNetSal, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
