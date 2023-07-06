package kr.or.ddit.jdbc_mybatis.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 상품 분류의 목록 조회시, 해당의 분류의 소속된 상품의 목록까지 함께 조회.
 * 	LPROD(1) VS PROD(N) -> has many
 *
 */
@Data
@EqualsAndHashCode(of="lprodId")
public class LprodVO {
	private Integer lprodId;
	private String lprodGu;
	private String lprodNm;
	
	@ToString.Exclude
	private List<ProdVO> prodList;
}
