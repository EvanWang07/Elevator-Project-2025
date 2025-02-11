package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;
import frc.robot.Constants;

public class AutoElevator extends Command {
    private final Elevator e_Elevator;
    private double setPoint; // later defined by control bindings in RobotContainer
    private double periodicError; // periodicError is defined here so execute() does not create a new local variable every period
    private PIDController elevatorPIDController = new PIDController(Constants.Elevator.kP, Constants.Elevator.kI, Constants.Elevator.kD);
    
    public AutoElevator(Elevator e_Elevator, double setPoint) { // setPoint is in ROTATIONS.
        this.e_Elevator = e_Elevator;
        addRequirements(e_Elevator);
        this.setPoint = setPoint;
        
    }

    public void initialize() {
        elevatorPIDController.setTolerance(Constants.Elevator.elevatorPIDGoalTolerance);
        elevatorPIDController.reset();
    }

    public void execute() {
        periodicError = (e_Elevator.getElevatorPosition() - setPoint); // defines error as difference of desired pos and current pos
        
        /* for debugging/testing */
        System.out.println(MathUtil.clamp((elevatorPIDController.calculate(periodicError, setPoint)), Constants.Elevator.elevatorPIDSpeedFloor, Constants.Elevator.elevatorPIDSpeedCap));
    
        /* do not enable yet */
        // e_Elevator.setElevatorMotorSpeed(MathUtil.clamp((elevatorPIDController.calculate(periodicError, setPoint)), Constants.Elevator.elevatorPIDSpeedFloor, Constants.Elevator.elevatorPIDSpeedCap) + Constants.Elevator.gravitationalOffsetVoltage);
    }

    public boolean isFinished() {
        return elevatorPIDController.atSetpoint();
    }

    public void end (boolean interrupted){
        e_Elevator.brakeElevator();
    }
}
