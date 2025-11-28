import java.sql.*;

public class EventoDAO 
{
   

    public static void InserirOrganizador(String nome, String email, String senha)
    {

        try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario (nome,email,senha) VALUES (?,?,?)");

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);

            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Gravado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }   
    
    public static void InserirEvento(String titulo, String descricao, String data_evento, String local, int id_usuario)
    {
         try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO evento (titulo,descricao,data_evento,local,id_usuario) VALUES (?,?,?,?,?)");

            stmt.setString(1, titulo);
            stmt.setString(2, descricao);
            stmt.setString(3, data_evento);
            stmt.setString(4, local);
            stmt.setInt(5, id_usuario);


            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Gravado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void InserirParticipantes(String nome, String email, String telefone) 
    {
         try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO participante (nome,email,telefone) VALUES (?,?,?)");

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);


            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Gravado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }    
    }

    public static void InserirInscricao(int id_participante, int id_evento)
    {
        try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO inscricao (id_participante, id_evento) VALUES (?,?)");

            stmt.setInt(1, id_participante);
            stmt.setInt(2, id_evento);
            


            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Gravado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }    
    }

    public static void listarOrganizadores()
    {
        try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario");
            ResultSet consulta = stmt.executeQuery();

            while (consulta.next()) {
                int id_usuario = consulta.getInt("id_usuario");
                String nome = consulta.getString("nome");
                String email = consulta.getString("email");
                String senha = consulta.getString("senha");
                String data_cadastro = consulta.getString("data_cadastro");

                System.out.println(id_usuario + " | " + nome + " | " + email + " | " + senha + " | " + data_cadastro);
            
            }

            consulta.close();
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void listarEventos()
    {
        try {

            Connection conn = ConexaoDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM evento");
            ResultSet consulta = stmt.executeQuery();

            while (consulta.next()) {
                int id_evento = consulta.getInt("id_evento");
                int id_usuario = consulta.getInt("id_usuario");
                String titulo = consulta.getString("titulo");
                String descricao = consulta.getString("descricao");
                String data_evento = consulta.getString("data_evento");
                String local = consulta.getString("local");
                String criado_em = consulta.getString("criado_em");

                System.out.println( id_evento + " | " + id_usuario + " | " + titulo + " | " + descricao + " | " + data_evento + " | " + local + " | " + criado_em );
            
            }

            consulta.close();
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void listarParticipantes()
    {
        
        try {
            Connection conn = ConexaoDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM participante");
            ResultSet consulta = stmt.executeQuery();

            while (consulta.next()) {
                int id_participante = consulta.getInt("id_participante");
                String nome = consulta.getString("nome");
                String email = consulta.getString("email");
                String telefone = consulta.getString("telefone");
                String data_cadastro = consulta.getString("data_cadastro");

                System.out.println( id_participante + " | " + nome + " | " + email + " | " + telefone + " | " + data_cadastro );
            
            }

            consulta.close();
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void listarInscricao() 
    {
        try {
            Connection conn = ConexaoDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM inscricao");
            ResultSet consulta = stmt.executeQuery();

            while (consulta.next()) {
                int id_inscricao = consulta.getInt("id_inscricao");
                int id_participante = consulta.getInt("id_participante");
                int id_evento = consulta.getInt("id_evento");
                String data_inscricao = consulta.getString("data_inscricao");
                

                System.out.println( id_inscricao + " | " + id_participante + " | " + id_evento + " | " + data_inscricao );
            
            }

            consulta.close();
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }

    public static void DeletarOrganizadores(int id_usuario)
    {
        
        try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");

            stmt.setInt(1, id_usuario);
            
        
            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Deletado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }    
    }

      public static void DeletarEventos(int id_evento)
    {
        
        try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM evento WHERE id_evento = ?");

            stmt.setInt(1, id_evento);
            
        
            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Deletado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }    
    }

      public static void DeletarParticipantes(int id_participante)
    {
        
        try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM participante WHERE id_participante = ?");

            stmt.setInt(1, id_participante);
            
        
            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Deletado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }    
    }

    public static void DeletarInscricao(int id_inscricao)
    {
        
        try 
        {
            Connection conn = ConexaoDB.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM inscricao WHERE id_inscricao = ?");

            stmt.setInt(1, id_inscricao);
            
        
            stmt.executeUpdate();
	        stmt.close();
            
            System.out.println("Deletado!");

            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }    
    }

    
}
