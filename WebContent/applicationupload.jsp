<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>申请书授权书PDF上传</title>
   
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeIn">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h1>申请书授权书PDF上传</h1>
          
                    </div>
                    <div class="ibox-content">
                        <form id="my-awesome-dropzone" class="dropzone" action="form_file_upload.html#">
                            <div class="dropzone-previews">
                            <h2>点击选择文件或从桌面拖动</h2>
                            </div>
                            <button type="submit" class="btn btn-primary pull-right"> 
                            <i class="fa fa-upload"></i>&nbsp;&nbsp;
                             <span class="bold">上传</span>
                             </button>
                                 
                        </form>
                     
                    </div>
                   
                         <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-3">
                                  
                                    <!-- <button class="btn btn-primary" type="submit">提交</button>
                                    <button class="btn btn-white" type="submit">返回</button> -->
                                       
                                     <button class="btn btn-success " type="submit">
                                    <i class="fa fa-sign-in"></i>&nbsp;&nbsp;
                                    <span class="bold">提交</span>
                                    </button>
                                    <button class="btn btn-default " type="submit">
                                    <i class="fa fa-mail-reply">
                                    </i>&nbsp;&nbsp;返回</button>
                                </div>
                            </div>
                </div>
            </div>
        </div>
    </div>
       
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/dropzone/dropzone.js"></script>
    <script>
        $(document).ready(function(){
        	Dropzone.options.myAwesomeDropzone={
        			autoProcessQueue:false,
        			uploadMultiple:true,
        			parallelUploads:100,
        			maxFiles:100,
        			init:function(){
        				var myDropzone=this;
        				this.element.querySelector("button[type=submit]").addEventListener("click",function(e){
        					e.preventDefault();
        					e.stopPropagation();
        					myDropzone.processQueue()
        					}
        				    );
        				this.on("sendingmultiple",function(){});
        				this.on("successmultiple",function(files,response){});
        				this.on("errormultiple",function(files,response){})
        				}
        	}
        	}
            );
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>