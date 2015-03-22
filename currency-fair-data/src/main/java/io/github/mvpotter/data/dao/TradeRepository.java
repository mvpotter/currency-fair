package io.github.mvpotter.data.dao;

import io.github.mvpotter.data.model.Trade;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TradeRepository extends PagingAndSortingRepository<Trade, Long> {

}
