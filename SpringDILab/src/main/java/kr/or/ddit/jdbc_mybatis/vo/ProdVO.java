package kr.or.ddit.jdbc_mybatis.vo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Data Mapper 를 이용해서 두개 이상의 테이블로부터 데이터를 조회하는 방법
 * 1. 메인 테이블을 기준(1)으로 테이블간의 관계성을 파악함.
 * 	ex) PROD vs	BUYER - 1:1 하나의 상품은 하나의 거래처를 가짐(has a).
 * 		BUYER vs PROD - 1:N 하나의 거래처는 여러개의 거래 상품을 가짐(has many)
 * 2. 각 테이블로부터 조회된 데이터를 바인딩한 도메인 객체 간의 관계 형성 
 *	ex) ProdVO has a BuyerVO
 *		BuyerVO has many ProdVO
 * 3. 직접 조인 쿼리 작성
 * 4. resultType --> resultMap 으로 수동 바인딩 설정.
 * 	  has a : assocation
 * 	  has many : collection
 */
@Data
@EqualsAndHashCode(of = "prodId")
public class ProdVO implements Serializable {
	private String prodId;
	private String prodName;
	private String prodLgu;
	private String prodBuyer;
	private int prodCost;
	private int prodPrice;
	private Integer prodSale;
	private String prodOutline;
	private String prodDetail;
	private String prodImg;
	private int prodTotalstock;
	private LocalDate prodInsdate;
	private Integer prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private Integer prodQtyin;
	private Integer prodQtysale;
	private Integer prodMileage;
	
}








