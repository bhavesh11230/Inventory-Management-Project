<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Issued Process</title>
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

        .login-container {
            background-color: #4a4e69;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .login-container h1 {
            margin-bottom: 20px;
        }

        .login-container label {
            display: block;
            margin-bottom: 5px;
            color: #f5f5f5;
        }

        .login-container input[type="text"],
        .login-container input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: none;
            border-radius: 5px;
        }

        .login-container input[type="button"] {
            width: 100%;
            padding: 10px;
            background-color: #22223b;
            border: none;
            border-radius: 5px;
            color: #f5f5f5;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-container input[type="button"]:hover {
            background-color: #4a4e69;
        }
    </style>
</head>

<body>
    <div class="header">
        <h1>Inventory Management</h1>
    </div>
    <div class="sidebar">
        <a href="managerTask">Home</a>
        <a href="#">Issued Processed Items</a>
    </div>
    <div class="main-content">
        <div class="content">
            <h2>Issued Process Materials</h2>
            <div class="login-container">
                <h1>Enter Detils</h1>
                <form action="issueProcessM" method="post">
                
                    <label for="accname">Process Material ID :</label>
                    <input type="text" id="pid" name="pid" value="<%=Integer.parseInt(request.getParameter("pid"))%>">
                    
                    <label for="accname">Process Material Name :</label>
                    <input type="text" id="pname" name="pname" value="<%=request.getParameter("pname")%>">
                    
                    <label for="accname">Process Material Issuer Name :</label>
                    <input type="text" id="ipname" name="ipname" placeholder="Enter Name">
                    
                    <label for="accmob">Material Quantity :</label>
                    <input type="text" id="ipquantity" name="ipquantity" placeholder="Enter Quantity">
                    
                    <label for="acccity">Issue Date :</label>
                    <input type="text" id="ipdate" name="ipdate" placeholder="Date">
                    
                    <label for="accbal">Time :</label>
                    <input type="number" id="iptime" name="iptime" placeholder="Time">
                    <button>Issue</button>
                </form>
            </div>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2024 Inventory Management. All rights reserved.</p>
    </div>
</body>

</html>
