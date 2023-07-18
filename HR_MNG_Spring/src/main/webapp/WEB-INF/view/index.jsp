<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/gridstack.js/7.2.3/gridstack.min.css" integrity="sha512-E+j/1VMJwdKrqR9HtAN+v10hxVLEYPa45J7BcSJ6hCT3T4Qic0IzV8+APYIy/S7Zx++4mdBfGIgfZfug838YWg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/gridstack.js/7.2.3/gridstack-all.js" integrity="sha512-YOR4V4BoOrenWl+3bMIpTC2wgIomAw7M0yPHjAQxP/kc4qL2Ew6gSIfuBzS+nHIfXmKyPxY7s/rmDLJL8pv9vQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style type="text/css">
	.datatr:hover {
		background-color: teal;
	}
	.datatr.active {
		background-color: #6482FF;
	} 
</style>
</head>
<body>
<div class="grid-stack m-3">
	<div class="grid-stack-item" gs-x="0" gs-y="0" gs-w="6" gs-h="3">
		<div class="grid-stack-item-content">
			<h4>해외 지사 현황</h4>
			<div class="row mb-3">
				<div class="col-auto">
					<select id="regionArea" class="form-select">
						<option value>전체</option>
					</select>
				</div>
			</div>
			<table class="table table-bordered">
				<thead class="table-success">
					<tr>
						<th>Department Name</th>
						<th>Manager Name</th>
						<th>Country, City</th>
					</tr>
				</thead>
				<tbody id="deptTB">
					
				</tbody>
			</table>
			<table class="table table-bordered">
				<thead class="table-success">	
					<tr>
						<th>POSTAL_CODE</th>
						<th>STATE_PROVINCE</th>
						<th>CITY</th>
						<th>STREET_ADDRESS</th>
					</tr>
				</thead>
				<tbody id="locTB" class="disable">
				
				</tbody>
			</table>
		</div>
	</div>
	<div class="grid-stack-item" gs-x="6" gs-y="0" gs-w="6" gs-h="3">
		<div class="grid-stack-item-content">
			<h4>직무별 연봉 현황</h4>
			<table class="table table-bordered">
				<thead class="table-success">
					<tr>
						<th>직무명</th>
						<th>연봉하한</th>
						<th>연봉상한</th>
					</tr>
				</thead>
				<tbody id="jobTB">
				</tbody>
			</table>
		</div>	
	</div>
	<div class="grid-stack-item" gs-x="0" gs-y="3" gs-w="12" gs-h="4">
		<div class="grid-stack-item-content">
			<table class="table table-bordered">
				<thead class="table-success">
					<tr>
						<th>이름</th>
						<th>이메일</th>
						<th>폰번호</th>
						<th>사수</th>
						<th>부서</th>
						<th>직무</th>
						<th>입사일</th>
						<th>퇴사일</th>
					</tr>
				</thead>
				<tbody id="empTB"></tbody>
			</table>
			<div class="pagingArea d-flex justify-content-center m-3"></div>
			<div id="searchUI" class="row justify-content-center">
				<div class="col-auto">
					<label for="empName" class="col-form-label">이름</label>
				</div>	
				<div class="col-auto">	
					<input type="text" name="empName" id="empName" placeholder="이름" class="form-control" /> 
				</div>
				<div class="col-auto">
					<label for="startMonth" class="col-form-label">입사일기준</label>
				</div>	
				<div class="col-auto">
					<div class="input-group">
						<input type="month" name="startMonth" id="startMonth" placeholder="2000-01" class="form-control"/>
						<span class="input-group-text">~</span>
						<input type="month" name="endMonth" id="endMonth" placeholder="2023-12" class="form-control"/>
					</div>
				</div>
				<div class="col-auto">
					<input type="button" id="searchBtn" value="검색" class="btn btn-primary" />
				</div>
			</div>
			<form id="searchForm" action="<c:url value='/employees'/>">
				<input type="hidden" name="page" placeholder="page" />
				<input type="hidden" name="empName" placeholder="empName" />
				<input type="hidden" name="departmentId" placeholder="departmentId" />
				<input type="hidden" name="jobId" placeholder="jobId" />
				<input type="hidden" name="startMonth" placeholder="startMonth" />
				<input type="hidden" name="endMonth" placeholder="endMonth" />
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	var grid = GridStack.init({});
	$("tbody:not(.disable)").on("click", ".datatr", function(event){
		$(this).siblings(".datatr").removeClass("active");
		$(this).toggleClass("active");
	});
	
	let empTB = $("#empTB");
	let fn_paging = function(page, event){
		event.preventDefault();
		searchForm.find("[name=page]").val(page);
		searchForm.submit();
		return false;
	}
	$("#searchUI").on("click", "#searchBtn", function(event){
		$(this).parents("#searchUI").find(":input[name]").each(function(idx, input){
			let name = input.name;
			let value = $(input).val();
			searchForm.find(`[name='\${name}']`).val(value);
		});
		searchForm.submit();
	});
	let searchForm = $("#searchForm").on("submit", function(event){
		event.preventDefault();
		empTB.empty();
		$(".pagingArea").empty();
		let url = this.action;
		let data = $(this).serialize();
		$.getJSON(url, data).done(function(resp){
			let dataList = resp.dataList;
			let trs = [];
			if(dataList.length>0){
				$(dataList).each(function(idx, emp){
					let tr = $("<tr>").append(
						$("<td>").html(emp.empName)		
						, $("<td>").html(emp.email)		
						, $("<td>").html(emp.phoneNumber)		
						, $("<td>").html(emp.manager?.empName)		
						, $("<td>").html(emp.department?.departmentName)		
						, $("<td>").html(emp.job?.jobTitle)		
						, $("<td>").html(emp.hireDate)		
						, $("<td>").html(emp.retireDate)		
					);
					trs.push(tr);
				})
			}else{
				trs.push($("<tr>").html(
						$("<td colspan='8'>").html("조건에 맞는 사원이 없음.")
					)
				);
			}
			empTB.html(trs);
			$(".pagingArea").html(resp.pagingHTML);
			searchForm.find("[name=page]").val("");
		});
		return false;
	}).submit();
	
	let jobTB = $("#jobTB").on("click", ".datatr", function(event){
		let job = $(this).data("source");
		let searchValue = null;
		if($(this).hasClass("active")){
			searchValue = job.jobId;
		}else{
			searchValue = "";
		}
		searchForm.find("[name=jobId]").val(searchValue);
		searchForm.submit();
	});
	
	let locTB = $("#locTB");
	let deptTB = $("#deptTB").on("click", ".datatr", function(event){
		let department = $(this).data("source");
		let searchValue = null;
		if($(this).hasClass("active")){
			locTB.find(".datatr").hide();
			locTB.find(".datatr").filter(function(idx, tr){
				return $(tr).data("source").locationId == department.location.locationId;
			}).show();
			searchValue = department.departmentId;
		}else{
			locTB.find(".datatr").show();
			searchValue = "";
		}
		searchForm.find("[name=departmentId]").val(searchValue);
		searchForm.submit();
	});
	
	let regionArea = $("#regionArea").on("change", function(event){
		let where = $(this).val();
		$.getJSON("<c:url value='/departments'/>", {where:where}).done(function(resp){
			let trs = [];
			if(resp.length>0){
				$(resp).each(function(index, dept){
					let tr = $("<tr>").append(
						$("<td>").html(dept.departmentName)		
						, $("<td>").html(dept.manager.empName)		
						, $("<td>").html(`\${dept.location.country.countryName},&nbsp;&nbsp;&nbsp;\${dept.location.city}`)		
					).addClass("datatr")
					.data("source", dept);
					trs.push(tr);		
				});
			}else{
				trs.push(
					$("<tr>").html(
						$("<td colspan='3'>").html("해당 국가에 등록된 정보가 없음.")		
					).addClass("nodata")
				);
			}
			deptTB.html(trs);
		});
		$.getJSON("<c:url value='/loc/locations'/>", {where:where}).done(function(resp){
			let trs = [];
			if(resp.length>0){
				$(resp).each(function(index, location){
					let tr = $("<tr>").append(
						$("<td>").html(location.postalCode)		
						, $("<td>").html(location.stateProvince)		
						, $("<td>").html(location.city)		
						, $("<td>").html(location.streetAddress)		
					).addClass("datatr")
					.data("source", location);
					trs.push(tr);		
				});
			}else{
				trs.push(
					$("<tr>").html(
						$("<td colspan='4'>").html("해당 국가에는 지사가 없음.")		
					).addClass("nodata")
				);
			}
			
			locTB.html(trs);
		});
	});
	
	$.getJSON("<c:url value='/loc/regions'/>").done(function(resp) {
		let optGroups = [];
		$(resp).each(function(idx, region){
			let optGrp = $("<optgroup>").attr("label", region.regionName);
			optGroups.push(optGrp);
			let opts = [];
			$(region.countries).each(function(index, country){
				let opt = $("<option>").val(country.countryId).html(country.countryName);
				opts.push(opt);
			});
			optGrp.append(opts);				
		});
		regionArea.append(optGroups).change();
	});
	
	$.getJSON("<c:url value='/jobs'/>").done(function(resp) {
		let trs = [];
		if(resp.length>0){
			$(resp).each(function(index, job){
				let tr = $("<tr>").append(
					$("<td>").html(job.jobTitle)		
					, $("<td>").html(job.minSalary)		
					, $("<td>").html(job.maxSalary)		
				).addClass("datatr")
				.data("source", job);
				trs.push(tr);		
			});
		}else{
			trs.push(
				$("<tr>").html(
					$("<td colspan='3'>").html("등록된 직무 정보 없음.")		
				).addClass("nodata")
			);
		}
		
		jobTB.html(trs);
	});
</script>
<jsp:include page="/includee/postScript.jsp" />
</body>
</html>