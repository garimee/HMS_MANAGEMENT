
package com.example.HMS_MANAGEMENT.repository;

import com.example.HMS_MANAGEMENT.constent.InvenStatus;
import com.example.HMS_MANAGEMENT.dto.InvenDto;
import com.example.HMS_MANAGEMENT.entity.InvenEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvenRepo extends JpaRepository<InvenEntity,Long> {

    List<InvenEntity> findAllByInvenStatusOrderByTimeDesc(InvenStatus invenStatus);
    List<InvenEntity> findByInvenStatusNotAndDateBetween(InvenStatus i, LocalDate start , LocalDate end , Sort date);
    void deleteAllByIdCode(Integer idCode);

    @Query("select sum(c.sellCash) from InvenEntity c where c.date = :d")
    Integer totalSellProduct(LocalDate d);

    @Query("select sum(c.buyCash) from InvenEntity c where c.date = :d")
    Integer totalBuyProduct(LocalDate d );

}
