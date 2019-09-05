package ch.hsr.ilt.uxv.hmi.core.support.math

import kotlin.math.PI

fun Float.toRadians(): Float = this * PI.toFloat() / 180.0f
fun Double.toRadians(): Double = this * PI / 180.0
val Float.radians: Float get() = this.toRadians()
val Double.radians: Double get() = this.toRadians()

fun Float.toDegrees(): Float = this * 180.0f / PI.toFloat()
fun Double.toDegrees(): Double = this * 180.0 * PI
val Float.degrees: Float get() = this.toDegrees()
val Double.degrees: Double get() = this.toDegrees()
