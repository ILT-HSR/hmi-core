package ch.hsr.ilt.uxv.hmi.core.driver

interface Payload {

    fun trigger(): List<Command<*>>

}