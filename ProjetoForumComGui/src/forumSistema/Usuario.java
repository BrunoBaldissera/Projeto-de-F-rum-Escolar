package forumSistema;
import java.util.Scanner;

/***
*
* @author todos
* Usuário comum do fórum, pode fazer postagens que devem
* ser aprovadas pelo moderador primeiro.
*
*/

public class Usuario{
	private String nome;	//nome do usuario (pode haver mais de um usuario com o mesmo nome)
	private String id;		//identificador (�nico)
	public int cred_atividade;		//indica a atividade do usuario (quanto mais alto mais envolvimento com o forum)
	public Sistema sistema;
	
	//////////////////////////////
	
	public Usuario(Sistema s, String nome, String id){
		this.nome = nome;
		this.id = id;
		
		this.cred_atividade = 0;
		this.sistema = s;
		this.sistema.getUsuarios().add(this);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCred_atividade() {
		return cred_atividade;
	}
	public void setCred_atividade(int cred_atividade) {
		this.cred_atividade = cred_atividade;
	}
	
	public void Comenta(Comentario original, Scanner sc){
		Comentario novo = new Comentario(this.sistema);
		novo.criaComentario(this.nome, this.sistema, sc);
		novo.setCamada(original.getCamada() + 1);
		
		original.insereComentario(novo);
	}
	
	public void Comenta(PostagemPublica original, Scanner sc){
		Comentario novo = new Comentario(this.sistema);
		novo.criaComentario(this.nome, this.sistema, sc);
		novo.setCamada(1);
		
		original.insereComentario(novo);
	}
	
	public Mensagem escolheMensagem(Scanner sc){		
		int cont = 1;
		char esc;
		System.out.println("\t//////////////////////////////");
		for(Mensagem i : this.sistema.getPostagens()){
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
}
