package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public final class CTREConfigs {
    public TalonFXConfiguration elevatorConfig = new TalonFXConfiguration();

    public CTREConfigs(){
        /* Elevator Motor Configuration */
        /* Motor Inverts and Neutral Mode */
        elevatorConfig.MotorOutput.Inverted = Constants.Elevator.elevatorMotorInvert;
        elevatorConfig.MotorOutput.NeutralMode = Constants.Elevator.elevatorMotorNeutralMode;
    }
}