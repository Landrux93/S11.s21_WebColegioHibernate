<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">    
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Start header -->
        <header class="top-navbar">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="index.html">
                        <img src="images/logo.png" alt="" />
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-rs-food" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbars-rs-food">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active"><a class="nav-link" href="index.html">Inicio</a></li>
                            <li class="nav-item"><a class="nav-link" href="ServletCurso?metodo=lista"><i class="fa fa-cutlery" aria-hidden="true"></i>Listar Cursos</a></li>
                            <li class="nav-item"><a class="nav-link" href="buscarCurso.jsp"><i class="fa fa-cart-plus" aria-hidden="true"></i>Buscar Curso</a></li>
                            <li class="nav-item"><a class="nav-link" href="ServletProfesor?metodo=lista"><i class="fa fa-hourglass-start" aria-hidden="true"></i>Listar Profesores</a></li>
                            <li class="nav-item"><a class="nav-link" href="buscarProfesor.jsp"><i class="fa fa-user" aria-hidden="true"> </i>Buscar Profesor</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <!-- End header -->
        
    </body>
</html>
