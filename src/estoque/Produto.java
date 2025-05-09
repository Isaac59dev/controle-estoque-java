package estoque;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
        }
    }

    public void removerEstoque(int qtd) {
        if (qtd > 0 && qtd <= quantidade) {
            this.quantidade -= qtd;
        }
    }

    @Override
    public String toString() {
        return String.format("Produto: %s | Quantidade: %d | Preço: R$ %.2f", nome, quantidade, preco);
    }
}
