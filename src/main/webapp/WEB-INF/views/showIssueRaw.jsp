<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Issued Raw</title>
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
        <a href="#">Issued Raw Materials</a>
    </div>
    <div class="main-content">
        <div class="content">
            <h2>issued Raw Materials</h2>
            <div class="login-container">
                <h1>Enter Details</h1>
                <form action="issueRawM" method="post">
                
                    <label for="accname">Raw Material ID :</label>
                    <input type="text" id="rid" name="rid" value="<%=Integer.parseInt(request.getParameter("rid"))%>">
                    
                    <label for="accname">Raw Material Name :</label>
                    <input type="text" id="rname" name="rname" value="<%=request.getParameter("rname")%>">
                    
                    <label for="accname">Raw Material Issuer Name :</label>
                    <input type="text" id="irname" name="irname" placeholder="Enter Name">
                    
                    <label for="accmob">Material Quantity :</label>
                    <input type="text" id="irquantity" name="irquantity" placeholder="Enter Quantity">
                    
                    <label for="acccity">Issue Date :</label>
                    <input type="text" id="irdate" name="irdate" placeholder="Date">
                    
                    <label for="accbal">Time :</label>
                    <input type="number" id="irtime" name="irtime" placeholder="Time">
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
