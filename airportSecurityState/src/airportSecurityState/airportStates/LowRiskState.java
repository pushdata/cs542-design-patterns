package airportSecurityState.airportStates;

import airportSecurityState.driver.Driver;

public class LowRiskState implements AirportStateI  {
    private static final String OPERATION_SEQ = "1 3 5 7 9";
    private RiskState state;

    public LowRiskState(RiskState iState) {
        state = iState;
    }
    @Override
    public void tightenOrLoosenSecurity(float aTraffic, float aItem) {
        if ((aTraffic >= 0 && aTraffic < 4) || (aItem >= 0 && aItem < 1)) {
            int riskState = checkProhibited(aItem);
            switch (riskState) {
                case 0:
                    Driver.operations_list.add(OPERATION_SEQ);
                    break;
                case 1:
                    System.out.println("Security Tightened");
                    state.setState(state.getModerateRiskState());
                    break;
                case 2:
                    System.out.println("Security Tightened");
                    state.setState(state.getHighRiskState());
                    break;
            }
        } else {
            System.out.println("Security Tightened");
            state.setState(state.getModerateRiskState());
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
