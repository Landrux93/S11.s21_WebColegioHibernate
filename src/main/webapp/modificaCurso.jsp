<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.entity.Curso"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Curso</title>
    </head>
    <body>
    <h1 class="loginTitle">Información del Curso</h1>
    <%   Curso objCurso = (Curso) request.getAttribute("curso"); %>
    <form action="ServletCurso" method="post">
        <input type="hidden" name="metodo" value="actualizar"/>
        <table class="table">
            <tr>
                <td class="loginLabel">ID</td>
                <td class="loginControl">
                    <input type="text" name="id"  readonly value="<%= objCurso.getIdCurso() %>"></td>
            </tr>
            <tr>
                <td class="loginLabel">Nombre del Curso</td>
                <td class="loginControl">
                    <input type="text" name="nombre" required  value="<%= objCurso.getNombre() %>"></td>
            </tr>
            <tr>
                <td class="loginLabel">Docente</td>
                <td class="loginControl">
                    <input type="text" name="docente" required value="<%= objCurso.getDocente() %>"></td>
            </tr>
            <tr>
                <td class="loginLabel">Lugar</td>
                <td class="loginControl">
                    <input type="text" name="lugar" required value="<%= objCurso.getLugar() %>"></td>
            </tr>	
            <tr>
                <td class="loginButton"><input type="submit" value="enviar"></td>
                <td class="loginButton"><input type="reset" value="borrar"></td>
            </tr>						
        </table>
    </form>
    </body>
</html>
