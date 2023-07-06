package kr.or.ddit.case1.dao;

public class Case1DAOFactory {
	public Case1DAO getCase1DAO() {
		return new Case1DAOImpl_Mysql();
	}
}
