package com.hamitmizrak.fullstackdeveloper12.data.repository;

import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>

@Repository
public interface IRegisterRepository extends CrudRepository<RegisterEntity, Long> {

    // Delivered Query
    // Emailden kullanıcı objesini bulmak
    // REmail: buradaki R register'ının kısaltması için kullandım.
    //Optional<RegisterEntity> findByREmail(String email);

    ////////////////////////////////
    // ROLES
    // Query: Karmaşık sorgular için kullanıyoruz.

}
