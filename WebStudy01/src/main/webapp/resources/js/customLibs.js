/**
 * 
 */
	$.fn.serializeObject = function(){
		let data = {};
		let nameSet = new Set();
//		this is JQuery object
		this.find(":input[name]").each((idx,ipt)=>{
			nameSet.add(ipt.name);
		}); //Attribute selector input[name^=param] param이라고 들어간. jquery.com!!doc을 봐라.
		let $formThis = this;
		nameSet.forEach(n=>{
			let $ipt = $formThis.find(`:input[name=${n}]`);
			let type = $ipt.attr("type");
			let value = null;
			if(type=="radio"){
				value = $ipt.filter((idx, rdoIpt)=>{return rdoIpt.checked;}).val();
			}else if (type=="checkbox"){
				value = $ipt.filter((idx, chkIpt)=>chkIpt.checked)
							.get()
							.map(i=>i.value);
			}else if(type ="number"){
				value = $ipt.val(); // value 속성 값을 반환.(attribute는 String 타입)
				value = parseInt(value); //여기부터 숫자.
			}else{
				value = $ipt.val();
			}
			data[n] = value;
		});
		return data;
	}