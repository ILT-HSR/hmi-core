package ch.hsr.ilt.uxv.hmi.driver

interface Payload {

    fun trigger(): List<Command<*>>

}