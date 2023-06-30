package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "prodId")
public class ProdVO implements Serializable {
	@NotBlank
	private String prodId;
	@NotBlank
	private String prodName;
	@NotBlank
	private String prodLgu;
	@NotBlank
	private String prodBuyer;
	@Min(0)
	private int prodCost;
	@Min(0)
	private int prodPrice;
	@NotNull
	@Min(0)
	private Integer prodSale;
	@NotBlank
	private String prodOutline;
	private String prodDetail;
	@NotBlank
	private String prodImg;
	@Min(0)
	private int prodTotalstock;
	private LocalDate prodInsdate;
	@NotNull
	@Min(0)
	private Integer prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private Integer prodQtyin;
	private Integer prodQtysale;
	private Integer prodMileage;
}








