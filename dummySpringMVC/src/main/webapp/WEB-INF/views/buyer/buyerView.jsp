<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	${buyer }
	
	<button id="htmlBtn">클릭(HTML)</button>
	<button id="jsonBtn">클릭(JSON)</button>
	<script>
		htmlBtn.addEventListener("click" , function(){
		fetch("")
			.then(resp=>{
				console.log(resp);
				return resp.text();
				
			}).then(html=>{
				console.log(html);
			});
		});
		
		jsonBtn.addEventListener("click" , function(){
			fetch("",{
				headers:{
					"Accept" : "application/json"
				}	
			}).then(resp=>{
					console.log(resp);
	 				return resp.json();
				}).then(respMap=>{
					console.log(respMap.buyer);
				});
			});
	</script>