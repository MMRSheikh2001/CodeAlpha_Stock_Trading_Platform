/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package stocktradingplatform.db;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface DaoService<E> {

    E save(E e);

    E findById(Long id);

    List<E> findAll();

    E update(E e);

    void delete(Long id);

}
