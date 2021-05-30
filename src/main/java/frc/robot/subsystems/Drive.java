package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveKinematics;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.SparkMax; //for neo motors (wheels, etc)
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.Constants;

public class Drive extends SubsystemBase {
    private static int frontLeftChannel;
    private static int rearLeftChannel;
    private static int frontRightChannel;
    private static int rearRightChannel;

    private static SpeedController frontLeft;
    private static SpeedController rearLeft;
    private static SpeedController frontRight;
    private static SpeedController rearRight;

    private static SpeedControllerGroup m_left;
    private static SpeedControllerGroup m_right;

    private final DifferentialDrive m_robotDrive;

    private final SpeedController shooterLeft = new CANSparkMax(Constants.ShooterConstants.leftMotorChannel, MotorType.kBrushless);
    private final SpeedController shooterRight = new CANSparkMax(Constants.ShooterConstants.rightMotorChannel, MotorType.kBrushless);

    private final DifferentialDrive m_shooter = new DifferentialDrive(shooterLeft, shooterRight);

    public Drive(int kfrontRightChannel, int krearRightChannel, int kfrontLeftChannel, int krearLeftChannel) {
        frontLeftChannel = kfrontLeftChannel;
        rearLeftChannel = krearLeftChannel;
        frontRightChannel = kfrontRightChannel;
        rearRightChannel = krearRightChannel;

        frontLeft = new CANSparkMax(frontLeftChannel, MotorType.kBrushless);
        rearLeft = new CANSparkMax(rearLeftChannel, MotorType.kBrushless);
        m_left = new SpeedControllerGroup(frontLeft, rearLeft);

        frontRight = new CANSparkMax(frontRightChannel, MotorType.kBrushless);
        rearRight = new CANSparkMax(rearRightChannel, MotorType.kBrushless);
        
        frontRight.setInverted(true); // frontLeft (id = 15) is in opposite direction
        rearRight.setInverted(true); // frontLeft (id = 10) is in opposite direction
        m_right = new SpeedControllerGroup(frontRight, rearRight);

        m_robotDrive = new DifferentialDrive(m_left, m_right);
    }

    public void shoot() {
        m_shooter.arcadeDrive(1, 0);
    }

    public void move_robot(double speed, double rotation) {
        m_robotDrive.arcadeDrive(speed, rotation);
    }
}