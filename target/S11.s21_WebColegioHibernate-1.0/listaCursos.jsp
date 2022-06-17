<!DOCTYPE html>
<%@page import="modelo.entity.Curso"%>
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
                <h1>Listado de Cursos</h1>
              </div><br>
              <h3>
                <a href="insertaCurso.jsp">Registrar Curso</a>
              </h3><br>
              <table>
                <caption class=""> Lista de Cursos</caption>	

                <tr class="">
                  <th>Id</th><th>Nombre</th><th>Docente</th><th>Lugar</th><th></th><th></th>
                </tr>
                <!-- 
                  Scriplet: son inserciones de codigo java dentro un JSP    < % %>
                  Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>    
                -->
                <%
                  List<Curso> lista = (List<Curso>) request.getAttribute("cursos");
                  if (lista != null) {
                    for (Curso aux : lista) {
                %>
                <tr class="grilla_campo"> 
                  <td><%= aux.getIdCurso()%> </td>
                  <td><%= aux.getNombre()%></td>
                  <td><%= aux.getDocente()%></td>
                  <td><%= aux.getLugar()%></td>

                  <td>
                    <a href="ServletCurso?metodo=elimina&id=<%= aux.getIdCurso()%>">
                      <img alt="Elimina" src="images/Delete.gif">	
                    </a>		
                  </td>
                  <td>
                    <a href="ServletCurso?metodo=modifica&id=<%= aux.getIdCurso()%>">
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