<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<title>List Student</title>

	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

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

</head>

<div id="wrapper">
    <div id="header">
        <h2>student List</h2>
    </div>
</div>

<div id="container">

		<div id="content">


            <!-- put new button: to see item -->

		    <input type="button" value="View Items"
            				   onclick="window.location.href='item'; return false;"
            				   class="add-button"
            />


            <security:authorize access="hasRole('ADMIN')">

            <input type="button" value="Add Student"
                        				   onclick="window.location.href='showFormToAddStu'; return false;"
                        				   class="add-button"
            />

            </security:authorize>

		    <!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Enroll No</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempStudent" items="${studentModel}">
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.enrollNo} </td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

	<br></br>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">

            <input type="submit" value="Logout"/>

        </form:form>

</body>
</html>