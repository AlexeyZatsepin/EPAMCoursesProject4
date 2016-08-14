package controller.commands;

import model.dao.impl.BillDAO;
import model.dao.impl.ClientDAO;
import model.dao.impl.CreditCardDAO;
import model.entity.Bill;
import model.entity.Client;
import model.entity.CreditCard;
import model.service.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/14/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class CreateBillCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        long cardId = Long.parseLong(request.getParameter("cardId"));
        long toClientId = Long.parseLong(request.getParameter("toClientId"));
        long amount = Long.parseLong(request.getParameter("amount"));
        long userId = (long) request.getSession().getAttribute("userId");

        ClientDAO clientDAO = (ClientDAO) context.getDBService().getClientDAO();
        BillDAO billDAO = (BillDAO) context.getDBService().getBillDAO();
        CreditCardDAO cardDAO = (CreditCardDAO) context.getDBService().getCreditCardDAO();

        CreditCard card = cardDAO.get(cardId);
        Client to = clientDAO.get(toClientId);
        Client from = clientDAO.get(userId);

        if (card.isBlocked()){
            request.setAttribute("message", "Card is blocked");
        }else if(card.getPayment().getAmount()<amount){
            request.setAttribute("message", "Not enough money");
        }else{
            Bill bill = new Bill(from,to,amount,new Date());
            long current = card.getPayment().getAmount();
            card.getPayment().setAmount(current-amount);
            cardDAO.update(card);
            billDAO.insert(bill);
            request.setAttribute("message", "Success");
        }
        return "./WEB-INF/views/billStatus.jsp";
    }
}
