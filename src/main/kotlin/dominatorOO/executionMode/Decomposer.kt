package org.example.dominatorOO.executionMode

import org.example.dominatorOO.facade.DominatorPort

data object Decomposer : ExecutionMode {
    override fun execute(port: DominatorPort) = port.fireDecomposer()
}