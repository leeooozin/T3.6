package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.Validador;
import modelo.Cliente;

/**
 * Respons�vel por mostrar a tela referente ao cliente de forma mais detalhada
 * @author Leo
 * @version 1.0 (Out 2021)
 */
public class TelaDetalheCliente implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelCPF = new JLabel("CPF: ");
	private JTextField valorCPF;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField valorTelefone;
	private JLabel labelEmail = new JLabel("Email: ");
	private JTextField valorEmail;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String s;
	
	int posicao;
	int opcao;
	
	/**
	 * Faz a escolha de mostrar as informa��es do cliente de forma mais detalhada ou cadastrar um novo cliente com base nos dois parametros
	 * @param op
	 * @param pos
	 */
	public void inserirEditar(int op, int pos) {
		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Detalhe de Cliente";
		janela = new JFrame(s);
		Cliente c = new Cliente();
		
		opcao = op;
		posicao = pos;
		
		if (op == 1) { //Sem dados
			valorNome = new JTextField(25);
			valorCPF = new JTextField(25);
			valorTelefone = new JTextField(25);
			valorEmail = new JTextField(25);
		}
		
		else if (op == 2) { //Com dados
			valorNome = new JTextField(c.getNome(pos), 25);
			valorCPF = new JTextField(c.getCPF(pos), 25);
			valorTelefone = new JTextField(c.getTelefone(pos), 25);
			valorEmail = new JTextField(c.getEmail(pos), 25);
			
			botaoExcluir.setBounds(65, 420, 115, 30);
			janela.add(botaoExcluir);
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelCPF.setBounds(30, 50, 150, 25);
		valorCPF.setBounds(180, 50, 180, 25);
		labelTelefone.setBounds(30, 80, 150, 25);
		valorTelefone.setBounds(180, 80, 180, 25);		
		labelEmail.setBounds(30, 110, 150, 25);
		valorEmail.setBounds(180, 110, 180, 25);
		
		botaoSalvar.setBounds(190, 420, 115, 30);
		
		janela.add(labelNome);
		janela.add(valorNome);
		janela.add(labelCPF);
		janela.add(valorCPF);
		janela.add(labelTelefone);
		janela.add(valorTelefone);
		janela.add(labelEmail);
		janela.add(valorEmail);
		
		janela.add(botaoSalvar);
		
		janela.setLayout(null);
		
		janela.setSize(400, 500);
		janela.setVisible(true);
		
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		Cliente c = new Cliente();
		Validador v = new Validador();
		
		if(src == botaoSalvar) {
			if(opcao == 1) { //Novo
				if(v.validaCPF(valorCPF.getText()) && v.validaEmail(valorEmail.getText()) && v.validaTelefone(valorTelefone.getText())) {
					Cliente.clienteN.add(valorNome.getText());
					Cliente.clienteC.add(valorCPF.getText());
					Cliente.clienteT.add(valorTelefone.getText());
					Cliente.clienteE.add(valorEmail.getText());
				} else {
					JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
							+ "Pode ter ocorrido um dos erros a seguir:  \n"
							+ "1. Nem todos os campos foram preenchidos \n"
							+ "2. CPF, Telefone n�o cont�m apenas n�meros \n"
							+ "3. Email inv�lido", null, 
							JOptionPane.ERROR_MESSAGE);
				}
				janela.dispose();
			}
			if(opcao == 2) { //Editar
				c.editNome(c.getNome(posicao), valorNome.getText());
				c.editCPF(c.getCPF(posicao), valorCPF.getText());
				c.editTelefone(c.getTelefone(posicao), valorTelefone.getText());
				c.editEmail(c.getEmail(posicao), valorEmail.getText());
			}
			janela.dispose();
		}
		
		if(src == botaoExcluir) {
			c.delCliente(c.getCPF(posicao));
			janela.dispose();
		}
	}
}
