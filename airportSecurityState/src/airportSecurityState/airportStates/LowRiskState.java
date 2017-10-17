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
        if ((aTraffic >= 0.0 && aTraffic < 4.0)) {
            int riskState = checkProhibited(aTraffic, aItem);
            switch (riskState) {
                case 0:
                    Driver.operations_list.add(OPERATION_SEQ);
                    break;
                case 1:
                    System.out.println("Security Tightened(MOD)");
                    state.setState(state.getModerateRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
                case 2:
                    System.out.println("Security Tightened(HIGH)");
                    state.setState(state.getHighRiskState());
                    state.getState().tightenOrLoosenSecurity(aTraffic, aItem);
                    break;
            }
        } else {
            System.out.println("Security Tightened(MOD)");
            state.setState(state.getModerateRiskState());
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
