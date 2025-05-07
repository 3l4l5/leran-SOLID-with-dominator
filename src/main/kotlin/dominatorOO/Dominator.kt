package org.example.dominatorOO

import org.example.dominatorOO.facade.DominatorPort
import org.example.dominatorOO.facade.HardwareDriverFacade
import org.example.dominatorOO.factory.ExecutionModeFactory

class Dominator(
    private val port: DominatorPort = HardwareDriverFacade()
) {
    fun fire() {
        val user   = port.authorizeUser()
        val target = port.scanTarget()
        val mode   = ExecutionModeFactory.decide(user, target)
        mode.execute(port)
    }
}