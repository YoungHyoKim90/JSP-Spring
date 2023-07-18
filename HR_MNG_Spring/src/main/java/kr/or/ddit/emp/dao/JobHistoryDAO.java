package kr.or.ddit.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.emp.vo.JobHistoryVO;
@Mapper
public interface JobHistoryDAO {
	public int insertJobHistory(JobHistoryVO history);
	public List<JobHistoryVO> selectJobHistories(JobHistoryVO detailCondition);
}
