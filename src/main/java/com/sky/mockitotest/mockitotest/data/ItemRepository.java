package com.sky.mockitotest.mockitotest.data;

import com.sky.mockitotest.mockitotest.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
