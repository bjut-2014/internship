         // 负责ajax发送数据 
         function up(fd) { 
             var xhr = new XMLHttpRequest(); 
             xhr.open('POST','uploadHomework',true); // 异步传输                
             xhr.send(fd); 
         } 
  
  
         function upload(obj) { 
        	   // alert('你选择文件了'); 
        	    alert(obj.value); // 文件对象,html5新增的api 

        	    var fd = new FormData(); // html5新增的对象,可以包装字符,二进制信息 
        	    fd.append(obj.name,obj.files[0]); 

        	    up(fd); 

         } 
