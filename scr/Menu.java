import java.util.Scanner;

public class Menu 
{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) 
        {
            System.out.println("==================================================");
            System.out.println("\t Sistema de Gerenciamento de Eventos");
            System.out.println("==================================================\n");

            System.out.println("Opcoes: \n ");
            System.out.println("1 - Gerenciar Organizadores");
            System.out.println("2 - Gerenciar Eventos");
            System.out.println("3 - Gerenciar Participantes");
            System.out.println("4 - Gerenciar Inscrições");
            System.out.println("5 - Deletar Parametros");
            System.out.println("6 - Sair");

            int comando =  in.nextInt();
            in.nextLine();

            if (comando == 1) 
            {
                System.out.println("===========================================");
                System.out.println("\t Gerenciar Organizadores");
                System.out.println("===========================================\n");

                System.out.println("Opcoes: \n ");
                System.out.println("1 - Inserir Organizadores");
                System.out.println("2 - Visualizar Organizadores");
                System.out.println("3 - Voltar");

                int selecionar = in.nextInt();
                in.nextLine();

                if (selecionar == 1) {

                    System.out.println("===========================================");
                    System.out.println("\t Inserir Organizadores ");
                    System.out.println("===========================================\n");

                    System.out.println("Digite o nome:");
                    String nome = in.nextLine(); 

                    System.out.println("Digite o email:");
                    String email = in.nextLine();

                    System.out.println("Digite a senha:");
                    String senha = in.nextLine();

                    EventoDAO.InserirOrganizador(nome, email, senha);
                }
                else if (selecionar == 2)
                {
                    System.out.println("===========================================");
                    System.out.println("\t Visualizar Organizadores ");
                    System.out.println("===========================================\n");

                    EventoDAO.listarOrganizadores();
                }
                else if (selecionar == 3)
                {
                    continue;
                }
                else { 
                    System.out.println("Comando invalido! Voltando ao menu principal...");
                    continue;
                }
            }
            else if (comando == 2) 
            {
                System.out.println("===========================================");
                System.out.println("\t Gerenciar Eventos");
                System.out.println("===========================================\n");

                System.out.println("Opcoes: \n ");
                System.out.println("1 - Inserir Eventos");
                System.out.println("2 - Visualizar Eventos");
                System.out.println("3 - Voltar");

                int selecionar = in.nextInt();
                in.nextLine();

                if (selecionar == 1) {

                    System.out.println("===========================================");
                    System.out.println("\t Inserir Evento ");
                    System.out.println("===========================================\n");

                    System.out.println("Digite o Titulo:");
                    String titulo = in.nextLine(); 

                    System.out.println("Digite a descricao:");
                    String descricao = in.nextLine();

                    System.out.println("Digite a data do evento:");
                    String data = in.nextLine();

                    System.out.println("Digite o local:");
                    String local = in.nextLine();

                    System.out.println("Usuario responsavel - id: ");
                    int id_usuario = in.nextInt();
                    in.nextLine();

                    EventoDAO.InserirEvento(titulo, descricao, data , local, id_usuario);
                }
                else if (selecionar == 2)
                {
                    System.out.println("===========================================");
                    System.out.println("\t Listar Eventos ");
                    System.out.println("===========================================\n");

                    EventoDAO.listarEventos();
                }
                else if (selecionar == 3)
                {
                    continue;
                }
                else { 
                    System.out.println("Comando invalido! Voltando ao menu principal...");
                    continue;
                }
            } 
            else if (comando == 3)
            {
                System.out.println("===========================================");
                System.out.println("\t Gerenciar Participantes");
                System.out.println("===========================================\n");

                System.out.println("Opcoes: \n ");
                System.out.println("1 - Inserir Participantes");
                System.out.println("2 - Visualizar Participantes");
                System.out.println("3 - Voltar");

                int selecionar = in.nextInt();
                in.nextLine();

                if (selecionar == 1) 
                {

                    System.out.println("===========================================");
                    System.out.println("\t Inserir Participante ");
                    System.out.println("===========================================\n");

                    System.out.println("Digite o nome:");
                    String nome = in.nextLine(); 

                    System.out.println("Digite o email:");
                    String email = in.nextLine();

                    System.out.println("Digite o telefone:");
                    String telefone = in.nextLine();

                    EventoDAO.InserirParticipantes(nome, email, telefone);
                }
                else if (selecionar == 2)
                {
                    System.out.println("===========================================");
                    System.out.println("\t Listar Participantes ");
                    System.out.println("===========================================\n");

                    EventoDAO.listarParticipantes();
                }
                else if (selecionar == 3)
                {
                    continue;
                }
                else { 
                    System.out.println("Comando invalido! Voltando ao menu principal...");
                    continue;
                }
            }
            else if (comando == 4) 
            {
                System.out.println("===========================================");
                System.out.println("\t Gerenciar Inscrições");
                System.out.println("===========================================\n");

                System.out.println("Opcoes: \n ");
                System.out.println("1 - Inserir Inscrições");
                System.out.println("2 - Visualizar Inscrições");
                System.out.println("3 - Voltar");

                int selecionar = in.nextInt();
                in.nextLine();

                if (selecionar == 1) {

                    System.out.println("===========================================");
                    System.out.println("\t Inserir Inscrições");
                    System.out.println("===========================================\n");

                    System.out.println("Digite o id do participante");
                    int id_participante = in.nextInt();
                    in.nextLine();

                    System.out.println("Digite o id do evento de sua escolha:");
                    int id_evento = in.nextInt();
                    in.nextLine();


                    EventoDAO.InserirInscricao(id_participante, id_evento );
                }
                else if (selecionar == 2)
                {
                    System.out.println("===========================================");
                    System.out.println("\t Listar Inscrições");
                    System.out.println("===========================================\n");

                    EventoDAO.listarInscricao();
                }
                else if (selecionar == 3)
                {
                    continue;
                }
                else { 
                    System.out.println("Comando invalido! Voltando ao menu principal...");
                    continue;
                }
            }
            else if(comando == 5)
            {
                System.out.println("===========================================");
                System.out.println("\t Deletar Parametros");
                System.out.println("===========================================\n");

                System.out.println("Opcoes: \n ");
                System.out.println("1 - Deletar Organizadores");
                System.out.println("2 - Deletar Eventos");
                System.out.println("3 - Deletar Participantes");
                System.out.println("4 - Deletar Inscrições");
                System.out.println("5 - Voltar");
                
                int selecionar = in.nextInt();
                in.nextLine();

                if (selecionar == 1) 
                {
                    System.out.println("Digite o id do Organizador para deletar:");
                    int id_usuario = in.nextInt();
                    in.nextLine();

                    EventoDAO.DeletarOrganizadores(id_usuario);
                }
                else if (selecionar == 2) 
                {
                    System.out.println("Digite o id do Evento para deletar:");
                    int id_evento = in.nextInt();
                    in.nextLine();

                    EventoDAO.DeletarEventos(id_evento);
                }
                else if (selecionar == 3) 
                {
                    System.out.println("Digite o id do Participante para deletar:");
                    int id_participante = in.nextInt();
                    in.nextLine();

                    EventoDAO.DeletarParticipantes(id_participante);
                }
                else if (selecionar == 4) 
                {
                    System.out.println("Digite o id do Participante para deletar:");
                    int id_participante = in.nextInt();
                    in.nextLine();

                    EventoDAO.DeletarParticipantes(id_participante);
                }
                else if (selecionar == 5)
                {
                    continue;
                }
                else { 
                    System.out.println("Comando invalido! Voltando ao menu principal...");
                    continue;
                }

            }
            else if (comando == 6)
            {
                System.out.println("Até logo!");
                in.close();
                break;
            }
            else 
            {
                System.out.println("Comando invalido! Voltando ao menu principal...");
                continue;
            }
   
     
        }
    }    
}
