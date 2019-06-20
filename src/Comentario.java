
public class Comentario extends Mensagem{
	public int camada;	//representa em que subcontexto da postagem original esta o comentario. (e.g. vale 2 se for um comentario de comentario)

	/////////////////////////////
	public Comentario(){
		super();
		this.camada = -1;
		}
	
	public int getCamada() {
		return camada;
	}
	public void setCamada(int camada) {
		this.camada = camada;
	}
	
	//colocar na classe usuario
	public void Comenta(Comentario original){
		Comentario novo = criaComentario();
		novo.setCamada(original.getCamada() + 1);
		
		insereComentario(novo);
	}
	
}
