import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioModerador extends Usuario{
	public String cargo;
	private ArrayList<Mensagem> pendentes;

	///////////////////////////////
	
	public UsuarioModerador(){
		super();
		Scanner sc= new Scanner(System.in);
		this.cargo = sc.nextLine();
		sc.close();
		
		this.pendentes = new ArrayList<Mensagem>();
	}
	
	public ArrayList<Mensagem> getPendentes() {
		return pendentes;
	}
	public void setPendentes(ArrayList<Mensagem> pendentes) {
		this.pendentes = pendentes;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void classificaMensagem(Mensagem m){
		Scanner sc = new Scanner(System.in);
		m.setAvaliacao(sc.next().charAt(0));
		sc.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
