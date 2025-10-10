/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luizfrancisco.biblioteca.dao;

import com.luizfrancisco.biblioteca.database.ConexaoDB;
import com.luizfrancisco.biblioteca.model.Livros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LivroDAO {
    private Connection con;
    
    public ArrayList<Livros> retornaListaDeLivros() throws SQLException{
        con = ConexaoDB.getConexao();
        
        String sql = "SELECT * FROM tb_livros";
        
        ArrayList<Livros> listaDeLivros = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Livros l = new Livros();
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setEditora(rs.getString("editora"));
                l.setAno(rs.getString("ano"));
                l.setIsDisponivel(rs.getBoolean("isDisponivel"));
                
                listaDeLivros.add(l);
            }
            
        } catch(SQLException e){
            System.out.println("ERRO ao retornar lista de livros" + e);
        }finally {
            con.close();
            System.out.println("Conexão fechada (lista de livros)");
        }
        
        return listaDeLivros;
    }
    
    public void addLivros(Livros l, int idUsuario) throws SQLException{
       con = ConexaoDB.getConexao();
       String sql = "INSERT INTO tb_livros (nome, editora, ano, isDisponivel) VALUES (?,?,?,?)";
       
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, l.getNome());
           ps.setString(2, l.getEditora());
           ps.setString(3, l.getAno());
           ps.setBoolean(4,  l.getIsDisponivel());
           
           ps.executeUpdate();
       }catch (SQLException e){
           System.out.println("ERRO AO CADASTRAR LIVRO -> " + e);
       }finally{
           con.close();
           System.out.println("Conexao com o banco fechada (adicionar tarefa)");
       }
 }
       
       public void editarLivro(Livros l, int id) throws SQLException{
           con = ConexaoDB.getConexao();
           
           String sql = "UPDATE tb_livros SET nome = ?, editora = ?, ano = ?, isDisponivel = ? WHERE id = ?";
           
           try {
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, l.getNome());
               ps.setString(2, l.getEditora());
               ps.setString(3, l.getAno());
               ps.setBoolean(4, l.getIsDisponivel());
               ps.setInt(5, id);
               
               ps.executeUpdate();
               
               
           }catch(SQLException e){
               System.out.println("ERRO AO EDITAR NO BANCO DE DADOS -> " + e);
           }finally{
               con.close();
               System.out.println("Livro atualizado! Fechando conexão...");
        }
    }
       
       public void deletarLivro(int id) throws SQLException{
           con = ConexaoDB.getConexao();
           
           String sql = "DELETE FROM tb_livros WHERE id = ?";
           
           try{
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setInt(1, id);
               
               ps.executeUpdate();
           }catch (SQLException e){
               System.out.println("ERRO ao deletar livro -> " + e);
           }finally{
               con.close();
               System.out.println("Fechando conexao ao deletar tarefa");
           }
       }
     
}

