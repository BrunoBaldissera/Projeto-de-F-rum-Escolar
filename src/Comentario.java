
public class Comentario extends Mensagem{
	public int camada;	//representa em que subcontexto da postagem original esta o comentario. (e.g. vale 2 se for um comentario de comentario)
	private Comentario[] comentarios;	//comentarios da postagem
	
	public int getCamada() {
		return camada;
	}
	public void setCamada(int camada) {
		this.camada = camada;
	}
	
	public Comentario[] getComentario() {
		return comentarios;
	}
	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}
}
