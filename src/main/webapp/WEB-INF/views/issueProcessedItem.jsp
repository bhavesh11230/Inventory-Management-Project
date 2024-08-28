<%@page import="com.r3sys.management.ProcessMaterial"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="com.r3sys.management.RawMaterial" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Issue Processed Items</title>
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
        <a href="#">Issue Processed Items</a>
    </div>
    <div class="main-content">
        <div class="content">
            <h2>Issuing Process Items</h2>
            <% List<ProcessMaterial> processmaterial= (List<ProcessMaterial>) request.getAttribute("processlist"); %>    
            <table>
                <tr>
                    <th>Material ID</th>
                    <th>Material Name</th>
                    <th>Material Quantity</th>
                    <th>Material Unit</th>
                    <th>Cost Per Unit</th>
                    <th>Action</th>
                </tr>
                <% if (processmaterial != null) { %>
                    <% for(ProcessMaterial p : processmaterial) { %>
                        <tr>
                            <td><%= p.getPid() %></td>
                            <td><%= p.getPname() %></td>
                            <td><%= p.getPquantity() %></td>
                            <td><%= p.getPunit() %></td>
                            <td><%= p.getPcost() %></td>
                            <td><a href="showIssueProcess?pid=<%=p.getPid() %>&pname=<%=p.getPname()%>">Issue</a></td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="5">No customers found.</td>
                    </tr>
                <% } %>
            </table>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2024 Inventory Management. All rights reserved.</p>
    </div>
</body>

</html>
