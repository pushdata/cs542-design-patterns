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
        if ((aTraffic >= 4.0 && aTraffic < 8.0) || (aItem >= 1.0 && aItem < 2.0)) {
            int riskState = checkProhibited(aTraffic, aItem);
            switch (riskState) {
                case 0:
                    System.out.println("Security Loosened(LOW)");
                    state.setState(state.getLowRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
                case 1:
                    Driver.operations_list.add(OPERATION_SEQ);
                    break;
                case 2:
                    System.out.println("Security Tightened(HIGH)");
                    state.setState(state.getHighRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
            }
        } else if ((aTraffic >= 8.0 || aItem >= 2.0)) {
            System.out.println("Security Tightened(HIGH)");
            state.setState(state.getHighRiskState());
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
        } else if ((aTraffic >= 4.0 && aTraffic < 8.0) || aItem >= 1.0 && aItem < 2.0) {
            return 1;
        } else {
            return 2;
        }
    }
}
