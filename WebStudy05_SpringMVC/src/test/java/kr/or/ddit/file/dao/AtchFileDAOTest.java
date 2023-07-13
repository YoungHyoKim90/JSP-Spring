package kr.or.ddit.file.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootTest;
import kr.or.ddit.file.vo.AtchFileDetailVO;
import kr.or.ddit.file.vo.AtchFileVO;

class AtchFileDAOTest extends AbstractRootTest{
	@Inject
	private AtchFileDAO dao;


	@Test
	void testGroup() {
		AtchFileVO groupVO = dao.selectAtchFileGroup(35);
		assertEquals(groupVO.getDetailList().size(), 6);
		
	}
	@Test
	void testFile() {
		AtchFileDetailVO condition = new AtchFileDetailVO();
		condition.setAtchFileId(35);
		condition.setFileSn(6);
		AtchFileDetailVO fileDetail = dao.selectAtchFileDetail(condition);
		assertNotNull(fileDetail);
		
	}
	@Test
	void testInsert() {
		AtchFileDetailVO file1 =  new AtchFileDetailVO();
		file1.setFileMime("image/png");
		file1.setFileSize(1000);
		file1.setFileStreCours("저장경로3");
		file1.setStreFileNm("저장명3");
		file1.setOrignlFileNm("원본파일명3");
		file1.setFileExtsn("png");
		
		AtchFileDetailVO file2 =  new AtchFileDetailVO();
		file2.setFileMime("image/png");
		file2.setFileSize(1000);
		file2.setFileStreCours("저장경로4");
		file2.setStreFileNm("저장명4");
		file2.setOrignlFileNm("원본파일명4");
		file2.setFileExtsn("png");
		
		AtchFileVO groupVO = new AtchFileVO();
		
		groupVO.setDetailList(Arrays.asList(file1,file2));
		int cnt = dao.insertAtchFileGroup(groupVO);
		
		assertEquals(cnt, 3);
	}
}
