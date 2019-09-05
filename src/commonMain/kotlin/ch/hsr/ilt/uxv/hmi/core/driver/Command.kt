package ch.hsr.ilt.uxv.hmi.core.driver

interface Command<out NativeType> {
    val nativeCommand: NativeType
}