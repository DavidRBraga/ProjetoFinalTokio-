package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionFactory.ConnectionFactory;

import model.Servico;

public class ServicoDAO {
	
private Connection conexao;
	
	
	public ServicoDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	public void insert(Servico servico) throws SQLException {
		String sql = "insert into T_AUTO_SERVICO (cd_servico,nm_servico,ds_endereco) values (?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setLong(1, 1L);
		stmt.setString(2, "Seguro Auto");
		stmt.setString(3, "Um otimo seguro para o seu carro");
		
		stmt.execute();
		stmt.close();
		
		
		
	}

}
