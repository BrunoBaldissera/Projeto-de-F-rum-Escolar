package forumSistema;
import java.io.IOException;

import Forum.gui.*;

public class Main {

	public static void main(String[] args) throws IOException {
	
		
		Sistema s = new Sistema();
		s.leUsuarios();
		s.criaMensagensAutomaticas();
		s.criaPostagensArquivo();

		frameLogin frame = new frameLogin(s);
		frame.setVisible(true);
	}

}
