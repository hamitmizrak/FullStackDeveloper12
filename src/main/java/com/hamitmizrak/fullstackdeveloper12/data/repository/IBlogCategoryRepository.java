package com.hamitmizrak.fullstackdeveloper12.data.repository;

import com.hamitmizrak.fullstackdeveloper12.data.entity.BlogCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>

@Repository
public interface IBlogCategoryRepository extends CrudRepository<BlogCategoryEntity,Long> {

    // Delivered Query (Kendi sorgumu yazdım)
    Optional<BlogCategoryEntity> findByCategoryName(String categoryName);
}
