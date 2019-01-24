<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	

    <title>添加结果PDF文件</title>
  	
	 <script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "assess_query_dr";
	</script>
	
	<!-- Bootstrap 3.3.4 -->
	<link href="./acss/bootstrap.min.css" rel="stylesheet" type="text/css">
	<!-- Font Awesome Icons -->
	<!-- Font Awesome Icons -->
	<link href="./acss/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<link href="./acss/select2.min.css" rel="stylesheet" type="text/css">
	
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">

</head>

<body class="gray-bg"   >
    <div class="row wrapper border-bottom white-bg page-heading">
      
      <!-- ********************************************************** -->
         <script type="text/javascript">
          window.name = "curWindow";

         </script>
             <div class="ibox-content">
                        <form target="curWindow"  class="form-horizontal" method="post" action="uppdf1.do"  enctype="multipart/form-data">
                    
                        
                      <h1>添加结果PDF文件</h1>

                         <div class="hr-line-dashed"></div>   
                            <div class="form-group">
                                <label class="col-sm-3 control-label">选择文件：</label>

                                <div class="col-sm-8">
                                    <input type="file" id="file"  name="file">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">订单编号：</label>

                                <div class="col-sm-8">
                                    <input type="text" id="uid" name="uid" value="${requestScope.uid }" class="form-control">
                                    <input type="hidden" id="name" name="name" value="${requestScope.name }">
                                
                                </div>
                            </div>                                                                                                                               
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary"  type="submit">提交</button>
                                    <button class="btn btn-white" type="button" onclick="javascript:window.history.back(-1);">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
         
         
         <!-- ********************************************************** -->

    </div>
   
</body>

</html>