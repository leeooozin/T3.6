package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;

/**
 * Respons�vel por mostrar a lista de produtos, clientes, funcionario, venda e estoque
 * @author Leo
 *
 */
public class TelaSelecionada implements ActionListener, ListSelectionListener{
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroProduto;
	private JButton refreshProduto;
	private JButton cadastroCliente;
	private JButton refreshCliente;
	private JButton cadastroFunc;
	private JButton refreshFunc;
	private JButton cadastroVenda;
	private JButton refreshVenda;
	private JButton refreshEst;
	private JButton buscaPro = new JButton("Buscar");
	private JButton buscaCli = new JButton("Buscar");
	private JButton buscaFun = new JButton("Buscar");
	private JButton buscaVen = new JButton("Buscar");
	private JTextField buscaProduto = new JTextField(25);
	private JTextField buscaCliente = new JTextField(25);
	private JTextField buscaFuncionario = new JTextField(25);
	private JTextField buscaVenda = new JTextField(25);
	private JComboBox<String> filtroProduto;
	private JList<String> listaProdutosCadastrados;
	private JList<String> listaClientesCadastrados;
	private JList<String> listaFuncionariosCadastrados;
	private JList<String> listaVendasCadastradas;
	private JList<String> listaEstoque;
	
	int opcao;
	
	/**
	 * Respons�vel por selecionar qual lista mostrar a partir do parametro recebido
	 * @param opc
	 */
	public void mostrarDados(int opc) {
		opcao = opc;
		
		switch(opc) {
		case 1: //PRODUTO
			ControleProduto cp = new ControleProduto();
			String[] filtro = {"Data", "Pre�o Crescente", "Pre�o Decrescente"};
			filtroProduto = new JComboBox<String>(filtro);
			listaProdutosCadastrados = new JList<String>(cp.getNomeProduto());
			janela = new JFrame("Produtos");
			titulo = new JLabel("Produtos Cadastrados");
			cadastroProduto = new JButton("Cadastrar");
			refreshProduto = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaProdutosCadastrados.setBounds(20, 60, 350, 350);
			listaProdutosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaProdutosCadastrados.setVisibleRowCount(5);
			filtroProduto.setBounds(20, 40, 115, 17);
			filtroProduto.setSelectedIndex(0);
			
			buscaProduto.setBounds(150, 40, 140, 17);
			buscaPro.setBounds(295, 40, 75, 17);
			
			cadastroProduto.setBounds(70, 420, 100, 30);
			refreshProduto.setBounds(200, 420, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(filtroProduto);
			janela.add(titulo);
			janela.add(listaProdutosCadastrados);
			janela.add(cadastroProduto);
			janela.add(refreshProduto);
			janela.add(buscaProduto);
			janela.add(buscaPro);
			
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			filtroProduto.addActionListener(this);
			cadastroProduto.addActionListener(this);
			refreshProduto.addActionListener(this);
			buscaPro.addActionListener(this);
			listaProdutosCadastrados.addListSelectionListener(this);
			
			break;
		
		case 2: //CLIENTE
			ControleCliente cc = new ControleCliente();
			listaClientesCadastrados = new JList<String>(cc.getNomeCliente());
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			cadastroCliente = new JButton("Cadastrar");
			refreshCliente = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaClientesCadastrados.setBounds(20, 60, 350, 350);
			listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaClientesCadastrados.setVisibleRowCount(5);
			
			buscaCliente.setBounds(150, 40, 140, 17);
			buscaCli.setBounds(295, 40, 75, 17);
			
			cadastroCliente.setBounds(70, 420, 100, 30);
			refreshCliente.setBounds(200, 420, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaClientesCadastrados);
			janela.add(cadastroCliente);
			janela.add(refreshCliente);
			janela.add(buscaCliente);
			janela.add(buscaCli);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			cadastroCliente.addActionListener(this);
			refreshCliente.addActionListener(this);
			buscaCli.addActionListener(this);
			listaClientesCadastrados.addListSelectionListener(this);
			
			break;
			
		case 3: //FUNCIONARIO
			ControleFuncionario cf = new ControleFuncionario();
			listaFuncionariosCadastrados = new JList<String>(cf.getNomeFuncionario());
			janela = new JFrame("Clientes");
			titulo = new JLabel("Funcion�rios Cadastrados");
			cadastroFunc = new JButton("Cadastrar");
			refreshFunc = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaFuncionariosCadastrados.setBounds(20, 60, 350, 350);
			listaFuncionariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaFuncionariosCadastrados.setVisibleRowCount(5);
			
			buscaFuncionario.setBounds(150, 40, 140, 17);
			buscaFun.setBounds(295, 40, 75, 17);
			
			cadastroFunc.setBounds(70, 420, 100, 30);
			refreshFunc.setBounds(200, 420, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaFuncionariosCadastrados);
			janela.add(cadastroFunc);
			janela.add(refreshFunc);
			janela.add(buscaFuncionario);
			janela.add(buscaFun);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			cadastroFunc.addActionListener(this);
			refreshFunc.addActionListener(this);
			buscaFun.addActionListener(this);
			listaFuncionariosCadastrados.addListSelectionListener(this);
			
			break;
		
		case 4: //VENDA
			ControleVenda cv = new ControleVenda();
			listaVendasCadastradas = new JList<String>(cv.getCodVenda());
			janela = new JFrame("Vendas");
			titulo = new JLabel("Vendas Cadastradas");
			refreshVenda = new JButton("Refresh");
			cadastroVenda = new JButton("Cadastro");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaVendasCadastradas.setBounds(20, 60, 350, 350);
			listaVendasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaVendasCadastradas.setVisibleRowCount(5);
			
			buscaVenda.setBounds(150, 40, 140, 17);
			buscaVen.setBounds(295, 40, 75, 17);

			cadastroVenda.setBounds(70, 420, 100, 30);
			refreshVenda.setBounds(200, 420, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(refreshVenda);
			janela.add(cadastroVenda);
			janela.add(listaVendasCadastradas);
			janela.add(buscaVenda);
			janela.add(buscaVen);

			janela.setSize(400, 500);
			janela.setVisible(true);

			cadastroVenda.addActionListener(this);
			refreshVenda.addActionListener(this);
			buscaVen.addActionListener(this);
			listaVendasCadastradas.addListSelectionListener(this); 
			
			break;
			
		case 5: //ESTOQUE
			ControleProduto cp2 = new ControleProduto();
			listaEstoque = new JList<String>(cp2.getNomeProduto());
			janela = new JFrame("Estoque");
			titulo = new JLabel("Selecione um produto");
			refreshEst = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaEstoque.setBounds(20, 60, 350, 350);
			listaEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaEstoque.setVisibleRowCount(5);
			
			refreshEst.setBounds(140, 420, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaEstoque);
			janela.add(refreshEst);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			refreshEst.addActionListener(this);
			listaEstoque.addListSelectionListener(this);
			
			break;
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		ControleProduto cp = new ControleProduto();
		ControleCliente cc = new ControleCliente();
		ControleFuncionario cf = new ControleFuncionario();
		ControleVenda cv = new ControleVenda();
		
		if(opcao == 1) {
			String s = (String) filtroProduto.getSelectedItem();
			
			switch (s) {
				case "Data":
					TelaDetalheProduto.opcFiltro = 0;
					listaProdutosCadastrados.setListData(cp.getProdutoN());
					listaProdutosCadastrados.updateUI();
					break;
				case "Pre�o Crescente":
					TelaDetalheProduto.opcFiltro = 1;
					listaProdutosCadastrados.setListData(cp.filtroProduto(1));
					listaProdutosCadastrados.updateUI();
					break;
				case "Pre�o Decrescente":
					TelaDetalheProduto.opcFiltro = 2;
					listaProdutosCadastrados.setListData(cp.filtroProduto(2));
					listaProdutosCadastrados.updateUI();
					break;
			}
		}
		
		if(src == cadastroProduto) {
			new TelaDetalheProduto().inserirEditar(1, 0);
		}
		
		if(src == refreshProduto) {
			listaProdutosCadastrados.setListData(cp.getNomeProduto());
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

		if(src == refreshEst) {
			listaEstoque.setListData(cp.getProdutoN());
			listaEstoque.updateUI();
		}
		
		if(src == cadastroVenda) {
			new TelaDetalheVenda().inserirEditar(1, 0);
		}
		
		if(src == refreshVenda) {
			listaVendasCadastradas.setListData(cv.getCodVenda());
			listaVendasCadastradas.updateUI();
		}
		
		if(src == buscaPro) {
			new TelaDetalheProduto().inserirEditar(2, Produto.produtoN.indexOf(buscaProduto.getText()));
		}
		
		if(src == buscaCli) {
			new TelaDetalheCliente().inserirEditar(2, Cliente.clienteN.indexOf(buscaCliente.getText()));
		}
		
		if(src == buscaFun) {
			new TelaDetalheFuncionario().inserirEditar(2, Funcionario.funcionarioN.indexOf(buscaFuncionario.getText()));
		}
		
		if(src == buscaVen) {
			new TelaDetalheVenda().inserirEditar(2, Venda.codigoVenda.indexOf(buscaVenda.getText()));
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
			
			if(e.getValueIsAdjusting() && src == listaEstoque) {
				new TelaDetalheEstoque().inserirEditar(listaEstoque.getSelectedIndex());
			}
			
			if(e.getValueIsAdjusting() && src == listaVendasCadastradas) {
				new TelaDetalheVenda().inserirEditar(2, listaVendasCadastradas.getSelectedIndex());
			}
		}
	
}
