package com.hamitmizrak.fullstackdeveloper12.data.repository;

import com.hamitmizrak.fullstackdeveloper12.data.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>

@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity,Long> {

    // Delivered Query (Kendi sorgumu yazdım)
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
