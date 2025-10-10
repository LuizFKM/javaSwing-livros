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
    
    public ArrayList<Livros> retornaListaDeLivros(int idUsuario) throws SQLException{
        con = ConexaoDB.getConexao();
        
        String sql = "SELECT * FROM tb_tarefas WHERE usuario_id = ?";
        
        ArrayList<Livros> listaDeLivros = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            
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
       
       public void editarTarefa(Livros l, int id) throws SQLException{
           con = ConexaoDB.getConexao();
           
           String sql = "UP tb_livros SET nome = ?, editora = ?, ano = ?, isDisponivel = ?, WHERE id = ?";
           
           try {
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, l.getNome());
               ps.setString(2, l.getEditora());
               ps.setString(3, l.getAno());
               ps.setBoolean(4, l.getIsDisponivel());
               
               ps.executeUpdate();
               
               
           }catch(SQLException e){
               System.out.println("ERRO AO EDITAR NO BANCO DE DADOS -> " + e);
           }finally{
               con.close();
               System.out.println("Livro atualizado! Fechando conexão...");
        }
    }
}

