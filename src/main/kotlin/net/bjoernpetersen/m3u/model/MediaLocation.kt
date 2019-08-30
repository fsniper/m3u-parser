package net.bjoernpetersen.m3u.model

import java.net.MalformedURLException
import java.net.URISyntaxException
import java.net.URL
import java.nio.file.FileSystemNotFoundException
import java.nio.file.InvalidPathException
import java.nio.file.Path
import java.nio.file.Paths

/**
 * The location of a media file referenced in a `.m3u` file.
 *
 * This is a sealed class with exactly two implementations:
 *
 * - [MediaPath]
 * - [MediaUrl]
 */
sealed class MediaLocation {
    /**
     * The URL pointing to the location.
     */
    abstract val url: URL

    companion object {
        /**
         * Creates a MediaLocation instance based on the given location.
         *
         * @param location the location from the m3u file
         * @param dir the base dir to resolve relative paths with
         * @return a MediaLocation instance, either [MediaPath] or [MediaUrl]
         * @throws IllegalArgumentException If the location does not have a valid format
         */
        @JvmStatic
        @JvmOverloads
        operator fun invoke(location: String, dir: Path? = null): MediaLocation {
            val path = tryParsePath(location, dir) ?: tryParseFileUrl(location)
            return if (path != null) MediaPath(path)
            else tryParseUrl(location)
                ?.let { MediaUrl(it) }
                ?: throw IllegalArgumentException("Could not parse as URL or path: $location")
        }

        private fun tryParsePath(location: String, dir: Path?): Path? {
            return try {
                if (dir == null) Paths.get(location)
                else dir.resolve(location)
            } catch (e: InvalidPathException) {
                null
            }
        }

        private fun tryParseFileUrl(location: String): Path? {
            return try {
                val url = URL(location)
                val uri = url.toURI()
                Paths.get(uri)
            } catch (e: MalformedURLException) {
                null
            } catch (e: URISyntaxException) {
                null
            } catch (e: FileSystemNotFoundException) {
                null
            } catch (e: IllegalArgumentException) {
                null
            }
        }

        private fun tryParseUrl(location: String): URL? {
            return try {
                URL(location)
            } catch (e: MalformedURLException) {
                null
            }
        }
    }
}

/**
 * A local media file location.
 *
 * @param path the local file path
 */
class MediaPath internal constructor(val path: Path) : MediaLocation() {
    override val url: URL by lazy { path.toUri().toURL() }
    override fun toString(): String {
        return "MediaPath(path=$path)"
    }
}

/**
 * A remote media file location.
 *
 * The [URL][url] may also point to a local file if it isn't using the "`file`" protocol.
 */
class MediaUrl internal constructor(override val url: URL) : MediaLocation() {
    override fun toString(): String {
        return "MediaUrl(url=$url)"
    }
}
