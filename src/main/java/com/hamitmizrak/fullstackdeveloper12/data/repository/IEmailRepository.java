package com.hamitmizrak.fullstackdeveloper12.data.repository;

import com.hamitmizrak.fullstackdeveloper12.data.entity.EmailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>

@Repository
public interface IEmailRepository extends CrudRepository<EmailEntity,Long> {

    //Delivered Query
   Optional<EmailEntity>  findByEmailTo(String email);
}
