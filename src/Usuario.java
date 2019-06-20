import java.util.Scanner;

public class Usuario{
	private String nome;	//nome do usuario (pode haver mais de um usuario com o mesmo nome)
	private String id;		//identificador (�nico)
	int cred_atividade;		//indica a atividade do usuario (quanto mais alto mais envolvimento com o forum)
	//////////////////////////////
	
	public Usuario(){
		Scanner sc = new Scanner(System.in);
		this.nome = sc.nextLine();
		//rever logica do id
		this.id = sc.nextLine();
		this.cred_atividade = 0;
		sc.close();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCred_atividade() {
		return cred_atividade;
	}
	public void setCred_atividade(int cred_atividade) {
		this.cred_atividade = cred_atividade;
	}
	
	
}
