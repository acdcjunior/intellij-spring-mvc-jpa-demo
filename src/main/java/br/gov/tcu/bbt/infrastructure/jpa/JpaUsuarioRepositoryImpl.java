package br.gov.tcu.bbt.infrastructure.jpa;

import br.gov.tcu.bbt.domain.usuario.Usuario;
import br.gov.tcu.bbt.domain.usuario.UsuarioRepository;

import org.springframework.stereotype.Repository;

@Repository
public class JpaUsuarioRepositoryImpl extends JpaAbstractRepository<Usuario> implements UsuarioRepository {
	
	public static final String FIND_BY_NOME = "Usuario.findByNome";

	@Override
	public Usuario findByNome(String nome) {
		return this.em.createNamedQuery(FIND_BY_NOME, Usuario.class)
				      .setParameter("nome", nome)
				      .getSingleResult();
	}

}