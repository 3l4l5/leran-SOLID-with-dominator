package org.example.lib.hardwareDriver.target

import org.example.lib.hardwareDriver.enums.TargetTypeEnum
import org.example.lib.hardwareDriver.enums.ThreatLevelEnum

class TargetObject(
    val type: TargetTypeEnum,
    val criminalIndex: Int,
    val threatLevel: ThreatLevelEnum
) {
}