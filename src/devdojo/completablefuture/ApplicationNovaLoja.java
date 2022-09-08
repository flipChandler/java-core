package devdojo.completablefuture;

import devdojo.completablefuture.model.NovaLoja;

import java.util.List;

public class ApplicationNovaLoja {

    public static void main(String[] args) {
        List<NovaLoja> lojas = NovaLoja.lojas();

        lojas.stream()
                .forEach(novaLoja -> System.out.println(novaLoja.getPreco()));
    }
}
