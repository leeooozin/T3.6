package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;


public class TelaSelecionada implements ActionListener, ListSelectionListener{
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroProduto;
	private JButton refreshProduto;
	private JList<String> listaProdutosCadastrados;
	
	public void mostrarDados(int opc) {
		switch(opc) {
		case 1:
			ControleProduto cp = new ControleProduto();
			listaProdutosCadastrados = new JList<String>(cp.getNomeProduto());
			janela = new JFrame("Produtos");
			titulo = new JLabel("Produtos Cadastrados");
			cadastroProduto = new JButton("Cadastrar");
			refreshProduto = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaProdutosCadastrados.setBounds(20, 50, 350, 350);
			listaProdutosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaProdutosCadastrados.setVisibleRowCount(5);
			
			cadastroProduto.setBounds(70, 420, 100, 30);
			refreshProduto.setBounds(200, 420, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaProdutosCadastrados);
			janela.add(cadastroProduto);
			janela.add(refreshProduto);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			cadastroProduto.addActionListener(this);
			refreshProduto.addActionListener(this);
			listaProdutosCadastrados.addListSelectionListener(this);
			
			break;
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		ControleProduto cp = new ControleProduto();
		
		if(src == cadastroProduto) {
			new TelaDetalheProduto().inserirEditar(1, 0);
		}
		
		if(src == refreshProduto) {
			listaProdutosCadastrados.setListData(cp.getProdutoN());
			listaProdutosCadastrados.updateUI();
		}
	}
	
	//Captura eventos relacionados ao JList
		public void valueChanged(ListSelectionEvent e) {
			Object src = e.getSource();

			if(e.getValueIsAdjusting() && src == listaProdutosCadastrados) {
				new TelaDetalheProduto().inserirEditar(2, listaProdutosCadastrados.getSelectedIndex());
			}
		}
	
}