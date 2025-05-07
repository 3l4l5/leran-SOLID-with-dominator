package org.example.dominatorOO.executionMode

import org.example.dominatorOO.facade.DominatorPort

data object Paralyzer : ExecutionMode {
    override fun execute(port: DominatorPort) = port.fireParalyzer()
}