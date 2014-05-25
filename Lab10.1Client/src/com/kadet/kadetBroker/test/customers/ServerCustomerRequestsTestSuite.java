package com.kadet.kadetBroker.test.customers;



import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestInsertCustomerToServer.class, TestUpdateCustomerInServer.class, TestRemoveCustomerFromServer.class, TestSelectCustomersFromServer.class})
public class ServerCustomerRequestsTestSuite {

}
