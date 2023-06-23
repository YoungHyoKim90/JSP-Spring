/**
 * 
 */
$(function(){
	let fn_modifyListBody = function(resp){
		let propList = resp.propList;
		let trTags = null;
		if(propList.length > 0){
			trTags = [];
			$.each(propList, function(index, prop){
				let tr = $("<tr>").append(
					$("<td>").html(prop.propertyName),
					$("<td>").html(prop.propertyValue),
					$("<td>").html(
						$("<button type='button'>")
							.addClass("delBtn")
							.text("삭제")
					)
				).addClass("datatr")
				.data("source", prop);
				trTags.push(tr);
			});
		}else{
			trTags = `<tr><td colspan="3">프로퍼티 없음.</td></tr>`;
		}
		$(listBody).html(trTags);
	}
	
	$.getJSON(location.href)
		.done(fn_modifyListBody);	
		
	$(listBody).on("click", "tr.datatr" ,function(event){
		let prop = $(this).data("source");
		console.log(prop);
	}).on("click", ".delBtn" ,function(){
		let prop = $(this).parents("tr.datatr").data("source");
		
		let settings = {
			url:location.href,
			method:"delete",
			data:{
				propertyName : prop.propertyName
			},
			dataType : "json"
		};
		$.ajax(settings)
			.done(resp=>{
				console.log(resp);
			});
	});
	let $insertForm = $(insertForm).on("submit", function(event){
		event.preventDefault();
		let settings = {
			url:insertForm.action,
			method:insertForm.method,
			data:$insertForm.serialize(),
			dataType:"json"
		};
		$.ajax(settings)
			.done(resp=>{
				if(resp.propList){
					fn_modifyListBody(resp);
					insertForm.reset();
				}else{
					alert(`${resp.result.prop} 등록 실패`);
				}
			});
	});
});






















