package org.example.lib.hardwareDriver

import org.example.lib.hardwareDriver.enums.TargetTypeEnum
import org.example.lib.hardwareDriver.enums.ThreatLevelEnum
import org.example.lib.hardwareDriver.enums.UserTypeEnum
import org.example.lib.hardwareDriver.target.TargetObject

class HardwareDriver {
    fun authorizeUser(): UserTypeEnum {
        return UserTypeEnum.ENFORCER
    }
    fun scanTarget(): TargetObject {
        return TargetObject(TargetTypeEnum.Human, 0, ThreatLevelEnum.A)
    }
    fun lockTrigger(){}
    fun report(){}
    fun fireEliminator(){}
    fun fireDecomposer(){}
    fun fireParalyzer(){}
}