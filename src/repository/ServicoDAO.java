package repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Servico> select() throws SQLException {
		List<Servico> usuarios = new ArrayList<Servico>();
		String sql = "select * from t_auto_servico";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Servico servico = new Servico();
			servico.setCd_servico(rs.getLong("Codigo: "));
			servico.setNm_servico(rs.getString("Nome do servico: "));
			servico.setDs_servico(rs.getString("Descrição do serviço: "));

		}
		rs.close();
		stmt.close();
		return usuarios;
	}

	public void delete(Long Cd_servico) throws SQLException {
		String sql = "delete from t_auto_servico where Cd_servico=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, Cd_servico);
		stmt.execute();
		stmt.close();
	}

	public void update(Servico servico) throws SQLException {
		String sql = "update t_auto_servico set Nm_servico=?, Ds_servico=?,where Cd_servico=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, servico.getNm_servico());
		stmt.setString(2, servico.getDs_servico());

		stmt.execute();
		stmt.close();
	}

}
