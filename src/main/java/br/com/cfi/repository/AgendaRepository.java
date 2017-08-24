package br.com.cfi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cfi.model.Tagenda;

public interface AgendaRepository extends JpaRepository<Tagenda, Long> {
	
	@Query(value="select fw_tagenda(?1,?2,?3,?4,?5,?6)", nativeQuery=true)
	public void findByFuncaoTagenda(Integer id, Date dataInicio, Date dataFim, Integer nid_empresa, String cnome_empresa, String cstatus);
	
	@Query(value="select nid_xpesquisa,Ddata,Csemana,Chora,Cnome_usuario,Nid_empresa,Cnome_empresa,Cobs,Cstatus from x_pesquisa where nid=?1", nativeQuery=true)
	public List<Tagenda> findByXpesquisaFuncaoTagenda(Integer id);

}
