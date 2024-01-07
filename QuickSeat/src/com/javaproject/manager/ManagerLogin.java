package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ManagerLogin extends JDialog {
	
	/*
	 * Descritipon : 관리자가 관리페이지로 접속하기 위해 아이디와 패스워드를 입력해 관리자 Table과 비교하여 메인페이지로 이동
	 * 
	 * Author : Lcy, Wdh
	 * 
	 * Date : 2024-01-05 , 16:07
	 */

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblAdminNumber;
	private JButton btnLogin;
	
	static ManagerLogin loginDialog = new ManagerLogin();
	static ManagerMain mainDialog = new ManagerMain();
	private JTextField tfAdminNumber;
	private JLabel lblAdminNumber_1;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			loginDialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManagerLogin() {
		setTitle("관리자 로그인");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblAdminNumber());
		contentPanel.add(getBtnLogin());
		
		tfAdminNumber = new JTextField();
		tfAdminNumber.setBounds(332, 140, 300, 60);
		contentPanel.add(tfAdminNumber);
		tfAdminNumber.setColumns(10);
		
		lblAdminNumber_1 = new JLabel("비밀번호  :");
		lblAdminNumber_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 30));
		lblAdminNumber_1.setBounds(120, 231, 200, 60);
		contentPanel.add(lblAdminNumber_1);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(332, 231, 300, 60);
		contentPanel.add(tfPassword);
	}
	private JLabel getLblAdminNumber() {
		if (lblAdminNumber == null) {
			lblAdminNumber = new JLabel("관리자번호  :");
			lblAdminNumber.setBounds(120, 140, 200, 60);
			lblAdminNumber.setFont(new Font("배달의민족 도현", Font.PLAIN, 30));
		}
		return lblAdminNumber;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("접속");
			btnLogin.setBounds(300, 350, 180, 70);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToMain();
				}
			});
			btnLogin.setFont(new Font("배달의민족 도현", Font.PLAIN, 40));
		}
		return btnLogin;
	}
	
	
	// ================================================ Functions =========================================================================
	
	private void goToMain() {
		loginDialog.setVisible(false);
		loginDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		mainDialog.setVisible(true);
	}
} // End