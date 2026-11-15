package nangorblast.common;

/** Empat arah gerak / arah hadap. */
public enum Direction {
    UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int dx() { return dx; }

    public int dy() { return dy; }

    public boolean isHorizontal() {
        return dy == 0;
    }

    public Direction opposite() {
        return switch (this) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
        };
    }

    /** Arah tegak lurus (searah jarum jam). */
    public Direction clockwise() {
        return switch (this) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }

    /**
     * Arah dominan dari {@code from} menuju {@code to}. Jika kedua posisi sama,
     * kembalikan {@code fallback}.
     */
    public static Direction towards(Position from, Position to, Direction fallback) {
        int dx = to.x() - from.x();
        int dy = to.y() - from.y();
        if (dx == 0 && dy == 0) {
            return fallback;
        }
        if (Math.abs(dx) >= Math.abs(dy)) {
            return dx > 0 ? RIGHT : LEFT;
        }
        return dy > 0 ? DOWN : UP;
    }
}
