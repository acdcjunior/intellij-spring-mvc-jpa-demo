package br.gov.tcu.bbt.domain.usuario;

import br.gov.tcu.bbt.domain.BaseRepository;

public interface UsuarioRepository extends BaseRepository<Usuario> {
	
    Usuario findByNome(String nome);
    
}