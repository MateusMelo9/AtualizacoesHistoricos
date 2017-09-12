var AtualizacoesHistoricos = AtualizacoesHistoricos || {}

AtualizacoesHistoricos.MaskMoney = (function(){
	
	function MaskMoney(){
		this.plain = $('.js-plain');
	}
	
	MaskMoney.prototype.iniciar = function(){
		this.plain.maskMoney({precision: 0});
	}
	
	return MaskMoney;
	
}());

$(function(){
	var maskMoney = new AtualizacoesHistoricos.MaskMoney();
	maskMoney.iniciar();
});