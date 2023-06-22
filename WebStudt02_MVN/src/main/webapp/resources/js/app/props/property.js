/**
 * 
 */
$(function(){
	$.getJSON(location.href)
		.done(resp=>{
			let propList = resp.propList;
			let trTags = null;
			if(propList.length > 0){
				trTags = [];
				$.each(propList, function(index, prop){
					let tr = $("<tr>").append(
						$("<td>").html(prop.propertyName),
						$("<td>").html(prop.propertyValue)
					).addClass("datatr")
					.data("source", prop);
					trTags.push(tr);
				});
			}else{
				trTags = `<tr><td colspan="2">프로퍼티 없음.</td></tr>`;
			}
			$(listBody).html(trTags);
		});	
	$(listBody).on("click", "tr.datatr" ,function(event){
		let prop = $(this).data("source");
		console.log(prop);
	});	
});






















