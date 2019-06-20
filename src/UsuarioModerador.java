import java.util.Scanner;

public class UsuarioModerador extends Usuario{
	public String cargo;
	public Sistema sistema;

	///////////////////////////////
	
	public UsuarioModerador(Sistema s, Scanner sc){
		super(s, sc);
		System.out.println("Insira seu cargo como moderador(a)");
		this.cargo = sc.nextLine();
		this.sistema.moderadores.add(this);
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void classificaMensagem(Mensagem m) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira 'a' para aprovar ou 'r' para reprovar");
		m.setAvaliacao(sc.next().charAt(0));
		
		if (m.getAvaliacao() == 'a'){
			this.sistema.aprovaMensagem(m);
		}
		if (m.getAvaliacao() == 'r'){
			this.sistema.reprovaMensagem(m);
		}
		
		sc.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
