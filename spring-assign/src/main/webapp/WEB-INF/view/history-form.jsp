<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Buy Item</title>

	<link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/add-student-style.css">

    <style type="text/css">
                html, body{
                	margin-left:15px; margin-right:15px;
                	padding:0px;
                	font-family:Verdana, Arial, Helvetica, sans-serif;
                }

                table {
                	border-collapse:collapse;
                	border-bottom:1px solid gray;
                	font-family: Tahoma,Verdana,Segoe,sans-serif;
                	width:72%;
                }

                th {
                	border-bottom:1px solid gray;
                	background:none repeat scroll 0 0 #09c332;
                	padding:10px;
                	color: #FFFFFF;
                }

                tr {
                	border-top:1px solid gray;
                	text-align:center;
                }

                tr:nth-child(even) {background: #FFFFFF}
                tr:nth-child(odd) {background: #BBBBBB}

                #wrapper {width: 100%; margin-top: 0px; }
                #header {width: 70%; background: #09c332; margin-top: 0px; padding:15px 0px 15px 15px;}
                #header h2 {width: 100%; margin:auto; color: #FFFFFF;}
                #container {width: 100%; margin:auto}
                #container h3 {color: #000;}
                #container #content {margin-top: 20px;}

                .add-button {
                	border: 1px solid #666;
                	border-radius: 5px;
                	padding: 4px;
                	font-size: 12px;
                	font-weight: bold;
                	width: 120px;
                	padding: 5px 10px;

                	margin-bottom: 15px;
                	background: #cccccc;
                }
            </style>

            <style>
                form {
                	margin-top: 10px;
                }

                label {
                	font-size: 16px;
                	width: 100px;
                	display: block;
                	text-align: right;
                	margin-right: 10px;
                	margin-top: 8px;
                	margin-bottom: 8px;
                }

                input {
                	width: 250px;
                	border: 1px solid #666;
                	border-radius: 5px;
                	padding: 4px;
                	font-size: 16px;
                }

                .save {
                	font-weight: bold;
                	width: 130px;
                	padding: 5px 10px;
                	margin-top: 30px;
                	background: #cccccc;
                }

                table {
                	border-style:none;
                	width:50%;
                }

                tr:nth-child(even) {background: #FFFFFF}
                tr:nth-child(odd) {background: #FFFFFF}

                tr {
                	border-style:none;
                	text-align:left;
                }

            </style>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Buy Item</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save History</h3>

		<form:form action="addHistory" modelAttribute="history" method="POST">

		    <!-- need to associate this data with customer id-->
		    <form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Item Id</label></td>
						<td><form:input path="itemId" /></td>
					</tr>

					<tr>
						<td><label>Seller Id: </label></td>
						<td><form:input path="studentId"/></td>
					</tr>

					<tr>
						<td><label>Buyer Enroll No:</label></td>
                        <td><form:input path="buyerEnrollNo" /></td>
					</tr>

					<tr>
                        <td><label>Selling Date: </label></td>
                        <td><form:input path="sellingDate" /></td>
                    </tr>



					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/api/item">Back to List</a>
		</p>

	</div>

</body>

</html>









