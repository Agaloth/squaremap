package net.pl3x.map.api;

import java.util.Objects;
import org.bukkit.Location;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a point on a map in the XZ plane. May be relative or absolute depending on the context
 */
public final class Point {

    private final double x;
    private final double z;

    private Point(final double x, final double z) {
        this.x = x;
        this.z = z;
    }

    /**
     * Get the x position of this point
     *
     * @return x
     */
    public double x() {
        return this.x;
    }

    /**
     * Get the z position of this point
     *
     * @return z
     */
    public double z() {
        return this.z;
    }

    /**
     * Create a new point from an x and z position
     *
     * @param x x position
     * @param z z position
     * @return point
     */
    public static @NonNull Point of(final double x, final double z) {
        return new Point(x, z);
    }

    /**
     * Create a new point from an x and z position
     *
     * @param x x position
     * @param z z position
     * @return point
     */
    public static @NonNull Point point(final double x, final double z) {
        return new Point(x, z);
    }

    /**
     * Get a new point from a Bukkit {@link Location}. Uses block location
     *
     * @param location location
     * @return point
     */
    public static @NonNull Point fromLocation(final @NonNull Location location) {
        return point(location.getBlockX(), location.getBlockZ());
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final @Nullable Point point = (Point) o;
        return Double.compare(point.x, this.x) == 0 && Double.compare(point.z, this.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.z);
    }

}
