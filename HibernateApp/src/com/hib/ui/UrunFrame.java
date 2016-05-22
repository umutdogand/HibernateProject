package com.hib.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hib.dao.IslemDao;
import com.hib.dao.UrunDao;
import com.hib.pojos.Urun;
import com.toedter.calendar.JDateChooser;

public class UrunFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtAdet;
	private JTextField txtAdi;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UrunFrame frame = new UrunFrame();
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
	public UrunFrame() {
		InitComponent();
	}

	private void InitComponent() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd.MM.yyyy");
		dateChooser.setBounds(125, 112, 97, 20);
		getContentPane().add(dateChooser);

		JLabel lblNewLabel = new JLabel("Uretim Tarihi");
		lblNewLabel.setBounds(23, 118, 92, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblAd = new JLabel("ADET");
		lblAd.setBounds(23, 59, 46, 14);
		getContentPane().add(lblAd);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(23, 33, 46, 14);
		getContentPane().add(lblId);

		JLabel label = new JLabel("ADI");
		label.setBounds(23, 84, 46, 14);
		getContentPane().add(label);

		txtId = new JTextField();
		txtId.setBounds(125, 30, 86, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtAdet = new JTextField();
		txtAdet.setColumns(10);
		txtAdet.setBounds(125, 56, 86, 20);
		getContentPane().add(txtAdet);

		txtAdi = new JTextField();
		txtAdi.setColumns(10);
		txtAdi.setBounds(125, 81, 86, 20);
		getContentPane().add(txtAdi);

		JButton btnGonder = new JButton("Gonder");
		btnGonder.addActionListener(this);
		btnGonder.setBounds(125, 163, 91, 23);
		getContentPane().add(btnGonder);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Urun u=new Urun();
		u.setAdet(Integer.parseInt(txtAdet.getText()));
		u.setUrunAdi(txtAdi.getText());
		u.setUretimTarihi(dateChooser.getDate());
		IslemDao i=new IslemDao();
		i.Ekle(u);
//		UrunDao dao=new UrunDao();
//		dao.Ekle(u);
	}
}
