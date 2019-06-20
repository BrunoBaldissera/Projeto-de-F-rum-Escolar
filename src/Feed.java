import java.util.ArrayList;

public class Feed {
	public ArrayList<Mensagem> publicacoes;
	
	public Feed(){
		this.publicacoes = new ArrayList<Mensagem>();
	}
	
	public void atualizaFeed(UsuarioModerador u, Mensagem m){
		for(Mensagem i : this.publicacoes){
			if (i.getAvaliacao() == 'a') this.publicacoes.add(i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
