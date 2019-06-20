import java.util.Scanner;

public class PostagemPublica extends Mensagem{
	
	private String[] tags;	//cada posicao e uma palavras-chave da postagem (e.g. Desabafo)
	private int reacoes;	//curtidas

	////////////////////////////////

	public PostagemPublica(){
		super();
		this.tags = new String[50];
		this.reacoes = 0;
	}
	
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public int getReacoes() {
		return reacoes;
	}
	public void setReacoes(int reacoes) {
		this.reacoes = reacoes;
	}
	
	public PostagemPublica criaPostagemPublica(){
		Scanner sc = new Scanner(System.in);
		PostagemPublica p = new PostagemPublica();
		
		p.setAutor(sc.nextLine());
		p.setCorpo_texto(sc.nextLine());
		p.setAvaliacao('p');
		
		sc.close();
		return p;
	}
	
	//colocar na classe usuario
	public void Comenta(PostagemPublica original){
		Comentario novo = criaComentario();
		novo.setCamada(1);
		
		insereComentario(novo);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
