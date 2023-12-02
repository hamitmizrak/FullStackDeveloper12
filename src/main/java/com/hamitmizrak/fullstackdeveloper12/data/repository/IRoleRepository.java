package com.hamitmizrak.fullstackdeveloper12.data.repository;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>

import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {

    // Delivered Query
    // Role name bulmak
    Optional<RoleEntity> findByRoleName(String roleName);

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // @ManyToMany
    // RolesEntity üzerinden RegisterEntity  çağırma
    // NOT: Query: Karmaşık sorgular için kullanıyoruz.
    // NOT: registerEmailFindRole => RoleEntity üzerinden EmailAddresi Bulmak içindir.
    // NOT: EntityNameRegisters bu isim RegisterEntity Name kullandığım parametredir.
    @Query("select r from EntityNameRegisters regEntity join regEntity.roles r where regEntity.rEmail = :emailParam")
    RoleEntity registerEmailFindRole(@Param("emailParam") String email);

} //end interface
