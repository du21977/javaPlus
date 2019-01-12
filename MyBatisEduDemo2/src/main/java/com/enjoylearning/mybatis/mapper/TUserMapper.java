package com.enjoylearning.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.enjoylearning.mybatis.entity.EmailSexBean;
import com.enjoylearning.mybatis.entity.TJobHistory;
import com.enjoylearning.mybatis.entity.TUser;

public interface TUserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert1(TUser record);
    
    int insert2(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    
    List<TUser> selectUserJobs1();
    
    List<TUser> selectUserJobs2();

//    <!--传参方式1，使用map，不推荐使用-->
    List<TUser> selectByEmailAndSex1(Map<String, Object> param);
//    <!--传参方式2：使用注解传参-->
    List<TUser> selectByEmailAndSex2(@Param("email") String email, @Param("sex") Byte sex);
//    <!--传参方式2：传对象-->
    List<TUser> selectByEmailAndSex3(EmailSexBean esb);
    
    
    List<TUser> selectBySymbol(@Param("tableName") String tableName,
                               @Param("inCol") String inCol,
                               @Param("orderStr") String orderStr,
                               @Param("sex") Byte sex);
    
    List<TUser> selectIfOper(@Param("email") String email, @Param("sex") Byte sex);
    
    
    List<TUser> selectIfandWhereOper(@Param("email") String email, @Param("sex") Byte sex);
    
    int updateIfOper(TUser record);
    
    int updateIfAndSetOper(TUser record);
    
    int insertIfOper(TUser record);
    
    List<TUser> selectForeach4In(String[] names);
    
    int insertForeach4Batch(List<TUser> users);
    
    
    
    
    
}