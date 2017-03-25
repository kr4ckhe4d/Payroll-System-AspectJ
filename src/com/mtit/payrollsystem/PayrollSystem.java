package com.mtit.payrollsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mtit.dataaccess.Employee;
import com.mtit.service.ServiceManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PayrollSystem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollSystem window = new PayrollSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PayrollSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ServiceManager.getEmployeeService().createEmployeeTbl();
		List<Employee> list = ServiceManager.getEmployeeService().getEmployees();
		/**
		 * Add two dummy data if the table does not have any data
		 */
		if(list.isEmpty()){
			Employee employee1 = new Employee(0,"Nipuna H Herath","Software Engineer",80000.00,0.12);
			ServiceManager.getEmployeeService().addEmployee(employee1);
			Employee employee2 = new Employee(0,"Madumal Sameera Piyasundara","Software Engineer",120000.00,0.12);
			ServiceManager.getEmployeeService().addEmployee(employee2);
			Employee employee3 = new Employee(0,"Nilesh Jayanandana","Software Engineer",150000.00,0.12);
			ServiceManager.getEmployeeService().addEmployee(employee3);
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEmployeePayrollSystem = new JLabel("Employee Payroll System");
		lblEmployeePayrollSystem.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JButton btnEmployeeInformation = new JButton("Employee Information");
		btnEmployeeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeeInformation().setVisible(true);
			}
		});
		
		JButton btnCalculateSalary = new JButton("Calculate Salary");
		btnCalculateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CalculateSalary().setVisible(true);
			}
		});
		
		JButton btnCalculateEpf = new JButton("Create Employee");
		btnCalculateEpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateEmployee().setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblEmployeePayrollSystem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(30))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEmployeeInformation, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addComponent(btnCalculateSalary, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addComponent(btnCalculateEpf, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblEmployeePayrollSystem)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnEmployeeInformation, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnCalculateSalary, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCalculateEpf, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
