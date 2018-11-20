package com.voam.springbootmockito.data;

import com.voam.springbootmockito.domain.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
