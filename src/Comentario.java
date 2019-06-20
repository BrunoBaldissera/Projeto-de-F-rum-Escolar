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
	
	public Comentario criaComentario(String autor, Sistema s){
		Scanner sc = new Scanner(System.in);
		Comentario novo = new Comentario(s);
		
		novo.setAutor(autor);
		
		System.out.println("Insira aqui seu texto");
		novo.setCorpo_texto(sc.nextLine());
		novo.setAvaliacao('p');
		
		sc.close();
		return novo;
	}
	
}
