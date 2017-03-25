package com.mtit.payrollsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mtit.service.ServiceManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCreateEmpTable = new JButton("Create Emp Table");
		btnCreateEmpTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceManager.getEmployeeService().createEmployeeTbl();
			}
		});
		
		JButton btnInsertData = new JButton("Insert Data");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInsertData)
						.addComponent(btnCreateEmpTable))
					.addContainerGap(277, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(btnCreateEmpTable)
					.addGap(18)
					.addComponent(btnInsertData)
					.addContainerGap(175, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
