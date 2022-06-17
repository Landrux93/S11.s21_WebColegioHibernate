<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"  type="text/css"  href="css/estilo.css" />
    <title>Curso Nuevo</title>
</head>
<body>
<!-- Start Menu -->
<div class="menu-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="cont mb-5" style="width: 60%;">
                <div class="head">
                    <h1>Registrar Curso</h1>
                </div>
                <form action="ServletCurso" method="post">
                    <input type="hidden" name="metodo" value="insertar"/>
                    <table class="table">
                        <tr>
                            <td class="">ID</td>
                            <td class="">
                                <input type="text" name="id"  readonly value=""></td>
                        </tr>
                        <tr>
                            <td class="">Nombre del Curso</td>
                            <td class="">
                                <input type="text" name="nombre" required  value=""></td>
                        </tr>
                        <tr>
                            <td class="">Docente</td>
                            <td class="">
                                <input type="text" name="docente" required value=""></td>
                        </tr>
                        <tr>
                            <td class="">Lugar</td>
                            <td class="">
                                <input type="text" name="lugar" required value=""></td>
                        </tr>	
                        <tr>
                            <td class=""><input type="submit" value="enviar"></td>
                            <td class=""><input type="reset" value="borrar"></td>
                        </tr>						
                    </table>
                </form>
                </div>
            </div>
        </div>
    </div>
</div>
    <%@include file="footer.jsp" %>
</body>
</html>
