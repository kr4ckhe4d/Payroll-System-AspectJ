package com.mtit.payrollsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mtit.service.ServiceManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mtit.dataaccess.Employee;

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
import java.awt.Color;

public class EmployeeInformation extends JFrame {

	private JPanel contentPane;
	private JTextField txtEID;
	private Employee emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInformation frame = new EmployeeInformation();
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
	public EmployeeInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEmployeeInformation = new JLabel("Employee Information");
		lblEmployeeInformation.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		JLabel lblDesignation_ = new JLabel("Designation       : ");
		
		JLabel lblBasicSalary = new JLabel("Basic Salary        : ");
		
		JLabel lblEpf_ = new JLabel("EPF                     : ");
		
		JLabel lblName = new JLabel("");
		
		JLabel lblDesignation = new JLabel("");
		
		JLabel lblBasicSal = new JLabel("");
		
		JLabel lblEPF = new JLabel("");
		JLabel lblEmployeeId = new JLabel("Employee ID");
		JLabel lblEmployeeName = new JLabel("Employee Name : ");
		txtEID = new JTextField();
		txtEID.setColumns(10);
		JButton btnRemove = new JButton("Remove ");
		btnRemove.setForeground(Color.RED);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emp = ServiceManager.getEmployeeService().getEmployee(Integer.parseInt(txtEID.getText()));
				if(emp != null){
					JOptionPane.showMessageDialog(null, "Employee Found!!", "Found", JOptionPane.INFORMATION_MESSAGE);
					btnRemove.setEnabled(true);
					lblName.setText(emp.getFullName());
					lblDesignation.setText(emp.getDesignation());
					lblBasicSal.setText(Double.toString(emp.getSalary()));
					lblEPF.setText(Double.toString(emp.getEPF()));
				}else{
					JOptionPane.showMessageDialog(null, "No record found for entered ID!!", "Not Found", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceManager.getEmployeeService().deleteEmployee(emp);
				JOptionPane.showMessageDialog(null, "Employee Removed!!", "Success", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		});
		btnRemove.setEnabled(false);
		

		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEmployeeName)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDesignation_, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBasicSalary, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEpf_, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addGap(6)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBasicSal, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
									.addGap(19))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblDesignation, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
										.addGap(18))
									.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
								.addComponent(lblEPF, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(6)
								.addComponent(lblEmployeeId)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtEID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSearch)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnBack)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblEmployeeInformation, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack)
						.addComponent(lblEmployeeInformation, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeId)
						.addComponent(txtEID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeName)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDesignation_)
						.addComponent(lblDesignation, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBasicSalary)
						.addComponent(lblBasicSal, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEPF, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblEpf_))
					.addGap(17))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
