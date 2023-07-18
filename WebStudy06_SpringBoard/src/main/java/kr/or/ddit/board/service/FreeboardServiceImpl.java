package kr.or.ddit.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.FreeboardDAO;
import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.board.vo.PaginationInfo;

@Service
public class FreeboardServiceImpl implements FreeboardService {
	@Inject
	private FreeboardDAO boardDAO;
	@Inject
	private PasswordEncoder encoder;

	private void encryptBoard(FreeboardVO board) {
		String plain = board.getBoPass();
		String encoded = encoder.encode(plain);
		board.setBoPass(encoded);
	}
	
	@Override
	public boolean createBoard(FreeboardVO board) {
		encryptBoard(board);
		return boardDAO.insertBoard(board) > 0;
	}


	@Override
	public List<FreeboardVO> retrieveBoardList(PaginationInfo paging) {
		long totalRecord = boardDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return boardDAO.selectBoardList(paging);
	}

	@Override
	public FreeboardVO retrieveBoard(int boNo) {
		return boardDAO.selectBoard(boNo);
	}

	@Override
	public boolean modifyBoard(FreeboardVO board) {
		return boardDAO.updateBoard(board) > 0;
	}

	@Override
	public boolean removeBoard(FreeboardVO board) {
		return boardDAO.deleteBoard(board) > 0;
	}
}
