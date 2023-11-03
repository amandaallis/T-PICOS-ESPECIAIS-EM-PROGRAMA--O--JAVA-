package com.faculdade.Controller;

import com.faculdade.modelo.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final List<Produto> listaProduto = new ArrayList<>();
    int id = 1;

    @GetMapping()
    public List<Produto> getProduct() {
        return listaProduto;
    }
    @GetMapping("/{cod}")
    public Stream getProductById(@PathVariable(value = "cod") Long cod) {
         return listaProduto.stream().filter(item -> item.getCodigo().equals(cod));
    }

    @PostMapping()
    public Produto newProduct(@RequestBody Produto produto) {
        Produto prod = new Produto();
        prod.setCodigo(Long.valueOf(id++));
        prod.setDescricao(produto.getDescricao());
        prod.setValor(prod.getValor());
        listaProduto.add(prod);
        return produto;
    }
    @PutMapping()
    public String updateProduct(@RequestParam Long cod,
                                        @RequestBody Produto produto) {
        listaProduto.forEach(item -> {
            if (item.getCodigo().equals(cod)) {

                item.setValor(produto.getValor());
                item.setDescricao(produto.getDescricao());
            }
        });
        return "Atualizado com sucesso!";
    }

    @DeleteMapping()
    public String deleteProductById(@RequestParam Long cod) {
        Iterator<Produto> iterator = listaProduto.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getCodigo().equals(cod)) {
                iterator.remove();
                return "Produto removido com sucesso";
            }
        }
        return "Produto não encontrado";
    }
}
