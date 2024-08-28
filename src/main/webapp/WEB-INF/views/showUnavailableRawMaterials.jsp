<%@page import="java.util.*" %>
<%@page import="com.r3sys.management.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unavailabel Raw Materials</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #283048;
            color: #f5f5f5;
            margin: 0;
        }

        .header {
            background-color: #4a4e69;
            padding: 15px;
            text-align: center;
        }

        .header h1 {
            margin: 0;
            color: #f5f5f5;
        }

        .sidebar {
            background-color: #22223b;
            padding: 15px;
            position: fixed;
            height: 100%;
            width: 200px;
            top: 0;
            left: 0;
        }

        .sidebar a {
            display: block;
            color: #f5f5f5;
            padding: 10px;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .sidebar a:hover {
            background-color: #4a4e69;
        }

        .main-content {
            margin-left: 220px;
            padding: 15px;
        }

        .footer {
            background-color: #4a4e69;
            padding: 15px;
            text-align: center;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        .footer p {
            margin: 0;
            color: #f5f5f5;
        }

        .content {
            max-width: 800px;
            margin: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #4a4e69;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4a4e69;
        }

        tr:nth-child(even) {
            background-color: #2b2d42;
        }
    </style>
</head>
<body>


 <div class="header">
        <h1>Inventory Management</h1>
    </div>
    <div class="sidebar">
        <a href="managerTask">Home</a>
        <a href="#">Unavailabel Raw Materials</a>
    </div>
    <div class="main-content">
        <div class="content">
            <h2>Unavailabel Raw Materials</h2>
            <% List<RawMaterial> rawmaterial = (List<RawMaterial>) request.getAttribute("RawMaterialList"); %>    
            <table>
                <tr>
                    <th>Material ID</th>
                    <th>Material Name</th>
                    <th>Material Quantity</th>
                    <th>Unit</th>
                    <th>Cost</th>
                </tr>
                    <% for(RawMaterial r : rawmaterial) { %>
                    <% if(r.getRquantity()<10) { %>
                        <tr>
                            <td><%= r.getRid() %></td>
                            <td><%= r.getRname() %></td>
                            <td><%= r.getRquantity() %></td>
                            <td><%= r.getRunit() %></td>
                            <td><%= r.getRcost()%></td>
                        </tr>
				<% 
			}
                    
		
		}
		%>
            </table>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2024 Inventory Management. All rights reserved.</p>
    </div>

</body>
</html>