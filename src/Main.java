import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		
		Sistema s = new Sistema();
		char op;
		Scanner sc = new Scanner(System.in);

		do{
			System.out.println("Seja bem-vindo(a) ao fórum! Por favor insira seus dados para continuar (para sair pressione 'x')");
			System.out.println("Nome de usuário:");
	
			String usuario;
			String senha;
			usuario = sc.nextLine();
			
			if(usuario.equals("x")) break;
			
			System.out.println("Senha:");
			senha = sc.nextLine();
			
			Usuario u = s.estaNoSistema(usuario, senha);
			if(u == null){
				System.out.println("O usuário não consta nos registros, quer criar uma conta? Pressione 's' para criar e 'n' caso contrário");
				op = sc.nextLine().charAt(0);
				if (op == 's'){
					u = new Usuario(s, sc);
				}
				continue;
			}
			else {
				System.out.println("Olá " + u.getNome() + "!");
		
			}
			op = 'x';
		}while(op != 'x');
		sc.close();
		
		System.out.println();
		
		System.out.println("Até mais!");
	}

}
