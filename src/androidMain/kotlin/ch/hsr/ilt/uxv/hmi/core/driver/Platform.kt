package ch.hsr.ilt.uxv.hmi.core.driver

import kotlinx.coroutines.newSingleThreadContext
import kotlin.coroutines.CoroutineContext

actual val PlatformContext: CoroutineContext = newSingleThreadContext("PlatformContext")
