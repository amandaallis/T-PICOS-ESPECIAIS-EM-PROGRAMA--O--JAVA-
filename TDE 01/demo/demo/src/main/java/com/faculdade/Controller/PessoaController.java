package com.faculdade.Controller;
import com.faculdade.modelo.Endereco;
import com.faculdade.modelo.Pessoa;
import com.faculdade.modelo.Produto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final List<Pessoa> listaPessoas = new ArrayList<>();
    public final List<Endereco> listaEndereco = new ArrayList<>();
    private int id = 1;

    @PostMapping()
    private ResponseEntity<Object> novaPessoa(@RequestBody Pessoa pessoa) {
        if(pessoa != null) {
            Pessoa pes1 = new Pessoa();
            pes1.setId(Long.valueOf(listaPessoas.size()+1));
            pes1.setCpf(pessoa.getCpf());
            pes1.setNome(pessoa.getNome());
            pes1.setSexo(pessoa.getSexo());
            pes1.setDataNascimento(pessoa.getDataNascimento());
            pes1.setEnderecos(pessoa.getEnderecos());
            listaPessoas.add(pes1);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }
    @GetMapping()
    private List<Pessoa> getPessoas() {
        return listaPessoas;
    }
    @GetMapping("/{cpf}")
    private ResponseEntity<Object> getPessoaByCpf(@PathVariable(value = "cpf") Long cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(listaPessoas.stream().filter(item -> item.getCpf().equals(cpf)));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") Long id, @RequestBody Pessoa pessoa) {
        listaPessoas.forEach(item -> {
            if (item.getId().equals(id)) {
                item.setSexo(pessoa.getSexo());
                item.setNome(pessoa.getNome());
                item.setCpf(pessoa.getCpf());
                item.setDataNascimento(pessoa.getDataNascimento());
                item.setEnderecos(pessoa.getEnderecos());
            };
        });
        return ResponseEntity.status(HttpStatus.OK).body(listaPessoas.stream().filter(item -> item.getId().equals(id)));
    }
    @DeleteMapping("{id}")
    private ResponseEntity<Object> deleteperson (@PathVariable(value = "id") Long id) {
        listaPessoas.forEach(item -> {
            if(item.getId().equals(id)) {
                listaPessoas.remove(item);
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body("Item removido com sucesso!");
    }
}
