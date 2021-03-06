<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
<!DOCTYPE html>
<html>

<head>
    <meta charset='ISO-8859-1'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Product Page</title>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>
    <style type='text/css'>
        .custom-container {
            margin: 50px auto 0 auto;
            width: 600px;
            -webkit-box-shadow: 4px 6px 13px -1px rgba(130, 126, 130, 0.64);
            -moz-box-shadow: 4px 6px 13px -1px rgba(130, 126, 130, 0.64);
            box-shadow: 4px 6px 13px -1px rgba(130, 126, 130, 0.64);
            padding: 50px;
        }
        
        .custom-button {
            margin-right: 10px;
            color: white;
            background-color: #66afe9;
            padding: 8px 20px 8px 20px;
            border-radius: 2px;
            border: 1px solid #66afe9;
        }
        
        .custom-button:hover {
            color: #66afe9;
            background-color: #ffffff;
            border: 1px solid #66afe9;
        }
    </style>
</head>

<body>
    <nav class='navbar navbar-default'>
        <div class='container-fluid'>
            <div class='navbar-header'>
                <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'> <span class='sr-only'>Toggle navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span></button> <a class='navbar-brand' href='#'>Brand</a> </div>
            <div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>
                <ul class='nav navbar-nav navbar-right'>
                    <li class='dropdown'> <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>New User? <span class='caret'></span></a>
                        <ul class='dropdown-menu'>
                            <li><a href='form.html'>User Form</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class='container'>
        <div class='custom-container'>
            <div class='custom-form'>
                <form name='myForm' action='http://localhost:8081/08ServletCompCart/CartServlet' method='post'>
                    <h2>Hello <%= session.getAttribute("username")%></h2>
                    <h3>Product Inventory</h3>
                    <div class='form-group'>
                        <label for='exampleInputEmail1'>Item Name</label>
                        <input type='text' class='form-control' id='email' placeholder='Item Name' name='itemname'> </div>
                    <div class='form-group'>
                        <label for='exampleInputEmail1'>Item Quantity</label>
                        <input type='text' class='form-control' id='email' placeholder='Item Quantity' name='itemqty'> </div>
                    <input class='custom-button btn btn-default' type='submit' name='btn' value='Add'>
                    <input class='custom-button btn btn-default' type='submit' name='btn' value='Buy'>
                    <input class='custom-button btn btn-default' type='submit' name='btn' value='Search'>
                    <input class='custom-button btn btn-default' type='submit' name='btn' value='Delete'>
                    <input class='custom-button btn btn-default' type='submit' name='btn' value='Search All'>
                </form>
            </div>
        </div>
    </div>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>
    <script></script>
    <script type='text/javascript'>
        $(function() {
            $('#button').click(function() {
                    var x = document.getElementById('itemname').value;
                    var patt = /^[a-zA-Z]*$/;
                    if (x.length === 0) {
                        alert('Item Name is mandatory');
                        return false;
                    }
                    if (patt.test(x) === false) {
                        alert('Item Name can only have characters');
                    }
            	});
       		});
    </script>
</body>

</html>
</body>
</html>