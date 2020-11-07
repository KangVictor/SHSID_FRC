package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
    private final Compressor m_compressor = new Compressor(Constants.PneumaticConstants.PCMChannel);
    private final Solenoid intakeSolenoid = new Solenoid(Constants.PneumaticConstants.PCMChannel,Constants.PneumaticConstants.intakeSolenoidChannel);
    private final Solenoid shooterSolenoid = new Solenoid(Constants.PneumaticConstants.PCMChannel,Constants.PneumaticConstants.shooterSolenoidChannel);
    public Climb() {

    }

    public void startCompressor() {
        m_compressor.setClosedLoopControl(true);
    }

    public void frontUp() {
        intakeSolenoid.set(true);
    }

    public void frontDown() {
        intakeSolenoid.set(false);
    }

    public void rearUp() {
        shooterSolenoid.set(true);
    }
    public void rearDown() {
        shooterSolenoid.set(false);
    }
}