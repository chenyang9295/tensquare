package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    /**
     * 查新最新问题
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl WHERE id=problemid AND labelid=? ORDER BY replytime desc",nativeQuery = true)
    Page<Problem> newProblem(String labelId, Pageable pageable);

    /**
     * 查新最热问题
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl WHERE id=problemid AND labelid=? ORDER BY reply desc",nativeQuery = true)
    Page<Problem> hotProblem(String labelId, Pageable pageable);

    /**
     * 查新未回复问题
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl WHERE id=problemid AND labelid=? AND reply=0  ORDER BY createtime desc",nativeQuery = true)
    Page<Problem> waitProblem(String labelId, Pageable pageable);
}
