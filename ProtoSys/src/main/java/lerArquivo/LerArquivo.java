package lerArquivo;


import Departamento.Departamento;
import Usuarios.Usuarios;
import Usuarios.UsuarioDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NVIDIA
 */
public class LerArquivo {

    List<Usuarios> listUsuarios;
    UsuarioDAO usuarioDAO;
    Usuarios usuario;
    Usuarios newUsuario;
    FileReader arq;
    File arquivo;
    String dados[] = null;
    
    public LerArquivo(String arquivoCaminho, Departamento departamento, String senha) {
        usuarioDAO = new UsuarioDAO();
        listUsuarios = new ArrayList<>();

        try {
            arq = new FileReader(arquivoCaminho);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                usuario = new Usuarios();
                dados = linha.split(";");
                usuario.setNome(dados[0]);
                usuario.setSobrenome(dados[1]);
                usuario.setEmail(dados[2]);
                usuario.setDepartamento(departamento);
                usuario.setSenha(senha);
                listUsuarios.add(usuario);
                linha = lerArq.readLine();
            }
            
            arq.close();
        } catch (IOException e) {
            e.getMessage();
        }
        
        usuarioDAO.inserirUsuario(listUsuarios);

    }

}
