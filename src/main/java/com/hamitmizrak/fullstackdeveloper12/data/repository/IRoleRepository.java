package com.hamitmizrak.fullstackdeveloper12.data.repository;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>

import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {

    // Delivered Query
    // role name bulmak
    Optional<RoleEntity> findByRoleName(String roleName);

    // @ManyToMany
}
