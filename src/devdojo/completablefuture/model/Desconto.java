package devdojo.completablefuture.model;

public class Desconto {

    public enum Codigo {
        NENHUM(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        ELITE(20);

        private final int procentagem;

        Codigo(int procentagem) {
            this.procentagem = procentagem;
        }

        public int getProcentagem() {
            return procentagem;
        }
    }
}
