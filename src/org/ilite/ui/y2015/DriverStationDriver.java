package org.ilite.ui.y2015;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import org.ilite.uitools.widget.toteLiftState.ToteLiftState;
import org.usfirst.frc.team1885.robot.comms.RobotInfoMessage;

public class DriverStationDriver {

	private static IntegerProperty toteState = new SimpleIntegerProperty();
	private static IntegerProperty recycleState = new SimpleIntegerProperty();

	public static void update(RobotInfoMessage msg) {
		int recycleStateInt = -1;
		int toteStateInt = -1;
		switch (msg.getRecycleBinState()) {
			case FORWARD:
				toteStateInt = ToteLiftState.STATE_RAISING;
				break;
			case REVERSE:
				toteStateInt = ToteLiftState.STATE_LOWERING;
				break;
			case OFF:
				toteStateInt = ToteLiftState.STATE_STOP;
				break;
		}
		switch (msg.getToteState()) {
			case FORWARD:
				toteStateInt = ToteLiftState.STATE_RAISING;
				break;
			case REVERSE:
				toteStateInt = ToteLiftState.STATE_LOWERING;
				break;
			case OFF:
				toteStateInt = ToteLiftState.STATE_STOP;
				break;
		}

		if (msg.isToteResetting())
			toteStateInt = ToteLiftState.STATE_RESET;
		if (msg.isUpperToteLimitSwitch())
			toteStateInt = ToteLiftState.STATE_TOTE;

		toteState.set(toteStateInt);
		recycleState.set(recycleStateInt);
	}
	
	public static IntegerProperty getToteStateProperty(){
		return toteState;
	}
	public static IntegerProperty getRecycleStateProperty(){
		return recycleState;
	}
}
