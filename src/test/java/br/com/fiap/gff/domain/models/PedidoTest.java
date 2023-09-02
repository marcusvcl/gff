package br.com.fiap.gff.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.model.entities.Pedido;
import br.com.fiap.gff.domain.model.valueobjects.ItemPedido;

class PedidoTest {

    @Test
    void DeveAdicionarItemAoPedido() {
        var pedido = new Pedido();
        var itemPedido = new ItemPedido("id", "nome", 3d, 10);
        pedido.adicionarItem(itemPedido);
        var quantidadeItems = pedido.getItems().size();
        assertEquals(1, quantidadeItems);
    }

    @Test
    void DeveAdicionarItensAoPedido() {
        var pedido = new Pedido();
        var item1 = new ItemPedido("id", "nome", 5d, 10);
        var item2 = new ItemPedido("id2", "nome2", 6d, 11);
        var items = new ArrayList<ItemPedido>(Arrays.asList(item1, item2));
        pedido.adicionarItem(items);
        var quantidadeItems = pedido.getItems().size();
        assertEquals(2, quantidadeItems);
    }

    @Test
    void DeveLancarExcecaoSeProdutoIdDoItemForNulo() {
        var pedido = new Pedido();
        var itemPedido = new ItemPedido(null, "nome", 2d, 10);
        Throwable exception = assertThrows(NullPointerException.class, () -> pedido.adicionarItem(itemPedido));
        assertEquals("Não se pode adicionar um item sem produto", exception.getMessage());
    }

    @Test
    void DeveLancarExcecaoSeQuantidadeDoItemForNegativo() {
        var pedido = new Pedido();
        var itemPedido = new ItemPedido("id", "nome", 3d, -5);
        Throwable exception = assertThrows(RequisicaoInvalidaException.class, () -> pedido.adicionarItem(itemPedido));
        assertEquals("Não se pode adicionar um item com quantidade negativa", exception.getMessage());
    }

    @Test
    void DeveLancarExcecaoSePrecoDoItemForNegativo() {
        var pedido = new Pedido();
        var itemPedido = new ItemPedido("id", "nome", -2d, 10);
        Throwable exception = assertThrows(RequisicaoInvalidaException.class, () -> pedido.adicionarItem(itemPedido));
        assertEquals("Não se pode adicionar um item com preço negativo", exception.getMessage());
    }

    @Test
    void DeveRemoverItemPeloProdutoIdDoPedido() {
        var pedido = new Pedido();
        var item1 = new ItemPedido("id", "nome", 5d, 10);
        var item2 = new ItemPedido("id2", "nome2", 6d, 11);
        var items = new ArrayList<ItemPedido>(Arrays.asList(item1, item2));
        pedido.adicionarItem(items);
        pedido.removerItem(item1.getProdutoId());
        var quantidadeItems = pedido.getItems().size();
        assertEquals(1, quantidadeItems);
    }

    @Test
    void DeveCalcularTotalDoPedido() {
        var pedido = new Pedido();
        var item1 = new ItemPedido("id", "nome", 5d, 10);
        var item2 = new ItemPedido("id2", "nome2", 6d, 11);
        var items = new ArrayList<ItemPedido>(Arrays.asList(item1, item2));
        pedido.adicionarItem(items);
        pedido.calcularTotalPedido();
        var totalPedido = pedido.getTotalPedido();
        assertEquals(11d, totalPedido);
    }

    @Test
    void DeveRetornarZeroAoCalcularTotalDoPedidoSemItems() {
        var pedido = new Pedido();
        pedido.calcularTotalPedido();
        var totalPedido = pedido.getTotalPedido();
        assertEquals(0, totalPedido);
    }

    @Test
    void DeveAtualizarStatusDoPedido() {
        var pedido = new Pedido();
        pedido.atualizarStatus("PRONTO");
        var novoStatus = pedido.getStatus().getStatus();
        assertNotNull(novoStatus);
    }

    @Test
    void DeveLancarExcecaoSeStatusInformadoNaoEstiverMapeado() {
        var pedido = new Pedido();
        Throwable exception = assertThrows(RequisicaoInvalidaException.class, () -> pedido.atualizarStatus("TESTE"));
        assertEquals("O status informado é inválido. Por favor repita a operação com um status válido.",
                exception.getMessage());
    }
}