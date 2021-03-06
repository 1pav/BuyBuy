package it.unitn.disi.buybuy.shop;

import it.unitn.aa1617.webprogramming.persistence.utils.dao.exceptions.DAOException;
import it.unitn.aa1617.webprogramming.persistence.utils.dao.exceptions.DAOFactoryException;
import it.unitn.aa1617.webprogramming.persistence.utils.dao.factories.DAOFactory;
import it.unitn.disi.buybuy.dao.ItemDAO;
import it.unitn.disi.buybuy.dao.entities.Item;
import it.unitn.disi.buybuy.utils.Converter;
import it.unitn.disi.buybuy.utils.ItemRetailerComparator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import it.unitn.disi.buybuy.types.ItemRetailerPair;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

    ItemDAO itemDao;

    @Override
    public void init() throws ServletException {
        DAOFactory daoFactory = (DAOFactory) super.getServletContext().getAttribute("daoFactory");
        if (daoFactory == null) {
            throw new ServletException("Impossible to get dao factory for item storage system");
        }
        try {
            itemDao = daoFactory.getDAO(ItemDAO.class);
        } catch (DAOFactoryException ex) {
            throw new ServletException("Impossible to get dao factory for item storage system", ex);
        }
    }

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
        // Request params
        final String query = request.getParameter("query");
        final Integer category_id = Converter.parseInt(request.getParameter("category"));
        final Float latitude = Converter.parseFloat(request.getParameter("lat"));
        final Float longitude = Converter.parseFloat(request.getParameter("lng"));
        // Output list
        List<Item> res = null;

        try {
            // Choosing type of query
            if (latitude != null && longitude != null) {
                List<ItemRetailerPair> itemsWithPlace = itemDao.getWithRetailer(category_id, query);
                Collections.sort(itemsWithPlace, new ItemRetailerComparator(latitude, longitude));
                res = new ArrayList<>();
                for (ItemRetailerPair pair : itemsWithPlace) {
                    res.add(pair.getKey());
                }
            } else if (query != null) {
                if (category_id == null) {
                    res = itemDao.getByQuery(query);
                } else {
                    res = itemDao.getByCategoryAndQuery(category_id, query);
                }
            } else if (category_id != null) {
                res = itemDao.getByCategory(category_id);
            } else {
                res = itemDao.getAll();
            }
        } catch (DAOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Sort-by filter in results page
        String sortBy = request.getParameter("sort");
        if (res != null && sortBy != null) {
            switch (sortBy) {
                case "rating":
                    res.sort(Item.Order.RATING);
                    break;
                case "price_desc":
                    res.sort(Item.Order.PRICE_DESC);
                    break;
                case "price_asc":
                    res.sort(Item.Order.PRICE_ASC);
            }
        }

        request.setAttribute("results", res);
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}
