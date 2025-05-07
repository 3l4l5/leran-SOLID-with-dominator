package org.example.dominatorOO.facade

import org.example.lib.hardwareDriver.enums.UserTypeEnum
import org.example.lib.hardwareDriver.target.TargetObject

interface DominatorPort {
    fun authorizeUser(): UserTypeEnum
    fun scanTarget(): TargetObject
    fun lockTrigger()
    fun report()
    fun fireParalyzer()
    fun fireEliminator()
    fun fireDecomposer()
}