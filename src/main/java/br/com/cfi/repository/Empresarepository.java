package br.com.cfi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cfi.model.Empresa;

public interface Empresarepository extends JpaRepository<Empresa, Integer> {
	
	@Query(value="select nid_empresa,f_ascutf8(cnome_empresa) as cnome_empresa, f_ascutf8(cpesquisa) as cpesquisa from empresa \n--#pageable\n", nativeQuery = true)
	public Page<Empresa> findAll(Pageable pageable);
	
	@Query(value="select nid_empresa,f_ascutf8(cnome_empresa) as cnome_empresa, f_ascutf8(cpesquisa) as cpesquisa from empresa where cpesquisa like ?1% ", nativeQuery = true)
	public List<Empresa> findByCpesquisaContaining(String cpesquisa);
}
