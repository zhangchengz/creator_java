package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.po.ClassStudentPO;
import com.tlf.creatoraccount.pojo.Accounts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {

    Accounts queryAccountByPhone(String phone);

    Accounts queryAccountByPhoneOrNumber(String phone, String number);

    void addAccount(Accounts accounts);

    Accounts queryAccountById(String id);

    int updatePassword(String pwd, String id);

    Accounts queryPwdById(String id);

    List<Accounts> queryAccountByClass(String classes);

    void deleteAccount(String id);

    void updateAccount(Accounts accounts);

    void updateAccountClass(String classes, String id);

    void deleteAccountClass(String classes);

    void deleteAccountClassById(String id);

    List<Accounts> selectStudentNoClass();

    List<Accounts> selectAllNames();

    List<ClassStudentPO> selectStudentsByCourseId();

    List<String> selectAllPhone();

    List<String> selectPhoneApartSelf(String id);

    List<String> selectAllNumber();

    List<Accounts> selectAccounts(String role, Integer offset, Integer limit);

    Integer selectCounts(String role);

    List<Accounts> selectStudentByClass(String classes);

}
