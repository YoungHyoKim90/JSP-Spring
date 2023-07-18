package kr.or.ddit.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.emp.vo.JobVO;

@Mapper
public interface JobDAO {
	public int insertJob(JobVO job);
	public List<JobVO> selectJobs();
	public JobVO selectJob(@Param("jobId") String jobId);
	public int updateJob(JobVO job);
	public int deleteJob(@Param("jobId") String jobId);
}
