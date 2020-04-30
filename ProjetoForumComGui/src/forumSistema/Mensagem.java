package forumSistema;
import java.util.ArrayList;

/***
 * 
*
* @author todos
* Classe base para outros tipos de postagens. Contém informações e métodos relacionados a autor, título, corpo de texto e reações.
*
*/

public class Mensagem {
	public String cargo;
	public String titulo;
	private String autor;	//quem escreveu a postagem, e igual a "anon" caso seja anonima
	private String corpo_texto;	//texto da postagem
	private Sistema sistema;

	private char avaliacao;	//char que representa a avaliacao do moderador, pode assumir 'p' (pendente), 'r' (reprovado), ou  'a' (aprovado)
	public ArrayList<Comentario> comentarios;	//comentarios
	///////////////////////////////////
	
	public Mensagem(Sistema s){
		this.cargo = null;
		this.autor = null;
		this.corpo_texto = null;
		this.avaliacao = 'p';
		this.comentarios = new ArrayList<Comentario>();
		this.sistema = s;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
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
	
	public static void main(String[] args) {


	}
}
