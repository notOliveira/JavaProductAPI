package com.fatec.produto;

import com.fatec.produto.model.entities.Produto;
import com.fatec.produto.services.IProdutoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProdutoApplicationTests {
	@Autowired
	IProdutoService produtoServico;

	@Test
	void contextLoads() {
	}

	@Test
	void ct01_verifica_custo() throws Exception {
		Produto produto = new Produto();
		produto.setCusto(12);
		assertEquals(12, produto.getCusto());
	}
	@Test
	void ct_02_consulta_com_sucesso() {
		List<Produto> produtos = produtoServico.consultaCatalogo();
		assertEquals(0, produtos.size());
	}
}
