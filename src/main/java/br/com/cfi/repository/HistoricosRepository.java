package br.com.cfi.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cfi.model.Ophistorico;

public interface HistoricosRepository extends JpaRepository<Ophistorico, Long>{
	
	@Query(value="select nid_xpesquisa, cprograma, cversao, cobs, nid_op, ddata,nid_empresa,cnome_empresa from x_pesquisa where nid=?1", nativeQuery=true)
	public List<Ophistorico> findByXpesquisaOphistorico(Integer id);
	
	@Query(value="select fw_ophistorico(?1,?2,?3,?4,?5)", nativeQuery=true)
	public void findByXpesquisaFuncaoOphistorico(Integer id, Date dataInicio, Date dataFim, String mod, Integer id_empresa);
	
	@Query(value="select fw_opPrograma(?1)", nativeQuery=true)
	public void findByFuncaoCprograma(Integer id);
	
	@Query(value="select nid_xpesquisa, cprograma, cversao, cobs, nid_op, ddata,nid_empresa,cnome_empresa from x_pesquisa x where nid=?1 ", nativeQuery=true)
	public List<Ophistorico> findByCprograma(Integer id);
	
	@Query(value="select nid_xpesquisa, cprograma, cversao, cobs, nid_op, ddata,nid_empresa,cnome_empresa from x_pesquisa x where x.cnome_empresa like %?1%", nativeQuery = true)
	public List<Ophistorico> findByCnome_empresaContaining(String cnome_empresa);
	
}
