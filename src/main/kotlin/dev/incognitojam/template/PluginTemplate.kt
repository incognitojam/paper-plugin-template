package dev.incognitojam.template

import dev.incognitojam.template.command.PingCommand
import dev.incognitojam.template.listener.JoinListener
import gg.flyte.twilight.twilight
import io.papermc.lib.PaperLib
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitCommandHandler

class PluginTemplate : JavaPlugin() {

    companion object {
        lateinit var instance: PluginTemplate
    }

    override fun onEnable() {
        instance = this
        twilight(this) { }

        BukkitCommandHandler.create(this).apply {
            enableAdventure()
            register(PingCommand())
            registerBrigadier()
        }

        JoinListener()

        PaperLib.suggestPaper(this)
    }
}
