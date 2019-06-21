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
					System.out.println("Você é moderador(a)?\n Se sim pressione 's', caso contrário 'n'");
					op = sc.nextLine().charAt(0);
					
					if (op == 's') u = new UsuarioModerador(s, sc);
					else u = new Usuario(s, sc);
				}
				continue;
			}
			do {
				System.out.println("Olá " + u.getNome() + "!");
				s.imprimePostagens();
				System.out.println("Para fazer uma postagem, digite 'p'");
				System.out.println("Para fazer um comentario, digite 'c'");
				System.out.println("Para deslogar, pressione 'x'");
				
				if(u instanceof UsuarioModerador){
					System.out.println("Mensagens pendentes:\n");
					((UsuarioModerador) u).imprimePendentes();
					System.out.println("Para avaliar uma postagem, digite 'a'");
				}
				
				op = sc.nextLine().charAt(0);
				switch (op){
					case 'p': {
						PostagemPublica p = new PostagemPublica(s);
						p.submetePostagem(u.getNome(), s, sc);
						break;
					}
					case 'a': {
						if (u instanceof UsuarioModerador){
							Mensagem m = ((UsuarioModerador) u).escolheMensagemAvaliar(sc);
							if (m != null) ((UsuarioModerador) u).classificaMensagem(m, sc);
						}
						else System.out.println("Acesso negado");
						break;
					}
					case 'c': {
						Mensagem m = u.escolheMensagem(sc);
						
						if(m instanceof PostagemPublica){
							u.Comenta((PostagemPublica) m, sc);
						}
						else if(m instanceof Comentario){
							u.Comenta((Comentario) m, sc);
						}
						
						break;
					}
					
					case 'x' : {
						System.out.println("Até mais," + u.getNome() + "!");
					}
					
					default : {
						System.out.println("Opção inválida, tente novamente");
					}
					
				}
		
			}while(op != 'x');
		}while(true);
		sc.close();
		
		System.out.println();
		
		System.out.println("Programa encerrado");
	}

}
