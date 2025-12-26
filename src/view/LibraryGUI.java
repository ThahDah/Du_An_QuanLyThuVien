package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ChangeToAddBookGUI;

//import Model.ThuVien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LibraryGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private ThuVien myLibrary;
	
	
	public LibraryGUI() {
		this.init();
		setVisible(true);
	}
	
	public void init() {
		setTitle("LibraryManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(477, 361);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ActionListener addBook = new ChangeToAddBookGUI(this);
		JButton addBookButton = new JButton("Thêm sách");
		addBookButton.addActionListener(addBook);
		addBookButton.setBounds(10, 268, 136, 45);
		contentPane.add(addBookButton);
		
		JButton addMemberButton = new JButton("Thêm thành viên");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddMemberGUI(LibraryGUI.this);
			}
		});
		addMemberButton.setBounds(317, 267, 136, 47);
		contentPane.add(addMemberButton);	
	}
}
