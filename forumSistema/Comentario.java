package forumSistema;
import java.util.Scanner;


public class Comentario extends Mensagem{
	public int camada;	//representa em que subcontexto da postagem original esta o comentario. (e.g. vale 2 se for um comentario de comentario)
	public int reacao;
	
	/////////////////////////////
	public Comentario(Sistema s){
		super(s);
		this.camada = -1;
		this.reacao = 0;
	}
	
	public int getCamada() {
		return camada;
	}
	
	public void setCamada(int camada) {
		this.camada = camada;
	}
	
	public void criaComentario(String autor, Sistema s, Scanner sc){		
		this.setAutor(autor);
		
		System.out.println("Insira aqui seu texto");
		this.setCorpo_texto(sc.nextLine());
		this.setAvaliacao('p');
	}
	
}
