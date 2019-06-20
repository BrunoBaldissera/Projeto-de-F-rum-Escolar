import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String usuario;
		String senha;
		Scanner sc = new Scanner(System.in);
		
		char op;
		do{
			System.out.println("Seja bem-vindo(a) ao fórum! Por favor insira seus dados para continuar");
			System.out.println("Nome de usuário:");
			usuario = sc.nextLine();
			System.out.println(usuario);
			
			System.out.println("Senha:");
			senha = sc.nextLine();
			System.out.println(senha);
			
			op = 's';
		}while(op != 's');
		
		sc.close();
	}

}
