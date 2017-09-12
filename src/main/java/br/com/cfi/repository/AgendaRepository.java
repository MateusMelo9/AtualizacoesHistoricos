package br.com.cfi.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cfi.model.Tagenda;

public interface AgendaRepository extends JpaRepository<Tagenda, Long> {
	
	@Query(value="select fw_tagenda(?1,?2,?3,?4,?5,?6)", nativeQuery=true)
	public void findByFuncaoTagenda(Integer id, Date dataInicio, Date dataFim, Integer nid_empresa, String cid_usu, String cstatus);
	
	@Query(value="select nid_xpesquisa,Ddata,Csemana,Chora,Cid_usu,Cnome_usuario,Nid_empresa,Cnome_empresa,Cobs,Cstatus from x_pesquisa where nid=?1", nativeQuery=true)
	public List<Tagenda> findByXpesquisaFuncaoTagenda(Integer id);
	
	@Query(value="select fw_agendausuario(?1)", nativeQuery = true)
	public void findByFuncaoConsultor(Integer id);
	
	@Query(value="select nid_xpesquisa,Ddata,Csemana,Chora,Cid_usu,Cnome_usuario,Nid_empresa,Cnome_empresa,Cobs,Cstatus from x_pesquisa xp where xp.nid=?1 \n--#pageable\n", nativeQuery=true)
	public Page<Tagenda> findByAllRandom(Integer id,Pageable pageable);
}
