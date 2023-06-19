package com.example.todolistspringbootintership.repositories;

import com.example.todolistspringbootintership.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>
{
}
