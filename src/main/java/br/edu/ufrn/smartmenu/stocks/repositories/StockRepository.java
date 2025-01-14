package br.edu.ufrn.smartmenu.stocks.repositories;

import java.util.Optional;

import br.edu.ufrn.smartmenu.items.models.Item;
import br.edu.ufrn.smartmenu.stocks.models.Stock;

public abstract interface StockRepository<T extends Stock<? extends Item>> {
    public Optional<T> findByItemId(Long itemId);
}
