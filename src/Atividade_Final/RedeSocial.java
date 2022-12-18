package Atividade_Final;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class RedeSocial {

	Scanner scan = new Scanner(System.in);
	String opcoes;
	ArrayList<Usuario> usuariosRede = new ArrayList<Usuario>();
	ArrayList<Postagem> todasPostagens = new ArrayList<Postagem>();
	Calendar data = Calendar.getInstance();
	
	public RedeSocial() {
		usuariosRede.add(new Usuario("Bruno", "teste1", "teste1"));
		usuariosRede.add(new Usuario("Alan", "teste2", "teste2"));
		usuariosRede.add(new Usuario("Willian", "teste3", "teste3"));
		
		fazerPostagem(0, dataAtual(), horaAtual(), "O Códing Tank foi bem divertido pessoal, espero encontra-los em futuros modulos.", todasPostagens);
		fazerPostagem(1, dataAtual(), horaAtual(), "Enfim o primeiro modulo dos futuros programadores java backend da Sinqia acabou, espero que todos tenham gostado do modulo e torço para dar aula novamente para vocês! PS: Continuem com essas conversas diárias, são bem legais e produtivas hahahah", todasPostagens);
		fazerPostagem(2, dataAtual(), horaAtual(), "Estou aproveitando minha viagem, não me chamem para ajuda-los hahaha Brincadeiras a parte, sei que todos conseguem!", todasPostagens);
		fazerPostagem(2, dataAtual(), horaAtual(), "Minha viagem está sendo TOPPPP !", todasPostagens);
		
		usuariosRede.get(0).seguirUsuario(0, 1, usuariosRede.get(1));
		usuariosRede.get(1).seguirUsuario(1, 0, usuariosRede.get(0));
		usuariosRede.get(1).seguirUsuario(1, 2, usuariosRede.get(2));
		usuariosRede.get(2).seguirUsuario(2, 0, usuariosRede.get(0));
		usuariosRede.get(2).seguirUsuario(2, 1, usuariosRede.get(1));
		
		comentarPostagem(0, 1, dataAtual(), horaAtual(), "Essa turminha é incrivel, que venha os próximos modulos!!", todasPostagens);
		comentarPostagem(1, 1, dataAtual(), horaAtual(), "Realmente, gostei muito dessa turma!!", todasPostagens);
		comentarPostagem(0, 2, dataAtual(), horaAtual(), "Certeza que eles conseguem, mas queria muito que te mandassem msg, só porque fez inveja com a viagem hahahahahaha", todasPostagens);
		
		telaInicial();
	}
	
	void telaInicial() {
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t Bem-Vindo a DevMakers - A Rede Social dos Desenvolvedores \t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*  Opção 1 - Efetuar Login                                                                              *");
		System.out.println("\t*  Opção 2 - Cadastrar Usuario                                                                          *");
		System.out.println("\t*  Opção 3 - Fechar                                                                                     *");
		System.out.print("\t***  Digite sua Opção: ");
		
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-3]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)){
			case 1:
				telaLogin();
				break;
			case 2:
				telaCadastro();
				break;
			case 3:
				System.out.println("\t*  Fechando a rede social! Até mais!                                                                    *");
				System.exit(0);
				break;
		}
	}
	
	void telaCadastro() {
		String nome, login, senha;
		boolean verificaLogin = false;
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t Bem-Vindo a DevMakers - A Rede Social dos Desenvolvedores \t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t     Cadastro de Usuário     \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		
		scan.nextLine(); //Limpa Buffer
		
		System.out.print("\t***  Digite seu Nome: ");
		nome = scan.nextLine();
		System.out.print("\t***  Digite seu Login: ");
		login = scan.nextLine();
		System.out.print("\t***  Digite sua Senha: ");
		senha = scan.nextLine();
		
		if(nome.trim().length() == 0 || login.trim().length() == 0 || senha.trim().length() == 0) {
			System.out.println("\t***\n\t***  Nome, Login e/ou Senha não podem ser vazios! Realize o cadastro novamente com um novo login! ");
			System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
			try {
				Thread.sleep(3000);
				telaInicial();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		for(Usuario logins : usuariosRede) {
			if(logins.getLogin().toLowerCase().equals(login.toLowerCase())) {
				verificaLogin = true;
			}
		}
		
		if(verificaLogin == true) {
			System.out.println("\t***\n\t***  Login já cadastrado! Realize o cadastro novamente com um novo login! ");
			System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
			try {
				Thread.sleep(3000);
				telaInicial();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			usuariosRede.add(new Usuario(nome, login, senha));
			System.out.println("\t***\n\t***  Cadastro Realizado!");
			System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
			try {
				Thread.sleep(3000);
				telaInicial();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	void telaLogin() {
		String login, senha;
		int idUsuario = -1;
		boolean verificaLogin = false;
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t Bem-Vindo a DevMakers - A Rede Social dos Desenvolvedores \t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t     Efetue seu Login     \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		scan.nextLine(); //Limpa Buffer
		
		System.out.print("\t***  Digite seu Login: ");
		login = scan.nextLine();
		System.out.print("\t***  Digite sua Senha: ");
		senha = scan.nextLine();
		
		for(int i = 0; i < usuariosRede.size(); i++) {
			if(usuariosRede.get(i).getLogin().toLowerCase().equals(login.toLowerCase()) && usuariosRede.get(i).getSenha().equals(senha)) {
				verificaLogin = true;
				idUsuario = i;
				break;
			}
		}
		
		if(verificaLogin == true) {
			System.out.println("\t***\n\t***  Login Realizado!");
			System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
			try {
				Thread.sleep(3000);
				telaMenu(idUsuario);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("\t***\n\t***  Login e/ou Senha incorretos! Realize uma nova tentativa de login!");
			System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
			try {
				Thread.sleep(3000);
				telaInicial();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	void telaMenu(int idUsuario) {
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t     Menu Principal     \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*  Opção 1 - Ver Timeline                                                                               *");
		System.out.println("\t*  Opção 2 - Ver Feed                                                                                   *");
		System.out.println("\t*  Opção 3 - Fazer um Post                                                                              *");
		System.out.println("\t*  Opção 4 - Quem estou Seguindo                                                                        *");
		System.out.println("\t*  Opção 5 - Meus Seguidores                                                                            *");
		System.out.println("\t*  Opção 6 - Procurar Pessoas                                                                           *");
		System.out.println("\t*  Opção 7 - Sair                                                                                       *");
		System.out.print("\t***  Digite sua Opção: ");
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-7]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)) {
			case 1:
				telaTimeline(idUsuario);
				break;
			case 2:
				telaFeed(idUsuario);
				break;
			case 3:
				telaPostagem(idUsuario);
				break;
			case 4:
				telaSeguindo(idUsuario);
				break;
			case 5:
				telaSeguidores(idUsuario);
				break;
			case 6:
				telaBuscaUsuario(idUsuario);
				break;
			case 7:
				System.out.println("\t***\n\t***  Saindo da conta!");
				System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
				try {
					Thread.sleep(3000);
					telaInicial();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
	}
	
	void telaTimeline(int idUsuario) {
		int qtdPostProprios = 0;
		ArrayList<Integer> idPostagens = new ArrayList<Integer>();
		idPostagens.clear();
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t          Timeline     \t\t\t\t         ********");
		System.out.println("\t*********************************************************************************************************");
		
		for(Postagem post : todasPostagens) {
			if(post.getIdUsuario() == idUsuario) {
				qtdPostProprios++;
			}
		}
		
		if(qtdPostProprios == 0) {
			System.out.println("\t*  Você não realizou nenhuma postagem!                                                                  *");
			System.out.println("\t*********************************************************************************************************");
		}
		else {
			for(int i = todasPostagens.size()-1; i >= 0; i--) {
				if(todasPostagens.get(i).getIdUsuario() == idUsuario) {
					idPostagens.add(i);
					System.out.println("\t*\t\t\t\t\t\t\t\t\t\t     " + todasPostagens.get(i).getData() + " - " + todasPostagens.get(i).getHora() );
					System.out.println("\t* ("+(i+1)+") Você postou:\n\t*");
					imprimeConteudoPost(todasPostagens.get(i).getConteudo());
					System.out.println("\t*\t\t\t\t\t\t\t\t\t\t\t" + todasPostagens.get(i).comentarios.size() + " comentários");
					System.out.println("\t*********************************************************************************************************");
				}
			}
		}
		
		System.out.println("\t*  Opção 1 - Ver Comentarios em algum Post                                                              *");
		System.out.println("\t*  Opção 2 - Ver Feed                                                                                   *");
		System.out.println("\t*  Opção 3 - Fazer um Post                                                                              *");
		System.out.println("\t*  Opção 4 - Quem estou Seguindo                                                                        *");
		System.out.println("\t*  Opção 5 - Meus Seguidores                                                                            *");
		System.out.println("\t*  Opção 6 - Procurar Pessoas                                                                           *");
		System.out.println("\t*  Opção 7 - Sair                                                                                       *");
		System.out.print("\t***  Digite sua Opção: ");
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-7]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)) {
			case 1:
				System.out.println("\t*  Informe o Código que está entre parenteses () do Post que deseja visualizar os comentarios!          *");
				System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
				System.out.print("\t***  Digite o Código: ");
				String idPost = scan.next();
				while(true) {
					if(idPost.matches("\\d+")) {
						if(Integer.parseInt(idPost) == 0) {
							telaTimeline(idUsuario);
						}
						for(int i = 0; i < idPostagens.size(); i++) {
							if((Integer.parseInt(idPost)-1) == idPostagens.get(i)) {
								verPostagem(idUsuario, (Integer.parseInt(idPost)-1));
								break;
							}
						}
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idPost = scan.next();
						
					}
					else if(!idPost.matches("\\d+")) {
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idPost = scan.next();
					}
				}
			case 2:
				telaFeed(idUsuario);
				break;
			case 3:
				telaPostagem(idUsuario);
				break;
			case 4:
				telaSeguindo(idUsuario);
				break;
			case 5:
				telaSeguidores(idUsuario);
				break;
			case 6:
				telaBuscaUsuario(idUsuario);
				break;
			case 7:
				System.out.println("\t***\n\t***  Saindo da conta!");
				System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
				try {
					Thread.sleep(3000);
					telaInicial();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
	}
	
	void telaFeed(int idUsuario) {
		int qtdPostDeSeguindo = 0;
		ArrayList<Integer> idPostagens = new ArrayList<Integer>();
		idPostagens.clear();
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t            Feed        \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		
		for(Postagem post : todasPostagens) {
			for(int idSeguindo : usuariosRede.get(idUsuario).seguindo) {
				if(post.getIdUsuario() == idSeguindo) {
					qtdPostDeSeguindo++;
				}
			}
		}
		
		if(qtdPostDeSeguindo == 0) {
			System.out.println("\t*  Não há nenhuma postagem!                                                                             *");
			System.out.println("\t*********************************************************************************************************");
		}
		else {
			for(int i = todasPostagens.size()-1; i >= 0; i--) {
				for(int idSeguindo : usuariosRede.get(idUsuario).seguindo) {
					if(todasPostagens.get(i).getIdUsuario() == idSeguindo) {
						idPostagens.add(i);
						System.out.println("\t*\t\t\t\t\t\t\t\t\t\t     " + todasPostagens.get(i).getData() + " - " + todasPostagens.get(i).getHora() );
						System.out.println("\t* ("+(i+1)+") " + usuariosRede.get(idSeguindo).getNome() + " postou:\n\t*");
						imprimeConteudoPost(todasPostagens.get(i).getConteudo());
						System.out.println("\t*\t\t\t\t\t\t\t\t\t\t\t" + todasPostagens.get(i).comentarios.size() + " comentários");
						System.out.println("\t*********************************************************************************************************");
					}
				}
			}
		}
		
		System.out.println("\t*  Opção 1 - Ver Comentarios em algum Post                                                              *");
		System.out.println("\t*  Opção 2 - Ver Timeline                                                                               *");
		System.out.println("\t*  Opção 3 - Fazer um Post                                                                              *");
		System.out.println("\t*  Opção 4 - Quem estou Seguindo                                                                        *");
		System.out.println("\t*  Opção 5 - Meus Seguidores                                                                            *");
		System.out.println("\t*  Opção 6 - Procurar Pessoas                                                                           *");
		System.out.println("\t*  Opção 7 - Sair                                                                                       *");
		System.out.print("\t***  Digite sua Opção: ");
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-7]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)) {
			case 1:
				System.out.println("\t*  Informe o Código que está entre parenteses () do Post que deseja visualizar os comentarios!          *");
				System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
				System.out.print("\t***  Digite o Código: ");
				String idPost = scan.next();
				while(true) {
					if(idPost.matches("\\d+")) {
						if(Integer.parseInt(idPost) == 0) {
							telaFeed(idUsuario);
						}
						for(int i = 0; i < idPostagens.size(); i++) {
							if((Integer.parseInt(idPost)-1) == idPostagens.get(i)) {
								verPostagem(idUsuario, (Integer.parseInt(idPost)-1));
								break;
							}
						}
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idPost = scan.next();
					}
					else if(!idPost.matches("\\d+")) {
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idPost = scan.next();
					}
				}
			case 2:
				telaTimeline(idUsuario);
				break;
			case 3:
				telaPostagem(idUsuario);
				break;
			case 4:
				telaSeguindo(idUsuario);
				break;
			case 5:
				telaSeguidores(idUsuario);
				break;
			case 6:
				telaBuscaUsuario(idUsuario);
				break;
			case 7:
				System.out.println("\t***\n\t***  Saindo da conta!");
				System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
				try {
					Thread.sleep(3000);
					telaInicial();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
		
	}
	
	void telaPostagem(int idUsuario) {
		String msgPost;
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t     Escreva seu Post     \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*  Escreva seu post (máximo de 270 caracteres) OBS: Digite \"SAIR\" para voltar ao menu inicial         *");
		System.out.print("\t*** ");
		
		scan.nextLine(); //Limpar buffer
		msgPost = scan.nextLine();
		
		while(msgPost.length() > 270) {
			System.out.println("\t*  Não deve exceder 270 caracteres, escreva novamente! OBS: Digite \"SAIR\" para voltar ao menu inicial *");
			System.out.print("\t*** ");
			msgPost = scan.nextLine();
		}
		
		if(msgPost.trim().length() == 0) {
			System.out.println("\t*  O post não pode ser vazio, será direcionado para a tela de menu!                                     *");
			try {
				Thread.sleep(3000);
				telaMenu(idUsuario);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(msgPost.trim().equals("SAIR")) {
			System.out.println("\t*  Você será direcionado para tela de menu!                                                             *");
			try {
				Thread.sleep(3000);
				telaMenu(idUsuario);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		fazerPostagem(idUsuario, dataAtual(), horaAtual(), msgPost, todasPostagens);
		System.out.println("\t*** Post efetuado! Voltando para o menu inicial.                                                        *");
		try {
			Thread.sleep(3000);
			telaMenu(idUsuario);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void verPostagem(int idUsuario, int idPostagem) {
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t    Visualizando Post        \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*\t\t\t\t\t\t\t\t\t\t     " + todasPostagens.get(idPostagem).getData() + " - " + todasPostagens.get(idPostagem).getHora() );
		
		if(todasPostagens.get(idPostagem).getIdUsuario() == idUsuario) {
			System.out.println("\t* ("+(idPostagem+1)+") Você postou:\n\t*");
		}
		else {
			System.out.println("\t* ("+(idPostagem+1)+") " + usuariosRede.get(todasPostagens.get(idPostagem).getIdUsuario()).getNome() + " postou:\n\t*");
		}
		
		imprimeConteudoPost(todasPostagens.get(idPostagem).getConteudo());
		System.out.println("\t*\t\t\t\t\t\t\t\t\t\t\t" + todasPostagens.get(idPostagem).comentarios.size() + " comentários");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t       Comentários        \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		
		if(todasPostagens.get(idPostagem).comentarios.size() == 0) {
			System.out.println("\t*  Não há nenhum comentário!                                                                            *");
			System.out.println("\t*********************************************************************************************************");
		}
		else {
			for(int i = 0; i <= todasPostagens.get(idPostagem).comentarios.size()-1; i++) {
				System.out.println("\t*\t\t\t\t\t\t\t\t\t\t     " + todasPostagens.get(idPostagem).getData() + " - " + todasPostagens.get(idPostagem).getHora() );
				if(todasPostagens.get(idPostagem).comentarios.get(i).getIdUsuario() == idUsuario) {
					System.out.println("\t* Você comentou:\n\t*");
				}
				else {
					System.out.println("\t* " + usuariosRede.get(todasPostagens.get(idPostagem).comentarios.get(i).getIdUsuario()).getNome() + " comentou:\n\t*");
				}
				imprimeConteudoPost(todasPostagens.get(idPostagem).comentarios.get(i).getConteudo());
				System.out.println("\t*" );
				System.out.println("\t*********************************************************************************************************");
			}
		}
		
		System.out.println("\t*  Opção 1 - Fazer um comentário                                                                        *");
		System.out.println("\t*  Opção 2 - Ver Timeline                                                                               *");
		System.out.println("\t*  Opção 3 - Ver Feed                                                                                   *");
		System.out.println("\t*  Opção 4 - Fazer um Post                                                                              *");
		System.out.println("\t*  Opção 5 - Quem estou Seguindo                                                                        *");
		System.out.println("\t*  Opção 6 - Meus Seguidores                                                                            *");
		System.out.println("\t*  Opção 7 - Procurar Pessoas                                                                           *");
		System.out.println("\t*  Opção 8 - Sair                                                                                       *");
		System.out.print("\t***  Digite sua Opção: ");
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-8]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)) {
			case 1:
				telaComentario(idUsuario, idPostagem);
				break;
			case 2:
				telaTimeline(idUsuario);
				break;
			case 3:
				telaFeed(idUsuario);
				break;
			case 4:
				telaPostagem(idUsuario);
				break;
			case 5:
				telaSeguindo(idUsuario);
				break;
			case 6:
				telaSeguidores(idUsuario);
				break;
			case 7:
				telaBuscaUsuario(idUsuario);
				break;
			case 8:
				System.out.println("\t***\n\t***  Saindo da conta!");
				System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
				try {
					Thread.sleep(3000);
					telaInicial();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
		
	}
	
	void telaComentario(int idUsuario, int idPostagem) {
		String msgComentario;
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t   Escreva seu Comentário   \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*  Escreva seu comentário (máximo de 270 caracteres) OBS: Digite \"SAIR\" para voltar ao menu inicial     *");
		System.out.print("\t*** ");
		
		scan.nextLine(); //Limpar buffer
		msgComentario = scan.nextLine();
		
		while(msgComentario.length() > 270) {
			System.out.println("\t*  Não deve exceder 270 caracteres, escreva novamente! OBS: Digite \"SAIR\" para voltar ao menu inicial *");
			System.out.print("\t*** ");
			msgComentario = scan.nextLine();
		}
		
		if(msgComentario.trim().length() == 0) {
			System.out.println("\t*  O comentário não pode ser vazio, será direcionado para o Post!                                       *");
			try {
				Thread.sleep(3000);
				verPostagem(idUsuario, idPostagem);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(msgComentario.trim().equals("SAIR")) {
			System.out.println("\t*  Você será direcionado para o Post!                                                                   *");
			try {
				Thread.sleep(3000);
				verPostagem(idUsuario, idPostagem);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		comentarPostagem(idUsuario, idPostagem, dataAtual(), horaAtual(), msgComentario, todasPostagens);
		System.out.println("\t*** Comentário efetuado! Voltando para o Post.                                                          *");
		try {
			Thread.sleep(3000);
			verPostagem(idUsuario, idPostagem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void telaBuscaUsuario(int idUsuario) {
		String nomeBusca;
		ArrayList<Integer> idResultados = new ArrayList<Integer>();
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t      Buscando Usuários      \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*  Escreva o nome da pessoa que deseja buscar!     OBS: Digite \"SAIR\" para voltar ao menu inicial       *");
		System.out.print("\t*** ");
		
		scan.nextLine(); //Limpar buffer
		nomeBusca = scan.nextLine();
		
		if(nomeBusca.trim().length() == 0) {
			System.out.println("\t*  A busca não pode ser vazia, será direcionado para o menu inicial!                                    *");
			try {
				Thread.sleep(3000);
				telaMenu(idUsuario);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(nomeBusca.trim().equals("SAIR")) {
			System.out.println("\t*  Você será direcionado para o menu inicial!                                                           *");
			try {
				Thread.sleep(3000);
				telaMenu(idUsuario);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			for(int i = 0; i < usuariosRede.size(); i++) {
				if(!(i == idUsuario)) {
					if(usuariosRede.get(i).getNome().toLowerCase().contains(nomeBusca.toLowerCase())) {
						idResultados.add(i);
					}
				}
			}
			
			if(idResultados.size() > 0) {
				System.out.println("\t*** Usuário(s) encontrado, será direcionado para a lista de resultados!                                 *");
				try {
					Thread.sleep(3000);
					telaResultadoBusca(idUsuario, idResultados);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			else {
				System.out.println("\t*** Nenhum usuário encontrado, será direcionado para o menu inicial!                                    *");
				try {
					Thread.sleep(3000);
					telaMenu(idUsuario);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	void telaResultadoBusca(int idUsuario, ArrayList<Integer> resultadoBusca) {
		String idUsuarioEscolhido;
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\tResultado da Busca de Usuários\t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		
		for(int i = 0; i < resultadoBusca.size(); i++) {
			System.out.println("\t*     (" + (resultadoBusca.get(i)+1) + ")  " + usuariosRede.get(resultadoBusca.get(i)).getNome());
			System.out.print("\t*\t\t\t\t\t\t\t\t\t --" + usuariosRede.get(resultadoBusca.get(i)).seguidores.size() + " seguidores -- ");
			System.out.println(usuariosRede.get(resultadoBusca.get(i)).seguindo.size() + " seguindo");
			System.out.println("\t*********************************************************************************************************");
		}
		
		System.out.println("\t*  Opção 1 - Seguir Usuário                                                                             *");
		System.out.println("\t*  Opção 2 - Parar de Seguir Usuário                                                                    *");
		System.out.println("\t*  Opção 3 - Ver Timeline                                                                               *");
		System.out.println("\t*  Opção 4 - Ver Feed                                                                                   *");
		System.out.println("\t*  Opção 5 - Fazer um Post                                                                              *");
		System.out.println("\t*  Opção 6 - Quem estou Seguindo                                                                        *");
		System.out.println("\t*  Opção 7 - Meus Seguidores                                                                            *");
		System.out.println("\t*  Opção 8 - Procurar Pessoas                                                                           *");
		System.out.println("\t*  Opção 9 - Sair                                                                                       *");
		System.out.print("\t***  Digite sua Opção: ");
		
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-9]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)) {
			case 1:
				System.out.println("\t*  Informe o Código que está entre parenteses () do Usuário que deseja seguir!                          *");
				System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
				System.out.print("\t***  Digite o Código: ");
				idUsuarioEscolhido = scan.next();
				while(true) {
					if(idUsuarioEscolhido.matches("\\d+")) {
						if(Integer.parseInt(idUsuarioEscolhido) == 0) {
							telaResultadoBusca(idUsuario, resultadoBusca);
							break;
						}
						else {
							for(int idEscolhido : resultadoBusca) {
								if((Integer.parseInt(idUsuarioEscolhido) - 1) == idEscolhido) {
									if(usuariosRede.get(idUsuario).seguirUsuario(idUsuario, idEscolhido, usuariosRede.get(idEscolhido))) {
										System.out.println("\t*** Usuário Seguido com Sucesso! Voltando para o resultado da busca.                                    *");
										try {
											Thread.sleep(3000);
											telaResultadoBusca(idUsuario, resultadoBusca);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									else {
										System.out.println("\t*** Você já segue esse usuário! Voltando para o resultado da busca.                                     *");
										try {
											Thread.sleep(3000);
											telaResultadoBusca(idUsuario, resultadoBusca);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
					else if(!idUsuarioEscolhido.matches("\\d+")) {
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
				}
				break;
			case 2:
				System.out.println("\t*  Informe o Código que está entre parenteses () do Usuário que deseja parar de Seguir!                 *");
				System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
				System.out.print("\t***  Digite o Código: ");
				idUsuarioEscolhido = scan.next();
				while(true) {
					if(idUsuarioEscolhido.matches("\\d+")) {
						if(Integer.parseInt(idUsuarioEscolhido) == 0) {
							telaResultadoBusca(idUsuario, resultadoBusca);
							break;
						}
						else {
							for(int idEscolhido : resultadoBusca) {
								if((Integer.parseInt(idUsuarioEscolhido) - 1) == idEscolhido) {
									if(usuariosRede.get(idUsuario).pararSeguirUsuario(idUsuario, idEscolhido, usuariosRede.get(idEscolhido))) {
										System.out.println("\t*** Parou de Seguir com Sucesso! Voltando para o resultado da busca.                                    *");
										try {
											Thread.sleep(3000);
											telaResultadoBusca(idUsuario, resultadoBusca);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									else {
										System.out.println("\t*** Você não segue esse usuário! Voltando para o resultado da busca.                                    *");
										try {
											Thread.sleep(3000);
											telaResultadoBusca(idUsuario, resultadoBusca);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
					else if(!idUsuarioEscolhido.matches("\\d+")) {
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
				}
				break;
			case 3:
				telaTimeline(idUsuario);
				break;
			case 4:
				telaFeed(idUsuario);
				break;
			case 5:
				telaPostagem(idUsuario);
				break;
			case 6:
				telaSeguindo(idUsuario);
				break;
			case 7:
				telaSeguidores(idUsuario);
				break;
			case 8:
				telaBuscaUsuario(idUsuario);
				break;
			case 9:
				System.out.println("\t***\n\t***  Saindo da conta!");
				System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
				try {
					Thread.sleep(3000);
					telaInicial();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
	}
	
	void telaSeguidores(int idUsuario) {
		String idUsuarioEscolhido;
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t      Meus Seguidores    \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		
		if(usuariosRede.get(idUsuario).seguidores.size() == 0) {
			System.out.println("\t*  Você não tem seguidores!");
			System.out.println("\t*********************************************************************************************************");
		}
		else {
			for(int i = 0; i < usuariosRede.get(idUsuario).seguidores.size(); i++) {
				System.out.println("\t*     (" + (usuariosRede.get(idUsuario).seguidores.get(i)+1) + ")  " + usuariosRede.get(usuariosRede.get(idUsuario).seguidores.get(i)).getNome());
				System.out.print("\t*\t\t\t\t\t\t\t\t\t --" + usuariosRede.get(usuariosRede.get(idUsuario).seguidores.get(i)).seguidores.size() + " seguidores -- ");
				System.out.println(usuariosRede.get(usuariosRede.get(idUsuario).seguidores.get(i)).seguindo.size() + " seguindo");
				System.out.println("\t*********************************************************************************************************");
			}
		}
		
		System.out.println("\t*  Opção 1 - Seguir Usuário                                                                             *");
		System.out.println("\t*  Opção 2 - Defazer Seguidor                                                                           *");
		System.out.println("\t*  Opção 3 - Ver Timeline                                                                               *");
		System.out.println("\t*  Opção 4 - Ver Feed                                                                                   *");
		System.out.println("\t*  Opção 5 - Fazer um Post                                                                              *");
		System.out.println("\t*  Opção 6 - Quem estou Seguindo                                                                        *");
		System.out.println("\t*  Opção 7 - Meus Seguidores                                                                            *");
		System.out.println("\t*  Opção 8 - Procurar Pessoas                                                                           *");
		System.out.println("\t*  Opção 9 - Sair                                                                                       *");
		System.out.print("\t***  Digite sua Opção: ");
		
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-9]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)) {
			case 1:
				System.out.println("\t*  Informe o Código que está entre parenteses () do Usuário que deseja seguir!                          *");
				System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
				System.out.print("\t***  Digite o Código: ");
				
				idUsuarioEscolhido = scan.next();
				
				while(true) {
					if(idUsuarioEscolhido.matches("\\d+")) {
						if(Integer.parseInt(idUsuarioEscolhido) == 0) {
							telaSeguidores(idUsuario);
							break;
						}
						else {
							for(int idEscolhido : usuariosRede.get(idUsuario).seguidores) {
								if((Integer.parseInt(idUsuarioEscolhido) - 1) == idEscolhido) {
									if(usuariosRede.get(idUsuario).seguirUsuario(idUsuario, idEscolhido, usuariosRede.get(idEscolhido))) {
										System.out.println("\t*** Usuário Seguido com Sucesso! Voltando para tela de seguidores.                                      *");
										try {
											Thread.sleep(3000);
											telaSeguidores(idUsuario);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									else {
										System.out.println("\t*** Você já segue esse usuário! Voltando para tela de seguidores.                                       *");
										try {
											Thread.sleep(3000);
											telaSeguidores(idUsuario);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
					else if(!idUsuarioEscolhido.matches("\\d+")) {
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
				}
				break;
			case 2:
				System.out.println("\t*  Informe o Código que está entre parenteses () do Usuário que deseja parar de Seguir!                 *");
				System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
				System.out.print("\t***  Digite o Código: ");
				
				idUsuarioEscolhido = scan.next();
				
				while(true) {
					if(idUsuarioEscolhido.matches("\\d+")) {
						if(Integer.parseInt(idUsuarioEscolhido) == 0) {
							telaSeguidores(idUsuario);
							break;
						}
						else {
							for(int idEscolhido : usuariosRede.get(idUsuario).seguidores) {
								if((Integer.parseInt(idUsuarioEscolhido) - 1) == idEscolhido) {
									if(usuariosRede.get(idEscolhido).pararSeguirUsuario(idEscolhido, idUsuario, usuariosRede.get(idUsuario))) {
										System.out.println("\t*** Desfez o Seguidor com Sucesso! Voltando para tela de seguidores.                                    *");
										try {
											Thread.sleep(3000);
											telaSeguidores(idUsuario);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
					else if(!idUsuarioEscolhido.matches("\\d+")) {
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
				}
				break;
			case 3:
				telaTimeline(idUsuario);
				break;
			case 4:
				telaFeed(idUsuario);
				break;
			case 5:
				telaPostagem(idUsuario);
				break;
			case 6:
				telaSeguindo(idUsuario);
				break;
			case 7:
				telaSeguidores(idUsuario);
				break;
			case 8:
				telaBuscaUsuario(idUsuario);
				break;
			case 9:
				System.out.println("\t***\n\t***  Saindo da conta!");
				System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
				try {
					Thread.sleep(3000);
					telaInicial();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
		
	}
	
	void telaSeguindo(int idUsuario) {
		String idUsuarioEscolhido;
		
		limpaConsole();
		System.out.println("\t*********************************************************************************************************");
		System.out.print("\t********\t       Bem-Vindo(a) " + usuariosRede.get(idUsuario).getNome());
		System.out.print("\t\t\t -- " + usuariosRede.get(idUsuario).seguidores.size() + " Seguidores");
		System.out.println(" -- " + usuariosRede.get(idUsuario).seguindo.size() + " Seguindo");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t*********************************************************************************************************");
		System.out.println("\t********\t\t\t\t      Quem Estou Seguindo    \t\t\t\t ********");
		System.out.println("\t*********************************************************************************************************");
		
		if(usuariosRede.get(idUsuario).seguindo.size() == 0) {
			System.out.println("\t*  Você não segue ninguém!");
			System.out.println("\t*********************************************************************************************************");
		}
		else {
			for(int i = 0; i < usuariosRede.get(idUsuario).seguindo.size(); i++) {
				System.out.println("\t*     (" + (usuariosRede.get(idUsuario).seguindo.get(i)+1) + ")  " + usuariosRede.get(usuariosRede.get(idUsuario).seguindo.get(i)).getNome());
				System.out.print("\t*\t\t\t\t\t\t\t\t\t --" + usuariosRede.get(usuariosRede.get(idUsuario).seguindo.get(i)).seguidores.size() + " seguidores -- ");
				System.out.println(usuariosRede.get(usuariosRede.get(idUsuario).seguindo.get(i)).seguindo.size() + " seguindo");
				System.out.println("\t*********************************************************************************************************");
			}
		}
		
		System.out.println("\t*  Opção 1 - Parar de Seguir Usuário                                                                    *");
		System.out.println("\t*  Opção 2 - Ver Timeline                                                                               *");
		System.out.println("\t*  Opção 3 - Ver Feed                                                                                   *");
		System.out.println("\t*  Opção 4 - Fazer um Post                                                                              *");
		System.out.println("\t*  Opção 5 - Quem estou Seguindo                                                                        *");
		System.out.println("\t*  Opção 6 - Meus Seguidores                                                                            *");
		System.out.println("\t*  Opção 7 - Procurar Pessoas                                                                           *");
		System.out.println("\t*  Opção 8 - Sair                                                                                       *");
		System.out.print("\t***  Digite sua Opção: ");
		
		opcoes = scan.next();
		
		while(!opcoes.matches("[1-8]")) {
			System.out.print("\t***  Digite novamente sua Opção: ");
			opcoes = scan.next();
		}
		
		switch(Integer.parseInt(opcoes)) {
			case 1:
				System.out.println("\t*  Informe o Código que está entre parenteses () do Usuário que deseja parar de Seguir!                 *");
				System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
				System.out.print("\t***  Digite o Código: ");
				idUsuarioEscolhido = scan.next();
				
				while(true) {
					if(idUsuarioEscolhido.matches("\\d+")) {
						if(Integer.parseInt(idUsuarioEscolhido) == 0) {
							telaSeguindo(idUsuario);
							break;
						}
						else {
							for(int idEscolhido : usuariosRede.get(idUsuario).seguindo) {
								if((Integer.parseInt(idUsuarioEscolhido) - 1) == idEscolhido) {
									if(usuariosRede.get(idUsuario).pararSeguirUsuario(idUsuario, idEscolhido, usuariosRede.get(idEscolhido))) {
										System.out.println("\t*** Parou de Seguir com Sucesso! Voltando para tela de quem você segue.                                 *");
										try {
											Thread.sleep(3000);
											telaSeguindo(idUsuario);
											break;
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
					else if(!idUsuarioEscolhido.matches("\\d+")) {
						System.out.println("\t*                                                                            OBS: Digite 0 para voltar! *");
						System.out.print("\t***  Digite novamente um Código válido: ");
						idUsuarioEscolhido = scan.next();
					}
				}
				break;
			case 2:
				telaTimeline(idUsuario);
				break;
			case 3:
				telaFeed(idUsuario);
				break;
			case 4:
				telaPostagem(idUsuario);
				break;
			case 5:
				telaSeguindo(idUsuario);
				break;
			case 6:
				telaSeguidores(idUsuario);
				break;
			case 7:
				telaBuscaUsuario(idUsuario);
				break;
			case 8:
				System.out.println("\t***\n\t***  Saindo da conta!");
				System.out.println("\t***\n\t***  Você será redirecionado em 3 segundos");
				try {
					Thread.sleep(3000);
					telaInicial();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
	}
	
	void imprimeConteudoPost(String conteudo) {
		if(conteudo.length() <= 90) {
			System.out.println("\t*\t" + conteudo.substring(0, conteudo.length()) + "\t");
		}
		else if(conteudo.length() > 90 && conteudo.length() <= 181) {
			System.out.println("\t*\t" + conteudo.substring(0, 90) + "\t");
			if(conteudo.charAt(90) == ' ') {
				System.out.println("\t*\t" + conteudo.substring(91, conteudo.length()) + "\t");
			}
			else {
				System.out.println("\t*\t" + conteudo.substring(90, conteudo.length()) + "\t");
			}
		}
		else if(conteudo.length() > 181 && conteudo.length() <= 270) {
			System.out.println("\t*\t" + conteudo.substring(0, 90) + "\t");
			if(conteudo.charAt(90) == ' ') {
				System.out.println("\t*\t" + conteudo.substring(91, 181) + "\t");
				if(conteudo.charAt(181) == ' ') {
					System.out.println("\t*\t" + conteudo.substring(182, conteudo.length()) + "\t");
				}
				else {
					System.out.println("\t*\t" + conteudo.substring(181, conteudo.length()) + "\t");
				}
			}
			else {
				System.out.println("\t*\t" + conteudo.substring(90, 180) + "\t");
				if(conteudo.charAt(180) == ' ') {
					System.out.println("\t*\t" + conteudo.substring(181, conteudo.length()) + "\t");
				}
				else {
					System.out.println("\t*\t" + conteudo.substring(180, conteudo.length()) + "\t");
				}
			}
		}
	}
	
	void fazerPostagem(int idUsuarioPost, String dataPost, String horaPost, String conteudoPost, ArrayList<Postagem> todosPosts) {
		todosPosts.add(new Postagem(idUsuarioPost, dataPost, horaPost, conteudoPost));
	}
	
	void comentarPostagem(int idUsuarioComentario, int idPostagem, String dataPost, String horaPost, String conteudoComentario, ArrayList<Postagem> todosPosts) {
		todosPosts.get(idPostagem).comentarios.add(new Comentario(idUsuarioComentario, dataPost, horaPost, conteudoComentario));
	}
		
	void limpaConsole() {
		for(int i = 0; i < 10; i++) {
			System.out.println("\n\n\n\n\n");
		}
	}
	
	String dataAtual() {
		if(data.get(Calendar.DATE) < 10) {
			return ("0" + data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR));
		}
		else {
			return (data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR));
		}
	}
	
	String horaAtual() {
		if(data.get(Calendar.HOUR_OF_DAY) < 10) {
			if(data.get(Calendar.MINUTE) < 10) {
				return ("0" + data.get(Calendar.HOUR_OF_DAY) + ":0" + data.get(Calendar.MINUTE));
			} 
			else {
				return ("0" + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE));
			}
		} 
		else {
			if(data.get(Calendar.MINUTE) < 10) {
				return (data.get(Calendar.HOUR_OF_DAY) + ":0" + data.get(Calendar.MINUTE));
			} 
			else {
				return (data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE));
			}
			
		}
	}
}
