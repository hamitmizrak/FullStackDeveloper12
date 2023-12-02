package com.hamitmizrak.fullstackdeveloper12.data.repository;

import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>

@Repository
public interface IRegisterRepository extends CrudRepository<RegisterEntity, Long> {

    // Delivered Query
    // Emailden kullanıcı objesini bulmak
    // REmail: buradaki R register'ının kısaltması için kullandım.
    Optional<RegisterEntity> findByREmail(String email);

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // RegisterEntity üzerinden RolesEntity çağırma
    // NOT: Query: Karmaşık sorgular için kullanıyoruz.
    // NOT: findAllByRegisterInJoinRolesRoleName => RegisterEntity üzerinden RolesName Bulmak içindir.
    // NOT: EntityNameRegisters bu isim RegisterEntity Name kullandığım parametredir.
    @Query("select reg from EntityNameRegisters reg join reg.roles rol where rol.roleName= :roleNameParam")
    List<RegisterEntity> findAllByRegisterInJoinRolesRoleName(@Param("roleNameParam") String roleName);

} //end interface
