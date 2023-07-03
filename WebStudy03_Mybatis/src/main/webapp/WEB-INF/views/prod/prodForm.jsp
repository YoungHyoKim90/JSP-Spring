<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post">
<table class="table table-border">
	<tr>
		<th>상품코드(???)</th>
		<td>
			<input class="form-control" type="text" name="prodId"
				value="${prod.prodId }" />
			<span class="error">${errors["prodId"]}</span>
		</td>
	</tr>
	<tr>
		<th>상품명</th>
		<td>
			<input class="form-control" type="text" name="prodName"
				value="${prod.prodName }" />
			<span class="error">${errors["prodName"]}</span>
		</td>
	</tr>
	<tr>
		<th>상품분류(???)</th>
		<td>
			<input class="form-control" type="text" name="prodLgu"
				value="${prod.prodLgu }" />
			<span class="error">${errors["prodLgu"]}</span>
		</td>
	</tr>
	<tr>
		<th>거래처(???)</th>
		<td>
			<input class="form-control" type="text" name="prodBuyer"
				value="${prod.prodBuyer }" />
			<span class="error">${errors["prodBuyer"]}</span>
		</td>
	</tr>
	<tr>
		<th>구매가</th>
		<td>
			<input class="form-control" type="number" name="prodCost"
				value="${prod.prodCost }" />
			<span class="error">${errors["prodCost"]}</span>
		</td>
	</tr>
	<tr>
		<th>판매가</th>
		<td>
			<input class="form-control" type="number" name="prodPrice"
				value="${prod.prodPrice }" />
			<span class="error">${errors["prodPrice"]}</span>
		</td>
	</tr>
	<tr>
		<th>세일가</th>
		<td>
			<input class="form-control" type="number" name="prodSale"
				value="${prod.prodSale }" />
			<span class="error">${errors["prodSale"]}</span>
		</td>
	</tr>
	<tr>
		<th>요약정보</th>
		<td>
			<input class="form-control" type="text" name="prodOutline"
				value="${prod.prodOutline }" />
			<span class="error">${errors["prodOutline"]}</span>
		</td>
	</tr>
	<tr>
		<th>상세정보</th>
		<td>
			<input class="form-control" type="text" name="prodDetail"
				value="${prod.prodDetail }" />
			<span class="error">${errors["prodDetail"]}</span>
		</td>
	</tr>
	<tr>
		<th>이미지경로</th>
		<td>
			<input class="form-control" type="text" name="prodImg"
				value="${prod.prodImg }" />
			<span class="error">${errors["prodImg"]}</span>
		</td>
	</tr>
	<tr>
		<th>총재고</th>
		<td>
			<input class="form-control" type="number"
			name="prodTotalstock" value="${prod.prodTotalstock }" />
			<span
			class="error">${errors["prodTotalstock"]}</span>
		</td>
	</tr>
	<tr>
		<th>입고일</th>
		<td>
			<input class="form-control" type="date" name="prodInsdate"
				value="${prod.prodInsdate }" />
			<span class="error">${errors["prodInsdate"]}</span>
		</td>
	</tr>
	<tr>
		<th>적정재고</th>
		<td>
			<input class="form-control" type="number"
			name="prodProperstock" value="${prod.prodProperstock }" />
			<span
			class="error">${errors["prodProperstock"]}</span>
		</td>
	</tr>
	<tr>
		<th>크기</th>
		<td>
			<input class="form-control" type="text" name="prodSize"
				value="${prod.prodSize }" />
			<span class="error">${errors["prodSize"]}</span>
		</td>
	</tr>
	<tr>
		<th>색상</th>
		<td>
			<input class="form-control" type="text" name="prodColor"
				value="${prod.prodColor }" />
			<span class="error">${errors["prodColor"]}</span>
		</td>
	</tr>
	<tr>
		<th>배송방법</th>
		<td>
			<input class="form-control" type="text" name="prodDelivery"
				value="${prod.prodDelivery }" />
			<span class="error">${errors["prodDelivery"]}</span>
		</td>
	</tr>
	<tr>
		<th>단위</th>
		<td>
			<input class="form-control" type="text" name="prodUnit"
				value="${prod.prodUnit }" />
			<span class="error">${errors["prodUnit"]}</span>
		</td>
	</tr>
	<tr>
		<th>입고량</th>
		<td>
			<input class="form-control" type="number" name="prodQtyin"
				value="${prod.prodQtyin }" />
			<span class="error">${errors["prodQtyin"]}</span>
		</td>
	</tr>
	<tr>
		<th>판매량</th>
		<td>
			<input class="form-control" type="number" name="prodQtysale"
				value="${prod.prodQtysale }" />
			<span class="error">${errors["prodQtysale"]}</span>
		</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>
			<input class="form-control" type="number" name="prodMileage"
				value="${prod.prodMileage }" />
			<span class="error">${errors["prodMileage"]}</span>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="등록">
		</td>
	</tr>
</table>
</form>

