package airportSecurityState.airportStates;

import airportSecurityState.driver.Driver;

public class HighRiskState implements AirportStateI {
    private static final String OPERATION_SEQ = "2 4 6 8 10";
    RiskState state;

    public HighRiskState(RiskState iState) {
        state = iState;
    }
    @Override
    public void tightenOrLoosenSecurity(float aTraffic, float aItem) {
        if (aTraffic >= 8 || aItem >= 2) {
            int riskState = checkProhibited(aItem);
            switch (riskState) {
                case 0:
                    System.out.println("Security Loosened");
                    state.setState(state.getLowRiskState());
                    break;
                case 1:
                    System.out.println("Security Loosened");
                    state.setState(state.getModerateRiskState());
                    break;
                case 2:
                    System.out.println("Security Tightened");
                    Driver.operations_list.add(OPERATION_SEQ);
                    break;
            }
        }
    }

    public int checkProhibited(float aItem) {
        if (aItem >= 0 && aItem < 1) {
            return 0;
        } else if (aItem >= 1 && aItem < 2) {
            return 1;
        } else {
            return 2;
        }
    }
}
