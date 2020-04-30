package forumSistema;
import java.util.Scanner;

/***
*
* @author todos
* Usuário com permissões de postagem direta ao fórum e que pode aprovar
* postagens vindouras de usuários comuns, de forma a exercer moderação no fórum.
*
*/

public class UsuarioModerador extends Usuario{
	public String cargo;

	///////////////////////////////
	
	public UsuarioModerador(Sistema s, String nome, String id, String cargo){
		super(s, nome, id);
		this.sistema.getUsuarios().remove(this);
		this.cargo = cargo;
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
