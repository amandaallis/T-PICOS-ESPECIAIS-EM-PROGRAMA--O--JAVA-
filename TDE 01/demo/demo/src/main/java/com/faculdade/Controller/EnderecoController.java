package com.faculdade.Controller;

import com.faculdade.modelo.Endereco;
import com.faculdade.modelo.Pessoa;
import com.faculdade.modelo.Produto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    public final List<Endereco> listaEndereco = new ArrayList<>();
    Endereco endereco = new Endereco();
}
