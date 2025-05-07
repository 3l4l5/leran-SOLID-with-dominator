package org.example.dominatorOO.facade

import org.example.lib.hardwareDriver.HardwareDriver

class HardwareDriverFacade(
    private val driver: HardwareDriver = HardwareDriver()
) : DominatorPort {
    override fun authorizeUser()           = driver.authorizeUser()
    override fun scanTarget()              = driver.scanTarget()
    override fun lockTrigger()             = driver.lockTrigger()
    override fun report()                  = driver.report()
    override fun fireParalyzer()           = driver.fireParalyzer()
    override fun fireEliminator()          = driver.fireEliminator()
    override fun fireDecomposer()          = driver.fireDecomposer()
}