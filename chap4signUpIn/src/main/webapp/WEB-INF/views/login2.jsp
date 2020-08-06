<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>LOGIN PAGE</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<style>
		html, body{
		   padding:0px;
		   margin:0px;
		   background:#F8F2ED;
		   font-family: 'Raleway', sans-serif;
		   color:#FFF;
		   height:100%;
		}
		
		.container{
		   min-height:300px;
		   max-width:250px;
		   margin:40px auto;
		   background:#FFF;
		   border-radius:2px;
		   box-shadow:0px 2px 3px rgba(0, 0, 0, 0.2);
		   display:flex;
		   flex-direction:column;
		   overflow:hidden;
		   animation: hi 0.5s;
		   -webkit-transform: translateZ(0px);
		   *{
		      box-sizing:border-box;
		   }
		}
		
		.pages{
		   flex:1;
		   white-space:nowrap;
		   position:relative;
		   transition:all 0.4s;
		   display:flex;
		   .page{
		      min-width:100%;
		      padding:20px 15px;
		      padding-top:0px;
		      background:linear-gradient(to left, #955DFF, #6FAAFF);
		      &:nth-of-type(1){
		         .input { transform:translateX(-100%) scale(0.5); }
		      }
		      &:nth-of-type(2){
		         .input { transform:translateX(100%) scale(0.5); }
		         
		      }
		      .input{
		         transition:all 1s; 
		         opacity:0; 
		         transition-delay:0s;
		         
		      }
		      &.signup{
		         background:linear-gradient(to left, #6FAAFF, #955DFF);
		      }
		      .title{
		         margin-bottom:10px;
		         font-size:14px;
		         position:relative;
		         line-height:14px;
		         i{
		            vertical-align:text-bottom;
		            font-size:19px;
		         }
		      }
		      .input{
		         margin-top:20px;
		      }
		      input.text{
		         background:#F6F7F9;
		         border:none;
		         border-radius:4px;
		         width:100%;
		         height:40px;
		         line-height:40px;
		         padding:0px 10px;
		         color:rgba(0, 0, 0, 0.5);
		         outline:none;
		      }
		      
		      input[type=submit]{
		         background:rgba(0, 0, 0, 0.5);
		         color:#F6F7F9;
		         height:40px;
		         line-height:40px;
		         width:100%;
		         border:none;
		         border-radius:4px;
		         font-weight:600;
		      }
		   }
		}
		
		.tabs{
		   max-height:50px;
		   height:50px;
		   display:flex;
		   background:#FFF;
		   
		   .tab{
		      flex:1;
		      color:#5D708A;
		      text-align:center;
		      line-height:50px;
		      transition:all 0.2s;
		      .text{
		         font-size:14px;
		         transform:scale(1);
		         transition:all 0.2s;
		      }
		   }  
		}
		
		input[type=radio]{ display:none; }
		@for $i from 0 through 1{
		   input[type=radio]:nth-of-type(#{$i + 1}):checked {
		      ~ .tabs .tab:nth-of-type(#{$i + 1}){
		         box-shadow:inset (6 * $i) + -3px 2px 5px rgba(0, 0, 0, 0.25);
		         color:#3F4C7F;
		         .text{ transform:scale(0.9); }
		      }
		      
		      ~ .pages{
		         transform:translateX(-100% * $i);
		         
		         .page:nth-of-type(#{$i + 1}){
		            .input { 
		               opacity:1; 
		               transform:translateX(0%); 
		               transition:all 0.5s;
		               @for $i from 1 through 5{
		                  &:nth-child(#{$i}) { 
		                     transition-delay:0.2s*$i
		                  }
		               }
		            }
		         }
		      }
		   }
		}
		
		@keyframes hi{
		   from { transform: translateY(50%) scale(0, 0); opacity:0; }
		}
	</style>
	<script lang="javascript">
		var signin = document.querySelector('#signin')
		var register = document.querySelector('#register')
		setTimeout(function(){ register.checked = true}, 1000)
		setTimeout(function(){ signin.checked = true}, 2000)
	</script>
	<script>
		$(document).ready(function() {
			$("#login_process").click(function(){
				var json = {
					idField : $("#idField").val(),
					pwField : $("#pwField").val()
				};
				for(var str in json) {
					if (json[str].length == 0) {
						alert("PLEASE INPUT " +
								$("#" + str).attr("placeholder"));
						$("#" + str).focus();
						return;
					}
				}
			});
		});
	</script>
</head>
<body>

<div class="container">
  <input type="radio" name="tab" id="signin" checked="checked"/>
  <input type="radio" name="tab" id="register"/>
  <div class="pages">
    <div class="page">
      <div class="input">
        <div class="title"><i class="material-icons">account_box</i> USERNAME</div>
        <input class="text" type="text" placeholder=""/>
      </div>
      <div class="input">
        <div class="title"><i class="material-icons">lock</i> PASSWORD</div>
        <input class="text" type="password" placeholder=""/>
      </div>
      <div class="input">
        <input type="submit" value="ENTER"/>
      </div>
    </div>
    <div class="page signup">
      <div class="input">
        <div class="title"><i class="material-icons">person</i> NAME</div>
        <input class="text" type="text" placeholder=""/>
      </div>
      <div class="input">
        <div class="title"><i class="material-icons">markunread_mailbox</i> EMAIL</div>
        <input class="text" type="password" placeholder=""/>
      </div>
      <div class="input">
        <input type="submit" value="SIGN ME UP!"/>
      </div>
    </div>
  </div>
  <div class="tabs">
    <label class="tab" for="signin">
      <div class="text">Sign In</div>
    </label>
    <label class="tab" for="register">
      <div class="text">Register</div>
    </label>
  </div>
</div>
</body>
</html>