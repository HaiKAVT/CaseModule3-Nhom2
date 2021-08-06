package Servlet;

import Services.SanPhamService;
import dao.ConnectionCSDL;
import models.SanPham;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {""})
public class SanPhamServlet extends HttpServlet {
    SanPhamService sanPhamService = new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createSp":
                resp.sendRedirect("views/createsp.jsp");
                break;
            case "editSp":
                int indexedit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("sanpham", sanPhamService.list.get(indexedit));
                requestDispatcher = req.getRequestDispatcher("views/editsp.jsp");
                requestDispatcher.forward(req, resp);
                break;
            case "deleteSp":
                int index= Integer.parseInt(req.getParameter("index"));
                sanPhamService.deletesp(index);
                resp.sendRedirect("/");
                break;
            default:
                sanPhamService.showsp();
                req.setAttribute("ahi", sanPhamService.list);
                requestDispatcher = req.getRequestDispatcher("views/index1.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createSp":
                int id = Integer.parseInt(req.getParameter("id"));
                String ten = req.getParameter("name");
                Double gia = Double.valueOf(req.getParameter("gia"));
                int idloai = Integer.parseInt(req.getParameter("idloaisp"));
                String img = req.getParameter("img");
                SanPham sanPham = new SanPham(id,ten, gia, idloai, img);
                sanPhamService.savesp(sanPham);
                resp.sendRedirect("/");
                break;
            case "editSp":
                int idedit = Integer.parseInt(req.getParameter("id"));
                String tenedit = req.getParameter("name");
                Double giaedit = Double.valueOf(req.getParameter("gia"));
                int idloaiedit = Integer.parseInt(req.getParameter("idloaisp"));
                String imgedit = req.getParameter("img");
                SanPham sanPhamedit = new SanPham(idedit, tenedit, giaedit, idloaiedit, imgedit);
                int indexedit= Integer.parseInt(req.getParameter("index"));
                sanPhamService.editsp(sanPhamedit,indexedit);
                resp.sendRedirect("/");
                break;

        }
    }
}

