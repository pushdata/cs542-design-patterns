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
        if (aTraffic >= 8.0 || aItem >= 2.0) {
            int riskState = checkProhibited(aTraffic, aItem);
            switch (riskState) {
                case 0:
                    System.out.println("Security Loosened(LOW)");
                    state.setState(state.getLowRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
                case 1:
                    System.out.println("Security Loosened(MOD)");
                    state.setState(state.getModerateRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
                case 2:
                    Driver.operations_list.add(OPERATION_SEQ);
                    break;
            }
        } else if ((aTraffic >= 4.0 && aTraffic < 8.0) || (aItem >= 1.0 && aItem < 2.0)) {
            System.out.println("Security Loosened(MOD)");
            state.setState(state.getModerateRiskState());
            state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
        } else {
            System.out.println("Security Loosened(LOW)");
            state.setState(state.getLowRiskState());
            state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
        }
    }

    public int checkProhibited(float aTraffic, float aItem) {
        if ((aTraffic >= 0.0 && aTraffic < 4.0) && (aItem >= 0.0 && aItem < 1.0)) {
            return 0;
        } else if ((aTraffic >= 4.0 && aTraffic < 8.0) && aItem >= 1.0 && aItem < 2.0) {
            return 1;
        } else {
            return 2;
        }
    }
}
