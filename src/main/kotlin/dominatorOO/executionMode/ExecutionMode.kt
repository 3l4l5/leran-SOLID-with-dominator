package org.example.dominatorOO.executionMode
import org.example.dominatorOO.facade.DominatorPort

sealed interface ExecutionMode {
    fun execute(port: DominatorPort)
}