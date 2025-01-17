package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.ControleProduto;
import controle.Validador;
import modelo.Estoque;
import modelo.Produto;

/**
 * Respons�vel por mostrar a tela referente ao produto de forma mais detalhada
 * @author Leo
 * @version 1.0 (Out 2021)
 */
public class TelaDetalheProduto implements ActionListener {
	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelPreco = new JLabel("Pre�o: ");
	private JTextField valorPreco;
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField valorMarca;
	private JLabel labelGen = new JLabel("G�nero: ");
	private JTextField valorGen;
	private JLabel labelCat = new JLabel("Categoria: ");
	private JTextField valorCat;
	private JLabel labelCod = new JLabel("C�digo: ");
	private JTextField valorCod;
	private JLabel labelDes = new JLabel("Descri��o: ");
	private JTextArea valorDes;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String s;
	
	static int opcFiltro = 0;
	int posicao;
	int opcao;
	
	/**
	 * Faz a escolha de mostrar as informa��es do produto de forma mais detalhada ou cadastrar um novo produto com base nos dois parametros
	 * @param op
	 * @param pos
	 */
	public void inserirEditar(int op, int pos) {
		if (op == 1) s = "Cadastro de Produto";
		if (op == 2) s = "Detalhe de Produto";
		janela = new JFrame(s);
		Produto p = new Produto();
		ControleProduto cp = new ControleProduto();
		
		switch(opcFiltro) {
			case 1:
				String[] s1 = new String[Produto.produtoN.size()];
				s1 = cp.filtroProduto(1).clone();
				if(s1[pos] != Produto.produtoN.get(pos)) {
					for(int i = 0; i < Produto.produtoN.size(); i++) {
						if(s1[pos] == Produto.produtoN.get(i)) {
							pos = i;
							break;
						}
					}
				}
				break;
			case 2:
				String[] s2 = new String[Produto.produtoN.size()];
				s2 = cp.filtroProduto(2).clone();
				if(s2[pos] != Produto.produtoN.get(pos)) {
					for(int i = 0; i < Produto.produtoN.size(); i++) {
						if(s2[pos] == Produto.produtoN.get(i)) {
							pos = i;
							break;
						}
					}
				}
				break;
		}
		
		
		opcao = op;
		posicao = pos;
		
		if (op == 1) { //Sem dados
			valorNome = new JTextField(25);
			valorPreco = new JTextField(25);
			valorMarca = new JTextField(25);
			valorGen = new JTextField(25);
			valorCat = new JTextField(25);
			valorCod = new JTextField(5);
			valorDes = new JTextArea();
			
		}
		
		else if (op == 2) { //Com dados
			valorNome = new JTextField(p.getNome(pos), 25);
			valorPreco = new JTextField(String.valueOf(p.getPreco(pos)), 25);
			valorMarca = new JTextField(p.getMarca(pos), 25);
			valorGen = new JTextField(p.getGenero(pos), 25);
			valorCat = new JTextField(p.getCategoria(pos), 25);
			valorCod = new JTextField(p.getCodigo(pos), 5);
			valorDes = new JTextArea(p.getDesc(pos));
			
			botaoExcluir.setBounds(65, 420, 115, 30);
			janela.add(botaoExcluir);
			
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelPreco.setBounds(30, 50, 150, 25);
		valorPreco.setBounds(180, 50, 180, 25);
		labelMarca.setBounds(30, 80, 150, 25);
		valorMarca.setBounds(180, 80, 180, 25);		
		labelGen.setBounds(30, 110, 150, 25);
		valorGen.setBounds(180, 110, 180, 25);
		labelCat.setBounds(30, 140, 150, 25);
		valorCat.setBounds(180, 140, 180, 25);
		labelCod.setBounds(30, 170, 150, 25);
		valorCod.setBounds(180, 170, 180, 25);
		labelDes.setBounds(30, 200, 150, 25);
		valorDes.setBounds(180, 200, 180, 200);
		
		botaoSalvar.setBounds(190, 420, 115, 30);
		
		janela.add(labelNome);
		janela.add(valorNome);
		janela.add(labelPreco);
		janela.add(valorPreco);
		janela.add(labelMarca);
		janela.add(valorMarca);
		janela.add(labelGen);
		janela.add(valorGen);
		janela.add(labelCat);
		janela.add(valorCat);
		janela.add(labelCod);
		janela.add(valorCod);
		janela.add(labelDes);
		janela.add(valorDes);
		
		janela.add(botaoSalvar);
		
		janela.setLayout(null);
		
		valorDes.setLineWrap(true);
		valorDes.setWrapStyleWord(true);
		
		janela.setSize(400, 500);
		janela.setVisible(true);
		
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		Produto p = new Produto();
		Validador v = new Validador();
		
		if(src == botaoSalvar) {	
			if(opcao == 1) { //Novo
				if(v.validaPreco(Double.valueOf(valorPreco.getText()).doubleValue())) {
					Produto.produtoN.add(valorNome.getText());
					Produto.produtoCo.add(valorCod.getText());
					Produto.produtoP.add(Double.valueOf(valorPreco.getText()).doubleValue());
					Produto.produtoM.add(valorMarca.getText());
					Produto.produtoD.add(valorDes.getText());
					Produto.produtoCa.add(valorCat.getText());
					Produto.produtoG.add(valorGen.getText());
					Estoque.estoque.add(0);
				} else {
					JOptionPane.showMessageDialog(null,"Pre�o Inv�lido!", null, 
							JOptionPane.ERROR_MESSAGE);
				}
			}
			if(opcao == 2) { //Editar
				p.editNome(p.getNome(posicao), valorNome.getText());
				p.editCodigo(p.getCodigo(posicao), valorCod.getText());
				p.editPreco(p.getPreco(posicao), Double.valueOf(valorPreco.getText()).doubleValue());
				p.editMarca(p.getMarca(posicao), valorMarca.getText());
				p.editDesc(p.getDesc(posicao), valorDes.getText());
				p.editCategoria(p.getCategoria(posicao), valorCat.getText());
				p.editGenero(p.getGenero(posicao), valorGen.getText());
			}
			janela.dispose();
		}
		
		if(src == botaoExcluir) {
			p.delProduto(p.getCodigo(posicao));
			janela.dispose();
		}
	}
}