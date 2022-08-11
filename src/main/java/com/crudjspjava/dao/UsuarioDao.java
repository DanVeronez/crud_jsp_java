package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDao {
	
	public static Connection criarConexaoComBancoDeDados() {
		
		Connection conexao = null;
		
		try {
			
			//Carrega o driver especificado
			Class.forName("com.mysql.jdbc.Driver");
			
			conexao = DriverManager.getConnection("jdbc:myql://localhost:3306/crud_jsp_java","root","");
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return conexao;
	}
	
	public static List<Usuario> pegarTodosOsUsuarios() {
		
		List<Usuario> listaDeUsuarios = new  ArrayList<Usuario>();
		
		try {
			
			//Cria conexão com o banco
			Connection conexao = criarConexaoComBancoDeDados();
			
			//Prepara a instrução SQL
			//PreparedStatement ==> Declaração preparada
			PreparedStatement declaracaoPreparada = (PreparedStatement) conexao.prepareStatement("SELECT * FROM usuario");
			
			//Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
			//Pelo fato de gerar uma lista de valores, é necessário percorrer os dados através do laço while
			//Resullt Set ==> Conjunto de resultados
			ResultSet conjuntoDeResultados = declaracaoPreparada.executeQuery();			
			
			//Faz a verificação de enquanto conter registros, percorre e resgata os valores
			while(conjuntoDeResultados.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setId		(conjuntoDeResultados.getInt	("id")		); 
				usuario.setNome		(conjuntoDeResultados.getString	("nome")	);
				usuario.setPassword	(conjuntoDeResultados.getString	("password"));
				usuario.setEmail	(conjuntoDeResultados.getString	("email")	);
				usuario.setSexo		(conjuntoDeResultados.getString	("sexo")	);
				usuario.setPais		(conjuntoDeResultados.getString	("pais")	);
				
				listaDeUsuarios.add(usuario);
			}
			
		}catch (Exception e) {
			System.out.println(e);
			
		}return listaDeUsuarios;
	}
	
}
