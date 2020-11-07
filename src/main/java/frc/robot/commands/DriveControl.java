package frc.robot.commands;

import frc.robot.subsystems.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveControl extends CommandBase{
    private final Drive m_Drive;
    private DoubleSupplier forward_speed;
    private DoubleSupplier rotation_speed;
    // private BooleanSupplier a_pressed;

    public DriveControl(DoubleSupplier y_speed, DoubleSupplier z_speed, Drive m_Drive) {
        this.m_Drive = m_Drive;
        forward_speed = y_speed;
        rotation_speed = z_speed;
        
        addRequirements(m_Drive);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute(){
    
        m_Drive.move_robot(forward_speed.getAsDouble(), rotation_speed.getAsDouble()); // rotation is opposite
    }
}