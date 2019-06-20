import java.util.Scanner;
import java.util.ArrayList;

public class Mensagem {
	private String autor;	//quem escreveu a postagem, e igual a "anon" caso seja anonima
	private String corpo_texto;	//texto da postagem
	private char avaliacao;	//char que representa a avaliacao do moderador, pode assumir 'p' (pendente), 'r' (reprovado), ou  'a' (aprovado)
	public ArrayList<Comentario> comentarios;	//comentarios
	///////////////////////////////////
	
	public Mensagem(){
		this.autor = null;
		this.corpo_texto = null;
		this.avaliacao = 'p';
		this.comentarios = new ArrayList<Comentario>();
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getCorpo_texto() {
		return corpo_texto;
	}
	public void setCorpo_texto(String corpo_texto) {
		this.corpo_texto = corpo_texto;
	}

	public char getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(char avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public void insereComentario(Comentario c){
		this.comentarios.add(c);
	}
	
	public Comentario criaComentario(){
		Scanner sc = new Scanner(System.in);
		Comentario novo = new Comentario();
		
		novo.setAutor(sc.nextLine());
		novo.setCorpo_texto(sc.nextLine());
		novo.setAvaliacao('p');
		
		sc.close();
		return novo;
	}
	
	public static void main(String[] args) {


	}
}
