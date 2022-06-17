<!DOCTYPE html>
<%@page import="modelo.entity.Profesor"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <%@include file="header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lista Cursos</title>
  </head>
  <body>
    <div class="menu-box">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="cont mb-5" style="width: 60%;">
              <div class="head">
                <h1>Listado de Profesores</h1>
              </div><br>
              <h3>
                <a href="insertaProfesor.jsp">Registrar Profesor</a>
              </h3><br>
              <table>
                <caption class=""> Lista de Profesores</caption>	

                <tr class="">
                  <th>Id</th><th>Nombre</th><th>Apellido</th><th>Especialidad</th><th>Fecha</th><th></th><th></th>
                </tr>
                <!-- 
                  Scriplet: son inserciones de codigo java dentro un JSP    < % %>
                  Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>    
                -->
                <%
                  List<Profesor> lista = (List<Profesor>) request.getAttribute("tbDocente");
                  if (lista != null) {
                    for (Profesor aux : lista) {
                %>
                <tr class="grilla_campo"> 
                  <td><%= aux.getIdDocente()%> </td>
                  <td><%= aux.getNombreDocente()%></td>
                  <td><%= aux.getApellidoDocente()%></td>
                  <td><%= aux.getEspecialidadDocente()%></td>
                  <td><%= aux.getFechaDocente()%></td>

                  <td>
                    <a href="ServletProfesor?metodo=elimina&id=<%= aux.getIdDocente()%>">
                      <img alt="Elimina" src="images/Delete.gif">	
                    </a>		
                  </td>
                  <td>
                    <a href="ServletProfesor?metodo=modifica&id=<%= aux.getIdDocente()%>">
                      <img alt="Actualiza" src="images/Edit.gif">	
                    </a>		
                  </td>			
                </tr>

                <%          }
                  }
                %>	

              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%@include file="footer.jsp" %>
  </body>
</html>