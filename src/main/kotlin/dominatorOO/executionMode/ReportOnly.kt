package org.example.dominatorOO.executionMode

import org.example.dominatorOO.facade.DominatorPort

data object ReportOnly : ExecutionMode {
    override fun execute(port: DominatorPort) {
        port.lockTrigger()
        port.report()
    }
}