package org.example.models

import org.example.lib.hardwareDriver.enums.TargetTypeEnum
import org.example.lib.hardwareDriver.HardwareDriver
import org.example.lib.hardwareDriver.enums.UserTypeEnum
import org.example.lib.hardwareDriver.enums.ThreatLevelEnum

class Dominator {
    fun fire(){
        val driver = HardwareDriver()
        val userType = driver.authorizeUser()
        // userが監視官 もしくは 執行官の場合
        if (userType == UserTypeEnum.ENFORCER || userType == UserTypeEnum.INSPECTOR)  {
            val target = driver.scanTarget()
            // userが執行官 かつ ターゲットが監視官の場合
            if (target.type == TargetTypeEnum.AdminHuman && userType == UserTypeEnum.INSPECTOR){
                // triggerをロックし、反逆行為を記録
                driver.lockTrigger()
                driver.report()
                return
            }
            if (target.type == TargetTypeEnum.Human){
                if (target.criminalIndex > 200) {
                    driver.fireParalyzer()
                    return
                } else if (target.criminalIndex > 300){
                    driver.fireEliminator()
                    return
                }
            } else {
                if (target.threatLevel == ThreatLevelEnum.A) {
                    driver.fireDecomposer()
                    return
                }
            }
        } else {
            driver.lockTrigger()
            return
        }
    }
}