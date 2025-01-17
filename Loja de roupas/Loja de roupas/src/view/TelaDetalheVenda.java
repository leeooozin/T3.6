package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCliente;
import controle.ControleFuncionario;
import controle.ControleProduto;
import controle.ControleVenda;
import controle.Validador;
import modelo.Cliente;
import modelo.Estoque;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;

/**
 * Respons�vel por mostrar a tela referente a venda de forma mais detalhada
 * @author Leo
 * @version 1.0 (Out 2021)
 */
public class TelaDetalheVenda implements ActionListener, ListSelectionListener {
	
	private JFrame janela = new JFrame();
	private JLabel titulo;
	private JLabel produto = new JLabel("Produto");
	private JLabel quantidade = new JLabel("Quantidade");
	private JLabel vendedor = new JLabel("Vendedor: ");
	private JLabel comprador = new JLabel("Comprador: ");
	private JLabel funcionario;
	private JLabel cliente;
	private JLabel preco;
	private JButton botaoExcluir = new JButton("Excluir");
	private JList<String> listaProdutosVendidos;
	private JList<String> listaClientesCadastrados;
	private JList<String> listaQuantidade;
	private JTextField cod;
	private JTextField qnt;
	private JButton botaoConcluir = new JButton("Concluir");
	private JButton botaoProximo = new JButton("Proximo");
	private JButton botaoAdicionar = new JButton("Adicionar");
	private JList<String> listaFuncionariosCadastrados;
	private JList<String> listaProdutosCadastrados;
	
	private static Double precofinal = 0.0;
	int posicao;
	int opcao;
	
	/**
	 * Faz a escolha de mostrar as informa��es da venda de forma mais detalhada ou cadastrar uma nova venda com base nos dois parametros
	 * @param op
	 * @param pos
	 */
	public void inserirEditar(int op, int pos) {
		
		opcao = op;
		posicao = pos;
		
		if(op == 1) { //Selecione um cliente
			ControleCliente cc = new ControleCliente();
			listaClientesCadastrados = new JList<String>(cc.getNomeCliente());
			titulo = new JLabel("Selecione um Cliente");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaClientesCadastrados.setBounds(20, 50, 350, 350);
			listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaClientesCadastrados.setVisibleRowCount(5);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaClientesCadastrados);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			listaClientesCadastrados.addListSelectionListener(this);
			
		}
		
		else if(op == 2) { //Mostra a nota
			ControleVenda cv = new ControleVenda();
			Venda v = new Venda();
			listaProdutosVendidos = new JList<String>(cv.getProVenda(pos));
			listaQuantidade = new JList<String>(cv.getQuantidade(pos));
			funcionario = new JLabel(v.getFuncionarioVenda(pos));
			cliente = new JLabel(v.getClienteVenda(pos));
			preco = new JLabel("R$ " + v.getPrecoFinal(pos));
			janela = new JFrame("Nota");
			titulo = new JLabel("NOTA");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			preco.setFont(new Font("Arial", Font.BOLD, 15));
			titulo.setBounds(165, 10, 250, 30);
			
			produto.setBounds(100, 50, 150, 25);
			quantidade.setBounds(290, 50, 150, 25);
			listaProdutosVendidos.setBounds(20, 90, 200, 200);
			listaQuantidade.setBounds(300, 90, 50, 200);
			
			vendedor.setBounds(30, 300, 150, 25);
			comprador.setBounds(30, 320, 150, 25);
			funcionario.setBounds(180, 300, 150, 25);
			cliente.setBounds(180, 320, 150, 25);
			
			preco.setBounds(150, 370, 250, 30);
			botaoExcluir.setBounds(130, 420, 115, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(produto);
			janela.add(quantidade);
			janela.add(listaProdutosVendidos);
			janela.add(listaQuantidade);
			janela.add(vendedor);
			janela.add(comprador);
			janela.add(funcionario);
			janela.add(cliente);
			janela.add(preco);
			janela.add(botaoExcluir);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			botaoExcluir.addActionListener(this);
		}
		
		if(op == 3) { //Selecione um funcionario
			ControleFuncionario cf = new ControleFuncionario();
			listaFuncionariosCadastrados = new JList<String>(cf.getNomeFuncionario());
			titulo = new JLabel("Selecione um Funcion�rio");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaFuncionariosCadastrados.setBounds(20, 50, 350, 350);
			listaFuncionariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaFuncionariosCadastrados.setVisibleRowCount(5);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaFuncionariosCadastrados);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			listaFuncionariosCadastrados.addListSelectionListener(this);
		}
		
		else if(op == 4) { //Selecione um produto
			ControleProduto cp = new ControleProduto();
			listaProdutosCadastrados = new JList<String>(cp.getNomeProduto());
			titulo = new JLabel("Selecione o Produto");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaProdutosCadastrados.setBounds(20, 50, 350, 350);
			listaProdutosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaProdutosCadastrados.setVisibleRowCount(5);
			
			botaoProximo.setBounds(130, 420, 115, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaProdutosCadastrados);
			janela.add(botaoProximo);
			
			janela.setSize(400, 500);
			janela.setVisible(true);
			
			botaoProximo.addActionListener(this);
			listaProdutosCadastrados.addListSelectionListener(this);
		}
		
		else if(op == 5) { //Adiciona a quantidade do produto selecionado
			titulo = new JLabel("Digite a Quantidade");
			qnt = new JTextField(25);
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			
			qnt.setBounds(90, 70, 180, 25);
			botaoAdicionar.setBounds(125, 120, 115, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(botaoAdicionar);
			janela.add(qnt);
			
			janela.setSize(400, 200);
			janela.setVisible(true);
			
			botaoAdicionar.addActionListener(this);
			
		}
		
		else if(op == 6) {
			titulo = new JLabel("Digite o C�digo da Venda");
			cod = new JTextField(25);
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			
			cod.setBounds(90, 70, 180, 25);
			botaoConcluir.setBounds(125, 120, 115, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(botaoConcluir);
			janela.add(cod);
			
			janela.setSize(400, 200);
			janela.setVisible(true);
			
			botaoConcluir.addActionListener(this);
		}
	}
	
	static ArrayList<String> auxiliar = new ArrayList<String>();
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		Venda v = new Venda();
		Produto p = new Produto();
		Validador va = new Validador();
		
		if(src == botaoExcluir) {
			v.delVenda(posicao);
			janela.dispose();
		}
		
		if(src == botaoProximo) {
			auxiliar.add(Double.toString(precofinal));
			precofinal = 0.0;
			Venda.vendas.add((ArrayList<String>) auxiliar.clone());
			auxiliar.clear();
			new TelaDetalheVenda().inserirEditar(6, 0);
			janela.dispose();
		}
		
		if(src == botaoAdicionar) {
			if(va.validaQuantidade(Integer.valueOf(qnt.getText()).intValue(), posicao)) {
				int quantidade = Estoque.estoque.get(posicao) - Integer.valueOf(qnt.getText()).intValue();
				precofinal = (p.getPreco(posicao) * Integer.valueOf(qnt.getText()).intValue()) + precofinal;
				auxiliar.add(Produto.produtoN.get(posicao));
				auxiliar.add(qnt.getText());
				Estoque.estoque.set(posicao, quantidade);
				quantidade = 0;
			} else {
				JOptionPane.showMessageDialog(null,"N�o existe quantidade suficiente desse produto", null, 
						JOptionPane.ERROR_MESSAGE);
			}
			janela.dispose();
		}
		
		if(src == botaoConcluir) {
			Venda.codigoVenda.add(cod.getText());
			janela.dispose();
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
			auxiliar.add(Cliente.clienteN.get(listaClientesCadastrados.getSelectedIndex()));
			new TelaDetalheVenda().inserirEditar(3, listaClientesCadastrados.getSelectedIndex());
			janela.dispose();
		}
		
		if(e.getValueIsAdjusting() && src == listaFuncionariosCadastrados) {
			auxiliar.add(Funcionario.funcionarioN.get(listaFuncionariosCadastrados.getSelectedIndex()));
			new TelaDetalheVenda().inserirEditar(4, listaFuncionariosCadastrados.getSelectedIndex());
			janela.dispose();
		}
		
		if(e.getValueIsAdjusting() && src == listaProdutosCadastrados) {
			new TelaDetalheVenda().inserirEditar(5, listaProdutosCadastrados.getSelectedIndex());
		}
	}
	
}
