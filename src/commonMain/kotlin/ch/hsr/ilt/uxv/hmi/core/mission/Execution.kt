package ch.hsr.ilt.uxv.hmi.core.mission

import ch.hsr.ilt.uxv.hmi.core.driver.Command

abstract class Execution {

    enum class Status {
        FAILURE,
        PREPARING,
        RUNNING,
        FINISHED
    }

    protected val fCommands = mutableListOf<Command<*>>()

    abstract fun tick() : Status

    open operator fun plusAssign(command: Command<*>) {
        fCommands += command
    }

    fun add(command: Command<*>) {
        this += command
    }
}