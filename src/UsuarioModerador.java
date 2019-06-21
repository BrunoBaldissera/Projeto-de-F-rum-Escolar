import java.util.Scanner;

public class UsuarioModerador extends Usuario{
	public String cargo;

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
	
	public Mensagem escolheMensagemAvaliar(Scanner sc){
		int cont = 1;
		char esc;
		System.out.println("\t//////////////////////////////");
		for(Mensagem i : this.sistema.getPendentes()){
			System.out.println("Número da postagem: " + cont);
			System.out.println(i.getAutor() + ":");
			System.out.println(i.getCorpo_texto());
			if (i instanceof PostagemPublica) System.out.println("+" + ((PostagemPublica) i).getReacoes());
			
			System.out.println("\n");
			System.out.println("Digite 'e' para escolher esta mensagem, e 'n' caso contrário");
			esc = sc.nextLine().charAt(0);
			if(esc == 'e') return i;
			cont++;
		}
		System.out.println("\t//////////////////////////////");
		return null;
	}
	
	public void classificaMensagem(Mensagem m, Scanner sc) {		
		System.out.println("Insira 'a' para aprovar ou 'r' para reprovar");
		m.setAvaliacao(sc.nextLine().charAt(0));
		
		if (m.getAvaliacao() == 'a'){
			this.sistema.aprovaMensagem(m);
		}
		if (m.getAvaliacao() == 'r'){
			this.sistema.reprovaMensagem(m);
		}
	}
	
	public void imprimePendentes(){
		int cont = 0;
		for(Mensagem i : this.sistema.getPendentes()){
			System.out.println("Número da postagem: " + cont);
			System.out.println(i.getAutor() + ":");
			System.out.println(i.getCorpo_texto());
			if (i instanceof PostagemPublica) System.out.println("+" + ((PostagemPublica) i).getReacoes());
			
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
