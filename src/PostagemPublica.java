
public class PostagemPublica extends Mensagem{
	
	private String[] tags;	//cada posicao e uma palavras-chave da postagem (e.g. Desabafo)
	private int reacoes;	//curtidas
	private Comentario[] comentarios;	//comentarios da postagem
	
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

	public Comentario[] getComentarios() {
		return comentarios;
	}
	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
