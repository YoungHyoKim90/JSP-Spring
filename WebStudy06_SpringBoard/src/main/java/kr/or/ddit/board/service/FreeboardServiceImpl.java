package kr.or.ddit.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.FreeboardDAO;

@Service
public class FreeboardServiceImpl implements FreeboardService {
	@Inject
	private FreeboardDAO boardDAO;
}
