import java.util.Scanner;

public class Usuario{
	private String nome;	//nome do usuario (pode haver mais de um usuario com o mesmo nome)
	private String id;		//identificador (�nico)
	public int cred_atividade;		//indica a atividade do usuario (quanto mais alto mais envolvimento com o forum)
	public Sistema sistema;
	
	//////////////////////////////
	
	public Usuario(Sistema s, Scanner sc){
		System.out.println("Insira aqui seu nome de usuário");
		this.nome = sc.nextLine();

		System.out.println("Insira aqui sua senha");
		this.id = sc.nextLine();
		
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
	
	public void Comenta(Comentario original){
		Comentario novo = new Comentario(this.sistema);
		novo = novo.criaComentario(this.nome, this.sistema);
		novo.setCamada(original.getCamada() + 1);
		
		original.insereComentario(novo);
	}
	
	public void Comenta(PostagemPublica original){
		Comentario novo = new Comentario(this.sistema);
		novo = novo.criaComentario(this.nome, this.sistema);
		novo.setCamada(1);
		
		original.insereComentario(novo);
	}
	
	
}
