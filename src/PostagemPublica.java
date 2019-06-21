import java.util.Map;
import java.util.Scanner;

public class PostagemPublica extends Mensagem{
	private String[] tags;	//cada posicao e uma palavras-chave da postagem (e.g. Desabafo)
	public int reacoes;	//curtidas

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
	public void criaPostagemPublica(String autor, Sistema s, Scanner sc){
		
		this.setAutor(autor);
		
		System.out.println("Insira aqui o texto");
		String temp = sc.nextLine();
		this.setCorpo_texto(temp);
		
		this.setAvaliacao('p');
		
	}
	
	public void enviaMensagemAutomatica(){
		for(Map.Entry<String, String> i : this.getSistema().getMensagensAutomaticas().entrySet()){
			if(this.getCorpo_texto().contains(i.getKey())){
				System.out.println(i.getValue());
			}
		}
	}
	
	public void submetePostagem(String autor, Sistema s, Scanner sc){
		PostagemPublica p = new PostagemPublica(s);
		p.criaPostagemPublica(autor, s, sc);
		
		p.enviaMensagemAutomatica();
		this.getSistema().getPendentes().add(p);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}