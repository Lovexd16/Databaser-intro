package com.javatodo.javatodo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
    
    @Query("SELECT t FROM Todo t WHERE t.deleted = 0") //skriv alla SQL kommandon med stora bokstäver. t för första bokstaven i todo. Stort T i Todo för det är klassen vi vill åt.
    List<Todo> findByNotDeleted(); //gör metod för att hitta de todos som inte är soft deleted

    @Transactional
    @Modifying
    @Query("UPDATE Todo t SET t.deleted = 1 WHERE t.id = ?1") //?1 betyder att vi ska skicka in ett dynamiskt värde
    int deleteTodo(int id);
}
