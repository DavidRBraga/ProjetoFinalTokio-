package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionFactory.ConnectionFactory;
import model.Categoria;



public class CategoriaDAO {
	private Connection conexao;

	public CategoriaDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	public void insert(Categoria categoria) throws SQLException {
		String sql = "insert into T_AUTO_CATEGORIA (cd_categoria,nm_categoria,ds_categoria) values (?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setLong(1, categoria.getCd_categoria());
		stmt.setString(2, categoria.getNm_categoria());
		stmt.setString(3, categoria.getDs_categoria());

		stmt.execute();
		stmt.close();

	}
	public List<Categoria> select() throws SQLException {
		List<Categoria> usuarios = new ArrayList<Categoria>();
		String sql = "select * from t_auto_Categoria";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setCd_categoria(rs.getLong("Codigo: "));
			categoria.setNm_categoria(rs.getString("Nome do servico: "));
			categoria.setDs_categoria(rs.getString("Descrição do serviço: "));

		}
		rs.close();
		stmt.close();
		return usuarios;
	}
	public void delete(Long Cd_categoria) throws SQLException {
		String sql = "delete from t_auto_categoria where Cd_categoria=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, Cd_categoria);
		stmt.execute();
		stmt.close();
	}
	public void update(Categoria categoria) throws SQLException {
		String sql = "update t_auto_categoria set Nm_categoria=?, Ds_categoria=?,where Cd_categoria=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, categoria.getNm_categoria());
		stmt.setString(2, categoria.getDs_categoria());

		stmt.execute();
		stmt.close();
	}
	
	

}
