import java.util.ArrayList;

public class Sistema {
	public ArrayList<Mensagem> postagens;
	public ArrayList<Usuario> usuarios;
	public ArrayList<UsuarioModerador> moderadores;
	
	private ArrayList<Mensagem> pendentes;
	/////////////////////////////////////////////////
	
	public Sistema(){
		this.postagens = new ArrayList<Mensagem>();
		this.usuarios = new ArrayList<Usuario>();
		this.moderadores = new ArrayList<UsuarioModerador>();
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<Mensagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(ArrayList<Mensagem> postagens) {
		this.postagens = postagens;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void aprovaMensagem(Mensagem m){
		this.postagens.add(m);
		this.pendentes.remove(m);
	}
	
	public void reprovaMensagem(Mensagem m){
		this.pendentes.remove(m);
	}
	
	public ArrayList<UsuarioModerador> getModeradores() {
		return moderadores;
	}

	public void setModeradores(ArrayList<UsuarioModerador> moderadores) {
		this.moderadores = moderadores;
	}

	public ArrayList<Mensagem> getPendentes() {
		return pendentes;
	}

	public void setPendentes(ArrayList<Mensagem> pendentes) {
		this.pendentes = pendentes;
	}

	public void imprimePostagens(){
		for(Mensagem i : this.postagens){
			System.out.println(i.getAutor() + ":");
			System.out.println(i.getCorpo_texto());

			System.out.println("\n\n");
		}
	}
	
	public Usuario estaNoSistema(String nome, String id){
		for(Usuario i : this.getUsuarios()){
			if(i.getNome().equals(nome)){
				if(i.getId().equals(id)) return i;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
