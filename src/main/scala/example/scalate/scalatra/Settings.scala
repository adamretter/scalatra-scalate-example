package example.scalate.scalatra

import akka.actor.Extension
import akka.actor.ExtensionId
import akka.actor.ExtensionIdProvider
import akka.actor.ExtendedActorSystem
import com.typesafe.config.Config

class SettingsImpl(config: Config) extends Extension {
  val Port: Int = config.getInt("scalatra-scalate-example.port")
}

object Settings extends ExtensionId[SettingsImpl] with ExtensionIdProvider {
  override def lookup = Settings

  override def createExtension(system: ExtendedActorSystem) =
    new SettingsImpl(system.settings.config)
}
