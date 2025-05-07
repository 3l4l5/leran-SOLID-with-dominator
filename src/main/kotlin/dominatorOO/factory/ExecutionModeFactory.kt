package org.example.dominatorOO.factory
import org.example.lib.hardwareDriver.enums.TargetTypeEnum
import org.example.lib.hardwareDriver.enums.UserTypeEnum
import org.example.lib.hardwareDriver.enums.ThreatLevelEnum
import org.example.lib.hardwareDriver.target.TargetObject
import  org.example.dominatorOO.executionMode.ExecutionMode

import  org.example.dominatorOO.executionMode.Locked
import  org.example.dominatorOO.executionMode.ReportOnly
import  org.example.dominatorOO.executionMode.Eliminator
import  org.example.dominatorOO.executionMode.Paralyzer
import  org.example.dominatorOO.executionMode.Decomposer


object ExecutionModeFactory {
    fun decide(user: UserTypeEnum, targetObject: TargetObject): ExecutionMode = when {
        user !in setOf(UserTypeEnum.INSPECTOR, UserTypeEnum.ENFORCER) ->
            Locked

        user == UserTypeEnum.INSPECTOR && targetObject.type == TargetTypeEnum.AdminHuman ->
            ReportOnly

        targetObject.type == TargetTypeEnum.Human && targetObject.criminalIndex >= 300 ->
            Eliminator

        targetObject.type == TargetTypeEnum.Human && targetObject.criminalIndex >= 200 ->
            Paralyzer

        targetObject.type != TargetTypeEnum.Human && targetObject.threatLevel == ThreatLevelEnum.A ->
            Decomposer

        else -> Locked
    }
}