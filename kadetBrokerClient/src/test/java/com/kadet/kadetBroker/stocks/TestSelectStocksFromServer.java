package com.kadet.kadetBroker.stocks;

import com.kadet.kadetBroker.exception.KadetException;
import org.junit.Test;

/**
 * Date: 25.05.14
 * Time: 12:48
 *
 * @author SarokaA
 */
public class TestSelectStocksFromServer {

    @Test
    public void simpleGet () throws KadetException {
/*
        PropertiesManager propertiesManager = PropertiesManager.getInstance();
        propertiesManager.initProperties();

        GetAllStocksCommand getStocksCommand = (GetAllStocksCommand) CommandManager.getInstance().newCommand(Strings.GET_ALL_STOCKS_COMMAND);

        try {
            CommandSender commandSender = new CommandSender(1994, "localhost");
            commandSender.send(getStocksCommand);
            Command command = (Command) commandSender.receive();
            // answerCommand.execute();
            // commandSender.close();

            StocksListTO answer = (StocksListTO) command.getResult();
            System.out.println("Stocks size : " + answer.getStockTOs().size());
        } catch (KadetException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

*/
    }

}
