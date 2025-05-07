package org.example.dominatorOO.executionMode

import org.example.dominatorOO.facade.DominatorPort

data object Eliminator: ExecutionMode {
    override fun execute(port: DominatorPort) = port.fireEliminator()
}