package br.com.apiproduto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiproduto.entity.Produto;
import br.com.apiproduto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService=produtoService;
	}
	
	@GetMapping
	@Operation(summary = "Busca por todos produtos")
	public ResponseEntity<List<Produto>> buscarTodos(){
		return ResponseEntity.ok(produtoService.buscarTodos()); //ok n precisa de new Response..
	}
	
	@PostMapping
	@Operation(summary = "Salva um produto") // Descrição do endpoint - Swagger
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
		var novoProduto=produtoService.salvar(produto);
		return new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		produtoService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
