package ch.hsr.ilt.uxv.hmi.core.driver

import ch.hsr.ilt.uxv.hmi.core.mission.Execution
import ch.hsr.ilt.uxv.hmi.core.support.geo.GPSPosition
import kotlin.coroutines.CoroutineContext

expect val PlatformContext: CoroutineContext

/**
 * The interface of drivers for a given 'Platform'
 *
 * Generally, a platform is some sort of unmanned vehicle, be it drones, submarines, rovers, etc.
 * Each platform provides a number of commands and queries that can be performed by the platform.
 * Additionally, a platform may be coupled to a payload, which allows for payload specific tasks
 * that can be performed. Payloads are accessed through payload drivers, an the attached payloads
 * can be queried through the platform itself.
 *
 * This interface specifies the minimal subset of commands and queries shared by all supported
 * platforms.
 *
 * @since 1.0.0
 * @author IFS Institute for Software
 */
interface Platform {

    /**
     * The driver id of the specific implementation
     *
     * @since 1.0.0
     */
    val driverId: String

    /**
     * Retrieve the platform name
     *
     * @since 1.0.0
     */
    val name: String

    /**
     * Check if the communication with the vehicle is working
     *
     * @since 1.0.0
     */
    val isAlive: Boolean

    /**
     * Access the current position of the vehicle
     *
     * The returned position shall be `null` if no position has yet been determined
     *
     * @since 1.0.0
     */
    val currentPosition: GPSPosition?

    /**
     * Get the payload attached to the vehicle
     *
     * @since 1.0.0
     */
    var payload: Payload

    /**
     * Get the mission execution strategy for the specific platform implementation
     *
     * @since 1.0.0
     */
    val execution: Execution

}