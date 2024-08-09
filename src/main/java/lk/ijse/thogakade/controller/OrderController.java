package lk.ijse.thogakade.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakade.bo.BOFactory;
import lk.ijse.thogakade.bo.custom.OrderBO;
import lk.ijse.thogakade.dto.OrderDTO;
import org.slf4j.Logger;

import java.io.IOException;

@WebServlet(urlPatterns = "/order", loadOnStartup = 1)
public class OrderController extends HttpServlet {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(OrderController.class);
    OrderBO orderBO = (OrderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ORDER);

    @Override
    public void init() throws ServletException {
        logger.info("Order Controller Initiated");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            logger.error("Invalid Content Type");
        }
        try (var writer = resp.getWriter()){
            Jsonb jsonb = JsonbBuilder.create();
            OrderDTO orderDTO = jsonb.fromJson(req.getReader(), OrderDTO.class);
            System.out.println(orderDTO + "in order controller");
            writer.write(String.valueOf(orderBO.saveOrder(orderDTO)));
            resp.setStatus(HttpServletResponse.SC_CREATED);
            logger.info("Order Added Successfully");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error("Failed to add Order");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()) {
            Jsonb jsonb = JsonbBuilder.create();
            resp.setContentType("application/json");
            jsonb.toJson(orderBO.getAllOrders(), writer);
            resp.setStatus(HttpServletResponse.SC_OK);
            logger.info("All Orders Retrieved Successfully");
        } catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }
}
