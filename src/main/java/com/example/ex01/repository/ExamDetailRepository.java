package com.example.ex01.repository;

import com.example.ex01.entity.Exam;
import com.example.ex01.entity.ExamDetail;
import com.example.ex01.entity.User;
import com.example.ex01.repository.CustomizedRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamDetailRepository extends CustomizedRepository<ExamDetail, Integer> {
    @Query("SELECT ed.exam FROM ExamDetail ed WHERE ed.teacher.id=:tid")
    List<Exam> listOfExam(@Param("tid") int tid);

    @Query("SELECT ed.teacher FROM ExamDetail ed WHERE ed.exam.id=:eid")
    List<User> listOfTeacher(@Param("eid") int eid);

   @Query("SELECT count(ed) FROM ExamDetail ed WHERE ed.teacher.id=:tid")
    int countOfExam(@Param("tid") int tid);

    @Query("FROM ExamDetail ed WHERE ed.exam.id=:eid AND ed.teacher.id=:tid")
    ExamDetail findExamDetail(@Param("eid") int eid, @Param("tid") int tid);

    @Query("SELECT ed FROM ExamDetail ed")
    List<ExamDetail> findAllExamDetails();
}
