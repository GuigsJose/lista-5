package br.edu.up.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.up.Models.Enums.Categoria;

public class Prompts {
    List<String> labelCategoria = Arrays.asList(
            "Ficção",
            "Religiosos",
            "Contos",
            "Romances",
            "Didádicos",
            "Infantis",
            "Quadrinhos",
            "Poesia",
            "Biografia",
            "Fantasia",
            "Tecnologia");

    public String DescricaoCategoria(int categoria) {
        return labelCategoria.stream().filter(x -> x.length() == categoria).collect(Collectors.toList())
                .toString();
    }

}
