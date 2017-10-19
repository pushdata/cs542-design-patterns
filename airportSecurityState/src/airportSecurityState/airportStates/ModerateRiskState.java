package airportSecurityState.airportStates;

import airportSecurityState.driver.Driver;

import static airportSecurityState.util.MyLogger.DebugLevel.CONSTRUCTOR;
import static airportSecurityState.util.MyLogger.DebugLevel.HIGH_TO_LOW;
import static airportSecurityState.util.MyLogger.DebugLevel.LOW_TO_HIGH;

public class ModerateRiskState implements AirportStateI {
    private static final String OPERATION_SEQ = "2 3 5 8 9";
    private RiskState state;

    public ModerateRiskState(RiskState iState) {
        Driver.logger.writeMessage("Moderate Risk State Constructor Called!", CONSTRUCTOR);
        state = iState;
    }

    @Override
    public void tightenOrLoosenSecurity(float aTraffic, float aItem) {
        if ((aTraffic >= 4.0 && aTraffic < 8.0) || (aItem >= 1.0 && aItem < 2.0)) {
            int riskState = checkProhibited(aTraffic, aItem);
            switch (riskState) {
                case 0:
                    Driver.logger.writeMessage("Moderate state to Low State!", HIGH_TO_LOW);
                    System.out.println("Security Loosened(LOW)");
                    state.setState(state.getLowRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
                case 1:
                    Driver.operations_list.add(OPERATION_SEQ);
                    break;
                case 2:
                    Driver.logger.writeMessage("Moderate state to High State!", LOW_TO_HIGH);
                    System.out.println("Security Tightened(HIGH)");
                    state.setState(state.getHighRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
            }
        } else if ((aTraffic >= 8.0 || aItem >= 2.0)) {
            Driver.logger.writeMessage("Moderate state to High State!", LOW_TO_HIGH);
            System.out.println("Security Tightened(HIGH)");
            state.setState(state.getHighRiskState());
            state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
        } else {
            Driver.logger.writeMessage("Moderate state to Low State!", HIGH_TO_LOW);
            System.out.println("Security Loosened(LOW)");
            state.setState(state.getLowRiskState());
            state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
        }
    }

    public int checkProhibited(float aTraffic, float aItem) {
        if (aItem >= 2.0 || aTraffic >= 8.0) {
            return 2;
        } else if ((aTraffic >= 0.0 && aTraffic < 4.0) && (aItem >= 0.0 && aItem < 1.0)) {
            return 0;
        } else if ((aTraffic >= 4.0 && aTraffic < 8.0) || aItem >= 1.0 && aItem < 2.0) {
            return 1;
        }
        return 0;
    }
}

