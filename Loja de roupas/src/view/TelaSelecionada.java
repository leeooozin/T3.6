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
	private JButton cadastroCliente;
	private JButton refreshCliente;
	private JButton cadastroFunc;
	private JButton refreshFunc;
	private JList<String> listaProdutosCadastrados;
	private JList<String> listaClientesCadastrados;
	private JList<String> listaFuncionariosCadastrados;
	
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
		
		case 2:
			ControleCliente cc = new ControleCliente();
			listaClientesCadastrados = new JList<String>(cc.getNomeCliente());
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			cadastroCliente = new JButton("Cadastrar");
			refreshCliente = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaClientesCadastrados.setBounds(20, 50, 350, 350);
			listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaClientesCadastrados.setVisibleRowCount(5);
			
			cadastroCliente.setBounds(70, 420, 100, 30);
			refreshCliente.setBounds(200, 420, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaClientesCadastrados);
			janela.add(cadastroCliente);
			janela.add(refreshCliente);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			cadastroCliente.addActionListener(this);
			refreshCliente.addActionListener(this);
			listaClientesCadastrados.addListSelectionListener(this);
			
			break;
			
		case 3:
			ControleFuncionario cf = new ControleFuncionario();
			listaFuncionariosCadastrados = new JList<String>(cf.getNomeFuncionario());
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			cadastroFunc = new JButton("Cadastrar");
			refreshFunc = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaFuncionariosCadastrados.setBounds(20, 50, 350, 350);
			listaFuncionariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaFuncionariosCadastrados.setVisibleRowCount(5);
			
			cadastroFunc.setBounds(70, 420, 100, 30);
			refreshFunc.setBounds(200, 420, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaFuncionariosCadastrados);
			janela.add(cadastroFunc);
			janela.add(refreshFunc);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			cadastroFunc.addActionListener(this);
			refreshFunc.addActionListener(this);
			listaFuncionariosCadastrados.addListSelectionListener(this);
			
			break;
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		ControleProduto cp = new ControleProduto();
		ControleCliente cc = new ControleCliente();
		ControleFuncionario cf = new ControleFuncionario();
		
		if(src == cadastroProduto) {
			new TelaDetalheProduto().inserirEditar(1, 0);
		}
		
		if(src == refreshProduto) {
			listaProdutosCadastrados.setListData(cp.getProdutoN());
			listaProdutosCadastrados.updateUI();
		}
		
		if(src == cadastroCliente) {
			new TelaDetalheCliente().inserirEditar(1, 0);
		}
		
		if(src == refreshCliente) {
			listaClientesCadastrados.setListData(cc.getClienteN());
			listaClientesCadastrados.updateUI();
		}
		
		if(src == cadastroFunc) {
			new TelaDetalheFuncionario().inserirEditar(1, 0);
		}
		
		if(src == refreshFunc) {
			listaFuncionariosCadastrados.setListData(cf.getFuncionarioN());
			listaFuncionariosCadastrados.updateUI();
		}
	}
	
	//Captura eventos relacionados ao JList
		public void valueChanged(ListSelectionEvent e) {
			Object src = e.getSource();

			if(e.getValueIsAdjusting() && src == listaProdutosCadastrados) {
				new TelaDetalheProduto().inserirEditar(2, listaProdutosCadastrados.getSelectedIndex());
			}
			
			if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
				new TelaDetalheCliente().inserirEditar(2, listaClientesCadastrados.getSelectedIndex());
			}
			
			if(e.getValueIsAdjusting() && src == listaFuncionariosCadastrados) {
				new TelaDetalheFuncionario().inserirEditar(2, listaFuncionariosCadastrados.getSelectedIndex());
			}
		}
	
}
