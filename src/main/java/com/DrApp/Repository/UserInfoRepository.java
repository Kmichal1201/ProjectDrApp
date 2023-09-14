package com.DrApp.Repository;

import com.DrApp.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {


}
