package dominatorOO.factory
import org.example.dominatorOO.executionMode.Eliminator
import org.example.dominatorOO.executionMode.Locked
import org.example.dominatorOO.executionMode.Paralyzer
import org.example.dominatorOO.executionMode.ReportOnly
import org.example.dominatorOO.executionMode.Decomposer
import org.junit.jupiter.api.DisplayName
import org.example.dominatorOO.factory.ExecutionModeFactory
import org.example.lib.hardwareDriver.enums.TargetTypeEnum
import org.example.lib.hardwareDriver.enums.ThreatLevelEnum
import org.example.lib.hardwareDriver.enums.UserTypeEnum
import org.example.lib.hardwareDriver.target.TargetObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


/**
 * ExecutionModeFactory の分岐テスト
 */
@DisplayName("ExecutionModeFactory.decide() の単体テスト")
class ExecutionModeFactoryTest {

 /* 執行官 × 監視官 → ReportOnly */
 @Test
 fun `監視官が管理官を狙うと→ReportOnly`() {
  val target = TargetObject(TargetTypeEnum.AdminHuman, 0, ThreatLevelEnum.B)
  assertEquals(
   ReportOnly,
   ExecutionModeFactory.decide(UserTypeEnum.INSPECTOR, target)
  )
 }

 /* 人間 × 犯罪係数 300 以上 → Eliminator */
 @Test
 fun `犯罪係数300以上→Eliminator`() {
  val target = TargetObject(TargetTypeEnum.Human, 350, ThreatLevelEnum.B)
  assertEquals(
   Eliminator,
   ExecutionModeFactory.decide(UserTypeEnum.ENFORCER, target)
  )
 }

 /* 人間 × 犯罪係数 200–299 → Paralyzer */
 @Test
 fun `犯罪係数200以上300未満は Paralyzer`() {
  val target = TargetObject(TargetTypeEnum.Human, 250, ThreatLevelEnum.B)
  assertEquals(
   Paralyzer,
   ExecutionModeFactory.decide(UserTypeEnum.ENFORCER, target)
  )
 }

 /* 非人間 × 脅威レベル A → Decomposer */
 @Test
 fun `非Humanかつ脅威レベルA→Decomposer`() {
  val target = TargetObject(TargetTypeEnum.NotHuman, 0, ThreatLevelEnum.A)
  assertEquals(
   Decomposer,
   ExecutionModeFactory.decide(UserTypeEnum.ENFORCER, target)
  )
 }

 /* いずれの条件にも該当しない → Locked */
 @Test
 fun `その他のケース→Locked`() {
  val target = TargetObject(TargetTypeEnum.Human, 100, ThreatLevelEnum.B)
  assertEquals(
   Locked,
   ExecutionModeFactory.decide(UserTypeEnum.ENFORCER, target)
  )
 }
}