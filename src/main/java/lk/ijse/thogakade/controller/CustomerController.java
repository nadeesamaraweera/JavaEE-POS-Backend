package lk.ijse.thogakade.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.List;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.dto.CustomerDTO;
import org.slf4j.Logger;


@WebServlet( urlPatterns = "/customer" )
public class CustomerController extends HttpServlet {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerController.class);
    CustomerBO customerBo = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    public void init() throws ServletException {
        logger.info("Customer Controller Initiated");
    }

    // TODO : Add Customer
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            logger.error("Invalid Content Type");
            return;
        }

        try ( var reader = req.getReader(); var writer = resp.getWriter()) {

            Jsonb jsonb = JsonbBuilder.create();
            CustomerDTO customerDto = jsonb.fromJson(reader, CustomerDTO.class);

            try {
                if (customerBo.saveCustomer(customerDto)){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                    writer.write("Customer Added Successfully");
                    logger.info("Customer Added Successfully");
                }
                else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    writer.write("Failed to add Customer");
                    logger.error("Failed to add Customer");
                }
            } catch (SQLException e) {
                logger.error("Failed to add Customer");
                e.printStackTrace();
            }

        }catch (Exception e){
            logger.error("Failed to add Customer");
            e.printStackTrace();
        }
    }

    // TODO : Get Customer
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{

            if (req.getParameter("id").equals("all")){
                List<CustomerDTO> allCustomers = customerBo.getAllCustomers();
                if (allCustomers != null){
                    resp.setContentType("application/json");
                    Jsonb jsonb = JsonbBuilder.create();
                    jsonb.toJson(allCustomers, resp.getWriter());
                    logger.info("All Customers Retrieved Successfully");
                }
                return;
            }


            String id = req.getParameter("id");
            CustomerDTO customerDto = customerBo.searchCustomer(id);
            if (customerDto != null){
                resp.setContentType("application/json");
                Jsonb jsonb = JsonbBuilder.create();
                jsonb.toJson(customerDto, resp.getWriter());
                logger.info("Customer Retrieved Successfully");
            }

        } catch (Exception e) {
            logger.error("Failed to Retrieve Customer");
            throw new RuntimeException(e);
        }

    }

    //Todo : Update Customer
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            logger.error("Invalid Content Type");
            return;
        }

        try (var reader = req.getReader(); var writer = resp.getWriter()) {

            Jsonb jsonb = JsonbBuilder.create();
            CustomerDTO customerDto = jsonb.fromJson(reader, CustomerDTO.class);

            if (customerBo.updateCustomer(customerDto)) {
                resp.setStatus(HttpServletResponse.SC_CREATED);
                writer.write("Customer Updated Successfully");
                logger.info("Customer Updated Successfully");
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                writer.write("Failed to update Customer");
                logger.error("Failed to update Customer");
            }
        }catch (Exception e){
            logger.error("Failed to update Customer");
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        try {
            if (customerBo.deleteCustomer(id)){
                resp.setStatus(HttpServletResponse.SC_CREATED);
                resp.getWriter().write("Customer Deleted Successfully");
                logger.info("Customer Deleted Successfully");
            }
            else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("Failed to delete Customer");
                logger.error("Failed to delete Customer");
            }
        } catch (Exception e) {
            logger.error("Failed to delete Customer");
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
