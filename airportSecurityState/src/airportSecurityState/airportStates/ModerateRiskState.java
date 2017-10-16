package airportSecurityState.airportStates;

import airportSecurityState.driver.Driver;

public class ModerateRiskState implements AirportStateI  {
    private static final String OPERATION_SEQ = "2 3 5 8 9";
    RiskState state;

    public ModerateRiskState(RiskState iState) {
        state = iState;
    }
    @Override
    public void tightenOrLoosenSecurity(float aTraffic, float aItem) {
        if ((aTraffic >= 4 && aTraffic < 8) || (aItem >= 1 && aItem < 2)) {
            int riskState = checkProhibited(aItem);
            switch (riskState) {
                case 0:
                    System.out.println("Security Loosened");
                    state.setState(state.getLowRiskState());
                    break;
                case 1:
                    Driver.operations_list.add(OPERATION_SEQ);
                    break;
                case 2:
                    System.out.println("Security Tightened");
                    state.setState(state.getHighRiskState());
                    break;
            }
        } else {
            System.out.println("Security Tightened");
            state.setState(state.getHighRiskState());
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
