package br.edu.up.utils;

import java.util.Arrays;
import java.util.List;

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

        return labelCategoria.get(categoria).toString();
    }

}
