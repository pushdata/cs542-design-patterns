package airportSecurityState.airportStates;

import airportSecurityState.driver.Driver;

import java.util.HashMap;

import static airportSecurityState.util.MyLogger.DebugLevel.CONSTRUCTOR;
import static airportSecurityState.util.MyLogger.DebugLevel.STATE_CHANGE;

public class RiskState {
    private AirportStateI highRiskState;
    private AirportStateI lowRiskState;
    private AirportStateI moderateRiskState;
    private AirportStateI state;

    public RiskState() {
        Driver.logger.writeMessage("Risk State Constructor Called!", CONSTRUCTOR);
        lowRiskState = new LowRiskState(this);
        moderateRiskState = new ModerateRiskState(this);
        highRiskState = new HighRiskState(this);
        state = lowRiskState;
    }

    public void invokeSecurity(HashMap<Integer, Float> aTraffic, HashMap<Integer, Float> aProhibited) {
        for (int i = 0, j = aTraffic.size(); i < j; i++) {
            state.tightenOrLoosenSecurity(aTraffic.get(i), aProhibited.get(i));
        }
    }

    public AirportStateI getState() {
        return state;
    }

    public void setState(AirportStateI iState) {
        Driver.logger.writeMessage("State Changed!", STATE_CHANGE);
        state = iState;
    }

    public AirportStateI getLowRiskState() {
        return lowRiskState;
    }

    public AirportStateI getModerateRiskState() {
        return moderateRiskState;
    }

    public AirportStateI getHighRiskState() {
        return highRiskState;
    }
}
