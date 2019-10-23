package com.test.mapper;

import com.test.entity.Question;
import com.test.entity.QuestionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface QuestionMapper {
    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);
    //ËÑË÷
    List<Question> selectByExampleRegexp(QuestionExample example,@Param("search")String search);

    Question selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
 
    int addQuesttionCount(@Param("record")Question record);
    int addQuesttionreply(@Param("record")Question record);

	List<Question> SelectByTat(@Param("record")Question record);




}