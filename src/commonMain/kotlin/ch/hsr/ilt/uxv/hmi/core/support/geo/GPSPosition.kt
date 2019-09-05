package ch.hsr.ilt.uxv.hmi.core.support.geo

import ch.hsr.ilt.uxv.hmi.core.support.math.degrees
import ch.hsr.ilt.uxv.hmi.core.support.math.radians
import kotlin.math.*

/**
 * A simple value type to hold GPS floating point coordinates
 *
 * @param latitude The latitude of the point (degrees)
 * @param longitude The longitude of the point (degrees)
 * @param altitude The altitude of the point (meters)
 *
 * @since 1.0.0
 * @author IFS Institute for Software
 */
data class GPSPosition(val latitude: Double, val longitude: Double, val altitude: Double) {

    companion object {
        const val EARTH_RADIUS_IN_METERS = 6378137
    }

    /**
     * Convert a #WGS89Position into a #GPSPosition
     *
     * @since 1.0.0
     */
    constructor(position: WGS89Position) : this(
            position.latitude.toFloat() / 1e7,
            position.longitude.toFloat() / 1e7,
            position.altitude.toFloat() / 1e3)

    fun distanceTo(other: GPSPosition): Double {
        val fromLatitude = latitude.radians
        val fromLongitude = longitude.radians
        val toLatitude = other.latitude.radians
        val toLongitude = other.longitude.radians

        return EARTH_RADIUS_IN_METERS * 2 * asin(min(1.0, sqrt(
                sin((toLatitude - fromLatitude) / 2.0).pow(2.0)
                        + cos(fromLatitude)
                        * cos(toLatitude)
                        * sin((toLongitude - fromLongitude) / 2.0).pow(2.0)
        )))
    }

    fun positionAt(distance: Double, compassBearing: Double): GPSPosition {
        val angularDistance = distance / EARTH_RADIUS_IN_METERS
        val bearingInRadians = compassBearing.radians
        val fromLatitude = latitude.radians
        val fromLongitude = longitude.radians

        val newLatitude = asin(sin(fromLatitude)
                * cos(angularDistance)
                + cos(fromLatitude)
                * sin(angularDistance)
                * cos(bearingInRadians))
        val newLongitude = fromLongitude + atan2(
                sin(bearingInRadians)
                        * sin(angularDistance)
                        * cos(fromLatitude),
                cos(angularDistance)
                        - sin(fromLatitude)
                        * sin(newLatitude)
        )
        return GPSPosition(newLatitude.degrees, newLongitude.degrees, altitude)
    }


}