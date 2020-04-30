package forumSistema;
import java.util.Map;
import java.util.Scanner;

 /***
*
* @author todos
* Este é a classe motor do sistema do nosso fórum. Seus atributos são relativos às postagens existentes,
* postagens pendentes para aprovação, lista de usuários comuns e lista de usuários moderadores. Serve como r
* eferência e parâmetro para o funcionamento base de virtualmente todos os outros métodos, e possui métodos próprios
* importantes como o de atualização dos usuários bem como de postagens, e de mensagens automáticas via arquivos csv.
*
*/

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
	
	public String criaPostagemPublica(Sistema s, String autor, String CorpoTexto, String titulo){
		this.setAutor(autor);
		this.setCorpo_texto(CorpoTexto);
		this.setTitulo(titulo);
		
		this.setAvaliacao('p');
		
		this.getSistema().getPendentes().add(this);
		return 	this.enviaMensagemAutomatica();
	}

	public void criaPostagemPublica(Sistema s, String autor, String CorpoTexto, String titulo, String cargo){
		this.setAutor(autor);
		this.setCorpo_texto(CorpoTexto);
		this.setCargo(cargo);
		this.setTitulo(titulo);
		
		this.setAvaliacao('p');
		
		this.getSistema().getPostagens().add(this);
		
	}
	
	public String enviaMensagemAutomatica(){
		for(Map.Entry<String, String> i : this.getSistema().getMensagensAutomaticas().entrySet()){
			if(this.getCorpo_texto().contains(i.getKey())){
				return i.getValue();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}