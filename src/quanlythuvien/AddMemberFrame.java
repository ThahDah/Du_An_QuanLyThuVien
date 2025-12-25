package quanlythuvien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AddMemberFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField birthField;
	private JTextField countryField;
	private JButton backButton;
	private JLabel idLable;
	private JTextField idField;
	private JLabel lblNewLabel;


	public AddMemberFrame(Menu m) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLable = new JLabel("Họ và tên:");
		nameLable.setBounds(22, 114, 69, 27);
		contentPane.add(nameLable);
		
		JButton addMemberButton = new JButton("Add");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(AddMemberFrame.this,"Đã thêm thành công");
				idField.setText("");
				nameField.setText("");
				birthField.setText("");
				countryField.setText("");
			}
		});
		addMemberButton.setBounds(300, 134, 88, 35);
		contentPane.add(addMemberButton);
		
		nameField = new JTextField();
		nameField.setBounds(117, 114, 133, 27);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel birthLable = new JLabel("Ngày sinh:");
		birthLable.setBounds(22, 161, 69, 27);
		contentPane.add(birthLable);
		
		birthField = new JTextField();
		birthField.setBounds(117, 161, 133, 27);
		contentPane.add(birthField);
		birthField.setColumns(10);
		
		JLabel countryLable = new JLabel("Quê quán:");
		countryLable.setBounds(22, 209, 70, 27);
		contentPane.add(countryLable);
		
		countryField = new JTextField();
		countryField.setBounds(117, 209, 133, 27);
		contentPane.add(countryField);
		countryField.setColumns(10);
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(338, 230, 88, 22);
		contentPane.add(backButton);
		
		idLable = new JLabel("Mã thành viên: ");
		idLable.setBounds(22, 70, 101, 27);
		contentPane.add(idLable);
		
		idField = new JTextField();
		idField.setBounds(117, 70, 133, 27);
		contentPane.add(idField);
		idField.setColumns(10);
		
		lblNewLabel = new JLabel("Nhập thông tin thành viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 11, 230, 35);
		contentPane.add(lblNewLabel);
		
		
	}
}
