package br.com.cfi.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class PageWrapper<T> {

	private Page<T> page;
	private UriComponentsBuilder uriBuilder;
	
	public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest) {
		// TODO Auto-generated constructor stub
		this.page = page;
		this.uriBuilder = ServletUriComponentsBuilder.fromRequest(httpServletRequest);
	}
	
	public List<T> getContent(){
		return page.getContent();
	}
	
	public boolean isEmpty(){
		return page.getContent().isEmpty();
	}
	
	public boolean isFirst(){
		return page.isFirst();
	}
	
	public boolean isLast(){
		return page.isLast();
	}
	
	public int getNumber(){
		return page.getNumber();
	}
	
	public int getTotalPages(){
		return page.getTotalPages();
	}
	
	public String urlToPage(int pagina){
		return uriBuilder.replaceQueryParam("page", pagina).build(true).encode().toUriString();
	}
	
}
