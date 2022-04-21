<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>List Item</title>

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

<body>

<div id="wrapper">
    <div id="header">
        <h2>Item To Sell List</h2>
    </div>
</div>

<hr>

<div id="container">

		<div id="content">


		            <!-- put new button: to see item -->

        		    <input type="button" value="View History"
                       onclick="window.location.href='history'; return false;"
                       class="add-button"
                    />
                    <input type="button" value="Add Item"
                       onclick="window.location.href='showFormToAddItem'; return false;"
                       class="add-button"
                    />


		    <!--  add our html table here -->

			<table>
				<tr>
					<th>Item Name</th>
					<th>     </th>
					<th>Item Price</th>
					<th>     </th>
					<th>Seller Id</th>
					<th>Buy</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempItem" items="${itemModel}">

				    <!-- construct an "Buy" link with customer id -->
                        <c:url var="buyLink" value="/api/showFormToAddHistory">
                            <c:param name="itemId" value="${tempItem.id}" />
                        </c:url>

					<tr>
						<td> ${tempItem.itemName} </td>
						<td>     </td>
						<td> ${tempItem.itemPrice} </td>
						<td>     </td>
						<td> ${tempItem.sellerId} </td>


						<td>
						    <!-- display the update link -->
						    <a href="${buyLink}">Buy Item</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

	<br></br>

	<p>
    <a href="${pageContext.request.contextPath}/api/getStudents">Back to Student List</a>
    </p>

</body>
</html>