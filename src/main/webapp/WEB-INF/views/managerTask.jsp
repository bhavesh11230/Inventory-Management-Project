<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Manager</title>
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
    margin-top: 50px;
}

.sidebar {
    background-color: #22223b;
    padding: 15px;
    position: fixed;
    height: 100%;
    width: 260px; /* Increased width */
    top: 0;
    left: 0;
    overflow-y: auto; /* Enable vertical scrolling */
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.3); /* Add shadow for depth */
}

.sidebar a {
    display: block;
    color: #f5f5f5;
    padding: 15px 20px; /* Increase padding */
    text-decoration: none;
    border-radius: 5px; /* Rounded corners */
    margin-bottom: 10px; /* Space between links */
    font-size: 16px; /* Increase font size */
    transition: background-color 0.3s, transform 0.3s; /* Smooth transitions */
}

.sidebar a:hover {
    background-color: #4a4e69;
    color: #f5f5f5;
    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.3); /* Text shadow on hover */
    transform: scale(1.05); /* Slight zoom effect */
}

.main-content {
    margin-left: 280px; /* Adjust for sidebar width */
    padding: 15px;
    display: flex;
    justify-content: center;
    align-items: center;
    height: calc(100vh - 60px); /* Adjust height to account for header and footer */
    background-size: cover; /* Ensure the image covers the container */
    background-position: center; /* Center the background image */
    background-repeat: no-repeat; /* Prevent the image from repeating */
    box-sizing: border-box;
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
    width: 100%;
    text-align: left;
}

    </style>
</head>

<body>
    <div class="header">
        <h1>Inventory Management</h1>
    </div>
    <div class="sidebar">
        <a href="addRaw">Add Raw Material</a>
        <a href="viewRaw">View Raw Material</a>
        <a href="deleteRaw">Delete Raw Materials</a>
        <a href="updateRawQty">Update Raw Material Quantity</a>
        <a href="addProcessed">Add Process Material</a>
        <a href="viewProcessed">View Process Material</a>
        <a href="deleteProcessed">Delete Process Materials</a>
        <a href="updateProcessQty">Update Process Material Quantity</a>
        <a href="issueRaw">Issue Raw Material</a>
        <a href="issueProcessed">Issue Process Material</a>
        <a href="viewIssueRawLogs">View Issue Raw</a>
        <a href="viewIssueProcessedLogs">View Issue Processed</a>
        <a href="unavailableRawMaterials">Unavailable Raw Materials</a>
        <a href="unavailableProcessedItems">Unavailable Process Materials</a>
        <a href="index">Logout</a>
        <a href="/">Logout</a>
    </div>
    <div class="main-content">
    </div>
    <div class="footer">
        <p>&copy; 2024 Inventory Management. All rights reserved.</p>
    </div>
</body>

</html>
