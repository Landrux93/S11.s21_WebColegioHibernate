package Controlador;

import modelo.dao.CursoDAO;
import modelo.dao.ICursoDAO;
import modelo.entity.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletCurso", urlPatterns = {"/ServletCurso"})
public class ServletCurso extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCurso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCurso at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if( request.getParameter("metodo")!=null )
        {
            if( request.getParameter("metodo").equals("lista"))
            {   //CONSULTAR TODOS
                lista(request, response);
            }
            else 
                if( request.getParameter("metodo").equals("modifica"))
                {   //CONSULTA UN CURSO PARA MODIFICAR
                    String id = request.getParameter("id");
                    CursoDAO objCursoDAO = new CursoDAO();
                    Curso objCurso = objCursoDAO.obtenerCurso(Integer.parseInt(id));
                    request.setAttribute("curso", objCurso);
                    request.getRequestDispatcher("/modificaCurso.jsp").forward(request, response);
                }
                else
                    if( request.getParameter("metodo").equals("elimina"))
                    {   //CONSULTA UN CURSO PARA ELIMINAR
                        String id = request.getParameter("id");
                        CursoDAO objCursoDAO = new CursoDAO();
                        Curso objCurso = objCursoDAO.obtenerCurso(Integer.parseInt(id));
                        request.setAttribute("curso", objCurso);
                        request.getRequestDispatcher("/eliminaCurso.jsp").forward(request, response);
                    }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if( request.getParameter("metodo")!=null )
        {
            if( request.getParameter("metodo").equals("insertar"))
            {
                registra(request, response);
            }
            else
                if( request.getParameter("metodo").equals("actualizar"))
                {
                    actualiza(request, response);
                }
                else
                     if( request.getParameter("metodo").equals("eliminar"))
                     {
                        elimina(request, response);
                     }
     
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    protected void lista(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        ICursoDAO objCursoDAO = new CursoDAO();
        // OBTENER TODOS
        List<Curso> listaCursos = objCursoDAO.obtenerCursos();
        //MUESTRA LA LISTA en JSP
        request.setAttribute("cursos", listaCursos);
        request.getRequestDispatcher("/listaCursos.jsp").forward(request, response);
    }
    protected void registra(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {   //INSERTAR CURSO
        String nombre = request.getParameter("nombre");
        String docente = request.getParameter("docente");
        String lugar = request.getParameter("lugar");
        
        ICursoDAO objCursoDAO = new CursoDAO();
        Curso objCurso = new Curso(0, nombre, docente, lugar);
        objCursoDAO.grabarCurso(objCurso);

        lista(request, response);
    }
    protected void actualiza(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {   //MODIFICAR CURSO
        int id = Integer.parseInt( request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String docente = request.getParameter("docente");
        String lugar = request.getParameter("lugar");
        
        ICursoDAO objCursoDAO = new CursoDAO();
        Curso objCurso = new Curso(id, nombre, docente, lugar);
        objCursoDAO.actualizarCurso(objCurso);

        lista(request, response);
    }
    protected void elimina(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {   //ELIMINAR CURSO
        int id = Integer.parseInt( request.getParameter("id"));
        ICursoDAO objCursoDAO = new CursoDAO();
        objCursoDAO.eliminarCurso(id);

        lista(request, response);
    }
}
    
    