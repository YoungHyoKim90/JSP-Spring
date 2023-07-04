<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<form method="post">
	<input type="hidden" name="buyerId" value="${buyer.buyerId }"/>
	<table class="table table-border">
		<tr>
			<th>거래처명</th>
			<td>
				<input class="form-control" type="text" name="buyerName"
				value="${buyer.buyerName }" />
				<span class="error">${errors["buyerName"]}</span>
			</td>
		</tr>
		<tr>
			<th>거래처분류</th>
			<td>
				<select name="buyerLgu" class="form-select">
					<option value>분류선택</option>
					<c:forEach items="${lprodList }" var="lprod">
						<option value="${lprod.lprodGu }"
							${lprod.lprodGu eq buyer.buyerLgu ? "selected" : "" }
						>${lprod.lprodNm }</option>
					</c:forEach>
				</select>
				<span class="error">${errors["buyerLgu"]}</span>
			</td>
		</tr>
		<tr>
			<th>은행</th>
			<td>
				<input class="form-control" type="text" name="buyerBank"
				value="${buyer.buyerBank }" />
				<span class="error">${errors["buyerBank"]}</span>
			</td>
		</tr>
		<tr>
			<th>계좌</th>
			<td>
				<input class="form-control" type="text" name="buyerBankno"
				value="${buyer.buyerBankno }" />
				<span class="error">${errors["buyerBankno"]}</span>
			</td>
		</tr>
		<tr>
			<th>계좌주</th>
			<td>
				<input class="form-control" type="text" name="buyerBankname"
				value="${buyer.buyerBankname }" />
				<span class="error">${errors["buyerBankname"]}</span>
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
				<input class="form-control" type="text" name="buyerZip"
				value="${buyer.buyerZip }" />
				<span class="error">${errors["buyerZip"]}</span>
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<input class="form-control" type="text" name="buyerAdd1"
				value="${buyer.buyerAdd1 }" />
				<span class="error">${errors["buyerAdd1"]}</span>
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<input class="form-control" type="text" name="buyerAdd2"
				value="${buyer.buyerAdd2 }" />
				<span class="error">${errors["buyerAdd2"]}</span>
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>
				<input class="form-control" type="text" name="buyerComtel"
				value="${buyer.buyerComtel }" />
				<span class="error">${errors["buyerComtel"]}</span>
			</td>
		</tr>
		<tr>
			<th>팩스번호</th>
			<td>
				<input class="form-control" type="text" name="buyerFax"
				value="${buyer.buyerFax }" />
				<span class="error">${errors["buyerFax"]}</span>
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input class="form-control" type="text" name="buyerMail"
				value="${buyer.buyerMail }" />
				<span class="error">${errors["buyerMail"]}</span>
			</td>
		</tr>
		<tr>
			<th>담당자명</th>
			<td>
				<input class="form-control" type="text" name="buyerCharger"
				value="${buyer.buyerCharger }" />
				<span class="error">${errors["buyerCharger"]}</span>
			</td>
		</tr>
		<tr>
			<th>내선번호</th>
			<td>
				<input class="form-control" type="text" name="buyerTelext"
				value="${buyer.buyerTelext }" />
				<span class="error">${errors["buyerTelext"]}</span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="btn btn-success" type="submit" value="등록">
				<input class="btn btn-danger" type="reset" value="취소">
				<input class="btn btn-secondary" type="button" value="뒤로가기"
					onclick="history.back();"
				>
				<a class="btn btn-secondary" href="<c:url value='/buyer/buyerList.do'/>">목록으로</a>
			</td>
		</tr>
	</table>
</form>
