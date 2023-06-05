<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/sampleForm.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/customLibs.js"></script>
</head>
<body>
<form id="sampleForm" action="<%=request.getContextPath()%>/03/payloadDataProcess.do" method="post">
<pre>
   <input type="text" name="param1"/>
   <input type="number" name="param2"/>
   <select name="selParamSingle">
      <option value="">선택</option>
      <option value="opt1Value">opt1</option>
      <option>opt2</option>
   </select>
   <!-- HtmlElement, property, boolean -->
   <!-- attr("multiple","multiple") prop() -->   
   <select name="selParamMulti" multiple size="5" >
      <option value="">선택</option>
      <option value="opt1Value">opt1</option>
      <option>opt2</option>
   </select>
   <label><input type="radio" name="rdoParam" value="radio1" />RADIO1</label>
   <label><input type="radio" name="rdoParam" value="radio2" />RADIO2</label>
   <label><input type="checkbox" name="chkParam" value="Check1"> CHECK1</label>
   <label><input type="checkbox" name="chkParam" value="Check2"> CHECK2</label>
   <input type="date" name="dateParam">
   <input type="datetime-local" name="datetimeParam">
   <input type="submit" value="전송"/>
</pre>
</form>

<script type="text/javascript">

   
   


//    sampleForm.onsubmit=
   $(sampleForm).on("submit",function(event){ //callbackfunction
      event.preventDefault();
      // this==event.target // HTMLElement
      // $(this) // jquery Object
      // this.action
      // $(this).attr("action")
      
      console.log(`HtmlElement : \${this}`);
      console.log(`jquery Object : \${$(this)}`);
      
      let url = this.action;
      let method = this.method;
      // 파라미터 전송시 사용.
      // let data =$(this).serialize();// form 입력값들을 파라미터형태로 전송가능한 문자열로 만들어줌
      
      let data = $(this).serializeObject(); // this is HTMLElement
      
      let setting = {
         url : url,
         method : method,
         data : JSON.stringify(data), // Marshalling
         headers :{
            "Content-Type" : "application/json"
         },
         //---------------------
         dataType : "json", // Accept: applicaion/json,
         success : function(resp) { // resp는 unmarshalling이 끝난 후 들어온 객체
                              // 언마샬링과 역직렬화는  jquery가 해줌
            alert(resp.message);
         },
         error : function(jqXHR, status, error) {
            console.log(jqXHR)
            console.log(status)
            console.log(error)
         }
      } // request line, header, body -> response
      console.log(setting);
      $.ajax(setting);
      
      return false;
   });
</script>
</body>
</html>