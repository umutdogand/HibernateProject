package com.hib.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hib.dao.UrunDao;
import com.hib.pojos.Urun;

public class UrunArama extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tableUrunler;
	private JTextField txtUrunAdi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UrunArama frame = new UrunArama();
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
	public UrunArama() {
		initComponent();
		DoldurTablo();
	}

	private void initComponent() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 11, 331, 251);
		contentPane.add(scrollPane);

		tableUrunler = new JTable();
		tableUrunler.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "URUNADI", "ADET", "URETIMTARIHI"
			}
		));
		scrollPane.setViewportView(tableUrunler);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 145, 251);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUrunAdi = new JLabel("Urun Adi");
		lblUrunAdi.setBounds(0, 28, 46, 14);
		panel.add(lblUrunAdi);

		txtUrunAdi = new JTextField();
		txtUrunAdi.setBounds(56, 25, 86, 20);
		panel.add(txtUrunAdi);
		txtUrunAdi.setColumns(10);

		JButton btnAraUrunAdi = new JButton("Ara Urun Adi");
		btnAraUrunAdi.addActionListener(this);
		btnAraUrunAdi.setBounds(27, 56, 115, 23);
		panel.add(btnAraUrunAdi);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String aranacak = txtUrunAdi.getText();

	}

	private void DoldurTablo() {
		TabloTemizle();
		DefaultTableModel md = (DefaultTableModel) tableUrunler.getModel();
		
		UrunDao u=new UrunDao();
		List<Urun> urunler=u.GetirUrunleri();
		
		try {
			for (Urun urun : urunler) {
				md.addRow(new Object[] { urun.getId(), urun.getUrunAdi(), urun.getAdet(),
 					urun.getUretimTarihi().toString()});
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void TabloTemizle() {

		DefaultTableModel dt = (DefaultTableModel) tableUrunler.getModel();
		int kayitSayisi = dt.getRowCount();
		for (int i = kayitSayisi - 1; i >= 0; i--) {
			dt.removeRow(i);
		}

	}
}
