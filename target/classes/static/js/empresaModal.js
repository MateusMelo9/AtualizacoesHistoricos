var AtualizacoesHistoricos = AtualizacoesHistoricos || {}

AtualizacoesHistoricos.PesquisaSolicitante = (function(){
	
	function PesquisaSolicitante(){
		this.pesquisaSolicitanteModal = $('#solicitanteModal');
		this.solicitanteInput = $('#cpesquisa');
		this.pesquisaSolicitanteBtn = $('.js-pesquisa-solicitante-modal-btn');
		this.containerTabelaPesquisaSolicitante = $('#containerTabelaPesquisaSolicitante');
		this.htmlTabelaPesquisa = $('#tabelaSolicitante').html();
		this.template = Handlebars.compile(this.htmlTabelaPesquisa);
		this.mensagemErro = $('.js-mensagem-erro');
		this.solicitante = $('.js-solicitate-pesquisa-modal');
	}
	
	PesquisaSolicitante.prototype.iniciar = function(){
		this.pesquisaSolicitanteBtn.on('click', onPesquisaClicado.bind(this));
		this.pesquisaSolicitanteModal.on('shown.bs.modal', onModalShow.bind(this));
		this.pesquisaSolicitanteModal.on('hide.bs.modal', onModalClose.bind(this));
	}
	
	function onModalShow(){
		this.solicitanteInput.focus();
	}
	
	function onModalClose(){
		this.solicitanteInput.val('');
		this.mensagemErro.addClass('hidden');
		var html = this.template('');
		this.containerTabelaPesquisaSolicitante.html('');
	}

	function onPesquisaClicado(event){
		event.preventDefault();
		
		$.ajax({
			url: this.pesquisaSolicitanteModal.find('form').attr('action'),
			method: 'GET',
			contentType:'application/json',
			data: {
				cpesquisa:this.solicitanteInput.val()
			},
			success: onPesquisaConcluida.bind(this),
			error: onErroPesquisa.bind(this)
		});
	}
	
	function onPesquisaConcluida(resultado){
		this.mensagemErro.addClass('hidden');
		
		var html = this.template(resultado);
		this.containerTabelaPesquisaSolicitante.html(html);
		
		var tabelaSolicitanteModal = new AtualizacoesHistoricos.TabelaSolicitanteModal(this.pesquisaSolicitanteModal);
		tabelaSolicitanteModal.iniciar();
	}
	
	function onErroPesquisa(){
		this.mensagemErro.removeClass('hidden');
	}
	
	return PesquisaSolicitante;
}());

AtualizacoesHistoricos.TabelaSolicitanteModal = (function(){
	
	function TabelaSolicitanteModal(modal){
		this.modalSolicitante = modal;
		this.solicitante=$('.js-solicitate-pesquisa-modal');
	}
	
	TabelaSolicitanteModal.prototype.iniciar = function(){
		this.solicitante.on('click', onSolicitanteSelecionado.bind(this));
	}
	
	function onSolicitanteSelecionado(event){
		this.modalSolicitante.modal('hide');
		var solicitanteSelecionado = $(event.currentTarget);
		$('#id_empresa').val(solicitanteSelecionado.data('codigo'));
		$('#cnome_empresa').val(solicitanteSelecionado.data('nome'));
	}
	
	return TabelaSolicitanteModal;
	
}());

$(function(){
	var pesquisaSolicitante = new AtualizacoesHistoricos.PesquisaSolicitante();
	pesquisaSolicitante.iniciar();
});