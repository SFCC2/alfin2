<%-- 
    Document   : index
    Created on : 24/08/2018, 11:43:42 AM
    Author     : Labing I5
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="vo2.Estudiante"%>
<%@page import="vo2.Excercise"%>
<%@page import="vo2.Results"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Portal 1</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
    <link href="css/custom.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
        <div class="container">
            <!-- Logo and responsive toggle -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-globe"></span> Logo</a>
            </div>
            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#">Home</a>
                    </li>
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Products</a>
                    </li>
    <li class="dropdown">
     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Services <span class="caret"></span></a>
     <ul class="dropdown-menu" aria-labelledby="about-us">
      <li><a href="#">Engage</a></li>
      <li><a href="#">Pontificate</a></li>
      <li><a href="#">Synergize</a></li>
     </ul>
    </li>    
                </ul>

   <!-- Search -->
   <form class="navbar-form navbar-right" role="search">
    <div class="form-group">
     <input type="text" class="form-control">
    </div>
    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Search</button>
   </form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

<div class="container-fluid">

 <!-- Left Column -->
 <div class="col-sm-3">

     
     
  <!-- List-Group Panel -->
  <div class="panel panel-default">
   <div class="panel-heading">
    <h1 class="panel-title"><span class="glyphicon glyphicon-random"></span> Completely Synergize</h1>
   </div>
   <div class="list-group">
    <a href="#" class="list-group-item">Resource Taxing</a>


