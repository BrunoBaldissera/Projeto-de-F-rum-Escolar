import java.util.Scanner;

public class PostagemPublica extends Mensagem{
	
	private String[] tags;	//cada posicao e uma palavras-chave da postagem (e.g. Desabafo)
	private int reacoes;	//curtidas

	////////////////////////////////

	public PostagemPublica(Sistema s){
		super(s);
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
	
	public PostagemPublica criaPostagemPublica(String autor, Sistema s){
		Scanner sc = new Scanner(System.in);
		PostagemPublica p = new PostagemPublica(s);
		
		
		p.setAutor(autor);
		
		System.out.println("Insira aqui o texto");
		p.setCorpo_texto(sc.nextLine());
		p.setAvaliacao('p');
		
		sc.close();
		return p;
	}
	
	public void submetePostagem(String autor, Sistema s){
		PostagemPublica p = new PostagemPublica(s);
		p = p.criaPostagemPublica(autor, s);
		
		this.getSistema().getPendentes().add(p);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
