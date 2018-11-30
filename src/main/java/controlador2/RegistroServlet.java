/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador2;

import dao2.DAOejercicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo2.Estudiante;
import dao2.DAOestudiante;
import dao2.DAOresultado;
import vo2.Excercise;
import vo2.Results;

/**
 *
 * @author Sulay Cupitra Cupitra
 * @Asginatura. BASE DE DATOS
 * @Actividad: Examen final
 * 
 */
public class RegistroServlet extends HttpServlet {

    private DAOestudiante dao;
    private DAOejercicios dao1;
    private DAOresultado dao2;

    @Override
    public void init() throws ServletException {
        this.dao = new DAOestudiante();
        this.dao1 = new DAOejercicios();
        this.dao2 = new DAOresultado();
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
            throws ServletException, IOException {
        try {
            RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
            if (request.getParameter("borrar") != null) {
                try {
                    String id = request.getParameter("borrar");
                    Estudiante persona = this.dao.find(Integer.parseInt(id));
                    this.dao.delete(persona);

                    String idE = request.getParameter("borrar");
                    Excercise ejer = this.dao1.find(Integer.parseInt(idE));
                    this.dao1.delete(ejer);

                    String idR = request.getParameter("borrar");
                    Results re = this.dao2.find(Integer.parseInt(id));
                    this.dao2.delete(re);

                } catch (SQLException ex) {
                    Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (request.getParameter("editar") != null) {

                String id = request.getParameter("editar");
                Estudiante persona = null;
                String idE = request.getParameter("editar");
                Excercise ejer = null;
                String idR = request.getParameter("editar");
                Results re = null;
                try {
                    persona = this.dao.find(Integer.parseInt(id));
                    ejer = this.dao1.find(Integer.parseInt(id));
                    re = this.dao2.find(Integer.parseInt(id));
                } catch (SQLException ex) {
                    Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("persona", persona);

            }
            ArrayList<Estudiante> personas = (ArrayList) this.dao.findAll();
            request.setAttribute("lista", personas);
            rq.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException {

        if (request.getParameter("Boton1") != null) {
            System.out.println("Presiona el boton 1");
        } else {
            System.out.println("Presiona el boton21");
        }

//        String[] vehiculos = request.getParameterValues("vehicle");
//        for (String vehiculo : vehiculos) {
//            System.out.println(vehiculo);
//        }
        if (request.getParameter("editar") != null) {
            //Estoy editando XD
            String cedula = request.getParameter("cedula");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String apellido1 = request.getParameter("correo");

            String cat = request.getParameter("cat");
            String end = request.getParameter("end");
            String topic = request.getParameter("topic");
            String maxpt = request.getParameter("maxpt");

            String sid = request.getParameter("cat");
            String points = request.getParameter("points");

            String resultid = request.getParameter("cat");
            String excerid = request.getParameter("cat");
            if (nombre != null && apellido != null && nombre.length() > 0) {
                try {
                    Estudiante persona = this.dao.find(Integer.parseInt(cedula));
                    persona.setNombre(nombre);
                    persona.setApellido(apellido);
                    persona.setCorreo(apellido1);
                    this.dao.update(persona);

                    Excercise exc = this.dao1.find(Integer.parseInt(excerid));
                    exc.setCAT(nombre);
                    exc.setEND(apellido);
                    exc.setTOPIC(topic);
                    int numEntero = Integer.parseInt(maxpt);
                    exc.setMAXTP(numEntero);
                    this.dao1.update(exc);

                    Results RE = this.dao2.find(Integer.parseInt(resultid));
                    RE.setIdEstudiante(Integer.parseInt(cedula));
                    RE.setCAT(cat);
                    RE.setENO(Integer.parseInt(end));
                    RE.setPOINTS(Integer.parseInt(points));
                    this.dao2.update(RE);

                } catch (SQLException ex) {
                    Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            //Estoy registrando uno 

            String cedula = request.getParameter("cedula");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String CORREO = request.getParameter("apellido");

            String cat = request.getParameter("cat");
            String end = request.getParameter("end");
            String topic = request.getParameter("topic");
            String maxpt = request.getParameter("maxpt");

            String sid = request.getParameter("cat");
            String points = request.getParameter("points");

            String resultid = request.getParameter("cat");
            String excerid = request.getParameter("cat");
            //Validaciones - SQL Inyection - Luego
            if (nombre != null && apellido != null && nombre.length() > 0) {
                try {

                    Estudiante persona
                            = new Estudiante(Integer.parseInt(cedula), nombre, apellido, CORREO);
                    if (!this.dao.insert(persona)) {
                        response.sendRedirect("index.jsp?error=ErrorDatos");
                    }
                    int contE = 1;
                    int contR = 1;

                    Excercise exc
                            = new Excercise(contE, cat, end, topic, Integer.parseInt(maxpt));
                    if (!this.dao1.insert(exc)) {
                        response.sendRedirect("index.jsp?error=ErrorDatos");
                    }

                    Results RE
                            = new Results(contR, Integer.parseInt(cedula), cat, Integer.parseInt(end),
                                    Integer.parseInt(points), Integer.parseInt(excerid));

                    if (!this.dao2.insert(RE)) {
                        response.sendRedirect("index.jsp?error=ErrorDatos");
                    }
                    contE++;
                    contR++;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }
        response.sendRedirect("RegistroServlet");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
