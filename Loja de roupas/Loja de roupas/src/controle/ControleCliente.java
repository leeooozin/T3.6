package controle;

import java.util.ArrayList;
import modelo.Cliente;

public class ControleCliente {
	public ArrayList<String> cc = new ArrayList<String>();
	
	public String[] getNomeCliente() {
		for(int i = 0; i < Cliente.clienteN.size(); i++) {
			cc.add(Cliente.clienteN.get(i));
		}

		String[] s = new String[cc.size()];
		for(int i = 0; i < cc.size(); i++) {
			s[i] = cc.get(i);
		}
		
		return s;
	}
	
	public String[] getClienteN() {
		String[] s = new String[Cliente.clienteN.size()];
		for(int i = 0; i < Cliente.clienteN.size(); i++) {
			s[i] = Cliente.clienteN.get(i);
		}
		
		return s;
	}
}